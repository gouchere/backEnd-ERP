package com.erp.lymytz.api.model.base;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.erp.lymytz.api.converter.param.ConverterSociete;
import com.erp.lymytz.api.model.YvsAlias;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Table(name = "yvs_base_unite_mesure")
@YvsAlias(name = "unite")
public class YvsBaseUniteMesure extends YvsEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@SequenceGenerator(sequenceName = "yvs_prod_unite_mesure_id_seq", name = "yvs_prod_unite_mesure_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_prod_unite_mesure_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
	private Long id;
	@Column(name = "reference")
	private String reference;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "description")
	private String description;
	@Column(name = "type")
	private String type;
	@Column(name = "actif")
	private Boolean actif;
	@Column(name = "defaut")
	private Boolean defaut;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "societe", referencedColumnName = "id")
	@JsonSerialize(converter = ConverterSociete.class)
	private YvsSocietes societe;

	public YvsBaseUniteMesure() {
		// TODO Auto-generated constructor stub
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public YvsSocietes getSociete() {
		return societe;
	}

	public void setSociete(YvsSocietes societe) {
		this.societe = societe;
	}

	public Boolean getDefaut() {
		return defaut==null?false:defaut;
	}

	public void setDefaut(Boolean defaut) {
		this.defaut = defaut;
	}

	public Boolean getActif() {
		return actif!=null?actif:false;
	}

	public void setActif(Boolean defaut) {
		this.actif = defaut;
	}

}
