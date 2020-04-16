package br.biblioteca.livros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autor")
public class AutorController {

    @GetMapping("/list")
    public ModelAndView listar() {
        return new ModelAndView("autor/list");

    }

    @GetMapping("/novo")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("autor/form");
        return modelAndView;

    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("autor/form");
        return modelAndView;

    }
    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        return new ModelAndView("redirect:/autor/list");

    }
    @PostMapping(value ="/gravar")
    public ModelAndView create() {
        return new ModelAndView("redirect:/autor/list");

    }

}
