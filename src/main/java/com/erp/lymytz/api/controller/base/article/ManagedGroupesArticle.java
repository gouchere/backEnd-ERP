package com.erp.lymytz.api.controller.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseGroupesArticle;
import com.erp.lymytz.api.repository.base.article.GroupesArticleRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCGroupesArticleRepo;
import com.erp.lymytz.api.service.base.article.IGroupesArticle;

@Service
public class ManagedGroupesArticle extends ManagedEntity<YvsBaseGroupesArticle, Long> implements IGroupesArticle{

	@Autowired
	GroupesArticleRepo repository;
	@Autowired
	JDBCGroupesArticleRepo jdbc;
	
	@Override
	public JDBCEntityRepo<YvsBaseGroupesArticle, Long> getJdbc() {
		return jdbc;
	}
	
	@Override
	public JpaRepository<YvsBaseGroupesArticle, Long> getRepository() {
		return repository;
	}
	
	@Override
	public List<YvsBaseGroupesArticle> findAll(Object societe) throws Exception {
		return repository.findBySociete((YvsSocietes)societe);
	}

}
