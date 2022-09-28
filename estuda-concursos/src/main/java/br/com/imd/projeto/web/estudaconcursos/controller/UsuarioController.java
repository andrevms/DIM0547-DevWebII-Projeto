package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.imd.projeto.web.estudaconcursos.model.Usuario;
import br.com.imd.projeto.web.estudaconcursos.service.UsuarioService;

@Controller
public class UsuarioController {
    
    @Autowired
    @Qualifier("usuarioServiceImpl")
    UsuarioService usuarioService;

    @RequestMapping("usuario/login")
    public String tryLoginUsuario(@ModelAttribute("email") String email, @ModelAttribute("senha") String senha,  Model model) {
        Usuario u = usuarioService.login(email, senha);
        System.out.println(u.getId() + " " + u.getNome() + " " + u.getEmail() + " " + u.getSenha());
        return "index";
    }
}
