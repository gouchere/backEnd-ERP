package com.erp.lymytz.api.model.base.article;

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
import javax.xml.bind.annotation.XmlTransient;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import com.erp.lymytz.api.model.base.article.param.YvsBaseFamilleArticle;
import com.erp.lymytz.api.model.base.tiers.param.YvsBaseCategorieClient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_plan_tarifaire")
@NamedQueries({
        @NamedQuery(name = "YvsBasePlanTarifaire.findAll", query = "SELECT y FROM YvsBasePlanTarifaire y WHERE y.categorie.societe = :societe"),
        @NamedQuery(name = "YvsBasePlanTarifaire.findByCategorie", query = "SELECT y FROM YvsBasePlanTarifaire y WHERE y.categorie = :categorie"),
        @NamedQuery(name = "YvsBasePlanTarifaire.findByArticle", query = "SELECT y FROM YvsBasePlanTarifaire y JOIN FETCH y.categorie WHERE y.article = :article"),
        @NamedQuery(name = "YvsBasePlanTarifaire.findByFamille", query = "SELECT y FROM YvsBasePlanTarifaire y WHERE y.famille = :famille")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBasePlanTarifaire extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_com_categorie_tarifaire_client_id_seq", name = "yvs_com_categorie_tarifaire_client_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_com_categorie_tarifaire_client_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puv")
    private Double puv;
    @Column(name = "puv_min")
    private Double puvMin;
    @Column(name = "nature_prix_min")
    private String naturePrixMin;
    @Column(name = "remise")
    private Double remise;
    @Column(name = "ristourne")
    private Double ristourne;
    @Column(name = "coef_augmentation")
    private Double coefAugmentation;
    @Column(name = "nature_coef_augmentation")
    private String natureCoefAugmentation;
    @Column(name = "nature_remise")
    private String natureRemise;
    @Column(name = "nature_ristourne")
    private String natureRistourne;
    @Column(name = "actif")
    private Boolean actif;

    @JoinColumn(name = "categorie", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseCategorieClient categorie;
    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseArticles article;
    @JoinColumn(name = "template", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseArticlesTemplate template;
    @JoinColumn(name = "famille", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseFamilleArticle famille;
    @JoinColumn(name = "conditionnement", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseConditionnement conditionnement;

    public YvsBasePlanTarifaire() {
        super();
    }

    public YvsBasePlanTarifaire(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaturePrixMin() {
        return naturePrixMin;
    }

    public void setNaturePrixMin(String naturePrixMin) {
        this.naturePrixMin = naturePrixMin;
    }

    public Double getPuvMin() {
        return puvMin != null ? puvMin : 0;
    }

    public void setPuvMin(Double puvMin) {
        this.puvMin = puvMin;
    }

    public YvsBaseFamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(YvsBaseFamilleArticle famille) {
        this.famille = famille;
    }

    public Double getRistourne() {
        return ristourne != null ? ristourne : 0;
    }

    public void setRistourne(Double ristourne) {
        this.ristourne = ristourne;
    }

    public Double getCoefAugmentation() {
        return coefAugmentation != null ? coefAugmentation : 0;
    }

    public void setCoefAugmentation(Double coefAugmentation) {
        this.coefAugmentation = coefAugmentation;
    }

    public String getNatureRemise() {
        return natureRemise;
    }

    public void setNatureRemise(String natureRemise) {
        this.natureRemise = natureRemise;
    }

    public String getNatureRistourne() {
        return natureRistourne;
    }

    public void setNatureRistourne(String natureRistourne) {
        this.natureRistourne = natureRistourne;
    }

    public String getNatureCoefAugmentation() {
        return natureCoefAugmentation;
    }

    public void setNatureCoefAugmentation(String natureCoefAugmentation) {
        this.natureCoefAugmentation = natureCoefAugmentation;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Double getPuv() {
        return puv != null ? puv : 0;
    }

    public void setPuv(Double puv) {
        this.puv = puv;
    }

    public Double getRemise() {
        return remise != null ? remise : 0;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public YvsBaseCategorieClient getCategorie() {
        return categorie;
    }

    public void setCategorie(YvsBaseCategorieClient categorie) {
        this.categorie = categorie;
    }

    public YvsBaseArticles getArticle() {
        return article;
    }

    public void setArticle(YvsBaseArticles article) {
        this.article = article;
    }

    @XmlTransient
    @JsonIgnore
    public YvsBaseArticlesTemplate getTemplate() {
        return template;
    }

    public void setTemplate(YvsBaseArticlesTemplate template) {
        this.template = template;
    }

    public YvsBaseConditionnement getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(YvsBaseConditionnement conditionnement) {
        this.conditionnement = conditionnement;
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
        if (!(object instanceof YvsBasePlanTarifaire)) {
            return false;
        }
        YvsBasePlanTarifaire other = (YvsBasePlanTarifaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBasePlanTarifaire[ id=" + id + " ]";
    }

}
