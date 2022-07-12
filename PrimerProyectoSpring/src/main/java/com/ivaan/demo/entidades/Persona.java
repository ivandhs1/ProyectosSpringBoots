package com.ivaan.demo.entidades;

public class Persona {
	
	private String id;
	private String nombre;
	private boolean estado;
	public Persona(String id, String nombre, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
