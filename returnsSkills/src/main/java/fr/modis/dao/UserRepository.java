package fr.modis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.modis.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//public List<User> findById(Double id);
}
