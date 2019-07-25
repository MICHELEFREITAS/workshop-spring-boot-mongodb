package com.example.michelefreitas.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.michelefreitas.workshopmongo.domain.User;
import com.example.michelefreitas.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	//serviço acessa o repositório
	@Autowired  //instanciar automaticamente um obj aqui no serviço
	private UserRepository repo;  //mecanismo de injeção automática do spring
	
	//retornará todos usuários do banco
	public List<User> findAll(){
		return repo.findAll();  // vai no banco e retorna todos objetos desse tipo de usuario
	}

}
