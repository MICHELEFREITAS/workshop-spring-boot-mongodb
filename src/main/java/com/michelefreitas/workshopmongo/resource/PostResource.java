package com.michelefreitas.workshopmongo.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michelefreitas.workshopmongo.domain.Post;
import com.michelefreitas.workshopmongo.resource.util.URL;
import com.michelefreitas.workshopmongo.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	//busca por id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//endpoint para fazer a busca
	//@RequestParam pq o critério de parametro lá do Postman será com "?"
	//defaultValue se o value não for informado será colocado String vazia ""
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue ="") String text){
		//decodifica o texto
		text = URL.decodeParam(text);
		//Pronto no serviço só chamar aqui
		List<Post> list = service.findByTitle(text);
		//retornar resposta cujo o corpo é essa lista
		return ResponseEntity.ok().body(list);
	}
	
	//implmentação do endpoint
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue ="") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate){
		text = URL.decodeParam(text);//decodificando texto
		Date min = URL.convertDate(minDate, new Date(0L));//tratar data mínima, se der problema, gerar data mínima do sistema
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}

}
