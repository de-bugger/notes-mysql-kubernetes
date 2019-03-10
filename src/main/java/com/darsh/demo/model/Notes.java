package com.darsh.demo.model;

import javax.persistence.*;

@Entity
public class Notes {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "notesId", nullable = false, updatable = false)
	private Long notes_Id;
	
	@Column(name = "title", nullable = false)
	private String title;
	private String Content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", nullable=false, updatable=false)
	private User user;
	
	public Long getNotes_Id() {
		return notes_Id;
	}
	public void setNotes_Id(Long notes_Id) {
		this.notes_Id = notes_Id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Notes [notes_Id=" + notes_Id + ", title=" + title + ", Content=" + Content  + "]";
	}
	
	
	
	
}
