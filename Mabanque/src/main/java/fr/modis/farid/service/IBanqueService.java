package fr.modis.farid.service;

import org.springframework.data.domain.Page;

import fr.modis.farid.entities.Compte;
import fr.modis.farid.entities.Operation;

public interface IBanqueService {
	public Compte consulterCompte(String codeCpte);
	public void verser(String codeCpte, double montant);
	public void retirer(String codeCpte, double montant);
	public void virement(String codeCpte1, String codeCpte2, double montant);
	public Page<Operation> listOperation(String codeCpte, int page, int size);
}
