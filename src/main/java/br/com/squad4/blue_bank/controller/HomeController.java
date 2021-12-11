package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.form.ClienteForm;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping(value = "/login.html")
        public String login() {
            return "login";

    }


    @GetMapping(value = "/cadastro.html")
    public String cadastro(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
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

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(method= RequestMethod.GET, value = "/cadastrocliente")
    public String inicio(){
        return "templates/cadastro.html";
    }

    @RequestMapping(method=RequestMethod.POST, value="/salvarcliente")
    public String salvar(Cliente cliente){
        clienteRepository.save(cliente);
        return "templates/cadastro.html";
    }


}
