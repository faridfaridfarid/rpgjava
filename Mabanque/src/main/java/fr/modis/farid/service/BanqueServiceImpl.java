package fr.modis.farid.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.modis.farid.dao.CompteRepository;
import fr.modis.farid.dao.OperationRepository;
import fr.modis.farid.entities.Compte;
import fr.modis.farid.entities.CompteCourant;
import fr.modis.farid.entities.Operation;
import fr.modis.farid.entities.Retrait;
import fr.modis.farid.entities.Versement;
@Service
@Transactional // toutes les methodes s'execute correctement ou on annule tout c'est le transactionnel
public class BanqueServiceImpl implements IBanqueService {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.findOne(codeCpte);
		if(cp ==null) throw new RuntimeException("Compte introuvable");
			return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse = 0;
		if(cp instanceof CompteCourant) {
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();}
		if(cp.getSolde() + facilitesCaisse < montant) {
			throw new RuntimeException("Solde insuffisant");}
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {
		
		return operationRepository.listOperation(codeCpte, new PageRequest(page, size));
	}

}
