package com.example.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private int done_flg;
	private String time_limit;
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getDone_flg() {
		return done_flg;
	}
	
	public String getTime_limit() {
		return time_limit;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setDone_flg(int done_flg) {
		this.done_flg=done_flg;
	}
	
	public void setTime_limit(String time_limit) {
		this.time_limit=time_limit;
	}

}
