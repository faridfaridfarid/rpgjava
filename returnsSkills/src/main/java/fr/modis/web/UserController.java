package fr.modis.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import fr.modis.dao.UserRepository;
import fr.modis.entities.User;

@Controller
@RequestMapping(value = "/User")
public class UserController {
	@Autowired       //pour l'injection, appel UserRepository
	private UserRepository userRepository;
	
	@RequestMapping(value = "/Index")  //dans l'url, /Index appelera la methode Index
	public String Index(Model model) {
		List<User> user = userRepository.findAll();
		//avant d'aller à la vue je stock les etudiants dans le model
		model.addAttribute("users", user);
		return "users";   // ça c'est ma vue qui s'appelera users.html
	}
}
