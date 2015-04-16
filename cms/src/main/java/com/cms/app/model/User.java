package com.cms.app.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;



public class User{


	@NotNull	
	private int id;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Min(6)
	private String pwd;
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String username;
	@Range(min=0,max=9)
	private int roleId;		
	String icon;	
	private boolean activated=false;
	String str;	
	private int warn=0;
	private boolean banned=false;
	
	public User(){
	}
		
	public void setId(int id){
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean getActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getWarn() {
		return warn;
	}
	public void setWarn(int warn) {
		this.warn = warn;
	}
	public boolean getBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}	
}
