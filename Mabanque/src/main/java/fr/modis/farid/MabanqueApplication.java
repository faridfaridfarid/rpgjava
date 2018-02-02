package fr.modis.farid;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.modis.farid.dao.ClientRepository;
import fr.modis.farid.dao.CompteRepository;
import fr.modis.farid.dao.OperationRepository;
import fr.modis.farid.entities.Client;
import fr.modis.farid.entities.Compte;
import fr.modis.farid.entities.CompteCourant;
import fr.modis.farid.entities.CompteEpargne;
import fr.modis.farid.entities.Retrait;
import fr.modis.farid.entities.Versement;
import fr.modis.farid.service.IBanqueService;

@SpringBootApplication
public class MabanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository; 
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueService banqueService;
	public static void main(String[] args) {
	 SpringApplication.run(MabanqueApplication.class, args);
	 
	 
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		 Client c1 = clientRepository.save(new Client("Farid","farid@gmail.com"));
		 Client c2 = clientRepository.save(new Client("Ghilou","ghilou@gmail.com"));
		
		 Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(), 90000, c1, 6000));
		 Compte cp2 = compteRepository.save(new CompteEpargne("c2", new Date(), 6000, c2, 5.5));
		 
		 operationRepository.save(new Versement(new Date(), 9000, cp1));
		 operationRepository.save(new Versement(new Date(), 6000, cp1)); 
		 operationRepository.save(new Versement(new Date(), 2300, cp1));
		 operationRepository.save(new Retrait(new Date(), 9000, cp1));
		 
		 operationRepository.save(new Versement(new Date(), 2300, cp2));
		 operationRepository.save(new Versement(new Date(), 400, cp2));
		 operationRepository.save(new Versement(new Date(), 2300, cp2));
		 operationRepository.save(new Retrait(new Date(), 3000, cp2));
		 
		 banqueService.verser("c1", 111111);
	}
}
