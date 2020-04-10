package br.biblioteca.livros.repository;

import br.biblioteca.livros.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity,Long> {
}
