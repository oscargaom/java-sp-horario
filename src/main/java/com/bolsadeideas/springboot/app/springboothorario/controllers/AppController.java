package com.bolsadeideas.springboot.app.springboothorario.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Value("${config.horario.apertura}")
    private Integer apertura;

    @Value("${config.horario.cierre}")
    private Integer cierre;

    @GetMapping({ "", "/", "/index" })
    public String index(Model model) {
        model.addAttribute("titulo", "Bienvenido al horario de atención a clientes");
        return "index";
    }

    @GetMapping("/cerrado")
    public String cerrado(Model model){

        StringBuilder mensaje= new StringBuilder("Cerrado, por favor vísitenos de ");
        mensaje.append(apertura);
        mensaje.append("hrs. a las ");
        mensaje.append(cierre);
        mensaje.append("hrs. Gracias");

        model.addAttribute("titulo", "Fuera del horario de atención.");
        model.addAttribute("mensaje", mensaje);

        return "cerrado";
    }
}
