package com.erp.lymytz.api.model.base.tiers.param;

import com.erp.lymytz.api.converter.base.tiers.param.ConverterCategorieFournisseur;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;
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

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_categorie_fournisseur")
@NamedQueries({
        @NamedQuery(name = "YvsBaseCategorieFournisseur.findAll", query = "SELECT y FROM YvsBaseCategorieFournisseur y WHERE y.societe = :societe ORDER BY y.libelle")
})
public class YvsBaseCategorieFournisseur extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_categorie_fournisseur_id_seq", name = "yvs_base_categorie_fournisseur_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_categorie_fournisseur_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "description")
    private String description;

    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsSocietes societe;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterCategorieFournisseur.class)
    private YvsBaseCategorieFournisseur parent;

    public YvsBaseCategorieFournisseur() {
        super();
    }

    public YvsBaseCategorieFournisseur(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseCategorieFournisseur(Long id, String libelle) {
        this(id);
        this.libelle = libelle;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public YvsBaseCategorieFournisseur getParent() {
        return parent;
    }

    public void setParent(YvsBaseCategorieFournisseur parent) {
        this.parent = parent;
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
        if (!(object instanceof YvsBaseCategorieFournisseur)) {
            return false;
        }
        YvsBaseCategorieFournisseur other = (YvsBaseCategorieFournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.tiers.param.YvsBaseCategorieFournisseur[ id=" + id + " ]";
    }

}
