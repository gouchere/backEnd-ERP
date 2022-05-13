package com.erp.lymytz.api.repository.jdbc;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.commons.ConstantesManager;
import com.erp.lymytz.api.model.YvsAlias;

@Repository
public class CustomJdbcRepo<T extends Serializable> {

	@Autowired
	@Qualifier("dataSource")
	DataSource ds;

	Class<T> type;
	String tableName;
	List<String> exclusions = new ArrayList<>();

//	@Autowired
//	JdbcTemplate jdbc;

	@Autowired
	NamedParameterJdbcTemplate jdbc;
//	
//	public List<T> loadData(Class<T> type, String query, SqlParams[] params) {
//		this.type = type;
//		MapSqlParameterSource parameter = new MapSqlParameterSource();
//		for (SqlParams p : params) {
//			parameter.addValue(p.getParamName(), p.getValue());
//		}
//		List<T> results = new ArrayList<>();
//		if (controleEntity(type)) {
//			results = jdbc.query(query, parameter, new RowMapper<T>() {
//				public T mapRow(ResultSet rs, final int rowNum) throws SQLException {
//					T entity = giveInstance(type);
//					ResultSetMetaData rsmt = rs.getMetaData();
//					int columns = rsmt.getColumnCount();
//					int icol = 1;
//					Colonnes colonne;
//					List<Colonnes> colonnes = new ArrayList<>();					
//					while (icol <= columns) {
//						colonne = new Colonnes();
//						colonne.setName(rsmt.getColumnName(icol));
//						colonne.setType(rsmt.getColumnTypeName(icol));
//						colonne.setNameTable(rsmt.getTableName(icol));
//						colonne.setNameTable(rsmt.getTableName(icol));
//						colonne.setValue(rs.getObject(icol));
//						colonnes.add(colonne);
//						icol++;
//					}
//					exclusions.clear();
//					exclusions.add(type.getName());
//					entity = fillDataWithJdbc(entity, colonnes);
//					return entity;
//				}
//			});
//		}
//		return results;
//	}

