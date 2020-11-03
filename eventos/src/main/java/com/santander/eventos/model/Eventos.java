package com.santander.eventos.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_EVENTOS")
public class Eventos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvento;
	
	
	@NotNull
	@Size(min =2, max = 100)
	private String titulo;
	
	@Size(min =2, max = 200)
	private String descricao;
	
	@NotNull
	private LocalDateTime inicioEvento;
	
	@NotNull
	private LocalDateTime fimEvento;
	

	@NotNull
	@Size(min=2, max=80)
	private String organizador;
	
	//private List convidados;
	
	
	public Eventos(Long idEvento, String titulo, String descricao, LocalDateTime inicioEvento, LocalDateTime fimEvento) {
		super();
		this.idEvento = idEvento;
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicioEvento = inicioEvento;
		this.fimEvento = fimEvento;
	}
	
	public Eventos() {
		super();
	}
	
	
	//Getters and Setters
	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	//public List getConvidados() {
		//return convidados;
	//}

	//public void setConvidados(List convidados) {
		//this.convidados = convidados;
	//}
	
	public LocalDateTime getInicioEvento() {
		return inicioEvento;
	}

	public void setInicioEvento(LocalDateTime inicioEvento) {
		this.inicioEvento = inicioEvento;
	}

	public LocalDateTime getFimEvento() {
		return fimEvento;
	}

	public void setFimEvento(LocalDateTime fimEvento) {
		this.fimEvento = fimEvento;
	}
	
	
	
	
	

}
