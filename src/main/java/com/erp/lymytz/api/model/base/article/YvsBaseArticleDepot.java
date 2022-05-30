package com.erp.lymytz.api.model.base.article;

import com.erp.lymytz.api.converter.base.article.ConverterArticles;
import com.erp.lymytz.api.converter.base.article.ConverterConditionnement;
import com.erp.lymytz.api.converter.base.emplacement.ConverterDepot;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_article_depot")
@NamedQueries({
        @NamedQuery(name = "YvsBaseArticleDepot.findAll", query = "SELECT y FROM YvsBaseArticleDepot y WHERE y.article = :article")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBaseArticleDepot extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_article_depot_id_seq", name = "yvs_base_article_depot_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_article_depot_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "stock_max")
    private Double stockMax;
    @Basic(optional = false)
    @Column(name = "stock_min")
    private Double stockMin;
    @Column(name = "mode_appro")
    private String modeAppro = "ACHT_PROD_EN";
    @Column(name = "mode_reappro")
    private String modeReappro = "RUPTURE";
    @Column(name = "categorie")
    private String categorie;
    @Column(name = "interval_approv")
    private Integer intervalApprov;
    @Column(name = "unite_interval")
    private String uniteInterval;
    @Column(name = "quantite_stock")
    private Double quantiteStock;
    @Column(name = "supp")
    private Boolean supp = false;
    @Column(name = "actif")
    private Boolean actif = true;
    @Column(name = "stock_alert")
    private Double stockAlert;
    @Column(name = "stock_initial")
    private Double stockInitial;
    @Column(name = "date_appro")
    @Temporal(TemporalType.DATE)
    private Date dateAppro;
    @Column(name = "marg_stock_moyen")
    private Double margStockMoyen;
    @Column(name = "stock_net")
    private Double stockNet;
    @Column(name = "lot_livraison")
    private Integer lotLivraison;
    @Column(name = "type_document_generer")
    private String typeDocumentGenerer = "FA";
    @Column(name = "generer_document")
    private Boolean genererDocument = false;
    @Column(name = "requiere_lot")
    private Boolean requiereLot = false;
    @Column(name = "suivi_stock")
    private Boolean suiviStock = false;
    @Column(name = "sell_without_stock")
    private Boolean sellWithoutStock = true;
    @Column(name = "default_pr")
    private Boolean defaultPr = false;
    @Column(name = "last_date_calcul_pr")
    @Temporal(TemporalType.DATE)
    private Date lastDateCalculPr;

    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterArticles.class)
    private YvsBaseArticles article;
    @JoinColumn(name = "depot", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterDepot.class)
    private YvsBaseDepots depot;
    @JoinColumn(name = "depot_pr", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterDepot.class)
    private YvsBaseDepots depotPr;
    @JoinColumn(name = "default_cond", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonSerialize(converter = ConverterConditionnement.class)
    private YvsBaseConditionnement defaultCond;

    public YvsBaseArticleDepot() {
        super();
    }

    public YvsBaseArticleDepot(Long id) {
        this();
        this.id = id;
    }

    public YvsBaseArticleDepot(Long id, YvsBaseArticles article) {
        this(id);
        this.article = article;
    }

    public YvsBaseArticleDepot(Long id, YvsBaseArticles article, YvsBaseDepots depot) {
        this(id, article);
        this.depot = depot;
    }

    public YvsBaseArticleDepot(Long id, Long idEmpl) {
        this(id);
    }

    public YvsBaseArticleDepot(Long id, Double stockMax, Double stockMin) {
        this(id);
        this.stockMax = stockMax;
        this.stockMin = stockMin;
    }

    public YvsBaseArticleDepot(YvsBaseArticleDepot y) {
        this.id = y.id;
        this.dateUpdate = y.dateUpdate;
        this.dateSave = y.dateSave;
        this.stockMax = y.stockMax;
        this.stockMin = y.stockMin;
        this.modeAppro = y.modeAppro;
        this.modeReappro = y.modeReappro;
        this.intervalApprov = y.intervalApprov;
        this.uniteInterval = y.uniteInterval;
        this.quantiteStock = y.quantiteStock;
        this.supp = y.supp;
        this.actif = y.actif;
        this.stockAlert = y.stockAlert;
        this.stockInitial = y.stockInitial;
        this.dateAppro = y.dateAppro;
        this.margStockMoyen = y.margStockMoyen;
        this.stockNet = y.stockNet;
        this.lotLivraison = y.lotLivraison;
        this.article = y.article;
        this.depot = y.depot;
        this.depotPr = y.depotPr;
        this.requiereLot = y.requiereLot;
        this.author = y.author;
        this.sellWithoutStock = y.sellWithoutStock;
    }

    public String getTypeDocumentGenerer() {
        return typeDocumentGenerer != null ? typeDocumentGenerer.trim().length() > 0 ? typeDocumentGenerer : "FA" : "FA";
    }

    public void setTypeDocumentGenerer(String typeDocumentGenerer) {
        this.typeDocumentGenerer = typeDocumentGenerer;
    }

    public Boolean getGenererDocument() {
        return genererDocument != null ? genererDocument : false;
    }

    public void setGenererDocument(Boolean genererDocument) {
        this.genererDocument = genererDocument;
    }

    public YvsBaseDepots getDepotPr() {
        return depotPr;
    }

    public void setDepotPr(YvsBaseDepots depotPr) {
        this.depotPr = depotPr;
    }

    public String getUniteInterval() {
        return uniteInterval != null ? uniteInterval : "";
    }

    public void setUniteInterval(String uniteInterval) {
        this.uniteInterval = uniteInterval;
    }

    public Double getStockMax() {
        return stockMax != null ? stockMax : 0;
    }

    public void setStockMax(Double stockMax) {
        this.stockMax = stockMax;
    }

    public Double getStockMin() {
        return stockMin != null ? stockMin : 0;
    }

    public void setStockMin(Double stockMin) {
        this.stockMin = stockMin;
    }

    public String getModeAppro() {
        modeAppro = modeAppro != null ? modeAppro : "";
        return modeAppro.trim().length() > 0 ? modeAppro : "ACHT_PROD_EN";
    }

    public void setModeAppro(String modeAppro) {
        this.modeAppro = modeAppro;
    }

    public String getModeReappro() {
        modeReappro = modeReappro != null ? modeReappro : "";
        return modeReappro.trim().length() > 0 ? modeReappro : "RUPTURE";
    }

    public void setModeReappro(String modeReappro) {
        this.modeReappro = modeReappro;
    }

    public Integer getIntervalApprov() {
        return intervalApprov != null ? intervalApprov : 0;
    }

    public void setIntervalApprov(Integer intervalApprov) {
        this.intervalApprov = intervalApprov;
    }

    public Double getQuantiteStock() {
        return quantiteStock != null ? quantiteStock : 0;
    }

    public void setQuantiteStock(Double quantiteStock) {
        this.quantiteStock = quantiteStock;
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

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YvsBaseArticles getArticle() {
        return article;
    }

    public void setArticle(YvsBaseArticles article) {
        this.article = article;
    }

    public Date getDateAppro() {
        return dateAppro;
    }

    public void setDateAppro(Date dateAppro) {
        this.dateAppro = dateAppro;
    }

    public Boolean getSellWithoutStock() {
        return sellWithoutStock != null ? sellWithoutStock : true;
    }

    public void setSellWithoutStock(Boolean sellWithoutStock) {
        this.sellWithoutStock = sellWithoutStock;
    }

    public YvsBaseDepots getDepot() {
        return depot;
    }

    public void setDepot(YvsBaseDepots depot) {
        this.depot = depot;
    }

    public Double getStockInitial() {
        return stockInitial != null ? stockInitial : 0;
    }

    public void setStockInitial(Double stockInitial) {
        this.stockInitial = stockInitial;
    }

    public Double getStockAlert() {
        return stockAlert != null ? stockAlert : 0;
    }

    public void setStockAlert(Double stockAlert) {
        this.stockAlert = stockAlert;
    }

    public Boolean getRequiereLot() {
        return requiereLot != null ? requiereLot : false;
    }

    public void setRequiereLot(Boolean requiereLot) {
        this.requiereLot = requiereLot;
    }

    public Double getMargStockMoyen() {
        return margStockMoyen != null ? margStockMoyen : 0.0;
    }

    public void setMargStockMoyen(Double margStockMoyen) {
        this.margStockMoyen = margStockMoyen;
    }

    public Double getStockNet() {
        return stockNet != null ? stockNet : 0.0;
    }

    public void setStockNet(Double stockNet) {
        this.stockNet = stockNet;
    }

    public Integer getLotLivraison() {
        return lotLivraison != null ? lotLivraison : 0;
    }

    public void setLotLivraison(Integer lotLivraison) {
        this.lotLivraison = lotLivraison;
    }

    public Boolean getSuiviStock() {
        return suiviStock != null ? suiviStock : true;
    }

    public void setSuiviStock(Boolean suiviStock) {
        this.suiviStock = suiviStock;
    }

    public YvsBaseConditionnement getDefaultCond() {
        return defaultCond;
    }

    public void setDefaultCond(YvsBaseConditionnement defaultCond) {
        this.defaultCond = defaultCond;
    }

    public Boolean getDefaultPr() {
        return defaultPr != null ? defaultPr : false;
    }

    public void setDefaultPr(Boolean defaultPr) {
        this.defaultPr = defaultPr;
    }

    public Date getLastDateCalculPr() {
        return lastDateCalculPr;
    }

    public void setLastDateCalculPr(Date lastDateCalculPr) {
        this.lastDateCalculPr = lastDateCalculPr;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        if (!(object instanceof YvsBaseArticleDepot)) {
            return false;
        }
        YvsBaseArticleDepot other = (YvsBaseArticleDepot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticleDepot[ id=" + id + " ]";
    }

}
