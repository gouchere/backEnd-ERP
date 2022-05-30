package com.erp.lymytz.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.erp.lymytz.api.converter.base.ConverterAuthor;
import com.erp.lymytz.api.model.base.users.YvsUsersAgence;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@MappedSuperclass
public abstract class YvsEntity implements Serializable {

    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateUpdate;
    @Column(name = "date_save")
    @Temporal(TemporalType.TIMESTAMP)
	protected Date dateSave = new Date();

    @JoinColumn(name = "author")
    @ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(converter = ConverterAuthor.class)
	protected YvsUsersAgence author;

	public YvsEntity() {
		// TODO Auto-generated constructor stub
		this.dateSave = new Date();
		this.dateUpdate = new Date();
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
