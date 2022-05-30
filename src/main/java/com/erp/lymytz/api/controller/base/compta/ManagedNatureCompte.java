package com.erp.lymytz.api.controller.base.compta;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.compta.YvsBaseNatureCompte;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.repository.base.compta.NatureCompteRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.compta.JDBCNatureCompteRepo;
import com.erp.lymytz.api.service.base.compta.INatureCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedNatureCompte extends ManagedEntity<YvsBaseNatureCompte, Long> implements INatureCompte {

    @Autowired
    NatureCompteRepo repository;
    @Autowired
    JDBCNatureCompteRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseNatureCompte, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseNatureCompte, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseNatureCompte> findAll(Object societe) throws Exception {
        return repository.findBySociete((YvsSocietes) societe);
    }

}
