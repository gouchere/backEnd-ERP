package com.erp.lymytz.api.model.base.article;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.erp.lymytz.api.converter.base.ConverterSociete;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Data
@Table(name = "yvs_base_articles_template")

public class YvsBaseArticlesTemplate extends YvsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_articles_template_id_seq", name = "yvs_articles_template_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_articles_template_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "change_prix")
    private Boolean changePrix;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "def_norme")
    private Boolean defNorme;
    @Column(name = "designation")
    private String designation;
    @Column(name = "mode_conso")
    private String modeConso;
    @Column(name = "ref_art")
    private String refArt;
    @Basic(optional = false)
    @Column(name = "suivi_en_stock")
    private Boolean suiviEnStock;
    @Basic(optional = false)
    @Column(name = "visible_en_synthese")
    private Boolean visibleEnSynthese;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coefficient")
    private Double coefficient;
    @Column(name = "service")
    private Boolean service;
    @Column(name = "methode_val")
    private String methodeVal;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "duree_vie")
    private Double dureeVie;
    @Column(name = "duree_garantie")
    private Double dureeGarantie;
    @Column(name = "fichier")
    private String fichier;
    @Column(name = "code_barre")
    private String codeBarre;

    @JoinColumn(name = "classe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseClassesStat classe;
    @JoinColumn(name = "groupe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseGroupesArticle groupe;
    @JoinColumn(name = "famille", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseFamilleArticle famille;
    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterSociete.class)
    private YvsSocietes societe;

    public YvsBaseArticlesTemplate() {

    }

    public YvsBaseArticlesTemplate(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseArticlesTemplate(String ref) {
        this();
        this.refArt = ref;
    }

    public YvsBaseArticlesTemplate(Long id, String ref, String des) {
        this();
        this.id = id;
        this.refArt = ref;
        this.designation = des;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCodeBarre() {
        return codeBarre != null ? codeBarre : "";
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public Boolean getChangePrix() {
        return changePrix != null ? changePrix : false;
    }

    public void setChangePrix(Boolean changePrix) {
        this.changePrix = changePrix;
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDefNorme() {
        return defNorme!=null?defNorme:false;
    }

    public void setDefNorme(Boolean defNorme) {
        this.defNorme = defNorme;
    }

    public String getDesignation() {
        return designation != null ? designation : "";
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getModeConso() {
        return modeConso != null ? modeConso : "";
    }

    public void setModeConso(String modeConso) {
        this.modeConso = modeConso;
    }

    public Boolean getSuiviEnStock() {
        return suiviEnStock != null ? suiviEnStock : false;
    }

    public void setSuiviEnStock(Boolean suiviEnStock) {
        this.suiviEnStock = suiviEnStock;
    }

    public Boolean getVisibleEnSynthese() {
        return visibleEnSynthese!=null?visibleEnSynthese:false;
    }

    public void setVisibleEnSynthese(Boolean visibleEnSynthese) {
        this.visibleEnSynthese = visibleEnSynthese;
    }

    public Double getCoefficient() {
        return coefficient != null ? coefficient : 0.0;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Boolean getService() {
        return service != null ? service : false;
    }

    public void setService(Boolean service) {
        this.service = service;
    }

    public String getMethodeVal() {
        return methodeVal != null ? methodeVal : "FIFO";
    }

    public void setMethodeVal(String methodeVal) {
        this.methodeVal = methodeVal;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getCategorie() {
        return categorie != null ? categorie : "";
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getDureeVie() {
        return dureeVie != null ? dureeVie : 0.0;
    }

    public void setDureeVie(Double dureeVie) {
        this.dureeVie = dureeVie;
    }

    public Double getDureeGarantie() {
        return dureeGarantie != null ? dureeGarantie : 0.0;
    }

    public void setDureeGarantie(Double dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    public String getFichier() {
        return fichier != null ? fichier : "";
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public YvsBaseGroupesArticle getGroupe() {
        return groupe;
    }

    public void setGroupe(YvsBaseGroupesArticle groupe) {
        this.groupe = groupe;
    }

    public YvsBaseFamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(YvsBaseFamilleArticle famille) {
        this.famille = famille;
    }

    public String getRefArt() {
        return refArt != null ? refArt : "";
    }

    public void setRefArt(String refArt) {
        this.refArt = refArt;
    }

    public YvsBaseClassesStat getClasse() {
        return classe;
    }

    public void setClasse(YvsBaseClassesStat classe) {
        this.classe = classe;
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
        if (!(object instanceof YvsBaseArticlesTemplate)) {
            return false;
        }
        YvsBaseArticlesTemplate other = (YvsBaseArticlesTemplate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticlesTemplate[ id=" + id + " ]";
    }
}
