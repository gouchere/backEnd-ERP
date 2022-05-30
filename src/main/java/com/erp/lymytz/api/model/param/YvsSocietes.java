package com.erp.lymytz.api.model.param;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.lymytz.api.model.YvsEntity;

@Entity
@Table(name = "yvs_societes")
public class YvsSocietes extends YvsEntity implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;

	public YvsSocietes() {
		// TODO Auto-generated constructor stub
	}

	public YvsSocietes(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
