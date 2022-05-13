package com.erp.lymytz.api.service;

import java.io.Serializable;
import java.util.List;

import com.erp.lymytz.api.model.ResultAction;

public interface IEntity<T extends Serializable, K> {

	public List<T> findAll(Object value) throws Exception;

	public List<T> findAll() throws Exception;
	
	public T findById(K id) throws Exception;

	public ResultAction<T> save(T entity) throws Exception;

	public ResultAction<T> update(K id, T entity) throws Exception;

	public ResultAction<List<T>> updateMany(List<T> list) throws Exception;

	public ResultAction<T> delete(K id) throws Exception;

	public ResultAction<List<T>> deleteMany(List<T> list) throws Exception;

}
