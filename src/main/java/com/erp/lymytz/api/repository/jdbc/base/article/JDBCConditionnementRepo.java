package com.erp.lymytz.api.repository.jdbc.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.article.YvsBaseConditionnement;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCConditionnementRepo implements JDBCEntityRepo<YvsBaseConditionnement, Long> {
	
	@Autowired
	CustomJdbcRepo<YvsBaseConditionnement> jdbcRepository;
	
	public JDBCConditionnementRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public List<YvsBaseConditionnement> findAll(){
		String query="SELECT y.* FROM yvs_base_conditionnement y ORDER BY y.id LIMIT 1";
		System.err.println("select articles...");
		return jdbcRepository.loadDataWithJdbc(YvsBaseConditionnement.class, query);		
	}
	
	public YvsBaseConditionnement findById(Long id){
		String query="SELECT y.* FROM yvs_base_conditionnement y WHERE id=?";
		return jdbcRepository.loadOneWithJdbc(YvsBaseConditionnement.class, query,new SqlParams[] {new SqlParams(1, id)});		
	}
}
