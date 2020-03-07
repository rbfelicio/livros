package br.biblioteca.livros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class LivroEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "QUANTIDADE_PAGINAS", nullable = false)
	private Integer quantidadePaginas;
	
	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	private AutorEntity autor;
}
