package com.ivaan.demo.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivaan.demo.entidades.Persona;

@RestController
@RequestMapping("sena")
public class PersonaRest {

	@GetMapping("persona")
	public ResponseEntity<Persona> getPersona(
			@RequestParam(value="id", defaultValue = "0")String documento){
		
		Persona miPersona = null;
		
		if(documento.equals("111")) {
			miPersona=new Persona (documento, "Pedro",true);
		}else if(documento.equals("222")){
			miPersona=new Persona (documento, "Ivan",true);
		}else {
			miPersona=new Persona ("0", "NA",false);
		}
		
		return ResponseEntity.ok(miPersona);
	}
	
}
