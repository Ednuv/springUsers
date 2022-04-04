package com.example.springUsers.entities.blog;
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

@Entity
@Table(name="blog")
public class Blog {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long bId;
	
	private String title;
	
	private String subtitle;
	
	@Column(length=100000)
	private String introduction;
	
	@Column(length=100000)
	private String description;
	
	@Column(length=100000)
	private String conclusion;
	
	private String author;
	
	@Lob
	private byte[] projectpic;
	
	private String projectfor;
	
	private String relatedvideo;
	
	private String projectpicname;

	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public long getbId() {
		return bId;
	}

	public void setbId(long bId) {
		this.bId = bId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	


	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	public String getProjectpicname() {
		return projectpicname;
	}

	public void setProjectpicname(String projectpicname) {
		this.projectpicname = projectpicname;
	}
	
	
	
	
	
}
