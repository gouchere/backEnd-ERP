package com.erp.lymytz.api.repository.base.emplacement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.param.YvsAgences;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots;



@Repository
public interface DepotsRepo extends JpaRepository<YvsBaseDepots, Long> {

	@Modifying
	@Query(name = "YvsBaseDepots.findAll")
	List<YvsBaseDepots> findBySociete(@Param("societe") YvsSocietes societe);

	@Modifying
	@Query(name = "YvsBaseDepots.findByAgence")
	List<YvsBaseDepots> findByAgence(@Param("agence") YvsAgences agence);
}
