package com.erp.lymytz.api.route.base.article;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleFournisseur;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.service.base.article.IArticleFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/article_fournisseur")
public class ArticleFournisseurController {

    @Autowired
    IArticleFournisseur service;

    @GetMapping("/")
    public List<YvsBaseArticleFournisseur> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_article/{article}")
    public List<YvsBaseArticleFournisseur> findAll(@PathVariable("article") Long article) {
        try {
            return service.findAll(new YvsBaseArticles(article));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBaseArticleFournisseur findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBaseArticleFournisseur> save(@RequestBody YvsBaseArticleFournisseur entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBaseArticleFournisseur> update(@PathVariable("id") Long id, @RequestBody YvsBaseArticleFournisseur entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBaseArticleFournisseur> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBaseArticleFournisseur>> updateMany(@RequestBody List<YvsBaseArticleFournisseur> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBaseArticleFournisseur>> deleteMany(@RequestBody List<YvsBaseArticleFournisseur> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
