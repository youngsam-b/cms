package com.cms.app.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Article {

	@NotNull
	int id;
	@NotNull
	int categoryId;
	@NotNull	
	String title;
	@NotNull	
	String editor1;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date lastupdate;
    @NotNull
    int stat;
    @NotNull
    int userId;
    @NotNull
    String ip;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date schedule;
    
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEditor1() {
		return editor1;
	}
	public void setEditor1(String body) {
		this.editor1 = body;
	}
	public Date getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
    public Date getSchedule() {
		return schedule;
	}
	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
	
	public Article(){
		
	}
	
}
