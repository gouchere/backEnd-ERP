package com.erp.lymytz.api.route;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.service.IEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class AController<T extends Serializable, ID> implements Serializable {

    protected abstract IEntity<T, ID> getRepository();

    @GetMapping("/")
    public List<T> findAll() {
        try {
            return getRepository().findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public T findOne(@PathVariable("id") ID id) throws Exception {
        return getRepository().findById(id);
    }

    @PostMapping("/")
    public ResultAction<T> save(@RequestBody T entity) throws Exception {
        return getRepository().save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<T> update(@PathVariable("id") ID id, @RequestBody T entity) throws Exception {
        return getRepository().update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<T> delete(@PathVariable("id") ID id) throws Exception {
        return getRepository().delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<T>> updateMany(@RequestBody List<T> entities) throws Exception {
        return getRepository().updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<T>> deleteMany(@RequestBody List<T> entities) throws Exception {
        return getRepository().deleteMany(entities);
    }
}
