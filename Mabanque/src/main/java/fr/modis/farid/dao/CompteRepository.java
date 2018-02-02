package fr.modis.farid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.modis.farid.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
