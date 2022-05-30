package com.erp.lymytz.api.model.base.article.param;

import java.io.Serializable;

import javax.persistence.*;

import com.erp.lymytz.api.converter.param.ConverterSociete;
import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Data
@Table(name = "yvs_base_classes_stat")
@NamedQueries({
        @NamedQuery(name = "YvsBaseClassesStat.findAll", query = "SELECT y FROM YvsBaseClassesStat y WHERE y.societe =:societe ORDER BY y.designation"),
})
public class YvsBaseClassesStat extends YvsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_classes_stat_id_seq", name = "yvs_base_classes_stat_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_classes_stat_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "code_ref")
    private String codeRef;
    @Column(name = "designation")
    private String designation;
    @Column(name = "actif")
    private Boolean actif;
    @Column(name = "visible_synthese")
    private Boolean visibleSynthese;
    @Column(name = "visible_journal")
    private Boolean visibleJournal;

    @JoinColumn(name = "societe", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterSociete.class)
    private YvsSocietes societe;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private YvsBaseClassesStat parent;

    public YvsBaseClassesStat() {
    }

    public YvsBaseClassesStat(Long id) {
        this.id = id;
    }

    public YvsBaseClassesStat(Long id, String codeRef) {
        this(id);
        this.codeRef = codeRef;
    }

    public YvsBaseClassesStat(Long id, String codeRef, String designation) {
        this(id, codeRef);
        this.designation = designation;
    }

    public Long getId() {
        return id != null ? id : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeRef() {
        return codeRef;
    }

    public void setCodeRef(String codeRef) {
        this.codeRef = codeRef;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getActif() {
        return actif != null ? actif : false;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean getVisibleSynthese() {
        return visibleSynthese != null ? visibleSynthese : false;
    }

    public void setVisibleSynthese(Boolean visibleSynthese) {
        this.visibleSynthese = visibleSynthese;
    }

    public Boolean getVisibleJournal() {
        return visibleJournal != null ? visibleJournal : false;
    }

    public void setVisibleJournal(Boolean visibleJournal) {
        this.visibleJournal = visibleJournal;
    }

    public YvsSocietes getSociete() {
        return societe;
    }

    public void setSociete(YvsSocietes societe) {
        this.societe = societe;
    }

    public YvsBaseClassesStat getParent() {
        return parent;
    }

    public void setParent(YvsBaseClassesStat parent) {
        this.parent = parent;
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
        if (!(object instanceof YvsBaseClassesStat)) {
            return false;
        }
        YvsBaseClassesStat other = (YvsBaseClassesStat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erp.lymytz.api.model.base.article.param.YvsBaseClassesStat[ id=" + id + " ]";
    }
}
