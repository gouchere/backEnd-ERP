package com.erp.lymytz.api.repository.jdbc.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.article.YvsBaseClassesStat;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCClassesStatRepo implements JDBCEntityRepo<YvsBaseClassesStat, Long> {
	
	@Autowired
	CustomJdbcRepo<YvsBaseClassesStat> jdbcRepository;
	
	public JDBCClassesStatRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public List<YvsBaseClassesStat> findAll(){
		String query="SELECT y.* FROM yvs_base_classes_stat y ORDER BY y.code_ref, y.designation";
		return jdbcRepository.loadDataWithJdbc(YvsBaseClassesStat.class, query);		
	}
	
	public YvsBaseClassesStat findById(Long id){
		String query="SELECT y.* FROM yvs_base_classes_stat y WHERE id=?";
		return jdbcRepository.loadOneWithJdbc(YvsBaseClassesStat.class, query,new SqlParams[] {new SqlParams(1, id)});		
	}
}
