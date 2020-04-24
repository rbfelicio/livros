package br.biblioteca.livros.api;

import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.dto.LivroDTO;
import br.biblioteca.livros.exception.LivroNotFoundException;
import br.biblioteca.livros.facade.ApiFacade;
import br.biblioteca.livros.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.biblioteca.livros.converter.LivroConverter.toDTO;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiFacade apiFacade;

    @GetMapping("/livro/list")
    public ResponseEntity<List<LivroDTO>> listar() {
        List<Livro> listaLivros = apiFacade.listaTodosLivros();
        return ResponseEntity.ok(toDTO(listaLivros));
    }

    @PostMapping("/livro/avaliacao/{id}")
    public ResponseEntity<Long> comentario(@PathVariable("id") Long id, @RequestBody AvaliacaoDTO avaliacaoDTO){
        try {
            return ResponseEntity.ok(apiFacade.salvarAvaliacao(id, avaliacaoDTO));
        }catch (LivroNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
