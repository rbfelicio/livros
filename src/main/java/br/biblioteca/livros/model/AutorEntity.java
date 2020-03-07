package br.biblioteca.livros.model;

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
	private Long Id;
	
	@Column(name = "NOME")
	private String nome;
	
	@OneToMany(mappedBy = "LIVRO")
	private List<LivroEntity> livro = new ArrayList<LivroEntity>(); 
}
