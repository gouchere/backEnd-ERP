package com.erp.lymytz.api.model.base;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.erp.lymytz.api.model.YvsEntity;

@Entity
public class YvsAgences extends YvsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    @SequenceGenerator(sequenceName = "yvs_agences_id_seq", name = "yvs_agences_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_agences_id_seq_name", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "codeagence")
	private String codeAgence;
	@Column(name = "abbreviation")
    private String abbreviation;
	@Column(name = "adresse")
    private String adresse;
	@Column(name = "code_postal")
    private String codePostal;
	@Column(name = "designation")
    private String designation;
	@Column(name = "region")
    private String region;
	@Column(name = "telephone")
    private String telephone;
	@Column(name = "email")
    private String email;
    @Column(name = "actif")
    private Boolean actif = true;
	
	
	@ManyToOne
	@JoinColumn(name = "societe", referencedColumnName = "id")
	private YvsSocietes societe;
	
	public YvsAgences() {
		// TODO Auto-generated constructor stub
	}
	
	public YvsAgences(Long id) {
		this.id = id;
	}

	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public YvsSocietes getSociete() {
		return societe;
	}

	public void setSociete(YvsSocietes societe) {
		this.societe = societe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		YvsAgences other = (YvsAgences) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
