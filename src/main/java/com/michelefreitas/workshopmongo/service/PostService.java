package com.michelefreitas.workshopmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelefreitas.workshopmongo.domain.Post;
import com.michelefreitas.workshopmongo.repository.PostRepository;
import com.michelefreitas.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	//método retornar um Post
	public Post findById(String id) {
		//se não existir o usuário do id passado, método retornará null
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	//método de busca com nome findByTitle. Retorna lista de posts 
	public List<Post> findByTitle(String text){
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);// vem lá do mongo do método no PostRepository
	}
	
	//método de consulta
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//acrescentar 1 dia na data	pq ela vai ser gerado no dia informado pelo usuário só que a meia noite.
		// os posts tem que ser até 24 horas daquele dia
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return repo.fullSearch(text, minDate, maxDate);		
	}	
}
