package com.erp.lymytz.api.repository.jdbc;

import java.util.List;

public interface JDBCEntityRepo<T, K> {
	
	public List<T> findAll();

	public T findById(K id);

}
