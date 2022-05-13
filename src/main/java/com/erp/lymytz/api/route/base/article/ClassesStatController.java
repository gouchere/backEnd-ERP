package com.erp.lymytz.api.route.base.article;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseClassesStat;
import com.erp.lymytz.api.service.base.article.IClassesStat;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/classe_statistique")
public class ClassesStatController {

	@Autowired 
	IClassesStat service;
	
	@GetMapping("/")
	public List<YvsBaseClassesStat> findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/by_societe/{societe}")
	public List<YvsBaseClassesStat> findAll(@PathVariable("societe") Integer societe){
		try {
			return service.findAll(new YvsSocietes(societe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public YvsBaseClassesStat findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping("/")
	public ResultAction<YvsBaseClassesStat> save(@RequestBody YvsBaseClassesStat entity) throws Exception{
		return service.save(entity);
	}
	
	@PutMapping("/{id}")
	public ResultAction<YvsBaseClassesStat> update(@PathVariable("id") Long id, @RequestBody YvsBaseClassesStat entity) throws Exception {
		return service.update(id, entity);
	}
	
	@DeleteMapping("/{id}")
	public ResultAction<YvsBaseClassesStat> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}
	
	@PostMapping("/updates")
	public ResultAction<List<YvsBaseClassesStat>> updateMany(@RequestBody List<YvsBaseClassesStat> entities) throws Exception {
		return service.updateMany(entities);
	}
	
	@PostMapping("/deletes")
	public ResultAction<List<YvsBaseClassesStat>> deleteMany(@RequestBody List<YvsBaseClassesStat> entities) throws Exception {
		return service.deleteMany(entities);
	}

}
