package com.erp.lymytz.api.repository.jdbc.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCArticlesRepo implements JDBCEntityRepo<YvsBaseArticles, Long> {
	
	@Autowired
	CustomJdbcRepo<YvsBaseArticles> jdbcRepository;
	
	public JDBCArticlesRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public List<YvsBaseArticles> findAll(){
		String query="SELECT y.* FROM yvs_base_articles y INNER JOIN yvs_base_famille_article f "
				+ "ON y.famille=f.id ORDER BY y.designation";
		return jdbcRepository.loadData(YvsBaseArticles.class, getQuery(), new SqlParams[] {});		
	}
	
	public YvsBaseArticles findById(Long id){
		String query="SELECT y.* FROM yvs_base_articles y WHERE id=:id";
		return jdbcRepository.loadOneData(YvsBaseArticles.class, query,new SqlParams[] {new SqlParams("id", id)});		
	}
	
	private String getQuery() {
		String query="SELECT y.id as art_id, "
				+ "y.ref_art as art_ref_art, "
				+ "f.id as famille_id, "
				+ "f.reference_famille as famille_reference_famille, "
				+ "f.designation as famille_designation "
				+ "FROM yvs_base_articles y "
				+ "INNER JOIN yvs_base_famille_article f ON y.famille=f.id "
				+ "ORDER BY y.id DESC "
				+ " LIMIT 1 ";
	return query;
	}
}
