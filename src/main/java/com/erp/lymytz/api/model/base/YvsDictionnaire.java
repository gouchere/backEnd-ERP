package com.erp.lymytz.api.model.base;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.erp.lymytz.api.model.YvsEntity;

import lombok.Data;

@Entity
@Data
@Table(name = "yvs_dictionnaire")
public class YvsDictionnaire extends YvsEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id")
	@Id
	@SequenceGenerator(name = "yvs_dictionnaire_id_seq_name", sequenceName = "yvs_dictionnaire_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "yvs_dictionnaire_id_seq_name", strategy = GenerationType.SEQUENCE)
	@Basic(optional = false)
	private Long id;
	@Column(name = "libele")
	private String libele;
	@Column(name = "titre")
	private String titre;
	@Column(name = "actif")
	private Boolean actif;
	@Column(name = "abreviation")
	private String abreviation;

	public YvsDictionnaire() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YvsDictionnaire other = (YvsDictionnaire) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "com.erp.lymytz.api.model.base.YvsDictionnaire[ id=" + id + " ]";
	}


}
