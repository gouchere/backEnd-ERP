package com.erp.lymytz.api.controller.base.emplacement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.YvsAgences;
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots;
import com.erp.lymytz.api.repository.base.emplacement.DepotsRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.emplacement.JDBCDepotsRepo;
import com.erp.lymytz.api.service.base.emplacement.IDepots;

@Service
public class ManagedDepots extends ManagedEntity<YvsBaseDepots, Long> implements IDepots{

	@Autowired
	DepotsRepo repository;
	@Autowired
	JDBCDepotsRepo jdbc;
	
	@Override
	public JDBCEntityRepo<YvsBaseDepots, Long> getJdbc() {
		return jdbc;
	}
	
	@Override
	public JpaRepository<YvsBaseDepots, Long> getRepository() {
		return repository;
	}
	
	@Override
	public List<YvsBaseDepots> findAll(Object societe) throws Exception {
		return repository.findBySociete((YvsSocietes)societe);
	}
	
	public List<YvsBaseDepots> findByAgence(Object agence) throws Exception {
		return repository.findByAgence((YvsAgences)agence);
	}

}
