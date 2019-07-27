package com.michelefreitas.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.michelefreitas.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
