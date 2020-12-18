package com.tew.business.resteasy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.tew.model.User;

public class AlmacenServidor {

	
	private Set<User> usuariosLogged;
	private static AlmacenServidor almacen;
	
	private AlmacenServidor() {
		usuariosLogged = new HashSet<User>();
		
	}
	
	public static AlmacenServidor getAlmacen() {
		if(almacen == null) {almacen = new AlmacenServidor();}
		return almacen;
	}

	public Set<User> getUsuariosLogged() {
		return usuariosLogged;
	}

	public void setUsuariosLogged(Set<User> usuariosLogged) {
		this.usuariosLogged = usuariosLogged;
	}
	
	
	
}
