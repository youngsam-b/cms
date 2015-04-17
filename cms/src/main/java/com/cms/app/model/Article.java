package com.cms.app.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Article {

	@NotNull
	int id;
	@NotNull	
	String title;
	@NotNull	
	String body;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
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
