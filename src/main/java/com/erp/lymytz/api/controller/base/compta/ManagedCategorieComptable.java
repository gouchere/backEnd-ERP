package com.erp.lymytz.api.controller.base.compta;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.repository.base.compta.CategorieComptableRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.compta.JDBCCategorieComptableRepo;
import com.erp.lymytz.api.service.base.compta.ICategorieComptable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedCategorieComptable extends ManagedEntity<YvsBaseCategorieComptable, Long> implements ICategorieComptable {

    @Autowired
    CategorieComptableRepo repository;
    @Autowired
    JDBCCategorieComptableRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseCategorieComptable, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseCategorieComptable, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseCategorieComptable> findAll(Object societe) throws Exception {
        return repository.findBySociete((YvsSocietes) societe);
    }

}
