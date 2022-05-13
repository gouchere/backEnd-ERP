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

import com.erp.lymytz.api.converter.base.ConverterUniteMesure;
import com.erp.lymytz.api.converter.base.article.ConverterArticles;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Data
@Table(name = "yvs_base_conditionnement")

public class YvsBaseConditionnement extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_conditionnement_id_seq", name = "yvs_base_conditionnement_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_conditionnement_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix_min")
    private Double prixMin;
    @Column(name = "prix_achat")
    private Double prixAchat;
    @Column(name = "prix_prod")
    private Double prixProd;
    @Column(name = "remise")
    private Double remise;
    @Column(name = "prix")
    private Double prix;
    @Column(name = "taux_pua")
    private Double tauxPua;
    @Column(name = "cond_vente")
    private Boolean byVente;
    @Column(name = "by_prod")
    private Boolean byProd;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "by_achat")
    private Boolean byAchat;
    @Column(name = "defaut")
    private Boolean defaut;
    @Column(name = "proportion_pua")
    private Boolean proportionPua;
    @Column(name = "nature_prix_min")
    private String naturePrixMin;
    @Column(name = "photo")
    private String photo;
    @Column(name = "photo_extension")
    private String photoExtension;
    @Column(name = "code_barre")
    private String codeBarre;
    @Column(name = "marge_min")
    private Double margeMin;

    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterArticles.class)
    private YvsBaseArticles article;
    @JoinColumn(name = "unite", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterUniteMesure.class)
    private YvsBaseUniteMesure unite;

    public YvsBaseConditionnement() {

    }

    public YvsBaseConditionnement(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseConditionnement(Long id, YvsBaseUniteMesure unite) {
        this(id);
        this.unite = unite;
    }

    public YvsBaseConditionnement(Long id, YvsBaseArticles article, YvsBaseUniteMesure unite) {
        this(id, unite);
        this.article = article;
    }

    public Double getMargeMin() {
        return margeMin != null ? margeMin : 0;
    }

    public void setMargeMin(Double margeMin) {
        this.margeMin = margeMin;
    }

    public Double getPrixProd() {
        return prixProd != null ? prixProd : 0;
    }

    public void setPrixProd(Double prixProd) {
        this.prixProd = prixProd;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTauxPua() {
        return tauxPua != null ? tauxPua : 0;
    }

    public void setTauxPua(Double tauxPua) {
        this.tauxPua = tauxPua;
    }

    public Boolean getProportionPua() {
        return proportionPua != null ? proportionPua : false;
    }

    public void setProportionPua(Boolean proportionPua) {
        this.proportionPua = proportionPua;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrixAchat() {
        return prixAchat != null ? prixAchat : 0;
    }

    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Double getPrixMin() {
        return prixMin != null ? prixMin : 0;
    }

    public void setPrixMin(Double prixMin) {
        this.prixMin = prixMin;
    }

    public Double getRemise() {
        return remise != null ? remise : 0;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public Double getPrix() {
        return prix != null ? prix : 0;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getNaturePrixMin() {
        return naturePrixMin;
    }

    public void setNaturePrixMin(String naturePrixMin) {
        this.naturePrixMin = naturePrixMin;
    }

    public Boolean getDefaut() {
        return defaut != null ? defaut : false;
    }

    public void setDefaut(Boolean defaut) {
        this.defaut = defaut;
    }

    public Boolean getByVente() {
        return byVente != null ? byVente : false;
    }

    public void setByVente(Boolean byVente) {
        this.byVente = byVente;
    }

    public Boolean getByProd() {
        return byProd != null ? byProd : false;
    }

    public void setByProd(Boolean byProd) {
        this.byProd = byProd;
    }

    public Boolean getByAchat() {
        return byAchat != null ? byAchat : false;
    }

    public void setByAchat(Boolean byAchat) {
        this.byAchat = byAchat;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getPhotoExtension() {
        return photoExtension != null ? photoExtension.trim().length() > 0 ? photoExtension : "png" : "png";
    }

    public void setPhotoExtension(String photoExtension) {
        this.photoExtension = photoExtension;
    }
    public YvsBaseUniteMesure getUnite() {
        return unite;
    }

    public void setUnite(YvsBaseUniteMesure unite) {
        this.unite = unite;
    }

    public YvsBaseArticles getArticle() {
        return article;
    }

    public void setArticle(YvsBaseArticles article) {
        this.article = article;
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
        if (!(object instanceof YvsBaseConditionnement)) {
            return false;
        }
        YvsBaseConditionnement other = (YvsBaseConditionnement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseConditionnement[ id=" + id + " ]";
    }
}