	public List<T> loadData(Class<T> type, String query, SqlParams[] params) {
		this.type = type;
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		for (SqlParams p : params) {
			parameter.addValue(p.getParamName(), p.getValue());
		}
		List<T> results = new ArrayList<>();
		if (controleEntity(type)) {
			results = jdbc.query(query, parameter, new RowMapper<T>() {
				public T mapRow(ResultSet rs, final int rowNum) throws SQLException {
					T entity = giveInstance(type);
					String alias = getAliasAnnotation(entity);
					for (Field f : entity.getClass().getDeclaredFields()) {
						if (hasColumOrJoinColum(f)) { 
							try {
								String nameColumn = getJoinColumnOrColumnNameAnnotation(f);
								f.set(entity, extractValue(query, f, rs, nameColumn, alias));
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					return entity;
				}
			});
		}
		return results;
	}

//	public Object getForeignValue(Field f, ResultSet rs) {
//		Object o = giveInstance(f);
//		return o;
//	}

	public Object extractValue(String query, Field fieldAttribute, ResultSet rs, String columName, String alias) {
		Object result = null;
		fieldAttribute.setAccessible(true);
		if (fieldAttribute != null) {
			try {
				if (hasEntityAnnotation(fieldAttribute)) {
					// évite les bouclage infini si l'attribut est de même type que la classe
					Object o = giveInstance(fieldAttribute);
					String alias_ = getAliasAnnotation(o);
					for (Field f : o.getClass().getDeclaredFields()) {
						System.err.println("Alias: " + alias_);
						if (hasColumOrJoinColum(f)) {
							String nameColumn = getJoinColumnOrColumnNameAnnotation(f);
							if (nameColumn != null && alias_ != null) {
								f.set(o, extractValue(query, f, rs, nameColumn, alias_));
							}
						}
					}
					return o;
				} else {
					return result = getDataValue(query, fieldAttribute, rs, columName, alias);
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Object getDataValue(String query, Field f, ResultSet rs, String columnName, String alias) {
		if (columnName != null && alias != null) {
			String columLabel = getColumLabel(columnName, alias);
			try {
				switch (f.getType().getSimpleName().toLowerCase()) {
				case "char":
				case "character":
					if (queryContains(columLabel, query)) {
						Character c = null;
						if (rs.getString(columnName) != null) {
							c = Character.valueOf(rs.getString(columLabel).charAt(0));
						}
						return c;
					}

				default:
					if (queryContains(columLabel, query)) {
						return rs.getObject(columLabel);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private boolean queryContains(String colum, String query) {
		return query.contains(colum);
	}

	private String getColumLabel(String columnName, String alias) {
		return (columnName != null && alias != null) ? alias.concat("_").concat(columnName) : null;
	}

	public T loadOneData(Class<T> type, String query, SqlParams[] params) {
		this.type = type;
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		for (SqlParams p : params) {
			parameter.addValue(p.getParamName(), p.getValue());
		}
		T results = null;
		if (controleEntity(type)) {
			results = jdbc.queryForObject(query, parameter, new RowMapper<T>() {
				public T mapRow(ResultSet rs, final int rowNum) throws SQLException {
					T entity = giveInstance(type);
					ResultSetMetaData rsmt = rs.getMetaData();
					int columns = rsmt.getColumnCount();
					int icol = 1;
					Colonnes colonne;
					List<Colonnes> colonnes = new ArrayList<>();
					;
					while (icol <= columns) {
						colonne = new Colonnes();
						colonne.setName(rsmt.getColumnName(icol));
						colonne.setType(rsmt.getColumnTypeName(icol));
						colonne.setNameTable(rsmt.getTableName(icol));
						colonne.setNameTable(rsmt.getTableName(icol));
						colonne.setValue(rs.getObject(icol));
						colonnes.add(colonne);
						icol++;
					}
					exclusions.clear();
					exclusions.add(type.getName());
					entity = fillDataWithJdbc(entity, colonnes);
					return entity;
				}
			});
		}
		return results;
	}

	/** Méthode d'entrée **/
	public List<T> loadDataWithJdbc(Class<T> type, String query) {
		return loadDataWithJdbc(type, query, null);
	}

	public T loadOneWithJdbc(Class<T> type, String query, SqlParams[] params) {
		this.type = type;
		T results = null;
		if (controleEntity(type)) {
			List<List<Colonnes>> datas = selectSqlData(query, params);
			T entity;
			if (datas.size() > 0) {
				entity = giveInstance(type);
				exclusions.clear();
				exclusions.add(type.getName());
				results = fillDataWithJdbc(entity, datas.get(0));
			}
		}
		return results;
	}

	public List<T> loadDataWithJdbc(Class<T> type, String query, SqlParams[] params) {
		this.type = type;
		List<T> results = new ArrayList<>();
		if (controleEntity(type)) {
			List<List<Colonnes>> datas = selectSqlData(query, params);
			T entity;
			for (List<Colonnes> line : datas) {
				entity = giveInstance(type);
				exclusions.clear();
				exclusions.add(type.getName());
				results.add(fillDataWithJdbc(entity, line));
			}
		}
		return results;
	}

	public List<List<Colonnes>> selectSqlData(String query, SqlParams[] params) {
		List<List<Colonnes>> datas = new ArrayList<>();
		List<Colonnes> colonnes;
		try (Connection connexion = ds.getConnection()) {
			PreparedStatement st = ds.getConnection().prepareStatement(query);
			if (params != null ? params.length > 0 : false) {
				for (SqlParams p : params) {
					st.setObject(p.getIndex(), p.getValue());
				}
			}
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmt = rs.getMetaData();
			int columns = rsmt.getColumnCount();
			while (rs.next()) {
				int icol = 1;
				Colonnes colonne;
				colonnes = new ArrayList<>();
				while (icol <= columns) {
					colonne = new Colonnes();
					colonne.setName(rsmt.getColumnName(icol));
					colonne.setType(rsmt.getColumnTypeName(icol));
					colonne.setNameTable(rsmt.getTableName(icol));
					colonne.setNameTable(rsmt.getTableName(icol));
					colonne.setValue(rs.getObject(icol));
					colonnes.add(colonne);
					icol++;
				}
				datas.add(colonnes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	// récupère les paramètre nommée dans la requete
	private List<String> getParam(String query) {
		List<String> params = new ArrayList<>();
		if (ConstantesManager.isString(query)) {
			Pattern pattern = Pattern.compile(ConstantesManager.regexParam);
			Matcher result = pattern.matcher(query);
			while (result.find()) {
				params.add(result.group());
			}
		}
		return params;
	}

	/** Construit l'objet à partir du résultat de la requête **/
	public T fillDataWithJdbc(T entity, List<Colonnes> datas) {
		if (entity != null && datas != null) {
			Entity a = entity.getClass().getAnnotation(Entity.class);
			if (a != null) {
				for (Field f : entity.getClass().getDeclaredFields()) {
					f.setAccessible(true);
					if (hasColumOrJoinColum(f)) {
						if (!f.getType().getClass().equals(entity.getClass())) {
							buildField(entity, f, datas);
						} else {
							// ici, on peut charger seulement certaine propriétés
						}
					}

				}
			} else {
				System.err.println("La classe doit porter l'annotation @Entity");
			}

		}
		return entity;
	}

	private void buildField(T entity, Field champ, List<Colonnes> datas) {
		// vérifie si le champ est une classe
		String table = hasTableAnnotation(entity);
		try {
			if (hasEntityAnnotation(champ)) {
				/*
				 * construit l'objet avec ses propriété en excluant... on vérifie dabord que la
				 * colone est représenté dans la requete
				 */
				String s = getJoinColumnOrColumnNameAnnotation(champ);
				String tableAttribut = champ.getType().getName();
				int idx = datas.indexOf(new Colonnes(s, table));
				if (idx >= 0 && !exclusions.contains(tableAttribut)) {
					champ.set(entity, fillDataWithJdbc(giveInstance(champ), datas));
				}
				exclusions.add(tableAttribut);
			} else {
				Object o = getValue(table, champ, datas);
				champ.set(entity, o);
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean hasColumOrJoinColum(Field f) {
		Annotation a = f.getAnnotation(Column.class);
		if (a != null) {
			return true;
		} else {
			a = f.getAnnotation(JoinColumn.class);
			if (a != null)
				return true;
		}
		return false;
	}

	private boolean hasEntityAnnotation(Field f) {
		Annotation a = f.getType().getAnnotation(Entity.class);
		if (a != null) {
			return true;
		} else {
			return false;
		}
	}

	private String hasTableAnnotation(T entity) {
		Table a = entity.getClass().getAnnotation(Table.class);
		if (a != null) {
			return a.name();
		} else {
			return null;
		}
	}

	private String hasTableAnnotation(Class<T> entity) {
		Table a = entity.getAnnotation(Table.class);
		if (a != null) {
			return a.name();
		} else {
			return null;
		}
	}

	private String getJoinColumnOrColumnNameAnnotation(Field f) {
		JoinColumn a = f.getAnnotation(JoinColumn.class);
		if (a != null) {
			return a.name();
		} else {
			Column c = f.getAnnotation(Column.class);
			if (c != null) {
				return c.name();
			}
		}
		return null;
	}

	private String getAliasAnnotation(Object classe) {
		YvsAlias a = classe.getClass().getAnnotation(YvsAlias.class);
		if (a != null) {
			return a.name();
		}
		return null;
	}

	private T giveInstance(Field f) {
		T o = null;
		try {
			Class c = Class.forName(f.getType().getName());
			Constructor[] ctors = c.getDeclaredConstructors();
			Constructor ctor = null;
			for (int i = 0; i < ctors.length; i++) {
				ctor = ctors[i];
				ctor.setAccessible(true);
				if (ctor.getGenericParameterTypes().length == 0)
					break;
			}
			ctor.setAccessible(true);
			o = (T) ctor.newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	private T giveInstance(Class<T> classe) {
		T o = null;
		try {
			Class c = Class.forName(classe.getName());
			Constructor[] ctors = c.getDeclaredConstructors();
			Constructor ctor = null;
			for (int i = 0; i < ctors.length; i++) {
				ctor = ctors[i];
				ctor.setAccessible(true);
				if (ctor.getGenericParameterTypes().length == 0)
					break;
			}
			ctor.setAccessible(true);
			o = (T) ctor.newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	/*
	 * Contrôle que la classe passé en paramètre contient bien l'anotation @Table
	 * avec la propriété name définit
	 */
	private boolean controleEntity(Class<T> type) {
		if (type != null) {
			this.tableName = hasTableAnnotation(type);
			if (this.tableName != null) {
				return true;
			}
		}
		return false;
	}

	public Object getValue(String table, Field f, List<Colonnes> datas) {
		if (f != null) {
			String colName = null;
			// récupère la notation
			Column an = f.getAnnotation(Column.class);
			if (an != null) {
				colName = an.name();
			} else {
				System.err.println(" Not column ... " + f.getName());
			}
			if (ConstantesManager.isString(table) && ConstantesManager.isString(colName)) {
				Colonnes e = new Colonnes(colName, table);
				int idx = datas.indexOf(e);
				if (idx >= 0) {
					if (!f.getType().getSimpleName().toLowerCase().equals("character")) {
						e = (datas.get(idx));
					} else {
						e = (datas.get(idx));
						if (e != null ? e.getValue() != null : false) {
							e.setValue(Character.valueOf(e.getValue().toString().charAt(0)));
						}
					}
				}
				return (e != null) ? e.getValue() : null;
			}
		}
		return null;
	}

}
