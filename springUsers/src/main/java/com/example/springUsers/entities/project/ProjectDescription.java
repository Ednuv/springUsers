package com.example.springUsers.entities.project;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="projectdescription")
public class ProjectDescription {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long pdId;
	
	private String title;
	
	@Column(length=1000)
	private String shortdescription;
	
	@Column(length=10000)
	private String description;
	
	
	private String cost;
	
	private String Author;
	
	
	private boolean active= true;
	
	private String projectLength;
	
	private String github;
	
	private String WhatsApp;
	
	private String requirements;
	
	private String level;
	
	private String relatedquiz;
	
	@Lob
	private byte[] projectpic;
	
	private String projectfor;
	
	private String relatedvideo;
	
	private boolean enrolled;
	
	private String projectpicname;
	
	
	
	@ManyToOne(fetch= FetchType.EAGER)
	private ProjectCategory category;
	

	public ProjectDescription() {
		
	}

	public long getqId() {
		return pdId;
	}

	public void setqId(long qId) {
		this.pdId = qId;
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


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ProjectCategory getCategory() {
		return category;
	}
	
	public void setCategory(ProjectCategory category) {
		this.category = category;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public long getPdId() {
		return pdId;
	}

	public void setPdId(long pdId) {
		this.pdId = pdId;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getProjectLength() {
		return projectLength;
	}

	public void setProjectLength(String projectLength) {
		this.projectLength = projectLength;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getWhatsApp() {
		return WhatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		WhatsApp = whatsApp;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRelatedquiz() {
		return relatedquiz;
	}

	public void setRelatedquiz(String relatedquiz) {
		this.relatedquiz = relatedquiz;
	}

	public byte[] getProjectpic() {
		return projectpic;
	}

	public void setProjectpic(byte[] projectpic) {
		this.projectpic = projectpic;
	}

	public String getProjectfor() {
		return projectfor;
	}

	public void setProjectfor(String projectfor) {
		this.projectfor = projectfor;
	}

	public String getRelatedvideo() {
		return relatedvideo;
	}

	public void setRelatedvideo(String relatedvideo) {
		this.relatedvideo = relatedvideo;
	}

	public boolean isEnrolled() {
		return enrolled;
	}

	public void setEnrolled(boolean enrolled) {
		this.enrolled = enrolled;
	}

	public String getProjectpicname() {
		return projectpicname;
	}

	public void setProjectpicname(String projectpicname) {
		this.projectpicname = projectpicname;
	}
	

	
	

}
