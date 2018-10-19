package com.buzzmonitor.bmposts.model;

import java.util.ArrayList;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "data", type = "data")
public class Data {
	
	@Id		
	private List <Post> data = new ArrayList<Post>();

	public Data() {
		
	}

	public List<Post> getData() {
		return data;
	}

	public void setData(List<Post> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Data [data=" + data + "]";
	}
	
}
