package com.erp.lymytz.api.repository.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticleEquivalent;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleEquivalentRepo extends JpaRepository<YvsBaseArticleEquivalent, Long> {

	@Modifying
	@Query(name = "YvsBaseArticleEquivalent.findAll")
	List<YvsBaseArticleEquivalent> findByArticle(@Param("article") YvsBaseArticles article);
}
