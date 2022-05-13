package com.erp.lymytz.api.controller.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseFamilleArticle;
import com.erp.lymytz.api.repository.base.article.FamilleArticleRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCFamilleArticleRepo;
import com.erp.lymytz.api.service.base.article.IFamilleArticle;

@Service
public class ManagedFamilleArticle extends ManagedEntity<YvsBaseFamilleArticle, Long> implements IFamilleArticle{

	@Autowired
	FamilleArticleRepo repository;
	@Autowired
	JDBCFamilleArticleRepo jdbc;
	
	@Override
	public JDBCEntityRepo<YvsBaseFamilleArticle, Long> getJdbc() {
		return jdbc;
	}
	
	@Override
	public JpaRepository<YvsBaseFamilleArticle, Long> getRepository() {
		return repository;
	}
	
	@Override
	public List<YvsBaseFamilleArticle> findAll(Object societe) throws Exception {
		return repository.findBySociete((YvsSocietes)societe);
	}

}
