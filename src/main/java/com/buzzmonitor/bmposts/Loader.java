package com.buzzmonitor.bmposts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.buzzmonitor.bmposts.model.Data;
import com.buzzmonitor.bmposts.repository.Repository;
import com.google.gson.Gson;


@Component
public class Loader {  
	
    @Autowired
    Repository repository;
    
    @PostConstruct
    @Transactional
    public void loadAll(){    	
    	//Remove this if you dont wanna set the database again
    	repository.deleteAll();
    	Gson gson = new Gson();
    	BufferedReader br = null;
    	try {
    	   br = new BufferedReader(new FileReader("posts-db.json"));
    	   Data result = gson.fromJson(br, Data.class);
    	   //Remove this if you dont wanna load the database again
    	   repository.saveAll(result.getData());    	
    	} catch (FileNotFoundException e) {
    	    e.printStackTrace();
    	  } finally {
    	    if (br != null) {
    	     try {
    	      br.close();
    	     } catch (IOException e) {    	      
    	      e.printStackTrace();
    	     }
    	  }
    	 } 	  	  	
    	
    }
    
}
