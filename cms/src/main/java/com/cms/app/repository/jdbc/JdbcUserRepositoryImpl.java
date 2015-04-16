package com.cms.app.repository.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.cms.app.model.User;
import com.cms.app.repository.UserMapper;
import com.cms.app.repository.UserRepository;

@Repository
public class JdbcUserRepositoryImpl implements UserRepository{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;	
    private SimpleJdbcInsert simpleJdbcInsert;
    
    @Autowired
    public JdbcUserRepositoryImpl(DataSource dataSource,NamedParameterJdbcTemplate namedParameterJdbcTemplate,SimpleJdbcInsert insertUser){
    	this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);    										
    	this.simpleJdbcInsert=new SimpleJdbcInsert(dataSource)
    	                    .withTableName("user")
    	                    .usingGeneratedKeyColumns("id")
    	                    .usingColumns("email"
    	                    			  ,"pwd"
    	                    			  ,"username"
    	                    			  ,"roleId"
    	                    			  ,"icon"
    	                    			  ,"activated"
    	                    			  ,"str"
    	                    			  ,"warn"
    	                    			  ,"banned");    	    	
    }
    
	@Override
	public int register(User user) {		
		 return simpleJdbcInsert.executeAndReturnKey(UserMapper.createUserParameterSource(user)).intValue() ;		
	}

	@Override
	public int update(User user) {
		String sql="UPDATE user SET icon=:icon WHERE id=:id";
		Map<String,Object> hmap = new HashMap<String,Object>();
		
		hmap.put("icon",user.getIcon());
		hmap.put("id",user.getId());
		
	    return namedParameterJdbcTemplate.update(sql, hmap);
	}

	@Override
	public User getUser(String email, String pwd) {

		try{
		String sql="SELECT * FROM user WHERE email=:email AND pwd=:pwd AND activated=true AND banned=false";
		Map<String,Object> hmap=new HashMap<String, Object>();
		hmap.put("email",email);
		hmap.put("pwd",pwd);
		return namedParameterJdbcTemplate.queryForObject(sql, hmap,new UserMapper());
		}catch(EmptyResultDataAccessException ex){
			return null;
			
		}
	}

	
	@Override
	public boolean isExist(String email) {
		String sql="SELECT count(*) FROM user WHERE email=:email";
		Map<String,Object> hmap=new HashMap<String, Object>();
		hmap.put("email", email);
		int a=namedParameterJdbcTemplate.queryForObject(sql, hmap, Integer.class);

		return a==0;
	}
	
	@Override
	public boolean activate(String email,String str){
		String sql="UPDATE user SET activated=true WHERE email=:email AND str=:str";
		Map<String,Object> hmap=new HashMap<String,Object>();
		hmap.put("email", email);
		hmap.put("str",str);
		return namedParameterJdbcTemplate.update(sql, hmap)==1;		
	}

	@Override
	public User getUserbyEmail(String email) {
		try{
			String sql="SELECT * FROM user WHERE email=:email";
			Map<String,Object> hmap=new HashMap<String, Object>();
			hmap.put("email",email);			
			return namedParameterJdbcTemplate.queryForObject(sql, hmap,new UserMapper());
			
			}catch(EmptyResultDataAccessException ex){
				return null;				
			}
	}

	@Override
	public User getUserbyId(int id) {
		try{
			String sql="SELECT * FROM user WHERE id=:id";
			Map<String,Object> hmap=new HashMap<String, Object>();
			hmap.put("id",id);			
			return namedParameterJdbcTemplate.queryForObject(sql, hmap,new UserMapper());
			
			}catch(EmptyResultDataAccessException ex){
				return null;				
			}
	}
	

}
