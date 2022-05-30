package com.erp.lymytz.api.controller.base.compta;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.repository.base.compta.PlanComptableRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.compta.JDBCPlanComptableRepo;
import com.erp.lymytz.api.service.base.compta.IPlanComptable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedPlanComptable extends ManagedEntity<YvsBasePlanComptable, Long> implements IPlanComptable {

    @Autowired
    PlanComptableRepo repository;
    @Autowired
    JDBCPlanComptableRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBasePlanComptable, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBasePlanComptable, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBasePlanComptable> findAll(Object societe) throws Exception {
        return repository.findBySociete((YvsSocietes) societe);
    }

}
