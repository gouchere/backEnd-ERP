package com.erp.lymytz.api.controller.base.article.param;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import com.erp.lymytz.api.repository.base.article.param.ArticleTemplateRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.param.JDBCArticleTemplateRepo;
import com.erp.lymytz.api.service.base.article.param.IArticleTemplate;

@Service
public class ManagedArticleTemplate extends ManagedEntity<YvsBaseArticlesTemplate, Long> implements IArticleTemplate{

	@Autowired
	ArticleTemplateRepo repository;
	@Autowired
	JDBCArticleTemplateRepo jdbc;

	@Override
	public JDBCEntityRepo<YvsBaseArticlesTemplate, Long> getJdbc() {
		return jdbc;
	}

	@Override
	public JpaRepository<YvsBaseArticlesTemplate, Long> getRepository() {
		return repository;
	}

	@Override
	public List<YvsBaseArticlesTemplate> findAll(Object societe) throws Exception {
		return repository.findBySociete((YvsSocietes)societe);
	}

}
