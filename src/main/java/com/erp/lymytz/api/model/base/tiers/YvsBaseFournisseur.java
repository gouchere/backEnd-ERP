package com.erp.lymytz.api.model.base.tiers;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable;
import com.erp.lymytz.api.model.base.param.YvsBaseModelReglement;
import com.erp.lymytz.api.model.base.tiers.param.YvsBaseCategorieFournisseur;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_fournisseur")
@NamedQueries({
        @NamedQuery(name = "YvsBaseFournisseur.findAll", query = "SELECT y FROM YvsBaseFournisseur y WHERE y.tiers.societe = :societe ORDER BY y.tiers.nom, y.tiers.prenom")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBaseFournisseur extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_fournisseur_id_seq", name = "yvs_base_fournisseur_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_fournisseur_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @Column(name = "date_save")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSave;
    @Column(name = "code_fsseur")
    private String codeFsseur;
    @Basic(optional = true)
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "seuil_solde")
    private Double seuilSolde;
    @Column(name = "defaut")
    private Boolean defaut;
    @Column(name = "exclus_for_home")
    private Boolean exclusForHome;

    @JoinColumn(name = "tiers", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseTiers tiers;
    @JoinColumn(name = "categorie_comptable", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseCategorieComptable categorieComptable;
    @JoinColumn(name = "categorie", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseCategorieFournisseur categorie;
    @JoinColumn(name = "compte", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBasePlanComptable compte;
    @JoinColumn(name = "model", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseModelReglement model;

//    @OneToOne(mappedBy = "fournisseur", fetch = FetchType.LAZY)
//    private YvsExtFournisseur codeExterne;

    public YvsBaseFournisseur() {
        super();
    }

    public YvsBaseFournisseur(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseFournisseur(Long id, YvsBaseTiers tiers) {
        this(id);
        this.tiers = tiers;
    }

    public YvsBaseFournisseur(Long id, String code, YvsBaseTiers tiers) {
        this(id, tiers);
        this.codeFsseur = code;
    }

    public YvsBaseFournisseur(Long id, String nom, String prenom) {
        this(id);
        this.nom = nom;
        this.prenom = prenom;
    }

    public YvsBaseFournisseur(Long id, String codeFsseur, String nom, String prenom) {
        this(id, nom, prenom);
        this.codeFsseur = codeFsseur;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @XmlTransient
//    @JsonIgnore
//    public YvsExtFournisseur getCodeExterne() {
//        return codeExterne;
//    }
//
//    public void setCodeExterne(YvsExtFournisseur codeExterne) {
//        this.codeExterne = codeExterne;
//    }


    public Double getSeuilSolde() {
        return seuilSolde != null ? seuilSolde : 0.0;
    }

    public void setSeuilSolde(Double seuilSolde) {
        this.seuilSolde = seuilSolde;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public YvsBaseModelReglement getModel() {
        return model;
    }

    public void setModel(YvsBaseModelReglement model) {
        this.model = model;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public YvsBasePlanComptable getCompte() {
        return compte;
    }

    public void setCompte(YvsBasePlanComptable compte) {
        this.compte = compte;
    }

    public Boolean getExclusForHome() {
        return exclusForHome != null ? exclusForHome : false;
    }

    public void setExclusForHome(Boolean exclusForHome) {
        this.exclusForHome = exclusForHome;
    }

    public Boolean getDefaut() {
        return defaut != null ? defaut : false;
    }

    public void setDefaut(Boolean defaut) {
        this.defaut = defaut;
    }

    public String getCodeFsseur() {
        return codeFsseur != null ? codeFsseur : "";
    }

    public void setCodeFsseur(String codeFsseur) {
        this.codeFsseur = codeFsseur;
    }

    public YvsBaseTiers getTiers() {
        return tiers;
    }

    public void setTiers(YvsBaseTiers tiers) {
        this.tiers = tiers;
    }

    public YvsBaseCategorieFournisseur getCategorie() {
        return categorie;
    }

    public void setCategorie(YvsBaseCategorieFournisseur categorie) {
        this.categorie = categorie;
    }

    public YvsBaseCategorieComptable getCategorieComptable() {
        return categorieComptable;
    }

    public void setCategorieComptable(YvsBaseCategorieComptable categorieComptable) {
        this.categorieComptable = categorieComptable;
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
        if (!(object instanceof YvsBaseFournisseur)) {
            return false;
        }
        YvsBaseFournisseur other = (YvsBaseFournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.tiers.YvsBaseFournisseur[ id=" + id + " ]";
    }

}
