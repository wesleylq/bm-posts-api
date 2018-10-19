package com.buzzmonitor.bmposts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "post", type = "default")
public class Post {
	@Id	
	private String post_id;
	private String content;
	private Author author;
	@Field(type = FieldType.Text, fielddata = true)
	private String date;
	private String origin;
	private String type;
	
	
	public Post() {			
	}

	public Post(String post_id, String content, Author author, String date, String origin, String type) {		
		this.post_id = post_id;
		this.content = content;
		this.author = author;
		this.date = date;
		this.origin = origin;
		this.type = type;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", content=" + content + ", author=" + author + ", date=" + date
				+ ", origin=" + origin + ", type=" + type + "]";
	}
	
}
