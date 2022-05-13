package com.erp.lymytz.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.erp.lymytz.api.model.base.YvsUsersAgence;

public class YvsEntity {
	
    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;
    @Column(name = "date_save")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSave = new Date();
    
    @JoinColumn(name = "author")
    @ManyToOne(fetch = FetchType.LAZY)
	private YvsUsersAgence author;
	
	public YvsEntity() {
		// TODO Auto-generated constructor stub
	}

	public YvsUsersAgence getAuthor() {
		return author;
	}

	public void setAuthor(YvsUsersAgence author) {
		this.author = author;
	}

	public Date getDateSave() {
		return dateSave;
	}

	public void setDateSave(Date dateSave) {
		this.dateSave = dateSave;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	
}
