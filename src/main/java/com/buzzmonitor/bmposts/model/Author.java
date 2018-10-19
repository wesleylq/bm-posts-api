package com.buzzmonitor.bmposts.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "author", type = "default")
public class Author {
	@Id
	private String name;
	private Long followers;
	private Long friends;
	private String profile_image_url;

	public Author() {		
	}

	public Author(String name, Long followers, Long friends, String profile_image_url) {		
	
		this.profile_image_url = profile_image_url;
		this.name = name;
		this.followers = followers;
		this.friends = friends;		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFollowers() {
		return followers;
	}

	public void setFollowers(Long followers) {
		this.followers = followers;
	}

	public Long getFriends() {
		return friends;
	}

	public void setFriends(Long friends) {
		this.friends = friends;
	}

	public String getImage() {
		return profile_image_url;
	}

	public void setImage(String image) {
		this.profile_image_url = image;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", followers=" + followers + ", friends=" + friends + ", image=" + profile_image_url + "]";
	}	
	
	

	

}
