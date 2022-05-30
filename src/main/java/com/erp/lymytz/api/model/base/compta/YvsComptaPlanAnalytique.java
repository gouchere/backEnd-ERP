package com.erp.lymytz.api.model.base.compta;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;

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

/**
 *
 * @author hp Elite 8300
 */
@Entity
@Table(name = "yvs_compta_plan_analytique")
@NamedQueries({
    @NamedQuery(name = "YvsComptaPlanAnalytique.findAll", query = "SELECT y FROM YvsComptaPlanAnalytique y WHERE y.societe = :societe")
})
public class YvsComptaPlanAnalytique extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_compta_plan_analytique_id_seq", name = "yvs_compta_plan_analytique_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_compta_plan_analytique_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "code_plan")
    private String codePlan;
    @Column(name = "description")
    private String description;
    @Column(name = "actif")
    private Boolean actif;

    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsSocietes societe;

    public YvsComptaPlanAnalytique() {
        super();
    }

    public YvsComptaPlanAnalytique(Long id) {
        this();
        this.id = id;
    }

    public YvsComptaPlanAnalytique(Long id, String codePlan, String intitule) {
        this(id);
        this.intitule = intitule;
        this.codePlan = codePlan;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getCodePlan() {
        return codePlan;
    }

    public void setCodePlan(String codePlan) {
        this.codePlan = codePlan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Date getDateSave() {
        return dateSave;
    }

    public void setDateSave(Date dateSave) {
        this.dateSave = dateSave;
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
        if (!(object instanceof YvsComptaPlanAnalytique)) {
            return false;
        }
        YvsComptaPlanAnalytique other = (YvsComptaPlanAnalytique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.compta.YvsComptaPlanAnalytique[ id=" + id + " ]";
    }

}
