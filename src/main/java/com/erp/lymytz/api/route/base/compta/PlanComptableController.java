package com.erp.lymytz.api.route.base.compta;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.service.base.compta.IPlanComptable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/plan_comptable")
public class PlanComptableController {

    @Autowired
    IPlanComptable service;

    @GetMapping("/")
    public List<YvsBasePlanComptable> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_societe/{societe}")
    public List<YvsBasePlanComptable> findAll(@PathVariable("societe") Integer societe) {
        try {
            return service.findAll(new YvsSocietes(societe));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBasePlanComptable findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBasePlanComptable> save(@RequestBody YvsBasePlanComptable entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBasePlanComptable> update(@PathVariable("id") Long id, @RequestBody YvsBasePlanComptable entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBasePlanComptable> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBasePlanComptable>> updateMany(@RequestBody List<YvsBasePlanComptable> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBasePlanComptable>> deleteMany(@RequestBody List<YvsBasePlanComptable> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
