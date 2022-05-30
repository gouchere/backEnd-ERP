package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.YvsBasePlanTarifaire;
import com.erp.lymytz.api.repository.base.article.PlanTarifaireRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCPlanTarifaireRepo;
import com.erp.lymytz.api.service.base.article.IPlanTarifaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedPlanTarifaire extends ManagedEntity<YvsBasePlanTarifaire, Long> implements IPlanTarifaire {

    @Autowired
    PlanTarifaireRepo repository;
    @Autowired
    JDBCPlanTarifaireRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBasePlanTarifaire, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBasePlanTarifaire, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBasePlanTarifaire> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
