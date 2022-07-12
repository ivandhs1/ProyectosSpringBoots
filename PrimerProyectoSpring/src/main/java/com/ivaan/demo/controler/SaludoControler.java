package com.ivaan.demo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class SaludoControler {
	
	@GetMapping("saludo")
	public String saludo() {
		return "Hola SpringBoot por primera vez";
	}
	
	@GetMapping("saludame")
	public String saludame(@RequestParam(value="nombre", defaultValue = "Bienvenid@") String nombre) {
		return "Hola "+nombre+" Este es nuestro primer ejemplo con SpringBoot";
	}
	
}
