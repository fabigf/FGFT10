package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.myapp.model.Curso;
import com.example.myapp.model.Rol;
import com.example.myapp.model.Usuario;
import com.example.myapp.repository.CursoRepository;
import com.example.myapp.repository.UsuarioRepository;

@SpringBootApplication
public class Main {

	@Autowired
    PasswordEncoder encoder;

	public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
		return args -> {
			usuarioRepository.save(new Usuario(null, "admin", "admin@mail.com", encoder.encode("1234"), Rol.ADMIN));
			usuarioRepository.save(new Usuario(null, "manager", "manager@mail.com", encoder.encode("1234"), Rol.MANAGER));
			usuarioRepository.save(new Usuario(null, "user", "user@mail.com", encoder.encode("1234"), Rol.USER));

			cursoRepository.save(new Curso(null, "Java Básico", "Programación", "Curso introductorio de Java"));
			cursoRepository.save(new Curso(null, "Spring Boot", "Frameworks", "Desarrollo de APIs REST con Spring Boot"));
			cursoRepository.save(new Curso(null, "Bases de Datos", "Datos", "Introducción a bases de datos relacionales"));
			cursoRepository.save(new Curso(null, "Angular", "Frontend", "Desarrollo web con Angular"));
			};
	}
}
