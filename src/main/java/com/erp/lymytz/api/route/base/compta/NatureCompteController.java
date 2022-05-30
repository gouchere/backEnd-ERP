package com.erp.lymytz.api.route.base.compta;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.compta.YvsBaseNatureCompte;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.service.base.compta.INatureCompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/nature_compte")
public class NatureCompteController {

    @Autowired
    INatureCompte service;

    @GetMapping("/")
    public List<YvsBaseNatureCompte> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_societe/{societe}")
    public List<YvsBaseNatureCompte> findAll(@PathVariable("societe") Integer societe) {
        try {
            return service.findAll(new YvsSocietes(societe));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBaseNatureCompte findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBaseNatureCompte> save(@RequestBody YvsBaseNatureCompte entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBaseNatureCompte> update(@PathVariable("id") Long id, @RequestBody YvsBaseNatureCompte entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBaseNatureCompte> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBaseNatureCompte>> updateMany(@RequestBody List<YvsBaseNatureCompte> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBaseNatureCompte>> deleteMany(@RequestBody List<YvsBaseNatureCompte> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
