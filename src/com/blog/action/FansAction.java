package com.blog.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.blog.beans.Fans;
import com.blog.beans.UserInfo;
import com.blog.common.Constant;
import com.blog.service.FansService;
import com.blog.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class FansAction extends ActionSupport {
	private FansService fansService;
	private UserInfoService userInfoService;
	private Map<String, Object> jsonMap;
	public FansService getFansService() {
		return fansService;
	}
	public void setFansService(FansService fansService) {
		this.fansService = fansService;
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
	public String getFans(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		jsonMap = new HashMap<String,Object>();
		Integer userId = (Integer)session.getAttribute("userId");
		Integer pageNum =Integer.parseInt(request.getParameter("pageNum"));
		List<Fans> fansList = fansService.getFansList(userId, pageNum, Constant.FANS_SIZE);
		List<UserInfo> fansInfo = new ArrayList<UserInfo>();
		List<Boolean> isNoticed = new ArrayList<Boolean>();
		Integer showSize = fansList.size();
		for(int i=0;i<showSize;i++){
			fansInfo.add(userInfoService.getUserInfoByUserId(fansList.get(i).getUserId()));
			isNoticed.add(fansService.exist(userId, fansList.get(0).getUserId()));	
		}
		jsonMap.put("fansInfo",fansInfo);
		jsonMap.put("isNoticed",isNoticed);
		jsonMap.put("fansList",fansList);
		jsonMap.put("showSize",showSize);
		
		return "jsonMap";
	}
	public String getNoticer(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		jsonMap = new HashMap<String,Object>();
		Integer userId = (Integer)session.getAttribute("userId");
		Integer pageNum =Integer.parseInt(request.getParameter("pageNum"));
		List<Fans> noticersList = fansService.getNoticerList(userId, pageNum, Constant.NOTICER_SIZE);
		List<UserInfo> noticersInfo = new ArrayList<UserInfo>();
		Integer showSize = noticersList.size();
		for(int i=0;i<showSize;i++){
			noticersInfo.add(userInfoService.getUserInfoByUserId(noticersList.get(i).getNoticerId()));	
		}
		jsonMap.put("noticersInfo",noticersInfo);
		jsonMap.put("noticersList",noticersList);
		jsonMap.put("showSize",showSize);
		
		return "jsonMap";
	}
	public String getNoticerTotalPages(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		jsonMap = new HashMap<String,Object>();
		Integer userId = (Integer)session.getAttribute("userId");
		Integer totalPages = fansService.getNoticerTotalPages(userId);
		System.out.println("totalpages"+totalPages);
		jsonMap.put("totalpages",totalPages);
		
		return "jsonMap";
	}
	public String getFansTotalPages(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		jsonMap = new HashMap<String,Object>();
		Integer userId = (Integer)session.getAttribute("userId");
		Integer totalPages = fansService.getFansTotalPages(userId);
		System.out.println("totalpages"+totalPages);
		jsonMap.put("totalpages",totalPages);
		
		return "jsonMap";
	}
	public void createNoticer(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		Integer fatherId = Integer.parseInt(request.getParameter("userId"));
		fansService.addFans(userId, fatherId); 	
	}
	public void deleteFans(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		Integer fansId=Integer.parseInt(request.getParameter("userId"));
		fansService.deleteFans(userId, fansId);
	}
}
