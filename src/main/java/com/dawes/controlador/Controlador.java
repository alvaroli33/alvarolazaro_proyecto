package com.dawes.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Controlador {

	@GetMapping("/index")
    public String index() {
        return "index";
    }
}
