package com.erp.lymytz.api.repository.jdbc.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCUninteMesure implements JDBCEntityRepo<YvsBaseUniteMesure, Long>  {
	
	@Autowired
	CustomJdbcRepo<YvsBaseUniteMesure> repository;
	
	public JDBCUninteMesure() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<YvsBaseUniteMesure> findAll(){
		String query="SELECT * from yvs_base_unite_mesure u INNER JOIN yvs_societes s ON s.id=u.societe  WHERE societe=:societe ORDER BY defaut, type";
		return repository.loadData(YvsBaseUniteMesure.class, getQuery(), new SqlParams[] {new SqlParams("societe",2290)} );
	}

	@Override
	public YvsBaseUniteMesure findById(Long id) {
		String query="SELECT y.* FROM yvs_base_unite_mesure y WHERE y.id=:id";
		YvsBaseUniteMesure re=repository.loadOneData(YvsBaseUniteMesure.class, query, new SqlParams[] {new SqlParams("id", id)});		
		return re;
	}
	
	private String getQuery() {
		return "SELECT y.id unite_id, y.reference AS unite_reference, "
				+ "y.libelle AS unite_libelle "
				+ "FROM yvs_base_unite_mesure y ";
	}
}
