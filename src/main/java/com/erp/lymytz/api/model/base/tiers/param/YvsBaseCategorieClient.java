package com.erp.lymytz.api.model.base.tiers.param;

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

import com.erp.lymytz.api.converter.base.tiers.param.ConverterCategorieClient;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.param.YvsBaseModelReglement;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_categorie_client")
@NamedQueries({
        @NamedQuery(name = "YvsBaseCategorieClient.findAll", query = "SELECT y FROM YvsBaseCategorieClient y WHERE y.societe = :societe  ORDER BY y.libelle")
})
public class YvsBaseCategorieClient extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_com_categorie_client_id_seq", name = "yvs_com_categorie_client_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_com_categorie_client_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "lier_client")
    private Boolean lierClient;
    @Column(name = "defaut")
    private Boolean defaut;
    @Column(name = "description")
    private String description;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "vente_online")
    private Boolean venteOnline;

    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsSocietes societe;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterCategorieClient.class)
    private YvsBaseCategorieClient parent;
    @JoinColumn(name = "model", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseModelReglement model;

    public YvsBaseCategorieClient() {
        super();
    }

    public YvsBaseCategorieClient(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseCategorieClient(Long id, String libelle) {
        this(id);
        this.libelle = libelle;
    }

    public YvsBaseCategorieClient(Long id, String code, String libelle) {
        this(id, libelle);
        this.code = code;
    }

    public YvsBaseCategorieClient(Long id, String code, String libelle, YvsBaseCategorieClient parent) {
        this(id, code, libelle);
        this.parent = parent;
    }

    public Boolean getVenteOnline() {
        return venteOnline != null ? venteOnline : false;
    }

    public void setVenteOnline(Boolean venteOnline) {
        this.venteOnline = venteOnline;
    }

    @XmlTransient
    @JsonIgnore
    public YvsBaseModelReglement getModel() {
        return model;
    }

    public void setModel(YvsBaseModelReglement model) {
        this.model = model;
    }

    public Boolean getDefaut() {
        return defaut;
    }

    public void setDefaut(Boolean defaut) {
        this.defaut = defaut;
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

    public Boolean getLierClient() {
        return lierClient;
    }

    public void setLierClient(Boolean lierClient) {
        this.lierClient = lierClient;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle != null ? libelle : "";
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

    @XmlTransient
    @JsonIgnore
    public YvsBaseCategorieClient getParent() {
        return parent;
    }

    public void setParent(YvsBaseCategorieClient parent) {
        this.parent = parent;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
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
        if (!(object instanceof YvsBaseCategorieClient)) {
            return false;
        }
        YvsBaseCategorieClient other = (YvsBaseCategorieClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.tiers.param.YvsBaseCategorieClient[ id=" + id + " ]";
    }

}
