package com.erp.lymytz.api.model.base.compta;

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

import com.erp.lymytz.api.converter.base.compta.ConverterNatureCompte;
import com.erp.lymytz.api.converter.base.compta.ConverterPlanComptable;
import com.erp.lymytz.api.model.YvsEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * @author hp Elite 8300
 */
@Entity
@Table(name = "yvs_base_plan_comptable")
@NamedQueries({
    @NamedQuery(name = "YvsBasePlanComptable.findAll", query = "SELECT y FROM YvsBasePlanComptable y LEFT JOIN FETCH y.compteGeneral JOIN FETCH y.natureCompte WHERE y.natureCompte.societe=:societe ORDER BY y.numCompte")
})
public class YvsBasePlanComptable extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_compta_plan_de_compte_id_seq", name = "yvs_compta_plan_de_compte_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_compta_plan_de_compte_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "num_compte")
    private String numCompte;
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "saisie_analytique")
    private Boolean saisieAnalytique;
    @Column(name = "saisie_echeance")
    private Boolean saisieEcheance;
    @Column(name = "saisie_compte_tiers")
    private Boolean saisieCompteTiers;
    @Column(name = "lettrable")
    private Boolean lettrable;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "type_compte")
    private String typeCompte;
    @Column(name = "type_report")
    private String typeReport;
    @Column(name = "sens_compte")
    private String sensCompte;
    @Column(name = "vente_online")
    private Boolean venteOnline;

    @JoinColumn(name = "nature_compte", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterNatureCompte.class)
    private YvsBaseNatureCompte natureCompte;

    @JoinColumn(name = "compte_general", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterPlanComptable.class)
    @JsonBackReference
    private YvsBasePlanComptable compteGeneral;

    public YvsBasePlanComptable() {
        super();
    }

    public YvsBasePlanComptable(Long id) {
        this.id = id;
    }

    public YvsBasePlanComptable(String numCompte) {
        this.numCompte = numCompte;
    }

    public YvsBasePlanComptable(Long id, String numCompte) {
        this.id = id;
        this.numCompte = numCompte;
    }

    public YvsBasePlanComptable(Long id, String numCompte, String intitule) {
        this.id = id;
        this.numCompte = numCompte;
        this.intitule = intitule;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumCompte() {
        return numCompte != null ? numCompte : "";
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getIntitule() {
        return intitule != null ? intitule : "";
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Boolean getVenteOnline() {
        return venteOnline != null ? venteOnline : false;
    }

    public void setVenteOnline(Boolean venteOnline) {
        this.venteOnline = venteOnline;
    }

    public YvsBasePlanComptable getCompteGeneral() {
        return compteGeneral;
    }

    public void setCompteGeneral(YvsBasePlanComptable compteGeneral) {
        this.compteGeneral = compteGeneral;
    }

    public Boolean getSaisieAnalytique() {
        return saisieAnalytique != null ? saisieAnalytique : false;
    }

    public void setSaisieAnalytique(Boolean saisieAnalytique) {
        this.saisieAnalytique = saisieAnalytique;
    }

    public Boolean getSaisieEcheance() {
        return saisieEcheance != null ? saisieEcheance : false;
    }

    public void setSaisieEcheance(Boolean saisieEcheance) {
        this.saisieEcheance = saisieEcheance;
    }

    public Boolean getSaisieCompteTiers() {
        return saisieCompteTiers != null ? saisieCompteTiers : false;
    }

    public void setSaisieCompteTiers(Boolean saisieCompteTiers) {
        this.saisieCompteTiers = saisieCompteTiers;
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

    public String getAbbreviation() {
        return abbreviation != null ? abbreviation : "";
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(String typeReport) {
        this.typeReport = typeReport;
    }

    public String getSensCompte() {
        return sensCompte;
    }

    public void setSensCompte(String sensCompte) {
        this.sensCompte = sensCompte;
    }

    public YvsBaseNatureCompte getNatureCompte() {
        return natureCompte;
    }

    public void setNatureCompte(YvsBaseNatureCompte natureCompte) {
        this.natureCompte = natureCompte;
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
        if (!(object instanceof YvsBasePlanComptable)) {
            return false;
        }
        YvsBasePlanComptable other = (YvsBasePlanComptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable[ id=" + id + " ]";
    }

}
