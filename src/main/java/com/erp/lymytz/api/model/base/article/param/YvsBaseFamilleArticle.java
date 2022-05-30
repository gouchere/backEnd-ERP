package com.erp.lymytz.api.model.base.article.param;

import java.io.Serializable;

import javax.persistence.*;

import com.erp.lymytz.api.converter.base.article.ConverterFamillesArticle;
import com.erp.lymytz.api.converter.param.ConverterSociete;
import com.erp.lymytz.api.model.YvsAlias;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Data
@YvsAlias(name="famille")
@Table(name = "yvs_base_famille_article")
@NamedQueries({
        @NamedQuery(name = "YvsBaseFamilleArticle.findAll", query = "SELECT y FROM YvsBaseFamilleArticle y WHERE y.societe =:societe ORDER BY y.designation"),
})
public class YvsBaseFamilleArticle extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_prod_famille_article_id_seq", name = "yvs_prod_famille_article_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_prod_famille_article_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "reference_famille")
    private String referenceFamille;
    @Column(name = "designation")
    private String designation;
    @Column(name = "description")
    private String description;
    @Column(name = "prefixe")
    private String prefixe;
    @Column(name = "actif")
    private Boolean actif;

    @JoinColumn(name = "famille_parent", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterFamillesArticle.class)
    private YvsBaseFamilleArticle familleParent;
    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterSociete.class)
    private YvsSocietes societe;

    public YvsBaseFamilleArticle() {

    }

    public YvsBaseFamilleArticle(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseFamilleArticle(String ref) {
        this();
        this.referenceFamille = ref;
    }

    public YvsBaseFamilleArticle(Long id, String designation) {
        this(id);
        this.designation = designation;
    }

    public YvsBaseFamilleArticle(Long id, String referenceFamille, String designation) {
        this(id, designation);
        this.referenceFamille = referenceFamille;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getPrefixe() {
        return prefixe;
    }

    public void setPrefixe(String prefixe) {
        this.prefixe = prefixe;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceFamille() {
        return referenceFamille;
    }

    public void setReferenceFamille(String referenceFamille) {
        this.referenceFamille = referenceFamille;
    }

    public String getDesignation() {
        return designation != null ? designation : "";
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public YvsBaseFamilleArticle getFamilleParent() {
        return familleParent;
    }

    public void setFamilleParent(YvsBaseFamilleArticle familleParent) {
        this.familleParent = familleParent;
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
        if (!(object instanceof YvsBaseFamilleArticle)) {
            return false;
        }
        YvsBaseFamilleArticle other = (YvsBaseFamilleArticle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.param.YvsBaseFamilleArticle[ id=" + id + " ]";
    }
}
