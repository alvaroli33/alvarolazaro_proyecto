package com.dawes;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

	public static void main (String[] args) {
		BCryptPasswordEncoder encriptador=new BCryptPasswordEncoder();
		System.out.println("temporal encriptado es "+encriptador.encode("temporal"));
	}
}
