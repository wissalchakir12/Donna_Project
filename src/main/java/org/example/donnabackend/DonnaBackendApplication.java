package org.example.donnabackend;

import org.example.donnabackend.Services.EmailService;
import org.example.donnabackend.Services.ProduitService;
import org.example.donnabackend.Web.CommandeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class DonnaBackendApplication implements CommandLineRunner
{

	@Autowired
	private EmailService emailService;
	@Autowired
	private ProduitService produitService;
	public static void main(String[] args) {


		SpringApplication.run(DonnaBackendApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


	}


}

