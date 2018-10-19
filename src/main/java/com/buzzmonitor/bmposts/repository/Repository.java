package com.buzzmonitor.bmposts.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.buzzmonitor.bmposts.model.Post;



public interface Repository extends ElasticsearchRepository<Post, String>{
	
	public List<Post> findByAuthorName(String author, Pageable pageable);

	public List<Post> findByAuthorNameAndOrigin(String author, String origin, Pageable pageable);

}