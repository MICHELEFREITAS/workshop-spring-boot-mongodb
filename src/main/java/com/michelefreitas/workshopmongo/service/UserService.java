package com.michelefreitas.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelefreitas.workshopmongo.domain.User;
import com.michelefreitas.workshopmongo.repository.UserRepository;
import com.michelefreitas.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	//serviço acessa o repositório
	@Autowired  //instanciar automaticamente um obj aqui no serviço
	private UserRepository repo;  //mecanismo de injeção automática do spring
	
	//retornará todos usuários do banco
	public List<User> findAll(){
		return repo.findAll();  // vai no banco e retorna todos objetos desse tipo de usuario
	}
	
	//retornar um usuário
	public User findById(String id) {
		//se não existir o usuário do id passado, método retornará null
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
		
		
	}

}
