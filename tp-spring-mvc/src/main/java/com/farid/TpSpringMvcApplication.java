package com.farid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.farid.dao.EtudiantRepository;
import com.farid.entities.Etudiant;

import groovyjarjarcommonscli.ParseException;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws java.text.ParseException {
		ApplicationContext ctx = SpringApplication.run(TpSpringMvcApplication.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("Ahmed", df.parse("1987-09-26"),"ahmed.gmail.com","ahmed"));
		etudiantRepository.save(new Etudiant("Farid", df.parse("1988-09-26"),"ahmed.gmail.com","farid"));
		etudiantRepository.save(new Etudiant("José", df.parse("1989-09-26"),"ahmed.gmail.com","josé"));
		
		//Page<Etudiant> etds = etudiantRepository.findAll(new PageRequest(0, 5));
		Page<Etudiant> etds = etudiantRepository.chercherEtudiants("%A%", new PageRequest(0, 5));
		etds.forEach(e->System.out.println(e.getNom()));
	}
}

// cette classe c'est mon apllication springboot