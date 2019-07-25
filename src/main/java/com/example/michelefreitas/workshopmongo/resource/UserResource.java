package com.example.michelefreitas.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.michelefreitas.workshopmongo.domain.User;
import com.example.michelefreitas.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")//padrão nome recurso plural
public class UserResource {
	
	//serviço que o controlador Rest acessa
	@Autowired
	private UserService service;
	
	//método que vai usar é get que serve para obter informações no padrão rest
	//outra forma é o @GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){//método retorna lista usuário. Busca todos. Acresc. o Response... ele retorna obj sofisticado(encapsula estrutura necessária retornar resposta http com possíveis cabeçalhos, erros... )
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);//ok vai instanciar Response... já com o cód http com sucesso. body é corpo da resposta
	}
}
