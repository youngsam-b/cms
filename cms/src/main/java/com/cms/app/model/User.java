package com.cms.app.model;



public class User{


	int id;
	String email;
	String pwd;
	int roleId;	
	String icon;
	boolean activated=false;
	String str;	
	int warn=0;
	boolean banned=false;
	
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
