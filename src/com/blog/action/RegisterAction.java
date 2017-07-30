package com.blog.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.blog.beans.User;
import com.blog.beans.UserInfo;
import com.blog.common.Constant;
import com.blog.service.UserInfoService;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private UserService userService;
	private UserInfoService userInfoService;
	private Map<String, Object> jsonMap = null;
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
	public String existCheck(){
		HttpServletRequest request = ServletActionContext.getRequest();
		jsonMap = new HashMap<String,Object>();
		String account = request.getParameter("account");
		Boolean isExist = userService.existCheck(account);
		jsonMap.put("valid",isExist);
		return "jsonMap";
	}
	public String loadCheck(){
		HttpServletRequest request = ServletActionContext.getRequest();
		jsonMap = new HashMap<String,Object>();
		String account = request.getParameter("account");
		Boolean isExist = userService.loginCheck(account);
		jsonMap.put("valid", isExist);
		return "jsonMap"; 
	}
	public String creat() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if (userService.registerCheck(account, password) == true) {
			User user = new User();
			user.setuserAccount(account);
			user.setuserPassword(password);
			userService.save(user);
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(username);
			Integer userId = userService.loadUserId(account);
			userInfo.setUserId(userId);
			userInfo.setUserPv(0);
			userInfoService.save(userInfo);
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			userInfo = userInfoService.getUserInfoByUserId(userId);
			userInfoService.update(userInfo); 
			userInfo.setUserRecentLoginTime(new Date());
			return Constant.SUCCESS;	
		}else {
			return Constant.FAIL;
		}
	}
}
