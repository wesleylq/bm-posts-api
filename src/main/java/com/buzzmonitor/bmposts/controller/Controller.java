package com.buzzmonitor.bmposts.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buzzmonitor.bmposts.model.Post;
import com.buzzmonitor.bmposts.repository.Repository;

@RestController
public class Controller {
	
	@Autowired
	Repository repository;
	
	
	@GetMapping("/")
    public String hello(){
        return "Welcome!";
    }
	
	@PostMapping("/posts")
	public Post addPost(@RequestBody Post post){
		return repository.save(post);
	}
	
	@DeleteMapping("/posts/{post_id}")
	   public void deletePost(@PathVariable String post_id){
		  repository.deleteById(post_id);		 
	   }
	
	@GetMapping("/posts")
	public List<Post> getPosts(){
		 Iterator<Post> iterator= repository.findAll().iterator();
		 List<Post> posts = new ArrayList<Post>();
		 while(iterator.hasNext()){
			 posts.add(iterator.next());
		 }
		 return posts;
	}
		
	@GetMapping(value = "/posts/author/{author}")
	public List<Post> findByAuthorName(@PathVariable String author, @PageableDefault
			(value = Integer.MAX_VALUE, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return repository.findByAuthorName(author,pageable);
    }
	
	@GetMapping(value = "/posts/author/{author}/{origin}")
	public List<Post> findByAuthorName(@PathVariable String author ,@PathVariable String origin, @PageableDefault
			(value = Integer.MAX_VALUE, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return repository.findByAuthorNameAndOrigin(author, origin ,pageable);
    }
	
	@GetMapping(value = "/posts/origin/{origin}")
	public List<Post> findByOrigin(@PathVariable String origin, @PageableDefault
			(value = Integer.MAX_VALUE, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return repository.findByOrigin(origin ,pageable);
    }
	
	
	@GetMapping(value = "/posts/content/{content}")
	public List<Post> findByContent(@PathVariable String content, @PageableDefault
			(value = Integer.MAX_VALUE, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return repository.findByContent(content,pageable);
    }
	
	@GetMapping(value = "/posts/id/{post_id}")
	public Optional<Post> findById(@PathVariable String post_id) {
        return repository.findById(post_id);
    }
	
}
