package com.erp.lymytz.api.route.base.article;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.YvsBaseTarifPointLivraison;
import com.erp.lymytz.api.service.base.article.ITarifPointLivraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/article_tarif")
public class TarifPointLivraisonController {

    @Autowired
    ITarifPointLivraison service;

    @GetMapping("/")
    public List<YvsBaseTarifPointLivraison> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_article/{article}")
    public List<YvsBaseTarifPointLivraison> findAll(@PathVariable("article") Long article) {
        try {
            return service.findAll(new YvsBaseArticles(article));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBaseTarifPointLivraison findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBaseTarifPointLivraison> save(@RequestBody YvsBaseTarifPointLivraison entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBaseTarifPointLivraison> update(@PathVariable("id") Long id, @RequestBody YvsBaseTarifPointLivraison entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBaseTarifPointLivraison> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBaseTarifPointLivraison>> updateMany(@RequestBody List<YvsBaseTarifPointLivraison> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBaseTarifPointLivraison>> deleteMany(@RequestBody List<YvsBaseTarifPointLivraison> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
