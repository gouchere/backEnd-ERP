package com.erp.lymytz.api.controller.base.article.param;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.param.YvsBaseClassesStat;
import com.erp.lymytz.api.repository.base.article.param.ClassesStatRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.param.JDBCClassesStatRepo;
import com.erp.lymytz.api.service.base.article.param.IClassesStat;

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
