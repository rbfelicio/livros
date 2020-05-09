package br.biblioteca.livros.controller;

import br.biblioteca.livros.model.Autor;
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
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    /**
     * Lista todos os autores
     * @return
     */
    @GetMapping("/list")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("autor/list");
        List<Autor> listaAutores = autorService.listaAutores();
        modelAndView.addObject("autores", listaAutores);
        return modelAndView;

    }

    /**
     * Redireciona para criação de um novo Autor
     * @param autor
     * @return
     */
    @GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Autor autor) {
        ModelAndView modelAndView = new ModelAndView("autor/form");
        return modelAndView;

    }

    /**
     * Altera as informacoes recebidas via formulario
     * @param id
     * @return
     */
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {

        Autor autor = autorService.buscaAutor(id);
        ModelAndView modelAndView = new ModelAndView("autor/form");
        modelAndView.addObject("autor", autor);
        return modelAndView;

    }

    /**
     * Exclui o registro de autor
     * @param id
     * @return
     */
    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        autorService.excluirAutor(id);
        return new ModelAndView("redirect:autor/list");

    }

    /**
     * Grava as informacoes de autor
     * @param autor
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/gravar")
    public ModelAndView create(@Valid Autor autor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Autor> listaAutores = autorService.listaAutores();
            return new ModelAndView("autores/form", "listaAutores", listaAutores);
        }
        autorService.salvarAutor(autor);
        return new ModelAndView("redirect:/autor/list");

    }

}
