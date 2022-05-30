package com.erp.lymytz.api.model.base.compta;

import java.io.Serializable;
import javax.persistence.*;

import com.erp.lymytz.api.converter.param.ConverterSociete;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author GOUCHERE YVES
 */
@Entity
@Table(name = "yvs_base_nature_compte")
@NamedQueries({
        @NamedQuery(name = "YvsBaseNatureCompte.findAll", query = "SELECT y FROM YvsBaseNatureCompte y WHERE y.societe=:societe ORDER by y.designation")
})
public class YvsBaseNatureCompte extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yvs_nature_compte_id_seq")
    @SequenceGenerator(sequenceName = "yvs_nature_compte_id_seq", allocationSize = 1, name = "yvs_nature_compte_id_seq")
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;
    @Column(name = "designation")
    private String designation;
    @Column(name = "type_report")
    private String typeReport;
    @Column(name = "nature")
    private String nature;
    @Column(name = "saisie_anal")
    private Boolean saisieAnal;
    @Column(name = "saisie_echeance")
    private Boolean saisieEcheance;
    @Column(name = "saisie_compte_tier")
    private Boolean saisieCompteTier;
    @Column(name = "lettrable")
    private Boolean lettrable;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "sens_compte")
    private String sensCompte;

    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterSociete.class)
    private YvsSocietes societe;

    public YvsBaseNatureCompte() {
        super();
    }

    public YvsBaseNatureCompte(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseNatureCompte(Long id, String designation) {
        this(id);
        this.designation = designation;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNature() {
        return nature != null ? nature.trim().length() > 0 ? nature : "AUTRE" : "AUTRE";
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(String typeReport) {
        this.typeReport = typeReport;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public Boolean getSaisieAnal() {
        return saisieAnal != null ? saisieAnal : false;
    }

    public void setSaisieAnal(Boolean saisieAnal) {
        this.saisieAnal = saisieAnal;
    }

    public Boolean getSaisieEcheance() {
        return saisieEcheance != null ? saisieEcheance : false;
    }

    public void setSaisieEcheance(Boolean saisieEcheance) {
        this.saisieEcheance = saisieEcheance;
    }

    public Boolean getSaisieCompteTier() {
        return saisieCompteTier != null ? saisieCompteTier : false;
    }

    public void setSaisieCompteTier(Boolean saisieCompteTier) {
        this.saisieCompteTier = saisieCompteTier;
    }

    public Boolean getLettrable() {
        return lettrable != null ? lettrable : false;
    }

    public void setLettrable(Boolean lettrable) {
        this.lettrable = lettrable;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getSensCompte() {
        return sensCompte;
    }

    public void setSensCompte(String sensCompte) {
        this.sensCompte = sensCompte;
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
        if (!(object instanceof YvsBaseNatureCompte)) {
            return false;
        }
        YvsBaseNatureCompte other = (YvsBaseNatureCompte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.compta.YvsBaseNatureCompte[ id=" + id + " ]";
    }
}
