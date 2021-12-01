package br.com.squad4.blue_bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/login.html")
        public String login() {
            return "login";

    }

    @GetMapping(value = "/cadastro.html")
    public String cadastro() {
        return "cadastro";

    }

    @GetMapping(value = "/historico.html")
    public String historico() {
        return "historico";

    }

    @GetMapping(value = "/crudclientes.html")
    public String crudclientes() {
        return "crudclientes";

    }


}
