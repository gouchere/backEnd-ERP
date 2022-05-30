package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.YvsBaseTarifPointLivraison;
import com.erp.lymytz.api.repository.base.article.TarifPointLivraisonRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCTarifPointLivraisonRepo;
import com.erp.lymytz.api.service.base.article.ITarifPointLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedTarifPointLivraison extends ManagedEntity<YvsBaseTarifPointLivraison, Long> implements ITarifPointLivraison {

    @Autowired
    TarifPointLivraisonRepo repository;
    @Autowired
    JDBCTarifPointLivraisonRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseTarifPointLivraison, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseTarifPointLivraison, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseTarifPointLivraison> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
