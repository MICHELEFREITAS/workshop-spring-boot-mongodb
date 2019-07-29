package com.michelefreitas.workshopmongo.service;

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
		return repo.findByTitleContainingIgnoreCase(text);		
	}
	
}
