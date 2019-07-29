package com.michelefreitas.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.michelefreitas.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	//Método personalizado com nome searchTitle
	//mongoDB. "?0" é o primeiro parametro que vem no método. No caso o String text. o options "i" ignorar maiúsculas e minúsc.
	@Query("{'title': { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	//consulta com query methods. Spring Dta monta a consulta com essa linha aí em baixo.
	//Buscar posts contendo um dados string no título. Método retorna lista de posts
	List<Post> findByTitleContainingIgnoreCase(String text);
	//PESQUISAR NO POSTMAN - GET -  http://localhost:8081/posts/titlesearch?text=bom%20dia
	
	
}
