package com.blog.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.blog.beans.UserInfo;
import com.blog.common.Constant;
import com.blog.service.UserInfoService;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {
	private UserService userService;
	private UserInfoService userInfoService;
	private Map<String,Object> jsonMap = null;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}
	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	public String login() throws Exception{
		HttpServletRequest requset = ServletActionContext.getRequest();
		HttpSession session = requset.getSession();
		String account = requset.getParameter("account");
		String password = requset.getParameter("password");
		System.out.println("login"+account+" "+password);
		if (userService.loginCheck(account, password)==true) {
			Integer userId = userService.loadUserId(account);
			session.setAttribute("userId", userId);
			UserInfo userInfo = userInfoService.getUserInfoByUserId(userId);
			userInfo.setUserRecentLoginTime(new Date());
			userInfoService.update(userInfo);
			return Constant.SUCCESS;	
		}else {
			return Constant.FAIL;
		}	
	}
	public String passwordCheck(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
	    Boolean result = userService.loginCheck(account, password);
	    jsonMap = new HashMap<String, Object>();
	    jsonMap.put("valid", result);
	    return "jsonMap";    
	}
	

}
