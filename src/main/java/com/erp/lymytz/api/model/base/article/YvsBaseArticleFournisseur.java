package com.erp.lymytz.api.model.base.article;

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

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.tiers.YvsBaseFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_article_fournisseur")
@NamedQueries({
    @NamedQuery(name = "YvsBaseArticleFournisseur.findAll", query = "SELECT y FROM YvsBaseArticleFournisseur y WHERE y.article = :article")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class YvsBaseArticleFournisseur extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_prod_article_fournisseur_id_seq", name = "yvs_prod_article_fournisseur_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_prod_article_fournisseur_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "delai_livraison")
    private Double delaiLivraison;
    @Column(name = "duree_garantie")
    private Double dureeGarantie;
    @Column(name = "duree_vie")
    private Double dureeVie;
    @Column(name = "unite_delai")
    private String uniteDelai;
    @Column(name = "unite_garantie")
    private String uniteGarantie;
    @Column(name = "unite_vie")
    private String uniteVie;
    @Column(name = "pua_ttc")
    private Boolean puaTtc;
    @Column(name = "principal")
    private Boolean principal;
    @Column(name = "puv")
    private Double puv;
    @Column(name = "remise")
    private Double remise;
    @Column(name = "nature_remise")
    private String natureRemise;
    @Column(name = "ref_art_externe")
    private String refArtExterne;
    @Column(name = "des_art_externe")
    private String desArtExterne;

    @JoinColumn(name = "fournisseur", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseFournisseur fournisseur;
    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseArticles article;

    public YvsBaseArticleFournisseur() {
        super();
    }

    public YvsBaseArticleFournisseur(Long id) {
        this();
        this.id = id;
    }

    public Boolean getPuaTtc() {
        return puaTtc != null ? puaTtc : false;
    }

    public void setPuaTtc(Boolean puaTtc) {
        this.puaTtc = puaTtc;
    }

    public String getNatureRemise() {
        return natureRemise;
    }

    public void setNatureRemise(String natureRemise) {
        this.natureRemise = natureRemise;
    }


    public String getRefArtExterne() {
        return refArtExterne != null ? refArtExterne.trim().length() > 0 ? refArtExterne : getArticle() != null ? getArticle().getRefArt() : "" : "";
    }

    public void setRefArtExterne(String refArtExterne) {
        this.refArtExterne = refArtExterne;
    }

    public String getDesArtExterne() {
        return desArtExterne != null ? desArtExterne.trim().length() > 0 ? desArtExterne : getArticle() != null ? getArticle().getDesignation() : "" : "";
    }

    public void setDesArtExterne(String desArtExterne) {
        this.desArtExterne = desArtExterne;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDelaiLivraison() {
        return delaiLivraison != null ? delaiLivraison : 0;
    }

    public Double getDureeVie() {
        return dureeVie != null ? dureeVie : 0;
    }

    public void setDureeVie(Double dureeVie) {
        this.dureeVie = dureeVie;
    }

    public void setDelaiLivraison(Double delaiLivraison) {
        this.delaiLivraison = delaiLivraison;
    }

    public Double getDureeGarantie() {
        return dureeGarantie != null ? dureeGarantie : 0;
    }

    public void setDureeGarantie(Double dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    public YvsBaseArticles getArticle() {
        return article;
    }

    public void setArticle(YvsBaseArticles article) {
        this.article = article;
    }

    public Boolean getPrincipal() {
        return principal != null ? principal : false;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
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

    public YvsBaseFournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(YvsBaseFournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getUniteDelai() {
        return uniteDelai != null ? uniteDelai : "H";
    }

    public void setUniteDelai(String uniteDelai) {
        this.uniteDelai = uniteDelai;
    }

    public String getUniteGarantie() {
        return uniteGarantie != null ? uniteGarantie.trim().length() > 0 ? uniteGarantie : "H" : "H";
    }

    public void setUniteGarantie(String uniteGarantie) {
        this.uniteGarantie = uniteGarantie;
    }

    public String getUniteVie() {
        return uniteVie != null ? uniteVie.trim().length() > 0 ? uniteVie : "H" : "H";
    }

    public void setUniteVie(String uniteVie) {
        this.uniteVie = uniteVie;
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
        if (!(object instanceof YvsBaseArticleFournisseur)) {
            return false;
        }
        YvsBaseArticleFournisseur other = (YvsBaseArticleFournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseArticleFournisseur[ id=" + id + " ]";
    }

}
