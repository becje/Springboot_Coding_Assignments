package com.promineotech.socialMediaApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.socialMediaApi.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
	
}

