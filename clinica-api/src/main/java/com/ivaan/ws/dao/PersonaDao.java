package com.ivaan.ws.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ivaan.ws.utilidades.PersonasUtilidades;
import com.ivaan.ws.vo.PersonaVo;

@Service
public class PersonaDao {
	
	public PersonaDao() {
		PersonasUtilidades.iniciarListar();
	}

	public PersonaVo consultarPersonaIndividual(String documento) {
		// TODO Auto-generated method stub
		PersonaVo persona=null;
		for (PersonaVo p: PersonasUtilidades.listaPersonas) {
			
			if(p.getDocumento().equals(documento)) {
				persona=new PersonaVo();
				persona.setDocumento(p.getDocumento());
				persona.setNombre(p.getNombre());
				persona.setTelefono(p.getTelefono());
				persona.setEdad(p.getEdad());
				persona.setProfesion(p.getProfesion());
				persona.setPassword(p.getPassword());
				persona.setTipo(p.getTipo());
			}
			
		}
		return persona;
	}
	
	public PersonaVo consultarPersonaIdProfesion(String documento, String profesion) {
		PersonaVo persona=null;
		for(PersonaVo p: PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(documento) && p.getProfesion().endsWith(profesion)) {
				persona=new PersonaVo();
				persona.setDocumento(p.getDocumento());
				persona.setNombre(p.getNombre());
				persona.setTelefono(p.getTelefono());
				persona.setEdad(p.getEdad());
				persona.setProfesion(p.getProfesion());
				persona.setPassword(p.getPassword());
				persona.setTipo(p.getTipo());
			}
		}
		return persona;
	}

	public List<PersonaVo> obtenerListaPersonas() {
		// TODO Auto-generated method stub
		return PersonasUtilidades.listaPersonas;
	}
	
	public PersonaVo registrarPersona(PersonaVo persona) {
		boolean existe=false;
		
		for(PersonaVo obj : PersonasUtilidades.listaPersonas){
			if(obj.getDocumento().equals(persona.getDocumento())) {
				existe=true;
				break;
			}
		}
		
		if(existe==false) {
			persona.setPassword(persona.getDocumento());
			PersonasUtilidades.listaPersonas.add(persona);
			return persona;
		}else {
			return null;
		}
		
	}
	
	public PersonaVo consultarLogin(String documento, String pass) {
		PersonaVo persona=null;
		
		for(PersonaVo p : PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(documento) && p.getPassword().equals(pass)) {
				persona=p;
				break;
			}
		}
		return persona;
	}
	
	public PersonaVo actualizarPersona(PersonaVo persona) {
		PersonaVo personaVo=null;
		for(PersonaVo obj : PersonasUtilidades.listaPersonas) {
			if(obj.getDocumento().equals(persona.getDocumento())) {
				obj.setDocumento(persona.getDocumento());
				obj.setNombre(persona.getNombre());
				obj.setTelefono(persona.getTelefono());
				obj.setEdad(persona.getEdad());
				obj.setProfesion(persona.getProfesion());
				obj.setPassword(persona.getPassword());
				obj.setTipo(persona.getTipo());
				personaVo=obj;
				break;
			}
		}
		return personaVo;
	}
	
	public void eliminarPersona(PersonaVo persona) {
		for(PersonaVo obj: PersonasUtilidades.listaPersonas) {
			if(obj.getDocumento().equals(persona.getDocumento())) {
				PersonasUtilidades.listaPersonas.remove(obj);
				break;
			}
		}
	}
}


