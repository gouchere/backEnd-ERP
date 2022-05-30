package com.erp.lymytz.api.repository.base.article.param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.param.YvsBaseClassesStat;

@Repository
public interface ClassesStatRepo extends JpaRepository<YvsBaseClassesStat, Long> {

	@Modifying
	@Query(name = "YvsBaseClassesStat.findAll")
	List<YvsBaseClassesStat> findBySociete(@Param("societe") YvsSocietes societe);

}
