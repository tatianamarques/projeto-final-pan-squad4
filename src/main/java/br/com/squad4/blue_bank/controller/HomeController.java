package br.com.squad4.blue_bank.controller;

import br.com.squad4.blue_bank.form.ClienteForm;
import br.com.squad4.blue_bank.model.Cliente;
import br.com.squad4.blue_bank.repository.ClienteRepository;
import br.com.squad4.blue_bank.services.ClienteService;
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
        ClienteForm cliente = new ClienteForm();
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
    private ClienteService clienteService;

    @RequestMapping(method= RequestMethod.GET, value = "/cadastrocliente")
    public String inicio(){
        return "templates/cadastro.html";
    }

    @RequestMapping(method=RequestMethod.POST, value="/salvarcliente")
    public String salvar(ClienteForm cliente,
                         @RequestParam(required = false,name = "senha") String senha,
                         @RequestParam(required = false,name = "senhac") String senhac,
                         Model model){

        if(!senha.equals(senhac)){
            model.addAttribute("aviso","Senhas não correspondem!");
        }else {

            System.out.println(senha);
            System.out.println(cliente);
            clienteService.salvar(cliente);
        }
        model.addAttribute("cliente",
                new ClienteForm( cliente.getNome(),
                                    cliente.getCpf(),
                                    cliente.getDataNascimento(),
                                    cliente.getEmail(),
                        cliente.getTelefoneForm(),
                        cliente.getEnderecoForm())
        );
        return "cadastro";
    }


}
