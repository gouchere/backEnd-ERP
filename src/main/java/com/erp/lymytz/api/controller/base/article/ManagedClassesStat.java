package com.erp.lymytz.api.controller.base.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseClassesStat;
import com.erp.lymytz.api.repository.base.article.ClassesStatRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCClassesStatRepo;
import com.erp.lymytz.api.service.base.article.IClassesStat;

@Service
public class ManagedClassesStat extends ManagedEntity<YvsBaseClassesStat, Long> implements IClassesStat{

	@Autowired
	ClassesStatRepo repository;
	@Autowired
	JDBCClassesStatRepo jdbc;
	
	@Override
	public JDBCEntityRepo<YvsBaseClassesStat, Long> getJdbc() {
		return jdbc;
	}
	
	@Override
	public JpaRepository<YvsBaseClassesStat, Long> getRepository() {
		return repository;
	}
	
	@Override
	public List<YvsBaseClassesStat> findAll(Object societe) throws Exception {
		return repository.findBySociete((YvsSocietes)societe);
	}

}
