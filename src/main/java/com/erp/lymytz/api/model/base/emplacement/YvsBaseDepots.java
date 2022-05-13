package com.erp.lymytz.api.model.base.emplacement;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.erp.lymytz.api.converter.base.ConverterAgence;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsAgences;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Data
@Table(name = "yvs_base_depots")
@NamedQueries({
    @NamedQuery(name = "YvsBaseDepots.findAll", query = "SELECT y FROM YvsBaseDepots y WHERE y.agence.societe =:societe ORDER BY y.designation"),
    @NamedQuery(name = "YvsBaseDepots.findByAgence", query = "SELECT y FROM YvsBaseDepots y WHERE y.agence =:agence ORDER BY y.designation")
    })
public class YvsBaseDepots extends YvsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_depots_id_seq", name = "yvs_base_depots_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_depots_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "description")
    private String description;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "code")
    private String code;
    @Column(name = "designation")
    private String designation;
    @Column(name = "op_achat")
    private Boolean opAchat = false;
    @Column(name = "op_vente")
    private Boolean opVente = false;
    @Column(name = "op_production")
    private Boolean opProduction = false;
    @Column(name = "op_transit")
    private Boolean opTransit = false;
    @Column(name = "op_retour")
    private Boolean opRetour = false;
    @Column(name = "op_reserv")
    private Boolean opReserv = false;
    @Column(name = "crenau")
    private Boolean crenau = false;
    @Column(name = "control_stock")
    private Boolean controlStock = false;
    @Column(name = "op_technique")
    private Boolean opTechnique;
    @Column(name = "supp")
    private Boolean supp = false;
    @Column(name = "actif")
    private Boolean actif = true;
    @Column(name = "principal")
    private Boolean principal = false;
    @Column(name = "verify_appro")
    private Boolean verifyAppro = false;
    @Column(name = "verify_all_valid_inventaire")
    private Boolean verifyAllValidInventaire = false;
    @Column(name = "requiere_lot")
    private Boolean requiereLot = false;

    @Column(name = "type_pf")
    private Boolean typePf = false;
    @Column(name = "type_mp")
    private Boolean typeMp = false;
    @Column(name = "type_ne")
    private Boolean typeNe = false;
    @Column(name = "type_psf")
    private Boolean typePsf = false;

    @JoinColumn(name = "agence", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterAgence.class)
    private YvsAgences agence;
//    @JoinColumn(name = "responsable", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private YvsGrhEmployes responsable;
//    @JoinColumn(name = "code_acces", referencedColumnName = "id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private YvsBaseCodeAcces codeAcces;

    public YvsBaseDepots() {

    }

    public YvsBaseDepots(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseDepots(Long id, String designation) {
        this(id);
        this.designation = designation;
    }

    public YvsBaseDepots(Long id, boolean actif) {
        this(id);
        this.actif = actif;
    }

    public YvsBaseDepots(Long id, String designation, YvsAgences agence) {
        this(id, designation);
        this.agence = agence;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOpRetour() {
        return opRetour != null ? opRetour : false;
    }

    public void setOpRetour(Boolean opRetour) {
        this.opRetour = opRetour;
    }

    public Boolean getOpReserv() {
        return opReserv != null ? opReserv : false;
    }

    public void setOpReserv(Boolean opReserv) {
        this.opReserv = opReserv;
    }

    public Boolean getVerifyAllValidInventaire() {
        return verifyAllValidInventaire != null ? verifyAllValidInventaire : true;
    }

    public void setVerifyAllValidInventaire(Boolean verifyAllValidInventaire) {
        this.verifyAllValidInventaire = verifyAllValidInventaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCrenau() {
        return crenau != null ? crenau : false;
    }

    public void setCrenau(Boolean crenau) {
        this.crenau = crenau;
    }

    public String getAbbreviation() {
        return abbreviation != null ? abbreviation : "";
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getOpAchat() {
        return opAchat != null ? opAchat : false;
    }

    public void setOpAchat(Boolean opAchat) {
        this.opAchat = opAchat;
    }

    public Boolean getOpVente() {
        return opVente != null ? opVente : false;
    }

    public void setOpVente(Boolean opVente) {
        this.opVente = opVente;
    }

    public Boolean getOpProduction() {
        return opProduction != null ? opProduction : false;
    }

    public void setOpProduction(Boolean opProduction) {
        this.opProduction = opProduction;
    }

    public Boolean getOpTransit() {
        return opTransit != null ? opTransit : false;
    }

    public void setOpTransit(Boolean opTransit) {
        this.opTransit = opTransit;
    }

    public Boolean getControlStock() {
        return controlStock != null ? controlStock : false;
    }

    public void setControlStock(Boolean controlStock) {
        this.controlStock = controlStock;
    }

    public Boolean getRequiereLot() {
        return requiereLot != null ? requiereLot : false;
    }

    public void setRequiereLot(Boolean requiereLot) {
        this.requiereLot = requiereLot;
    }

    public Boolean getSupp() {
        return supp != null ? supp : false;
    }

    public void setSupp(Boolean supp) {
        this.supp = supp;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean getOpTechnique() {
        return opTechnique != null ? opTechnique : false;
    }

    public void setOpTechnique(Boolean opTechnique) {
        this.opTechnique = opTechnique;
    }

    public Boolean getVerifyAppro() {
        return verifyAppro != null ? verifyAppro : false;
    }

    public void setVerifyAppro(Boolean verifyAppro) {
        this.verifyAppro = verifyAppro;
    }

    public Boolean getTypePf() {
        return typePf != null ? typePf : false;
    }

    public void setTypePf(Boolean typePf) {
        this.typePf = typePf;
    }

    public Boolean getTypeMp() {
        return typeMp != null ? typeMp : false;
    }

    public void setTypeMp(Boolean typeMp) {
        this.typeMp = typeMp;
    }

    public Boolean getTypeNe() {
        return typeNe != null ? typeNe : false;
    }

    public void setTypeNe(Boolean typeNe) {
        this.typeNe = typeNe;
    }

    public Boolean getTypePsf() {
        return typePsf != null ? typePsf : false;
    }

    public void setTypePsf(Boolean typePsf) {
        this.typePsf = typePsf;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public YvsAgences getAgence() {
        return agence;
    }

    public void setAgence(YvsAgences agence) {
        this.agence = agence;
    }

//  public YvsGrhEmployes getResponsable() {
//      return responsable;
//  }
//
//  public void setResponsable(YvsGrhEmployes responsable) {
//      this.responsable = responsable;
//  }
//
//    public YvsUsersAgence getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(YvsUsersAgence author) {
//        this.author = author;
//    }
//
//    public YvsBaseCodeAcces getCodeAcces() {
//        return codeAcces;
//    }
//
//    public void setCodeAcces(YvsBaseCodeAcces codeAcces) {
//        this.codeAcces = codeAcces;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YvsBaseDepots)) {
            return false;
        }
        YvsBaseDepots other = (YvsBaseDepots) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots[ id=" + id + " ]";
    }
}
