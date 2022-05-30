package com.erp.lymytz.api.model.base.param;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.base.YvsDictionnaire;
import com.erp.lymytz.api.model.param.YvsSocietes;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Lymytz Dowes
 */
@Entity
@Table(name = "yvs_dictionnaire_informations")
@NamedQueries({
        @NamedQuery(name = "YvsDictionnaireInformations.findAll", query = "SELECT y FROM YvsDictionnaireInformations y")
})
public class YvsDictionnaireInformations extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yvs_dictionnaire_informations_id_seq")
    @SequenceGenerator(sequenceName = "yvs_dictionnaire_informations_id_seq", allocationSize = 1, name = "yvs_dictionnaire_informations_id_seq")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "active_livraison")
    private Boolean activeLivraison;

    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsSocietes societe;
    @JoinColumn(name = "lieux", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsDictionnaire lieux;

    public YvsDictionnaireInformations() {
        super();
    }

    public YvsDictionnaireInformations(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActiveLivraison() {
        return activeLivraison != null ? activeLivraison : false;
    }

    public void setActiveLivraison(Boolean activeLivraison) {
        this.activeLivraison = activeLivraison;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public YvsDictionnaire getLieux() {
        return lieux;
    }

    public void setLieux(YvsDictionnaire lieux) {
        this.lieux = lieux;
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
        if (!(object instanceof YvsDictionnaireInformations)) {
            return false;
        }
        YvsDictionnaireInformations other = (YvsDictionnaireInformations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.param.YvsDictionnaireInformations[ id=" + id + " ]";
    }

}
