package com.erp.lymytz.api.repository.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticleSubstitution;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleSubstitutionRepo extends JpaRepository<YvsBaseArticleSubstitution, Long> {

	@Modifying
	@Query(name = "YvsBaseArticleSubstitution.findAll")
	List<YvsBaseArticleSubstitution> findByArticle(@Param("article") YvsBaseArticles article);
}
