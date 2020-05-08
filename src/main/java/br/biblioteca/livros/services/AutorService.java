package br.biblioteca.livros.services;

import br.biblioteca.livros.exception.AutorNotFoundException;
import br.biblioteca.livros.model.Autor;
import br.biblioteca.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public List<Autor> listaAutores() {
        return autorRepository.findAll();
    }

    public void salvarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    public Autor buscaAutor(Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new AutorNotFoundException());
    }

    public void excluirAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
