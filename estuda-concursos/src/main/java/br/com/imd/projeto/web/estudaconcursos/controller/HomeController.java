package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/login")
    public String login(Model model) {
        model.addAttribute("email", new String());
        model.addAttribute("senha", new String());
        return "pages/sign-in";
    }

    @RequestMapping(path = "/cadastro")
    public String cadastro() {
        return "pages/sign-up";
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        return new ModelAndView("dashboard");
    }
}
