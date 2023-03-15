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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagensvagalume" )
public class PostagemVagalume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo nome é Obrigatório !")
	@Size(min = 5, max = 1000, message = " O campo da postagem deve conter no Min 10 e no Máx 1000 caracteres")
	private String nome;


	@NotBlank(message = "O campo telefone é Obrigatório !")
	private String telefone;

	@NotBlank(message = "O campo endereco é Obrigatório !")
	private String endereco;

	@NotBlank(message = "O campo horario é Obrigatório !")
	private String horario;

	@NotBlank(message = "O campo dias é Obrigatório !")
	private String dias;
	
	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime datapostagem;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaVagalume temavagalume;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private UsuarioVagalume usuario;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public LocalDateTime getDatapostagem() {
		return datapostagem;
	}

	public void setDatapostagem(LocalDateTime datapostagem) {
		this.datapostagem = datapostagem;
	}

	public TemaVagalume getTemavagalume() {
		return temavagalume;
	}

	public void setTemavagalume(TemaVagalume temavagalume) {
		this.temavagalume = temavagalume;
	}

	public UsuarioVagalume getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVagalume usuario) {
		this.usuario = usuario;
	}
}

