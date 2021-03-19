package com.promineotech.socialMediaApi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	private Long id;
	private String username;
	private String profilePictureUrl;
	
	@JsonIgnore
	private Set<User> following;
	private String password;
	
	@JsonIgnore
	private Set<Post> posts;
	
	@JsonIgnore
	private Set<Comment> comments;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getID() {
		return id;
	}
	
	public void setID(Long id) {
		this.id =id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	@OneToMany (mappedBy = "user")
	public Set<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "following",
			joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "followingId", referencedColumnName = "id"))
	public Set<User> getFollowing() {
		return following;
	}
	
	public void setFollowing(Set<User> following) {
		this.following = following;
	}
	
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}
	
	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}
}
