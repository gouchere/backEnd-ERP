package com.erp.lymytz.api.repository.jdbc.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.article.YvsBaseArticlesTemplate;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCArticleTemplateRepo implements JDBCEntityRepo<YvsBaseArticlesTemplate, Long> {
	
	@Autowired
	CustomJdbcRepo<YvsBaseArticlesTemplate> jdbcRepository;
	
	public JDBCArticleTemplateRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public List<YvsBaseArticlesTemplate> findAll(){
		String query="SELECT y.* FROM yvs_base_articles_template y ORDER BY y.libelle";
		return jdbcRepository.loadDataWithJdbc(YvsBaseArticlesTemplate.class, query);		
	}
	
	public YvsBaseArticlesTemplate findById(Long id){
		String query="SELECT y.* FROM yvs_base_articles_template y WHERE id=?";
		return jdbcRepository.loadOneWithJdbc(YvsBaseArticlesTemplate.class, query,new SqlParams[] {new SqlParams(1, id)});		
	}
}
