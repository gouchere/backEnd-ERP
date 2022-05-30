package com.erp.lymytz.api.model.base.tiers;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsDictionnaire;
import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable;
import com.erp.lymytz.api.model.base.param.YvsBaseModelReglement;
import com.erp.lymytz.api.model.param.YvsAgences;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_tiers")
@NamedQueries({
        @NamedQuery(name = "YvsBaseTiers.findAll", query = "SELECT y FROM YvsBaseTiers y WHERE y.societe = :societe")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBaseTiers extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_tiers_id_seq", name = "yvs_tiers_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_tiers_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "bp")
    private String bp;
    @Column(name = "civilite")
    private String civilite;
    @Column(name = "classe")
    private String classe;
    @Column(name = "code_barre")
    private String codeBarre;
    @Column(name = "code_tiers")
    private String codeTiers;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email")
    private String email;
    @Column(name = "logo")
    private String logo;
    @Column(name = "nom")
    private String nom;
    @Column(name = "point_de_vente")
    private String pointDeVente;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "tel")
    private String tel;
    @Column(name = "code_postal")
    private String codePostal;
    @Column(name = "code_ration")
    private String codeRation;
    @Column(name = "responsable")
    private String responsable;
    @Column(name = "statut")
    private String statut;
    @Column(name = "site")
    private String site;
    @Column(name = "always_visible")
    private Boolean alwaysVisible;
    @Basic(optional = true)
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "fabriquant")
    private Boolean fabriquant;
    @Column(name = "compte")
    private String compte;
    @Column(name = "employe")
    private Boolean employe;
    @Column(name = "client")
    private Boolean client;
    @Column(name = "fournisseur")
    private Boolean fournisseur;
    @Column(name = "representant")
    private Boolean representant;
    @Column(name = "st_societe")
    private Boolean stSociete;
    @Column(name = "personnel")
    private Boolean personnel;

    @JoinColumn(name = "compte_collectif", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBasePlanComptable compteCollectif;
    @JoinColumn(name = "pays", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsDictionnaire pays;
    @JoinColumn(name = "ville", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsDictionnaire ville;
    @JoinColumn(name = "secteur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsDictionnaire secteur;
    //    @JoinColumn(name = "ristourne", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private YvsComPlanRistourne ristourne;
//    @JoinColumn(name = "comission", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private YvsComPlanCommission comission;
    @JoinColumn(name = "mdr", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseModelReglement mdr;
    @JoinColumn(name = "categorie_comptable", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseCategorieComptable categorieComptable;
    @JoinColumn(name = "agence", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsAgences agence;
    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsSocietes societe;

//    @OneToOne(mappedBy = "tiers", fetch = FetchType.LAZY)
//    private YvsExtTiers codeExterne;

    public YvsBaseTiers() {
        super();
    }

    public YvsBaseTiers(String codeTiers) {
        this();
        this.codeTiers = codeTiers;
    }

    public YvsBaseTiers(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseTiers(Long id, String codeTiers) {
        this(id);
        this.codeTiers = codeTiers;
    }

    public YvsBaseTiers(Long id, String nom, String prenom) {
        this(id);
        this.nom = nom;
        this.prenom = prenom;
    }

    public YvsBaseTiers(Long id, String codeTiers, String nom, String prenom) {
        this(id);
        this.codeTiers = codeTiers;
        this.nom = nom;
        this.prenom = prenom;
    }

    public YvsBaseTiers(Long id, boolean client, boolean fournisseur, boolean representant, boolean societe, boolean sup) {
        this(id);
        this.client = client;
        this.fournisseur = fournisseur;
        this.representant = representant;
        this.stSociete = societe;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeRation() {
        return codeRation != null ? codeRation.trim() : "";
    }

    public void setCodeRation(String codeRation) {
        this.codeRation = codeRation;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getCodeTiers() {
        return codeTiers != null ? codeTiers : "";
    }

    public void setCodeTiers(String codeTiers) {
        this.codeTiers = codeTiers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNom() {
        return nom != null ? nom : "";
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(String pointDeVente) {
        this.pointDeVente = pointDeVente;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Boolean getAlwaysVisible() {
        return alwaysVisible != null ? alwaysVisible : false;
    }

    public void setAlwaysVisible(Boolean alwaysVisible) {
        this.alwaysVisible = alwaysVisible;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean getFabriquant() {
        return fabriquant != null ? fabriquant : false;
    }

    public void setFabriquant(Boolean fabriquant) {
        this.fabriquant = fabriquant;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public Boolean getEmploye() {
        return employe != null ? employe : false;
    }

    public void setEmploye(Boolean employe) {
        this.employe = employe;
    }

    public YvsDictionnaire getSecteur() {
        return secteur;
    }

    public void setSecteur(YvsDictionnaire secteur) {
        this.secteur = secteur;
    }

    public YvsBasePlanComptable getCompteCollectif() {
        return compteCollectif;
    }

    public void setCompteCollectif(YvsBasePlanComptable compteCollectif) {
        this.compteCollectif = compteCollectif;
    }

//    public YvsComPlanRistourne getRistourne() {
//        return ristourne;
//    }
//
//    public void setRistourne(YvsComPlanRistourne ristourne) {
//        this.ristourne = ristourne;
//    }
//
//    public YvsComPlanCommission getComission() {
//        return comission;
//    }
//
//    public void setComission(YvsComPlanCommission comission) {
//        this.comission = comission;
//    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public YvsDictionnaire getPays() {
        return pays;
    }

    public void setPays(YvsDictionnaire pays) {
        this.pays = pays;
    }

    public YvsDictionnaire getVille() {
        return ville;
    }

    public void setVille(YvsDictionnaire ville) {
        this.ville = ville;
    }

    public YvsAgences getAgence() {
        return agence;
    }

    public void setAgence(YvsAgences agence) {
        this.agence = agence;
    }

    public YvsBaseCategorieComptable getCategorieComptable() {
        return categorieComptable;
    }

    public void setCategorieComptable(YvsBaseCategorieComptable categorieComptable) {
        this.categorieComptable = categorieComptable;
    }

    public Boolean getClient() {
        return client != null ? client : false;
    }

    public void setClient(Boolean client) {
        this.client = client;
    }

    public Boolean getFournisseur() {
        return fournisseur != null ? fournisseur : false;
    }

    public void setFournisseur(Boolean fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Boolean getRepresentant() {
        return representant != null ? representant : false;
    }

    public void setRepresentant(Boolean representant) {
        this.representant = representant;
    }

    public Boolean getStSociete() {
        return stSociete != null ? stSociete : false;
    }

    public void setStSociete(Boolean stSociete) {
        this.stSociete = stSociete;
    }

    public Boolean getPersonnel() {
        return personnel != null ? personnel : false;
    }

    public void setPersonnel(Boolean personnel) {
        this.personnel = personnel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YvsBaseTiers)) {
            return false;
        }
        YvsBaseTiers other = (YvsBaseTiers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.tiers.YvsBaseTiers[ id=" + id + " ]";
    }

}
