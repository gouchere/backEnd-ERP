package com.erp.lymytz.api.model.base.compta;

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
import javax.persistence.Transient;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;

/**
 * @author hp Elite 8300
 */
@Entity
@Table(name = "yvs_compta_centre_analytique")
@NamedQueries({
        @NamedQuery(name = "YvsComptaCentreAnalytique.findAll", query = "SELECT y FROM YvsComptaCentreAnalytique y  JOIN FETCH y.plan WHERE y.plan.societe=:societe ORDER BY y.codeRef")
})
public class YvsComptaCentreAnalytique extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_compta_centre_analytique_id_seq", name = "yvs_compta_centre_analytique_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_compta_centre_analytique_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "designation")
    private String designation;
    @Column(name = "code_ref")
    private String codeRef;
    @Column(name = "description")
    private String description;
    @Column(name = "niveau")
    private String niveau;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "type_centre")
    private String typeCentre;

    @JoinColumn(name = "unite_oeuvre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseUniteMesure uniteOeuvre;
    @JoinColumn(name = "plan", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsComptaPlanAnalytique plan;

    @Transient
    private boolean new_;
    @Transient
    private double coeficient;
    @Transient
    private long idAffectation = -1;
    @Transient
    private Date dateSave_ = new Date();

    public YvsComptaCentreAnalytique() {
        super();
    }

    public YvsComptaCentreAnalytique(Long id) {
        this();
        this.id = id;
    }

    public YvsComptaCentreAnalytique(Long id, String codeRef, String designation) {
        this(id);
        this.designation = designation;
        this.codeRef = codeRef;
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

    public String getCodeRef() {
        return codeRef;
    }

    public void setCodeRef(String codeRef) {
        this.codeRef = codeRef;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getTypeCentre() {
        return typeCentre != null ? typeCentre.trim().length() > 0 ? typeCentre : "P" : "P";
    }

    public void setTypeCentre(String typeCentre) {
        this.typeCentre = typeCentre;
    }

    public YvsBaseUniteMesure getUniteOeuvre() {
        return uniteOeuvre;
    }

    public void setUniteOeuvre(YvsBaseUniteMesure uniteOeuvre) {
        this.uniteOeuvre = uniteOeuvre;
    }

    public YvsComptaPlanAnalytique getPlan() {
        return plan;
    }

    public void setPlan(YvsComptaPlanAnalytique plan) {
        this.plan = plan;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public boolean isNew_() {
        return new_;
    }

    public void setNew_(boolean new_) {
        this.new_ = new_;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public long getIdAffectation() {
        return idAffectation;
    }

    public void setIdAffectation(long idAffectation) {
        this.idAffectation = idAffectation;
    }

    public void setDateSave_(Date dateSave_) {
        this.dateSave_ = dateSave_;
    }

    public Date getDateSave_() {
        return dateSave_;
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
        if (!(object instanceof YvsComptaCentreAnalytique)) {
            return false;
        }
        YvsComptaCentreAnalytique other = (YvsComptaCentreAnalytique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.compta.YvsComptaCentreAnalytique[ id=" + id + " ]";
    }

}
