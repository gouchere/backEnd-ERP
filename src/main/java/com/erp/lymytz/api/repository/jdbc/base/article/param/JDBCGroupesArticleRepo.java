package com.erp.lymytz.api.repository.jdbc.base.article.param;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.article.param.YvsBaseGroupesArticle;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCGroupesArticleRepo implements JDBCEntityRepo<YvsBaseGroupesArticle, Long> {

	@Autowired
	CustomJdbcRepo<YvsBaseGroupesArticle> jdbcRepository;

	public JDBCGroupesArticleRepo() {
		// TODO Auto-generated constructor stub
	}

	public List<YvsBaseGroupesArticle> findAll(){
		String query="SELECT y.* FROM yvs_base_groupes_article y ORDER BY y.designation";
		return jdbcRepository.loadDataWithJdbc(YvsBaseGroupesArticle.class, query);
	}

	public YvsBaseGroupesArticle findById(Long id){
		String query="SELECT y.* FROM yvs_base_groupes_article y WHERE id=?";
		return jdbcRepository.loadOneWithJdbc(YvsBaseGroupesArticle.class, query,new SqlParams[] {new SqlParams(1, id)});
	}
}
