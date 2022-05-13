package com.erp.lymytz.api.controller.base;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.YvsDictionnaire;
import com.erp.lymytz.api.repository.base.DictionnaireRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.JDBCDictionnaireRepo;
import com.erp.lymytz.api.service.base.IDictionnaire;

@Service
public class ManagedDictionnaire extends ManagedEntity<YvsDictionnaire, Long> implements IDictionnaire{

	@Autowired
	DictionnaireRepo repository;
	@Autowired
	JDBCDictionnaireRepo jdbc;
	
	@Override
	public JDBCEntityRepo<YvsDictionnaire, Long> getJdbc() {
		return jdbc;
	}
	
	@Override
	public JpaRepository<YvsDictionnaire, Long> getRepository() {
		return repository;
	}

}
