package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/cadastro")
    public String cadastro() {
        return "index";
    }

}
