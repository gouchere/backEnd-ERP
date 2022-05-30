package com.erp.lymytz.api.repository.jdbc.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseTarifPointLivraison;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCTarifPointLivraisonRepo implements JDBCEntityRepo<YvsBaseTarifPointLivraison, Long> {

	@Autowired
	CustomJdbcRepo<YvsBaseTarifPointLivraison> jdbcRepository;

	public JDBCTarifPointLivraisonRepo() {
		// TODO Auto-generated constructor stub
	}

	public List<YvsBaseTarifPointLivraison> findAll(){
		String query="SELECT y.* FROM yvs_base_articles y INNER JOIN yvs_base_famille_article f "
				+ "ON y.famille=f.id ORDER BY y.designation";
		return jdbcRepository.loadData(YvsBaseTarifPointLivraison.class, query, new SqlParams[] {});
	}

	public YvsBaseTarifPointLivraison findById(Long id){
		String query="SELECT y.* FROM yvs_base_articles y WHERE id=:id";
		return jdbcRepository.loadOneData(YvsBaseTarifPointLivraison.class, query,new SqlParams[] {new SqlParams("id", id)});
	}
}
