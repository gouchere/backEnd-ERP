package com.erp.lymytz.api.repository.jdbc.base.emplacement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCDepotsRepo implements JDBCEntityRepo<YvsBaseDepots, Long> {
	
	@Autowired
	CustomJdbcRepo<YvsBaseDepots> jdbcRepository;
	
	public JDBCDepotsRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public List<YvsBaseDepots> findAll(){
		String query="SELECT y.* FROM yvs_base_depots y ORDER BY y.libelle";
		return jdbcRepository.loadDataWithJdbc(YvsBaseDepots.class, query);		
	}
	
	public YvsBaseDepots findById(Long id){
		String query="SELECT y.* FROM yvs_base_depots y WHERE id=?";
		return jdbcRepository.loadOneWithJdbc(YvsBaseDepots.class, query,new SqlParams[] {new SqlParams(1, id)});		
	}
}
