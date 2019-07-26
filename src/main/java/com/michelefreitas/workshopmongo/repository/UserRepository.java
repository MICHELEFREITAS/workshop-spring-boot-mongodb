package com.michelefreitas.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.michelefreitas.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
