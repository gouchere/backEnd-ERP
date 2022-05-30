package com.erp.lymytz.api.repository.jdbc.base.article;

import com.erp.lymytz.api.model.base.article.YvsBasePlanTarifaire;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCPlanTarifaireRepo implements JDBCEntityRepo<YvsBasePlanTarifaire, Long> {

	@Autowired
	CustomJdbcRepo<YvsBasePlanTarifaire> jdbcRepository;

	public JDBCPlanTarifaireRepo() {
		// TODO Auto-generated constructor stub
	}

	public List<YvsBasePlanTarifaire> findAll(){
		String query="SELECT y.* FROM yvs_base_articles y INNER JOIN yvs_base_famille_article f "
				+ "ON y.famille=f.id ORDER BY y.designation";
		return jdbcRepository.loadData(YvsBasePlanTarifaire.class, query, new SqlParams[] {});
	}

	public YvsBasePlanTarifaire findById(Long id){
		String query="SELECT y.* FROM yvs_base_articles y WHERE id=:id";
		return jdbcRepository.loadOneData(YvsBasePlanTarifaire.class, query,new SqlParams[] {new SqlParams("id", id)});
	}
}
