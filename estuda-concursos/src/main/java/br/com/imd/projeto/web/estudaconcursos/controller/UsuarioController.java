package br.com.imd.projeto.web.estudaconcursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.imd.projeto.web.estudaconcursos.dto.CadastrarUsuarioDto;
import br.com.imd.projeto.web.estudaconcursos.dto.LoginUsuarioDto;
import br.com.imd.projeto.web.estudaconcursos.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    @Qualifier("usuarioServiceImpl")
    UsuarioService usuarioService;

    @PostMapping("login")
    public ModelAndView tryLoginUsuario(LoginUsuarioDto req) {

        System.out.println(req.toString());

        if (usuarioService.login(req.getEmail(), req.getSenha())) {
            var modelAndView = new ModelAndView("redirect:/dashboard");
            return modelAndView;
        } else {
            var modelAndView = new ModelAndView("pages/sign-in");
            modelAndView.addObject("erro", "Login e/ou senha incorretos");
            return modelAndView;
        }
    }

    @PostMapping()
    public ModelAndView cadastrarUsuario(CadastrarUsuarioDto req) {

        if (!req.senhaEConfirmacaoConferem()) {
            var modelAndView = new ModelAndView("pages/sign-up");
            modelAndView.addObject("erro", "Senha e confirmação de senha não conferem");
            return modelAndView;
        } else {
            var modelAndView = new ModelAndView("pages/sign-in");
            modelAndView.addObject("cadastroRecente", true);
            usuarioService.saveUsuario(req.paraUsuario());
            return modelAndView;
        }

    }
}
