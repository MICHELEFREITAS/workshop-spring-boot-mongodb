package com.michelefreitas.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.michelefreitas.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	//consulta com query methods. Spring Dta monta a consulta com essa linha aí em baixo.
	//Buscar posts contendo um dados string no título. Método retorna lista de posts
	List<Post> findByTitleContainingIgnoreCase(String text);
	//PESQUISAR NO POSTMAN - GET -  http://localhost:8081/posts/titlesearch?text=bom%20dia
}
