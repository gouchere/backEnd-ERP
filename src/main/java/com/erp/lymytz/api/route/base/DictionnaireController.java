package com.erp.lymytz.api.route.base;

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
import com.erp.lymytz.api.model.base.YvsDictionnaire;
import com.erp.lymytz.api.service.base.IDictionnaire;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/dictionnaires")
public class DictionnaireController {

	@Autowired 
	IDictionnaire service;
	
	@GetMapping("/")
	public List<YvsDictionnaire> findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public YvsDictionnaire findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping("/")
	public ResultAction<YvsDictionnaire> save(@RequestBody YvsDictionnaire entity) throws Exception{
		return service.save(entity);
	}
	
	@PutMapping("/{id}")
	public ResultAction<YvsDictionnaire> update(@PathVariable("id") Long id, @RequestBody YvsDictionnaire entity) throws Exception {
		return service.update(id, entity);
	}
	
	@DeleteMapping("/{id}")
	public ResultAction<YvsDictionnaire> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}
	
	@PostMapping("/updates")
	public ResultAction<List<YvsDictionnaire>> updateMany(@RequestBody List<YvsDictionnaire> entities) throws Exception {
		return service.updateMany(entities);
	}
	
	@PostMapping("/deletes")
	public ResultAction<List<YvsDictionnaire>> deleteMany(@RequestBody List<YvsDictionnaire> entities) throws Exception {
		return service.deleteMany(entities);
	}
}
