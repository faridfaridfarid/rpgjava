package fr.modis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.modis.dao.UserRepository;
import fr.modis.entities.User;

@SpringBootApplication
public class ReturnsSkillsApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(ReturnsSkillsApplication.class, args);
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd 'at'hh:mm:ss");
		userRepository.save(new User(0.00005426, 552.04620807, 0.0, 0.0, 0.03002890, 0.0,
				df.parse("2018-01-29 at 05:12:36 "), df.parse("0000-00-00 at 00:00:00")));
	}
}
