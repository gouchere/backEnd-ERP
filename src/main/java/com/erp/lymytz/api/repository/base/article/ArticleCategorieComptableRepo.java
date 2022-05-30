package com.erp.lymytz.api.repository.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticleCategorieComptable;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCategorieComptableRepo extends JpaRepository<YvsBaseArticleCategorieComptable, Long> {

	@Modifying
	@Query(name = "YvsBaseArticleCategorieComptable.findAll")
	List<YvsBaseArticleCategorieComptable> findByArticle(@Param("article") YvsBaseArticles article);

	@Modifying
	@Query(name = "YvsBaseArticleCategorieComptable.findByTemplate")
	List<YvsBaseArticleCategorieComptable> findByTemplate(@Param("template") YvsBaseArticlesTemplate template);
}
