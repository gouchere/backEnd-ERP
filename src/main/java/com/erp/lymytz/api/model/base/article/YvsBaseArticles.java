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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.erp.lymytz.api.converter.base.ConverterUniteMesure;
import com.erp.lymytz.api.converter.base.article.ConverterClassesStat;
import com.erp.lymytz.api.converter.base.article.ConverterFamillesArticle;
import com.erp.lymytz.api.converter.base.article.ConverterGroupesArticle;
import com.erp.lymytz.api.converter.base.article.ConverterTemplateArticle;
import com.erp.lymytz.api.converter.base.tiers.ConverterTiers;
import com.erp.lymytz.api.model.YvsAlias;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;
import com.erp.lymytz.api.model.base.tiers.YvsBaseTiers;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Data
@YvsAlias(name = "art")
@Table(name = "yvs_base_articles")
@NamedQueries({
    @NamedQuery(name = "YvsBaseArticles.findAll", query = "SELECT y FROM YvsBaseArticles y WHERE y.famille.societe =:societe ORDER BY y.refArt")
    })
public class YvsBaseArticles extends YvsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_articles_id_seq", name = "yvs_articles_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_articles_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "tags")
    private String tags;
    @Column(name = "designation")
    private String designation;
    @Column(name = "mode_conso")
    private String modeConso;
    @Column(name = "photo_1")
    private String photo1;
    @Column(name = "photo_1_extension")
    private String photo1Extension;
    @Column(name = "ref_art")
    private String refArt;
    @Column(name = "class_stat")
    private String classStat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coefficient")
    private Double coefficient;
    @Column(name = "service")
    private Boolean service;
    @Column(name = "methode_val")
    private String methodeVal;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "photo_2")
    private String photo2;
    @Column(name = "photo_2_extension")
    private String photo2Extension;
    @Column(name = "photo_3")
    private String photo3;
    @Column(name = "photo_3_extension")
    private String photo3Extension;
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "duree_vie")
    private Double delaiLivraison;
    @Column(name = "ordre")
    private Integer ordre;
    @Column(name = "duree_garantie")
    private Double dureeGarantie;
    @Column(name = "def_norme")
    private Boolean defNorme;
    @Column(name = "norme")
    private Boolean norme;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "masse_net")
    private Double masseNet;
    @Column(name = "prix_min")
    private Double prixMin;
    @Column(name = "pua")
    private Double pua;
    @Column(name = "pua_ttc")
    private Boolean puaTtc;
    @Column(name = "puv")
    private Double puv;
    @Column(name = "change_prix")
    private Boolean changePrix;
    @Column(name = "puv_ttc")
    private Boolean puvTtc;
    @Column(name = "remise")
    private Double remise;
    @Column(name = "suivi_en_stock")
    private Boolean suiviEnStock;
    @Column(name = "visible_en_synthese")
    private Boolean visibleEnSynthese;
    @Column(name = "controle_fournisseur")
    private Boolean controleFournisseur;
    @Column(name = "fichier")
    private String fichier;
    @Column(name = "nature_prix_min")
    private String naturePrixMin;
    @Column(name = "type_service")
    private Character typeService;
    @Column(name = "lot_fabrication")
    private Integer lotFabrication;
    @Column(name = "taux_ecart_pr")
    private Double tauxEcartPr;
    @Column(name = "requiere_lot")
    private Boolean requiereLot = false;

    @JoinColumn(name = "template", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
	@JsonSerialize(converter = ConverterTemplateArticle.class)
    private YvsBaseArticlesTemplate template;
    @JoinColumn(name = "groupe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
	@JsonSerialize(converter = ConverterGroupesArticle.class)
    private YvsBaseGroupesArticle groupe;
    @JoinColumn(name = "famille", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
	@JsonSerialize(converter = ConverterFamillesArticle.class)
    private YvsBaseFamilleArticle famille;
    @JoinColumn(name = "classe1", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
	@JsonSerialize(converter = ConverterClassesStat.class)
    private YvsBaseClassesStat classe1;
    @JoinColumn(name = "classe2", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
	@JsonSerialize(converter = ConverterClassesStat.class)
    private YvsBaseClassesStat classe2;

    @JoinColumn(name = "fabriquant", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterTiers.class)
    private YvsBaseTiers fabriquant;
    @JoinColumn(name = "unite_stockage", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterUniteMesure.class)
    private YvsBaseUniteMesure uniteStockage;
    @JoinColumn(name = "unite_vente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterUniteMesure.class)
    private YvsBaseUniteMesure uniteVente;
    @JoinColumn(name = "unite_de_masse", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterUniteMesure.class)
    private YvsBaseUniteMesure uniteDeMasse;
    @JoinColumn(name = "unite_volume", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterUniteMesure.class)
    private YvsBaseUniteMesure uniteDeVolume;

    public YvsBaseArticles() {

    }

    public YvsBaseArticles(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseArticles(Long id, String ref, String des) {
        this(id);
        this.refArt = ref;
        this.designation = des;
    }

    public YvsBaseArticles(Long id, String ref, String des, boolean puvTtc) {
        this(id, ref, des);
        this.puvTtc = puvTtc;
    }

    public YvsBaseArticles(Long id, String ref, String des, boolean puvTtc, boolean actif) {
        this(id, ref, des, puvTtc);
        this.actif = actif;
    }

    public YvsBaseArticles(Long id, boolean changePrix, boolean defNorme, boolean norme, double masseNet, double prixMin, double pua, double puv, double remise, boolean suiviEnStock, boolean visibleEnSynthese) {
        this(id);
        this.changePrix = changePrix;
        this.defNorme = defNorme;
        this.norme = norme;
        this.masseNet = masseNet;
        this.prixMin = prixMin;
        this.pua = pua;
        this.puv = puv;
        this.remise = remise;
        this.suiviEnStock = suiviEnStock;
        this.visibleEnSynthese = visibleEnSynthese;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getChangePrix() {
        return changePrix != null ? changePrix : false;
    }

    public void setChangePrix(Boolean changePrix) {
        this.changePrix = changePrix;
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation != null ? designation : "";
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getModeConso() {
        return modeConso != null ? modeConso : "";
    }

    public void setModeConso(String modeConso) {
        this.modeConso = modeConso;
    }

    public Double getMasseNet() {
        return masseNet != null ? masseNet : 0.0;
    }

    public void setMasseNet(Double masseNet) {
        this.masseNet = masseNet;
    }

    public Double getPrixMin() {
        return prixMin != null ? prixMin : 0.0;
    }

    public void setPrixMin(Double prixMin) {
        this.prixMin = prixMin;
    }

    public String getRefArt() {
        return refArt != null ? refArt : "";
    }

    public void setRefArt(String refArt) {
        this.refArt = refArt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getControleFournisseur() {
        return controleFournisseur != null ? controleFournisseur : false;
    }

    public void setControleFournisseur(Boolean controleFournisseur) {
        this.controleFournisseur = controleFournisseur;
    }

    public Boolean getSuiviEnStock() {
        return suiviEnStock != null ? suiviEnStock : true;
    }

    public void setSuiviEnStock(Boolean suiviEnStock) {
        this.suiviEnStock = suiviEnStock;
    }

    public Boolean getVisibleEnSynthese() {
        return visibleEnSynthese != null ? visibleEnSynthese : false;
    }

    public void setVisibleEnSynthese(Boolean visibleEnSynthese) {
        this.visibleEnSynthese = visibleEnSynthese;
    }

    public String getClassStat() {
        return classStat != null ? classStat : "";
    }

    public void setClassStat(String classStat) {
        this.classStat = classStat;
    }

    public Double getCoefficient() {
        return coefficient != null ? coefficient : 0.0;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Boolean getService() {
        return service != null ? service : false;
    }

    public void setService(Boolean service) {
        this.service = service;
    }

    public String getMethodeVal() {
        return methodeVal != null ? methodeVal : "FIFO";
    }

    public void setMethodeVal(String methodeVal) {
        this.methodeVal = methodeVal;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getCategorie() {
        return categorie != null ? categorie : "";
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getDelaiLivraison() {
        return delaiLivraison != null ? delaiLivraison : 0.0;
    }

    public void setDelaiLivraison(Double delaiLivraison) {
        this.delaiLivraison = delaiLivraison;
    }

    public Double getDureeGarantie() {
        return dureeGarantie != null ? dureeGarantie : 0.0;
    }

    public void setDureeGarantie(Double dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    public Boolean getRequiereLot() {
        return requiereLot != null ? requiereLot : false;
    }

    public void setRequiereLot(Boolean requiereLot) {
        this.requiereLot = requiereLot;
    }

    public Boolean getPuaTtc() {
        return puaTtc != null ? puaTtc : false;
    }

    public void setPuaTtc(Boolean puaTtc) {
        this.puaTtc = puaTtc;
    }

    public Boolean getPuvTtc() {
        return puvTtc != null ? puvTtc : false;
    }

    public void setPuvTtc(Boolean puvTtc) {
        this.puvTtc = puvTtc;
    }

    public String getNaturePrixMin() {
        return naturePrixMin;
    }

    public void setNaturePrixMin(String naturePrixMin) {
        this.naturePrixMin = naturePrixMin;
    }

    public String getFichier() {
        return fichier != null ? fichier : "";
    }

    public Character getTypeService() {
        return typeService;
    }

    public void setTypeService(Character typeService) {
        this.typeService = typeService;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public Integer getLotFabrication() {
        return lotFabrication != null ? lotFabrication : 1;
    }

    public void setLotFabrication(Integer lotFabrication) {
        this.lotFabrication = lotFabrication;
    }

    public Boolean getDefNorme() {
        return defNorme != null ? defNorme : false;
    }

    public void setDefNorme(Boolean defNorme) {
        this.defNorme = defNorme;
    }

    public Boolean getNorme() {
        return norme != null ? norme : false;
    }

    public void setNorme(Boolean norme) {
        this.norme = norme;
    }

    public Double getPua() {
        return pua != null ? pua : 0;
    }

    public void setPua(Double pua) {
        this.pua = pua;
    }

    public Double getPuv() {
        return puv != null ? puv : 0;
    }

    public void setPuv(Double puv) {
        this.puv = puv;
    }

    public Double getRemise() {
        return remise != null ? remise : 0;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public String getPhoto1Extension() {
        return photo1Extension != null ? photo1Extension.trim().length() > 0 ? photo1Extension : "png" : "png";
    }

    public void setPhoto1Extension(String photo1Extension) {
        this.photo1Extension = photo1Extension;
    }

    public String getPhoto2Extension() {
        return photo2Extension != null ? photo2Extension.trim().length() > 0 ? photo2Extension : "png" : "png";
    }

    public void setPhoto2Extension(String photo2Extension) {
        this.photo2Extension = photo2Extension;
    }

    public String getPhoto3Extension() {
        return photo3Extension != null ? photo3Extension.trim().length() > 0 ? photo3Extension : "png" : "png";
    }

    public void setPhoto3Extension(String photo3Extension) {
        this.photo3Extension = photo3Extension;
    }

    public YvsBaseClassesStat getClasse1() {
        return classe1;
    }

    public void setClasse1(YvsBaseClassesStat classe1) {
        this.classe1 = classe1;
    }

    public YvsBaseClassesStat getClasse2() {
        return classe2;
    }

    public void setClasse2(YvsBaseClassesStat classe2) {
        this.classe2 = classe2;
    }

    public YvsBaseUniteMesure getUniteDeVolume() {
        return uniteDeVolume;
    }

    public void setUniteDeVolume(YvsBaseUniteMesure uniteDeVolume) {
        this.uniteDeVolume = uniteDeVolume;
    }

    public YvsBaseTiers getFabriquant() {
        return fabriquant;
    }

    public void setFabriquant(YvsBaseTiers fabriquant) {
        this.fabriquant = fabriquant;
    }

    public YvsBaseGroupesArticle getGroupe() {
        return groupe;
    }

    public void setGroupe(YvsBaseGroupesArticle groupe) {
        this.groupe = groupe;
    }

    public YvsBaseFamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(YvsBaseFamilleArticle famille) {
        this.famille = famille;
    }

    public YvsBaseUniteMesure getUniteStockage() {
        return uniteStockage;
    }

    public void setUniteStockage(YvsBaseUniteMesure uniteStockage) {
        this.uniteStockage = uniteStockage;
    }

    public YvsBaseUniteMesure getUniteVente() {
        return uniteVente;
    }

    public void setUniteVente(YvsBaseUniteMesure uniteVente) {
        this.uniteVente = uniteVente;
    }

    public YvsBaseArticlesTemplate getTemplate() {
        return template;
    }

    public void setTemplate(YvsBaseArticlesTemplate template) {
        this.template = template;
    }

    public YvsBaseUniteMesure getUniteDeMasse() {
        return uniteDeMasse;
    }

    public void setUniteDeMasse(YvsBaseUniteMesure uniteDeMasse) {
        this.uniteDeMasse = uniteDeMasse;
    }

    public Double getTauxEcartPr() {
        return tauxEcartPr != null ? tauxEcartPr : 0;
    }

    public void setTauxEcartPr(Double tauxEcartPr) {
        this.tauxEcartPr = tauxEcartPr;
    }

    public Integer getOrdre() {
        return ordre != null ? ordre : 0;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
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
        if (!(object instanceof YvsBaseArticles)) {
            return false;
        }
        YvsBaseArticles other = (YvsBaseArticles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticles[ id=" + id + " ]";
    }
}
