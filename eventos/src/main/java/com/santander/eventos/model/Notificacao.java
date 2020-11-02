package com.santander.eventos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_NOTIFICACAO")
public class Notificacao {
	
	@Column(name = "idNotificacao")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNotificacao;
	
	private Date data;
	
	@NotNull
	@Size(min=2, max=10)
	private String notifica;

	//Getters and Setters
	public Long getIdNotificacao() {
		return idNotificacao;
	}

	public void setIdNotificacao(Long idNotificacao) {
		this.idNotificacao = idNotificacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNotifica() {
		return notifica;
	}

	public void setNotifica(String notifica) {
		this.notifica = notifica;
	}
	

}
