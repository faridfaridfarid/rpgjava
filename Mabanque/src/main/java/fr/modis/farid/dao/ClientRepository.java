package fr.modis.farid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.modis.farid.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
