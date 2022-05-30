package com.erp.lymytz.api.model.base.article;

import com.erp.lymytz.api.converter.base.article.ConverterArticles;
import com.erp.lymytz.api.converter.base.article.ConverterTemplateArticle;
import com.erp.lymytz.api.converter.base.compta.ConverterCategorieComptable;
import com.erp.lymytz.api.converter.base.compta.ConverterPlanComptable;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_article_categorie_comptable", schema = "public")
@NamedQueries({
        @NamedQuery(name = "YvsBaseArticleCategorieComptable.findAll", query = "SELECT y FROM YvsBaseArticleCategorieComptable y WHERE y.article = :article"),
        @NamedQuery(name = "YvsBaseArticleCategorieComptable.findByTemplate", query = "SELECT y FROM YvsBaseArticleCategorieComptable y WHERE y.template = :template")
})
public class YvsBaseArticleCategorieComptable extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_compte_article_id_seq", name = "yvs_base_compte_article_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_compte_article_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "actif")
    private Boolean actif;

    @JoinColumn(name = "compte", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterPlanComptable.class)
    private YvsBasePlanComptable compte;
    @JoinColumn(name = "categorie", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterCategorieComptable.class)
    private YvsBaseCategorieComptable categorie;
    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterArticles.class)
    private YvsBaseArticles article;
    @JoinColumn(name = "template", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterTemplateArticle.class)
    private YvsBaseArticlesTemplate template;

    public YvsBaseArticleCategorieComptable() {
        super();
    }

    public YvsBaseArticleCategorieComptable(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id != null ? id : 0;
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

    public YvsBasePlanComptable getCompte() {
        return compte;
    }

    public void setCompte(YvsBasePlanComptable compte) {
        this.compte = compte;
    }

    public YvsBaseCategorieComptable getCategorie() {
        return categorie;
    }

    public void setCategorie(YvsBaseCategorieComptable categorie) {
        this.categorie = categorie;
    }


    public YvsBaseArticles getArticle() {
        return article;
    }

    public void setArticle(YvsBaseArticles article) {
        this.article = article;
    }

    @XmlTransient
    public YvsBaseArticlesTemplate getTemplate() {
        return template;
    }

    public void setTemplate(YvsBaseArticlesTemplate template) {
        this.template = template;
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
        if (!(object instanceof YvsBaseArticleCategorieComptable)) {
            return false;
        }
        YvsBaseArticleCategorieComptable other = (YvsBaseArticleCategorieComptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticleCategorieComptable[ id=" + id + " ]";
    }

}
