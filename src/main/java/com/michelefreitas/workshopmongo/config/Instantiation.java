package com.michelefreitas.workshopmongo.config;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.michelefreitas.workshopmongo.domain.Post;
import com.michelefreitas.workshopmongo.domain.User;
import com.michelefreitas.workshopmongo.dto.AuthorDTO;
import com.michelefreitas.workshopmongo.repository.PostRepository;
import com.michelefreitas.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	//para fazer operação com o BD
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//chamando o userRepository que foi instanciado em cima para limpar a coleção do mongoDB
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		//null pois é o BD que vai gerar o id. Instanciando os usuários
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvar usuário para que ele tenham id próprio
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		//instanciando o post já associado com o autor dele
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		//lista com vários argumentos. Salvando todo mundo

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		//maria na lista de post dela eu vou adicionar post 1 e 2
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
	}
}
