package com.erp.lymytz.api.controller.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticlesRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticlesRepo;
import com.erp.lymytz.api.service.base.article.IArticles;

@Service
public class ManagedArticles extends ManagedEntity<YvsBaseArticles, Long> implements IArticles{

	@Autowired
	ArticlesRepo repository;
	@Autowired
	JDBCArticlesRepo jdbc;

	@Override
	public JDBCEntityRepo<YvsBaseArticles, Long> getJdbc() {
		return jdbc;
	}

	@Override
	public JpaRepository<YvsBaseArticles, Long> getRepository() {
		return repository;
	}

	@Override
	public List<YvsBaseArticles> findAll(Object societe) throws Exception {
		return repository.findBySociete((YvsSocietes)societe);
	}

}
