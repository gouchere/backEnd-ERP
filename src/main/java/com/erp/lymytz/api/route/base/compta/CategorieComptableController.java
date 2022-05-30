package com.erp.lymytz.api.route.base.compta;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.service.base.compta.ICategorieComptable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/categorie_comptable")
public class CategorieComptableController {

    @Autowired
    ICategorieComptable service;

    @GetMapping("/")
    public List<YvsBaseCategorieComptable> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_societe/{societe}")
    public List<YvsBaseCategorieComptable> findAll(@PathVariable("societe") Integer societe) {
        try {
            return service.findAll(new YvsSocietes(societe));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBaseCategorieComptable findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBaseCategorieComptable> save(@RequestBody YvsBaseCategorieComptable entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBaseCategorieComptable> update(@PathVariable("id") Long id, @RequestBody YvsBaseCategorieComptable entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBaseCategorieComptable> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBaseCategorieComptable>> updateMany(@RequestBody List<YvsBaseCategorieComptable> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBaseCategorieComptable>> deleteMany(@RequestBody List<YvsBaseCategorieComptable> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
