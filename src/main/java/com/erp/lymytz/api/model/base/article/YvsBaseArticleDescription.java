package com.erp.lymytz.api.model.base.article;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Lymytz Dowes
 */
@Entity
@Table(name = "yvs_base_article_description")
@NamedQueries({
        @NamedQuery(name = "YvsBaseArticleDescription.findAll", query = "SELECT y FROM YvsBaseArticleDescription y WHERE y.article = :article")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBaseArticleDescription extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_article_description_id_seq", name = "yvs_base_article_description_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_article_description_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "description")
    private String description;

    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne
    private YvsBaseArticles article;

    public YvsBaseArticleDescription() {
        super();
    }

    public YvsBaseArticleDescription(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof YvsBaseArticleDescription)) {
            return false;
        }
        YvsBaseArticleDescription other = (YvsBaseArticleDescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticleDescription[ id=" + id + " ]";
    }

}
