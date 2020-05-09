package br.biblioteca.livros.controller;

import br.biblioteca.livros.model.Autor;
import br.biblioteca.livros.model.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivrosService livroService;

    @Autowired
    AutorService autorService;

    /**
     * Lista todos os livros
     *
     * @return
     */
    @GetMapping("/list")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("livros/list");
        List<Livro> listaLivros = livroService.listaTodosLivros();
        modelAndView.addObject("livros", listaLivros);
        return modelAndView;
    }

    /**
     * Cria um novo registro de livro de acordo com as informacoes recebidas via formulario
     *
     * @param livro
     * @return
     */
    @GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Livro livro) {
        ModelAndView modelAndView = new ModelAndView("livros/form");
        List<Autor> listaAutores = autorService.listaAutores();
        modelAndView.addObject("listaAutores", listaAutores);
        return modelAndView;
    }

    /**
     * Altera os dados do livro de acordo com as alteracoes realizadas no formulario
     *
     * @param id
     * @return
     */
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {

        Livro livro = livroService.buscaLivro(id);
        List<Autor> listaAutores = autorService.listaAutores();

        ModelAndView modelAndView = new ModelAndView("livros/form");
        modelAndView.addObject("listaAutores", listaAutores);
        modelAndView.addObject("livro", livro);

        return modelAndView;
    }

    /**
     * Exclui um registro de livro
     *
     * @param id
     * @return
     */
    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        livroService.excluirLivro(id);
        return new ModelAndView("redirect:/livros/list");
    }

    /**
     * Grava os informacoes recebidas de uma alteracao
     *
     * @param livro
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Livro livro, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Autor> listaAutores = autorService.listaAutores();
            return new ModelAndView("livros/form", "listaAutores", listaAutores);
        }
        livroService.salvarLivro(livro);
        return new ModelAndView("redirect:/livros/list");

    }

}
