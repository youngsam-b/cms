package com.cms.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cms.app.exception.CustomException;
import com.cms.app.model.User;
import com.cms.app.util.EmailUtil;
import com.cms.app.util.CommonUtil;
import com.cms.web.service.CmsService;


@Controller
public class UserController {

	@Autowired
	CmsService cmsService;	
	@Autowired
	EmailUtil emailUtil;
		
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getRegister(@ModelAttribute User user,
									ModelAndView mav)  {
		mav.addObject("random",RandomStringUtils.randomAlphanumeric(10));
		mav.setViewName("reigster");
		return mav;
	}
		
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String activate(@RequestParam("email") String email,
						   @RequestParam("str") String str
			               ) throws CustomException {
		
								
		if(cmsService.activate(email,str))
			return "activate";
		else
			throw new CustomException(null,new CustomException());		
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public String success(@ModelAttribute User user) {
		try{			
			//emailUtil.send(user.getEmail(), user.getStr());		
			}catch(RuntimeException ex){
				throw new CustomException(user,ex);
			}		
		return "success";
	}
	
	@RequestMapping(value = {"/isExist"}, method = RequestMethod.POST)
	public
	@ResponseBody
	boolean	isExist(@RequestParam("email") String email){	
		return cmsService.isExist(email);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute User user, 
			               BindingResult result
			) {
		
		if(result.hasErrors())
			return "register";
		
		
		user.setStr(RandomStringUtils.randomAlphabetic(10));
		try{
		cmsService.register(user);		
		}catch(RuntimeException ex){
			throw new CustomException(user,ex);
		}		
		
		return "success";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView getUpdate(HttpServletRequest req,ModelAndView mav,BindingResult result) {				

		try{
		User user=(User)req.getSession().getAttribute("user");
		user=cmsService.getUserbyId(user.getId());
		mav.addObject(user);
		if(result.hasErrors())
			mav.setViewName("update");
		else
			mav.setViewName("signin");
		
		return mav;
		}catch(RuntimeException ex){
			throw new CustomException(null,ex);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute User user,HttpServletRequest req) {
		
		try{
		int id=((User)req.getSession().getAttribute("user")).getId();
		user.setId(id);
		cmsService.update(user);		
		
		}catch(RuntimeException ex){
			throw new CustomException(user,ex);
		}		
		
		return "update";
	}
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String getSignin() throws CustomException {
		return "signin";
	}

    @RequestMapping(value = "/signin", method = {RequestMethod.POST} )
    public String signin(
    							@RequestParam(value="email",required=true) String email,
    							@RequestParam(value="pwd",required=true) String pwd,
    							@RequestParam(value="rememberme",required=false) Boolean rememberme,
    							HttpSession session,
    							HttpServletRequest request,
    							HttpServletResponse response		
    							
    		)  {
    	
    	
    	String returnUrl="";
    	try{
        User user = cmsService.signIn(email,pwd);

    	if(user!=null)
    		session.setAttribute("user", user);    		
    	else
    		return "redirect:signin?auth=fail";
  		
    	
		if(rememberme!=null&&rememberme==true)
			CommonUtil.setRemeberMeCookie(request, response, user);
		
		
		returnUrl = CommonUtil.redirectProcess(request.getHeader("referer"));
    	}catch(RuntimeException ex){
    		throw new CustomException(null,ex);
    	}
		
		return returnUrl;													
    }

    @RequestMapping(value = "/rememberme", method = RequestMethod.POST)
    public String rememberme(HttpServletRequest request	    		
    		)
    {
    	  String[] decryptedMessage=CommonUtil.getRememberMeCookie(request);


    	  StringBuilder sb=new StringBuilder();
    	  sb.append("email=").append(decryptedMessage[0]).append("&")
    	     .append("pwd=").append(decryptedMessage[1]).append("&")
    	     .append("rememberme=").append(true);
    	  
    	  return "forward:/signin?"+sb.toString();
    }
    
	@RequestMapping(value = "/signout", method = RequestMethod.GET)		
	public String signout(HttpSession session,
						 HttpServletRequest request,
						 HttpServletResponse response							 
			){				
		
	session.invalidate();
    CommonUtil.DeleteCookie(request, response);
	
	return "/";
	}    
			
	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public String getForget() throws CustomException {
		return "forget";
	}

    @RequestMapping(value = "/forget", method = {RequestMethod.POST} )
    public String forget(@RequestParam(value="email") String email,ModelAndView mav)  {    	
    	
    	try{
    		User u=cmsService.getUserbyEmail(email);
    		
    		if(u==null)
    			return "redirect:/forget?auth=fail";
    		//else
    		//emailUtil.sendPwd(u.getEmail(),u.getPwd());
    		
    	}catch(RuntimeException ex){
    		throw new CustomException(null,ex);
    	}
		
    	return "forgetSuccess"; 													
    }

}
