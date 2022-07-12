package com.ivaan.ws.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.ivaan.ws.vo.PersonaVo;

public class PersonasUtilidades {
	
	public final static int TIPO_ADMIN=1;
	public final static int TIPO_EMPLEADO=2;
	static int bandera=0;
	
	public static List<PersonaVo> listaPersonas = new ArrayList<PersonaVo>();
	
	public static void iniciarListar() {
		if(bandera==0) {
			listaPersonas.add(new PersonaVo("admin","Administrador","NA",0,"Na","admin",1));
			listaPersonas.add(new PersonaVo("111","Cristian David HEnao","74532442",33,"Ingeniero","111",TIPO_ADMIN));
			listaPersonas.add(new PersonaVo("222","Juan Martin Orozco","3234234",21,"Estudiante","222",TIPO_EMPLEADO));
			listaPersonas.add(new PersonaVo("333","Maria Andrea Perez","23423423",22,"Estudiante","333",TIPO_EMPLEADO));
			bandera=1;
			
		}
	}
	
}
