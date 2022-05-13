package com.erp.lymytz.api.model.base;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "yvs_users_agence")
public class YvsUsersAgence implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @SequenceGenerator(sequenceName = "yvs_users_agence_id_seq", name = "yvs_users_agence_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_users_agence_id_seq_name", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "can_action")
    private Boolean canAction; //l'utilisateur peut modifier les données de cette agence
    @Column(name = "connecte")
    private Boolean connecte;	//l'utilisateur peut se connecter et voir les données de cette agence
    @Column(name = "user_systeme")
    private Boolean userSysteme;
    
    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @Column(name = "date_save")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSave;
    
    public YvsUsersAgence() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Boolean getCanAction() {
		return canAction;
	}

	public void setCanAction(Boolean canAction) {
		this.canAction = canAction;
	}

	public Boolean getConnecte() {
		return connecte;
	}

	public void setConnecte(Boolean connecte) {
		this.connecte = connecte;
	}

	public Boolean getUserSysteme() {
		return userSysteme;
	}

	public void setUserSysteme(Boolean userSysteme) {
		this.userSysteme = userSysteme;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Date getDateSave() {
		return dateSave;
	}

	public void setDateSave(Date dateSave) {
		this.dateSave = dateSave;
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
		YvsUsersAgence other = (YvsUsersAgence) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
