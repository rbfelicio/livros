package br.biblioteca.livros.repository;

import br.biblioteca.livros.model.Avaliacao;
import br.biblioteca.livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {

}
