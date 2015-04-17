package com.cms.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import com.cms.app.model.User;

public class UserRowMapper implements RowMapper<User>  {

	 public  static MapSqlParameterSource createUserParameterSource(User user) {
	        return new MapSqlParameterSource()
  				        .addValue("email",user.getEmail())
	        		    .addValue("pwd",user.getPwd())
	        		    .addValue("username",user.getUsername())
	        		    .addValue("roleId",user.getRoleId())
	        		    .addValue("icon",user.getIcon())
	        		    .addValue("activated",user.getActivated())
	        		    .addValue("str",user.getStr())
	        		    .addValue("warn",user.getWarn())
	        		    .addValue("banned",user.getBanned());

	    }

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {					
		   User user = new User();
		   user.setId(rs.getInt("id"));	    	
		   user.setEmail(rs.getString("email"));
		   user.setPwd(rs.getString("pwd"));
		   user.setUsername(rs.getString("username"));
		   user.setRoleId(rs.getInt("roleId"));
		   user.setIcon(rs.getString("icon"));
		   user.setActivated(rs.getBoolean("activated"));
		   user.setStr(rs.getString("str"));
		   user.setWarn(rs.getInt("warn"));
		   user.setBanned(rs.getBoolean("banned"));
		   
		   return user;
	}	     
}
