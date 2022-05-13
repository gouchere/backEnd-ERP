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
@Table(name = "yvs_base_groupes_article")

public class YvsBaseGroupesArticle extends YvsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_groupesproduits_id_seq", name = "yvs_groupesproduits_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_groupesproduits_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "designation")
    private String designation;
    @Column(name = "photo")
    private String photo;
    @Column(name = "refgroupe")
    private String refgroupe;
    @Column(name = "code_appel")
    private String codeAppel;
    @Column(name = "actif")
    private Boolean actif;
    @JoinColumn(name = "groupe_parent", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)

    private YvsBaseGroupesArticle groupeParent;
    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterSociete.class)
    private YvsSocietes societe;

    public YvsBaseGroupesArticle() {
    }

    public YvsBaseGroupesArticle(Long id) {
        this.id = id;
    }

    public YvsBaseGroupesArticle(Long id, String designation) {
        this(id);
        this.designation = designation;
    }

    public YvsBaseGroupesArticle(Long id, String refgroupe, String designation) {
        this(id, designation);
        this.refgroupe = refgroupe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefgroupe() {
        return refgroupe;
    }

    public void setRefgroupe(String refgroupe) {
        this.refgroupe = refgroupe;
    }

    public String getCodeAppel() {
        return codeAppel;
    }

    public void setCodeAppel(String codeAppel) {
        this.codeAppel = codeAppel;
    }

    public String getDesignation() {
        return designation != null ? designation : "";
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

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public YvsBaseGroupesArticle getGroupeParent() {
        return groupeParent;
    }

    public void setGroupeParent(YvsBaseGroupesArticle groupeParent) {
        this.groupeParent = groupeParent;
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
        if (!(object instanceof YvsBaseGroupesArticle)) {
            return false;
        }
        YvsBaseGroupesArticle other = (YvsBaseGroupesArticle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseGroupesArticle[ id=" + id + " ]";
    }
}
