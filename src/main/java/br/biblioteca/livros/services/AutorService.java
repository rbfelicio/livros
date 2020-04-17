package br.biblioteca.livros.services;

import br.biblioteca.livros.model.Autor;
import br.biblioteca.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    AutorRepository autorRepository;

    public List<Autor> listaAutores() {
        return autorRepository.findAll();
    }
}
