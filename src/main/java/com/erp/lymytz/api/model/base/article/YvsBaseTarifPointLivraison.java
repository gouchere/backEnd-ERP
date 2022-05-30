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

import com.erp.lymytz.api.model.base.param.YvsDictionnaireInformations;

/**
 * @author lymytz
 */
@Entity
@Table(name = "yvs_base_tarif_point_livraison")
@NamedQueries({
        @NamedQuery(name = "YvsBaseTarifPointLivraison.findAll", query = "SELECT y FROM YvsBaseTarifPointLivraison y WHERE y.article = :article ORDER BY y.lieuxLiv.lieux.libele")
})
public class YvsBaseTarifPointLivraison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_tarif_point_livraison_id_seq", name = "yvs_base_tarif_point_livraison_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_tarif_point_livraison_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "frais_livraison")
    private Double fraisLivraison;
    @Column(name = "delai_retour")
    private Integer delaiRetour;
    @Column(name = "delai_for_livraison")
    private Integer delaiForLivraison;
    @Column(name = "delai_for_retrait")
    private Integer delaiForRetrait;
    @Column(name = "livraison_domicile")
    private Boolean livraisonDomicile;

    @JoinColumn(name = "article", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsBaseArticles article;
    @JoinColumn(name = "lieux_liv", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsDictionnaireInformations lieuxLiv;

    public YvsBaseTarifPointLivraison() {
        super();
    }

    public YvsBaseTarifPointLivraison(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFraisLivraison() {
        return fraisLivraison != null ? fraisLivraison : 0;
    }

    public void setFraisLivraison(Double fraisLivraison) {
        this.fraisLivraison = fraisLivraison;
    }

    public Boolean getLivraisonDomicile() {
        return livraisonDomicile != null ? livraisonDomicile : false;
    }

    public void setLivraisonDomicile(Boolean livraisonDomicile) {
        this.livraisonDomicile = livraisonDomicile;
    }

    public Integer getDelaiForLivraison() {
        return delaiForLivraison != null ? delaiForLivraison : 0;
    }

    public void setDelaiForLivraison(Integer delaiForLivraison) {
        this.delaiForLivraison = delaiForLivraison;
    }

    public Integer getDelaiForRetrait() {
        return delaiForRetrait != null ? delaiForRetrait : 0;
    }

    public void setDelaiForRetrait(Integer delaiForRetrait) {
        this.delaiForRetrait = delaiForRetrait;
    }

    public Integer getDelaiRetour() {
        return delaiRetour != null ? delaiRetour : 0;
    }

    public void setDelaiRetour(Integer delaiRetour) {
        this.delaiRetour = delaiRetour;
    }

    public YvsBaseArticles getArticle() {
        return article;
    }

    public void setArticle(YvsBaseArticles article) {
        this.article = article;
    }

    public YvsDictionnaireInformations getLieuxLiv() {
        return lieuxLiv;
    }

    public void setLieuxLiv(YvsDictionnaireInformations lieuxLiv) {
        this.lieuxLiv = lieuxLiv;
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
        if (!(object instanceof YvsBaseTarifPointLivraison)) {
            return false;
        }
        YvsBaseTarifPointLivraison other = (YvsBaseTarifPointLivraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.YvsBaseTarifPointLivraison[ id=" + id + " ]";
    }

}
