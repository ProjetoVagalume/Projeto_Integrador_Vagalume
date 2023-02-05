package org.generation.vagalume.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagensvagalume" )
public class PostagemVagalume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo postagem é Obrigatório !")
	@Size(min = 5, max = 1000, message = " O campo da postagem deve conter no Min 10 e no Máx 1000 caracteres")
	private String postagemtexto;
	
	@UpdateTimestamp
	private LocalDateTime datapostagem;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaVagalume temavagalume;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private UsuarioVagalume usuario;
	
	
	
	public UsuarioVagalume getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVagalume usuario) {
		this.usuario = usuario;
	}

	public TemaVagalume getTemavagalume() {
		return temavagalume;
	}

	public void setTemavagalume(TemaVagalume temavagalume) {
		this.temavagalume = temavagalume;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostagemtexto() {
		return postagemtexto;
	}

	public void setPostagemtexto(String postagemtexto) {
		this.postagemtexto = postagemtexto;
	}

	public LocalDateTime getDatapostagem() {
		return datapostagem;
	}

	public void setDatapostagem(LocalDateTime datapostagem) {
		this.datapostagem = datapostagem;
	}
}
