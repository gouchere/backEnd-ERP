package com.erp.lymytz.api.repository.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticleAnalytique;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleAnalytiqueRepo extends JpaRepository<YvsBaseArticleAnalytique, Long> {

	@Modifying
	@Query(name = "YvsBaseArticleAnalytique.findAll")
	List<YvsBaseArticleAnalytique> findByArticle(@Param("article") YvsBaseArticles article);
}
