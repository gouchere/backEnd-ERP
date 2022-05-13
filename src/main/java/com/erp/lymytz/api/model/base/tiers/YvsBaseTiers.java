package com.erp.lymytz.api.model.base.tiers;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.erp.lymytz.api.model.YvsEntity;

import lombok.Data;

@Entity
@Data
@Table(name = "yvs_base_tiers")

public class YvsBaseTiers extends YvsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(sequenceName = "yvs_base_tiers_id_seq", name = "yvs_base_tiers_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_base_tiers_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    public YvsBaseTiers() {

    }

    public YvsBaseTiers(Long id) {
        this();
        this.id = id;
    }
    
    public Long getId() {
		return id;
	}
    
    public void setId(Long id) {
		this.id = id;
	}

}
