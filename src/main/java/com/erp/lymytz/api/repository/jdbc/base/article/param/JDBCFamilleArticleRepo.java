package com.erp.lymytz.api.repository.jdbc.base.article.param;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.model.base.article.param.YvsBaseFamilleArticle;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;

@Service
public class JDBCFamilleArticleRepo implements JDBCEntityRepo<YvsBaseFamilleArticle, Long> {

	@Autowired
	CustomJdbcRepo<YvsBaseFamilleArticle> jdbcRepository;

	public JDBCFamilleArticleRepo() {
		// TODO Auto-generated constructor stub
	}

	public List<YvsBaseFamilleArticle> findAll(){
		String query="SELECT y.* FROM yvs_base_famille_article y ORDER BY y.reference_famille, y.designation";
		return jdbcRepository.loadDataWithJdbc(YvsBaseFamilleArticle.class, query);
	}

	public YvsBaseFamilleArticle findById(Long id){
		String query="SELECT y.* FROM yvs_base_famille_article y WHERE id=?";
		return jdbcRepository.loadOneWithJdbc(YvsBaseFamilleArticle.class, query,new SqlParams[] {new SqlParams(1, id)});
	}
}
