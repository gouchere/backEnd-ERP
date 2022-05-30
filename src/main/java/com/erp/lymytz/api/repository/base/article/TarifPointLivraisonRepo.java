package com.erp.lymytz.api.repository.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.YvsBaseTarifPointLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarifPointLivraisonRepo extends JpaRepository<YvsBaseTarifPointLivraison, Long> {

	@Modifying
	@Query(name = "YvsBaseTarifPointLivraison.findAll")
	List<YvsBaseTarifPointLivraison> findByArticle(@Param("article") YvsBaseArticles article);
}
