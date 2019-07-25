package com.example.michelefreitas.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.michelefreitas.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")//padrão nome recurso plural
public class UserResource {
	//método que vai usar é get que serve para obter informações no padrão rest
	//outra forma é o @GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){//método retorna lista usuário. Busca todos. Acresc. o Response... ele retorna obj sofisticado(encapsula estrutura necessária retornar resposta http com possíveis cabeçalhos, erros... )
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));//adiciona objetos maria e alex na list 
		return ResponseEntity.ok().body(list);//ok vai instanciar Response... já com o cód http com sucesso. body é corpo da resposta
	}
}
