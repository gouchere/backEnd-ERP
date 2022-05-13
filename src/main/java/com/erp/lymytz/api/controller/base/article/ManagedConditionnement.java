package com.erp.lymytz.api.controller.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.YvsBaseConditionnement;
import com.erp.lymytz.api.repository.base.article.ConditionnementRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCConditionnementRepo;
import com.erp.lymytz.api.service.base.article.IConditionnement;

@Service
public class ManagedConditionnement extends ManagedEntity<YvsBaseConditionnement, Long> implements IConditionnement{

	@Autowired
	ConditionnementRepo repository;
	@Autowired
	JDBCConditionnementRepo jdbc;
	
	@Override
	public JDBCEntityRepo<YvsBaseConditionnement, Long> getJdbc() {
		return jdbc;
	}
	
	@Override
	public JpaRepository<YvsBaseConditionnement, Long> getRepository() {
		return repository;
	}
	
	@Override
	public List<YvsBaseConditionnement> findAll(Object article) throws Exception {
		return repository.findByArticle((YvsBaseArticles)article);
	}

}
