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
import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;
import com.erp.lymytz.api.service.base.IUniteMesure;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/unite_mesure")
public class UniteMesureController {

	@Autowired
	IUniteMesure service;

	@GetMapping("/")
	public List<YvsBaseUniteMesure> findAllUnite(){
		try {
			return service.findAll(2290L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}") 
	public YvsBaseUniteMesure findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping("/")
	public ResultAction<YvsBaseUniteMesure> save(@RequestBody YvsBaseUniteMesure entity) throws Exception{
		return service.save(entity);
	}
	
	@PutMapping("/{id}")
	public ResultAction<YvsBaseUniteMesure> update(@PathVariable("id") Long id, @RequestBody YvsBaseUniteMesure entity) throws Exception {
		return service.update(id, entity);
	}	
	
	@DeleteMapping("/{id}")
	public ResultAction<YvsBaseUniteMesure> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}
	
	@PostMapping("/updates")
	public ResultAction<List<YvsBaseUniteMesure>> updateMany(@RequestBody List<YvsBaseUniteMesure> entities) throws Exception {
		return service.updateMany(entities);
	}
	
	@PostMapping("/deletes")
	public ResultAction<List<YvsBaseUniteMesure>> deleteMany(@RequestBody List<YvsBaseUniteMesure> entities) throws Exception {
		return service.deleteMany(entities);
	}

	@GetMapping("/ping")
	public void ping() {
		System.err.println("Ping server");
	}
}
