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
 *
 * @author Lymytz Dowes
 */
@Entity
@Table(name = "yvs_base_article_pack")
@NamedQueries({
    @NamedQuery(name = "YvsBaseArticlePack.findAll", query = "SELECT y FROM YvsBaseArticlePack y ORDER BY y.designation")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBaseArticlePack extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_article_pack_id_seq", name = "yvs_base_article_pack_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_article_pack_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "designation")
    private String designation;
    @Column(name = "photo")
    private String photo;
    @Column(name = "montant")
    private Double montant;
    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne
    private YvsBaseConditionnement article;

    public YvsBaseArticlePack() {
        super();
    }

    public YvsBaseArticlePack(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getMontant() {
        return montant != null ? montant : 0;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public YvsBaseConditionnement getArticle() {
        return article;
    }

    public void setArticle(YvsBaseConditionnement article) {
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
        if (!(object instanceof YvsBaseArticlePack)) {
            return false;
        }
        YvsBaseArticlePack other = (YvsBaseArticlePack) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticlePack[ id=" + id + " ]";
    }

}
