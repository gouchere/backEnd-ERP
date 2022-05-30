package com.erp.lymytz.api.route.base.article;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.YvsBasePlanTarifaire;
import com.erp.lymytz.api.service.base.article.IPlanTarifaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/plan_tarifaire")
public class PlanTarifaireController {

    @Autowired
    IPlanTarifaire service;

    @GetMapping("/")
    public List<YvsBasePlanTarifaire> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_article/{article}")
    public List<YvsBasePlanTarifaire> findAll(@PathVariable("article") Long article) {
        try {
            return service.findAll(new YvsBaseArticles(article));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBasePlanTarifaire findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBasePlanTarifaire> save(@RequestBody YvsBasePlanTarifaire entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBasePlanTarifaire> update(@PathVariable("id") Long id, @RequestBody YvsBasePlanTarifaire entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBasePlanTarifaire> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBasePlanTarifaire>> updateMany(@RequestBody List<YvsBasePlanTarifaire> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBasePlanTarifaire>> deleteMany(@RequestBody List<YvsBasePlanTarifaire> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
