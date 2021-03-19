package com.promineotech.socialMediaApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.socialMediaApi.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
	
}
