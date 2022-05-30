package com.erp.lymytz.api.model.param;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsDictionnaire;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author GOUCHERE YVES
 */
@Entity
@Table(name = "yvs_agences")
@NamedQueries({
        @NamedQuery(name = "YvsAgences.findDesignation", query = "SELECT y.designation FROM YvsAgences y WHERE y.actif=true and y.supp=false and (y.codeagence = :codeagence OR y.abbreviation=:codeagence)")
})
public class YvsAgences extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    @SequenceGenerator(sequenceName = "yvs_agences_id_seq", name = "yvs_agences_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_agences_id_seq_name", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "code_postal")
    private String codePostal;
    @Column(name = "codeagence")
    private String codeagence;
    @Column(name = "designation")
    private String designation;
    @Column(name = "last_author")
    private String lastAuthor;
    @Column(name = "region")
    private String region;
    @Column(name = "adresse_ip")
    private String adresseIp;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "actif")
    private Boolean actif = true;
    @Column(name = "supp")
    private Boolean supp = false;
    @Column(name = "last_date_save")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDateSave;

    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsSocietes societe;
    //	@JoinColumn(name = "secteur_activite", referencedColumnName = "id")
//	@ManyToOne
//	private YvsGrhSecteurs secteurActivite;
//	@JoinColumn(name = "chef_agence", referencedColumnName = "id")
//	@ManyToOne(fetch = FetchType.LAZY)
//	private YvsGrhEmployes chefAgence;
    @JoinColumn(name = "ville", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsDictionnaire ville;
//	@JoinColumn(name = "mutuelle", referencedColumnName = "id")
//	@ManyToOne(fetch = FetchType.LAZY)
//	private YvsMutMutuelle mutuelle;

    public YvsAgences() {
        super();
    }

    public YvsAgences(Long id) {
        this();
        this.id = id;
    }

    public YvsAgences(Long id, String abbreviation, String codeagence, YvsSocietes societe) {
        this(id);
        this.abbreviation = abbreviation;
        this.societe = societe;
    }

    public YvsAgences(Long id, String designation) {
        this(id);
        this.designation = designation;
    }

    public YvsAgences(Long id, String codeagence, String designation) {
        this(id, designation);
        this.codeagence = codeagence;
    }

    public YvsAgences(Long id, boolean actif, boolean supp) {
        this(id);
        this.actif = actif;
        this.supp = supp;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresseIp() {
        return adresseIp;
    }

    public void setAdresseIp(String adresseIp) {
        this.adresseIp = adresseIp;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAbbreviation() {
        return abbreviation != null ? abbreviation : "";
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

    public String getCodeagence() {
        return codeagence != null ? codeagence : "";
    }

    public void setCodeagence(String codeagence) {
        this.codeagence = codeagence;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLastAuthor() {
        return lastAuthor;
    }

    public void setLastAuthor(String lastAuthor) {
        this.lastAuthor = lastAuthor;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getSupp() {
        return supp;
    }

    public void setSupp(Boolean supp) {
        this.supp = supp;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLastDateSave() {
        return lastDateSave;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public void setLastDateSave(Date lastDateSave) {
        this.lastDateSave = lastDateSave;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

//	public YvsGrhSecteurs getSecteurActivite() {
//		return secteurActivite;
//	}
//
//	public void setSecteurActivite(YvsGrhSecteurs secteurActivite) {
//		this.secteurActivite = secteurActivite;
//	}
//
//	public YvsGrhEmployes getChefAgence() {
//		return chefAgence;
//	}
//
//	public void setChefAgence(YvsGrhEmployes chefAgence) {
//		this.chefAgence = chefAgence;
//	}

    public YvsDictionnaire getVille() {
        return ville;
    }

    public void setVille(YvsDictionnaire ville) {
        this.ville = ville;
    }

//	@XmlTransient
//	public YvsMutMutuelle getMutuelle() {
//		return mutuelle;
//	}
//
//	public void setMutuelle(YvsMutMutuelle mutuelle) {
//		this.mutuelle = mutuelle;
//	}


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YvsAgences)) {
            return false;
        }
        YvsAgences other = (YvsAgences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.param.YvsAgences{" + "id=" + id + '}';
    }
}
