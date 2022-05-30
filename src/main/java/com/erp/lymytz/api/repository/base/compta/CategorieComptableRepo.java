package com.erp.lymytz.api.repository.base.compta;

import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.erp.lymytz.api.model.param.YvsSocietes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategorieComptableRepo extends JpaRepository<YvsBaseCategorieComptable, Long> {

	@Modifying
	@Query(name = "YvsBaseCategorieComptable.findAll")
	List<YvsBaseCategorieComptable> findBySociete(@Param("societe") YvsSocietes societe);
}
