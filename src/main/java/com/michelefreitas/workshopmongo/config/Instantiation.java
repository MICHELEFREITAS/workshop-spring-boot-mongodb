package com.michelefreitas.workshopmongo.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.michelefreitas.workshopmongo.domain.User;
import com.michelefreitas.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	//para fazer operação com o BD
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//chamando o userRepository que foi instanciado em cima para limpar a coleção do mongoDB
		userRepository.deleteAll();
		
		//null pois é o BD que vai gerar o id
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		//lista com vários argumentos
		
	}

}
