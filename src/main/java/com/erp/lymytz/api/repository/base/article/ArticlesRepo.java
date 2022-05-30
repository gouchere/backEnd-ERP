package com.erp.lymytz.api.repository.base.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;



@Repository
public interface ArticlesRepo extends JpaRepository<YvsBaseArticles, Long> {

	@Modifying
	@Query(name = "YvsBaseArticles.findAll")
	List<YvsBaseArticles> findBySociete(@Param("societe") YvsSocietes societe);
}
