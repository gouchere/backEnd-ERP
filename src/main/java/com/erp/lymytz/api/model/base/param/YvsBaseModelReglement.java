package com.erp.lymytz.api.model.base.param;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsBaseCodeAcces;
import com.erp.lymytz.api.model.param.YvsSocietes;

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_model_reglement")
@NamedQueries({
        @NamedQuery(name = "YvsBaseModelReglement.findAll", query = "SELECT y FROM YvsBaseModelReglement y WHERE y.societe = :societe ORDER BY y.reference")
})
public class YvsBaseModelReglement extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_model_reglement_id_seq", name = "yvs_base_model_reglement_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_model_reglement_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @Column(name = "date_save")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSave;
    @Column(name = "description")
    private String description;
    @Column(name = "reference")
    private String reference;
    @Column(name = "type")
    private char type;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "paye_before_valide")
    private Boolean payeBeforeValide;
    @JoinColumn(name = "code_acces", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseCodeAcces codeAcces;
    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsSocietes societe;

    public YvsBaseModelReglement() {
        super();
    }

    public YvsBaseModelReglement(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseModelReglement(Long id, String designation) {
        this(id);
        this.reference = designation;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Boolean getPayeBeforeValide() {
        return payeBeforeValide != null ? payeBeforeValide : false;
    }

    public void setPayeBeforeValide(Boolean payeBeforeValide) {
        this.payeBeforeValide = payeBeforeValide;
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReference() {
        return reference != null ? reference : "";
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public YvsBaseCodeAcces getCodeAcces() {
        return codeAcces;
    }

    public void setCodeAcces(YvsBaseCodeAcces codeAcces) {
        this.codeAcces = codeAcces;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
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
        if (!(object instanceof YvsBaseModelReglement)) {
            return false;
        }
        YvsBaseModelReglement other = (YvsBaseModelReglement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.param.YvsBaseModelReglement[ id=" + id + " ]";
    }

}
