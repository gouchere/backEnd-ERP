package com.erp.lymytz.api.controller.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;
import com.erp.lymytz.api.repository.base.UniteMesureRepo;
import com.erp.lymytz.api.repository.jdbc.CustomJdbcRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.SqlParams;
import com.erp.lymytz.api.repository.jdbc.base.JDBCUninteMesure;
import com.erp.lymytz.api.service.base.IUniteMesure;

@Service
public class ManagedUniteMesure extends ManagedEntity<YvsBaseUniteMesure, Long> implements IUniteMesure{
	
	@Autowired
	UniteMesureRepo repository;
	@Autowired
	JDBCUninteMesure jdbcRepo;
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	CustomJdbcRepo<YvsBaseUniteMesure> jdbcRepository;

	@Override
	public List<YvsBaseUniteMesure> findAll_(Long societe) {
		String query="SELECT * from yvs_base_unite_mesure u INNER JOIN yvs_societes s ON s.id=u.societe  WHERE societe=:societe ORDER BY defaut, type";
		return jdbcRepository.loadData(YvsBaseUniteMesure.class, query, new SqlParams[] {new SqlParams("societe",2290)} );
		
	}

//	@Override
//	public YvsBaseUniteMesure loadOne(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public UniteMesureRepo getRepository() {
		return repository;
	}
	
	@Override
	public JDBCEntityRepo<YvsBaseUniteMesure, Long> getJdbc() {
		// TODO Auto-generated method stub
		return jdbcRepo;
	}
}
