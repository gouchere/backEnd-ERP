package com.erp.lymytz.api.model.base.users;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.erp.lymytz.api.model.YvsEntity;
import com.erp.lymytz.api.model.param.YvsAgences;

@Entity
@Table(name = "yvs_users")
public class YvsUsers extends YvsEntity implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(sequenceName = "yvs_users_id_seq", name = "yvs_users_id_seq_name", allocationSize = 1)
    @GeneratedValue(generator = "yvs_users_id_seq_name", strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "code_users")
    private String codeUsers;
    @Column(name = "password_user")
    private String passwordUser;
    @Column(name = "photo")
    private String photo;
    @Column(name = "civilite")
    private String civilite;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "vente_online")
    private Boolean venteOnline = false;
    @Column(name = "actif")
    private Boolean actif = true;
    @Column(name = "connect_online_planning")
    private Boolean connectOnlinePlanning = false;
    @Column(name = "alea_mdp")
    private String aleaMdp;
    @Column(name = "connecte")
    private Boolean connecte = false;
    @Column(name = "nom_users")
    private String nomUsers;
    @Column(name = "super_admin")
    private Boolean superAdmin = false;
    @Column(name = "supp")
    private Boolean supp = false;

    @JoinColumn(name = "agence", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YvsAgences agence;

    public YvsUsers() {
		// TODO Auto-generated constructor stub
	}
}
