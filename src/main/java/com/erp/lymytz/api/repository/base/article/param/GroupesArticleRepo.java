package com.erp.lymytz.api.repository.base.article.param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.param.YvsBaseGroupesArticle;



@Repository
public interface GroupesArticleRepo extends JpaRepository<YvsBaseGroupesArticle, Long> {


	@Modifying
	@Query(name = "YvsBaseGroupesArticle.findAll")
	List<YvsBaseGroupesArticle> findBySociete(@Param("societe") YvsSocietes societe);

}
