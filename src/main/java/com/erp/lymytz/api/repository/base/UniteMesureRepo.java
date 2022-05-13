package com.erp.lymytz.api.repository.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;

@Repository
public interface UniteMesureRepo extends JpaRepository<YvsBaseUniteMesure, Long>{
	
//	@Query("SELECT y FROM YvsBaseUniteMesure y WHERE y.societe.id=:societe")
//	public List<YvsBaseUniteMesure> findBySociete(@Param("societe" ) Long idSociete);
	
	@Query("SELECT y FROM YvsBaseUniteMesure y JOIN FETCH y.societe")
	public List<YvsBaseUniteMesure>  findAll();
	
	@Query("SELECT y FROM YvsBaseUniteMesure y JOIN FETCH y.societe WHERE y.id=:id")
	public Optional<YvsBaseUniteMesure>  findById(@Param("id") Long id);

}
