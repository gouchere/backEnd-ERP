package com.erp.lymytz.api.model.base.article;

import com.erp.lymytz.api.model.YvsEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_article_equivalent")
@NamedQueries({
        @NamedQuery(name = "YvsBaseArticleEquivalent.findAll", query = "SELECT y FROM YvsBaseArticleEquivalent y WHERE y.article = :article")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBaseArticleEquivalent extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_prod_article_equivalent_id_seq", name = "yvs_prod_article_equivalent_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_prod_article_equivalent_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pourcentage")
    private Double pourcentage;
    @JoinColumn(name = "article_equivalent", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseArticles articleEquivalent;
    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseArticles article;

    public YvsBaseArticleEquivalent() {
        super();
    }

    public YvsBaseArticleEquivalent(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public YvsBaseArticles getArticleEquivalent() {
        return articleEquivalent;
    }

    public void setArticleEquivalent(YvsBaseArticles articleEquivalent) {
        this.articleEquivalent = articleEquivalent;
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
        if (!(object instanceof YvsBaseArticleEquivalent)) {
            return false;
        }
        YvsBaseArticleEquivalent other = (YvsBaseArticleEquivalent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticleEquivalent[ id=" + id + " ]";
    }

}
