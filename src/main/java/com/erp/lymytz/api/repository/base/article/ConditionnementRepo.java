package com.erp.lymytz.api.repository.base.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.YvsBaseConditionnement;


@Repository
public interface ConditionnementRepo extends JpaRepository<YvsBaseConditionnement, Long> {

	@Modifying
	@Query(name = "YvsBaseConditionnement.findAll")
	List<YvsBaseConditionnement> findByArticle(@Param("article") YvsBaseArticles article);
}
