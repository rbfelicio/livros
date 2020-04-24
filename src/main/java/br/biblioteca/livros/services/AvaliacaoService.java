package br.biblioteca.livros.services;

import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.model.Avaliacao;
import br.biblioteca.livros.model.Livro;
import br.biblioteca.livros.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> listaTodasAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Long salvarAvaliacao(Avaliacao avaliacao ){
        return avaliacaoRepository.save(avaliacao).getId();
    }

    public Avaliacao buscaAvaliacao(Long id){
        return avaliacaoRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void excluirAvaliacao(Long id){
        avaliacaoRepository.deleteById(id);
    }
}
