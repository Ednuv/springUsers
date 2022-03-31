package com.example.springUsers.entities.quiz;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="quizcategory")
public class Category {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long cid;
	
	private String title;
	
	@Column(length=5000)
	private String description;
	
	@OneToMany(mappedBy = "category", cascade= CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizzes = new LinkedHashSet<>();

	public Category() {

	}

	public Category(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
