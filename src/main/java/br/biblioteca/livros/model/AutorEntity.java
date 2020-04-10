package br.biblioteca.livros.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class AutorEntity {

	@Id
	@GeneratedValue
	@Column(name = "AUTOR_ID")
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@OneToMany(mappedBy = "autor")
	private List<LivroEntity> livros = new ArrayList<>();

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

	public List<LivroEntity> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroEntity> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id +", nome=" + nome + "]";
	}
}
