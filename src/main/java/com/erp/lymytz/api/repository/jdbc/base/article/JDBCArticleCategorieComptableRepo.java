package com.erp.lymytz.api.repository.jdbc.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticleCategorieComptable;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleDepot;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCArticleCategorieComptableRepo implements JDBCEntityRepo<YvsBaseArticleCategorieComptable, Long> {

	@Autowired
	CustomJdbcRepo<YvsBaseArticleCategorieComptable> jdbcRepository;

	public JDBCArticleCategorieComptableRepo() {
		// TODO Auto-generated constructor stub
	}

	public List<YvsBaseArticleCategorieComptable> findAll(){
		String query="SELECT y.* FROM yvs_base_articles y INNER JOIN yvs_base_famille_article f "
				+ "ON y.famille=f.id ORDER BY y.designation";
		return jdbcRepository.loadData(YvsBaseArticleCategorieComptable.class, query, new SqlParams[] {});
	}

	public YvsBaseArticleCategorieComptable findById(Long id){
		String query="SELECT y.* FROM yvs_base_articles y WHERE id=:id";
		return jdbcRepository.loadOneData(YvsBaseArticleCategorieComptable.class, query,new SqlParams[] {new SqlParams("id", id)});
	}
}
