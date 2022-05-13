package com.erp.lymytz.api.repository.base.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseClassesStat;



@Repository
public interface ClassesStatRepo extends JpaRepository<YvsBaseClassesStat, Long> {
	
	List<YvsBaseClassesStat> findBySociete(YvsSocietes societe);

}