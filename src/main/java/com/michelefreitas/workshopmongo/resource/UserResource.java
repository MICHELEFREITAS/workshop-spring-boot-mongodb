package com.michelefreitas.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.michelefreitas.workshopmongo.domain.User;
import com.michelefreitas.workshopmongo.dto.UserDTO;
import com.michelefreitas.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")//padrão nome recurso plural
public class UserResource {
	
	//serviço que o controlador Rest acessa
	@Autowired
	private UserService service;
	
	//método que vai usar é get que serve para obter informações no padrão rest
	//outra forma é o @GetMapping
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){//método retorna lista usuário. Busca todos. Acresc. o Response... ele retorna obj sofisticado(encapsula estrutura necessária retornar resposta http com possíveis cabeçalhos, erros... )
		List<User> list = service.findAll();//carrega lista usuário
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // converte cada um para DTO. stream transformar em coleção compatível. .map pega cada objeto x da lista original e para cada objeto x da lista orig..., para cada objeto desse q será um usuário
		return ResponseEntity.ok().body(listDto);//ok vai instanciar Response... já com o cód http com sucesso. body é corpo da resposta
	}
	

	//id tem que casar com id recebido no value da url colocar @PathVaria...
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	//implementação método insert
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		//convertendo Dto para user
		User obj = service.fromDTO(objDto);
		//chamando insert
		obj = service.insert(obj);
		
		//instanciar obj URI e faz chamada passando obj.geId como argumento. Pega end. do novo objeto inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//retorna resposta vazia com o cod 201(que é o cod resposta http), com o cabeçalho contendo a localização do novo recurso criado
		return ResponseEntity.created(uri).build();
		
	}
	
	
}
