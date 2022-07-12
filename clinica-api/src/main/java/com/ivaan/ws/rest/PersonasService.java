package com.ivaan.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivaan.ws.dao.PersonaDao;
import com.ivaan.ws.vo.PersonaVo;

@RestController
@RequestMapping("/servicio")
public class PersonasService {
	
	@Autowired(required=true)
	private PersonaDao personaDao;
	
	@GetMapping("hola")
	public String saludo() {
		return "Este es el saludo de clinica web";
	}
	
	/**http://localhost:8080/servicio/personas?id=admin*/
	@GetMapping("personas")
	public ResponseEntity<PersonaVo> getPersona(@RequestParam(value="id", defaultValue = "0") String documento){
		
		PersonaVo persona = personaDao.consultarPersonaIndividual(documento);
		
		if(persona==null) {
			persona = new PersonaVo();
		}
		
		return ResponseEntity.ok(persona);
		
	}
	
	/**http://localhost:8080/servicio/personas?id=111&profesion=Estudiante*/
	@GetMapping("profesion")
	public ResponseEntity<PersonaVo> getPersonaIdProfesion(@RequestParam(value="id", defaultValue = "0") String documento,
															@RequestParam(value="profesion", defaultValue = "0") String profesion){
		
		PersonaVo persona = personaDao.consultarPersonaIdProfesion(documento, profesion);
		
		if(persona==null) {
			persona = new PersonaVo();
		}
		
		return ResponseEntity.ok(persona);
		
	}
	
	
	/**http://localhost:8080/servicio/personas/222*/
	@GetMapping("personas/{id}")
	public ResponseEntity<PersonaVo> getPersona1(@PathVariable("id") String documento){
		
		PersonaVo persona = personaDao.consultarPersonaIndividual(documento);
		
		if(persona!=null) {
			
			return ResponseEntity.ok(persona);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	/**http://localhost:8080/servicio/personas/222/Estudiante*/
	@GetMapping("personas/{id}/{profesion}")
	public ResponseEntity<PersonaVo> getPersonaIdProfesion2(@PathVariable("id") String documento,
															@PathVariable String profesion){
		
		PersonaVo persona = personaDao.consultarPersonaIdProfesion(documento, profesion);
		
		if(persona==null) {
			return ResponseEntity.ok(persona);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	/**http://localhost:8080/servicio/personas-list*/
	@GetMapping("personas-list")
	public ResponseEntity<List<PersonaVo>> getPersonas(){
		List<PersonaVo> personas = personaDao.obtenerListaPersonas();
		return ResponseEntity.ok(personas);
	}
	
	/**http://localhost:8080/servicio/guardar*/
	@PostMapping("guardar")
	public ResponseEntity<PersonaVo> registrarPersona(@RequestBody PersonaVo persona){
		PersonaVo miPersona=personaDao.registrarPersona(persona);
		if(miPersona!=null) {
			return ResponseEntity.ok(miPersona);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("login")
	public ResponseEntity<PersonaVo> validarUsuario(@RequestBody PersonaVo persona){
		 PersonaVo miPersona=personaDao.consultarLogin(persona.getDocumento(), persona.getPassword());
		 if(miPersona!=null) {
			 return ResponseEntity.ok(miPersona);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	}
	
	@PutMapping("actualizar")
	public ResponseEntity<PersonaVo> actualizarUsuario(@RequestBody PersonaVo persona){
		PersonaVo miPersona=null;
		if(personaDao.consultarPersonaIndividual(persona.getDocumento())!=null) {
			miPersona=personaDao.actualizarPersona(persona);
			if(miPersona!=null) {
				return ResponseEntity.ok(miPersona);
			}else {
				return ResponseEntity.notFound().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable String id){
		PersonaVo miPersona=personaDao.consultarPersonaIndividual(id);
		if(miPersona!=null) {
			personaDao.eliminarPersona(miPersona);
			return ResponseEntity.ok(null);
			
		}
		return ResponseEntity.notFound().build();
	}
	
}
