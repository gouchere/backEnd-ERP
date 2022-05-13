package com.erp.lymytz.api.controller;

import java.io.Serializable;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.service.IEntity;

public abstract class ManagedEntity<T extends Serializable, K> implements IEntity<T, K> {
	
	public abstract JDBCEntityRepo<T, K> getJdbc();
	
	public abstract JpaRepository<T, K> getRepository();

	@Override
	public List<T> findAll(Object value) throws Exception{
//		return getJdbc().findAll();
		return getRepository().findAll();
	}

	@Override
	public List<T> findAll() throws Exception{ 
//		return getJdbc().findAll();
		return getRepository().findAll();
	}

	@Override
	public T findById(K id) {
		//return getJdbc().findById(id);
		java.util.Optional<T> optional =  getRepository().findById(id);
		return optional.isPresent()?optional.get():null;
	}

	@Override
	public ResultAction<T> save(T entity) {
		// TODO Auto-generated method stub
		try {
			T result= getRepository().save(entity);
			if(result!=null) {
				return new ResultAction<T>(true, result, "Succès");
			}
		}catch(Exception ex) {
			Logger.getLogger(getClass()).log(Level.ERROR, ex);
		}
		return new ResultAction<T>(false, null, "Action impossible");
	}

	@Override
	public ResultAction<T> update(K id, T entity) {
		// TODO Auto-generated method stub
		try {
			T result= getRepository().save(entity);
			if(result!=null) {
				return new ResultAction<T>(true, result, "Succès");
			}
		}catch(Exception ex) {
			Logger.getLogger(getClass()).log(Level.ERROR, ex);
		}
		return new ResultAction<T>(false, null, "Action impossible");
	}

	@Override
	public ResultAction<List<T>> updateMany(List<T> list) {
		// TODO Auto-generated method stub
		if(list!=null) {
			try {
				getRepository().saveAll(list);
				return new ResultAction<List<T>>(true, list, "Succès");
			}catch(Exception ex) {
				Logger.getLogger(getClass()).log(Level.ERROR, ex);
			}
		}
		return new ResultAction<List<T>>(false, null, "Action impossible");
	}

	@Override
	public ResultAction<T> delete(K id) {
		// TODO Auto-generated method stub
		T entity = findById(id);
		if(entity!=null) {
			try {
				getRepository().delete(entity);
				return new ResultAction<T>(true, entity, "Succès");
			}catch(Exception ex) {
				Logger.getLogger(getClass()).log(Level.ERROR, ex);
				return new ResultAction<T>(false, null, ex.getMessage());
			}
		}

		return new ResultAction<T>(false, null, "Action impossible");
	}

	@Override
	public ResultAction<List<T>> deleteMany(List<T> list) {
		// TODO Auto-generated method stub
		if(list!=null) {
			try {
				getRepository().deleteAll(list);
				return new ResultAction<List<T>>(true, list, "Succès");
			}catch(Exception ex) {
				Logger.getLogger(getClass()).log(Level.ERROR, ex);
			}
		}
		return new ResultAction<List<T>>(false, null, "Action impossible");
	}

}
