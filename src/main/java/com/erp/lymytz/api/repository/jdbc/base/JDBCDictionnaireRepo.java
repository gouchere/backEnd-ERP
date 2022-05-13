package com.erp.lymytz.api.repository.jdbc.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.YvsDictionnaire;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCDictionnaireRepo implements JDBCEntityRepo<YvsDictionnaire, Long> {
	
	@Autowired
	CustomJdbcRepo<YvsDictionnaire> jdbcRepository;
	
	public JDBCDictionnaireRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public List<YvsDictionnaire> findAll(){
		System.err.println("Request call");
		String query="SELECT y.* FROM yvs_dictionnaire y ORDER BY y.titre, y.libele";
		return jdbcRepository.loadData(YvsDictionnaire.class, query,new SqlParams[] {});		
	}
	
	public YvsDictionnaire findById(Long id){
		String query="SELECT y.* FROM yvs_dictionnaire y WHERE id=:id";
		return jdbcRepository.loadOneData(YvsDictionnaire.class, query,new SqlParams[] {new SqlParams("id", id)});		
	}
}
