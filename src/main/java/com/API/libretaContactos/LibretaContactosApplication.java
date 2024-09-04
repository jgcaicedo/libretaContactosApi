package com.API.libretaContactos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.API.LibretaContactos.Controlador", "com.API.LibretaContactos.Modelo", "com.API.LibretaContactos.Repositorio", "com.API.LibretaContactos.Servicio", "com.API.LibretaContactos.Config"})
public class LibretaContactosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibretaContactosApplication.class, args);
	}

}
