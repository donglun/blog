package com.blog.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.blog.beans.Comment;
import com.blog.beans.UserInfo;
import com.blog.service.CommentService;
import com.blog.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport {

	private CommentService commentService;
	private UserInfoService userInfoService;
	private Map<String, Object> jsonMap;
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
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
	public String getListComment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		jsonMap = new HashMap<String,Object>();
		Integer blogId = Integer.parseInt(request.getParameter("blogId"));
		List<Comment> commentlist = commentService.getCommentByBlogId(blogId);
		List<UserInfo> userInfolist = new ArrayList<UserInfo>();
		for(int i = 0;commentlist.size()<0;i++) {
			userInfolist.add(userInfoService.getUserInfoByUserId(commentlist.get(0).getBlogId()));	
		}
		return "jsonMap" ;
	}
	public String reply(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		Integer fatherId = Integer.parseInt(request.getParameter("fatherId"));
		Integer blogId = Integer.parseInt(request.getParameter("blogId"));
		String content = request.getParameter("content");
		commentService.reply(fatherId, blogId, userId, content); 
		commentService.setReply(fatherId); 
		return "jsonMap";
	}
	public void addComment(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		Integer blogId = Integer.parseInt(request.getParameter("blogId"));
		String content = request.getParameter("content");
		commentService.addComment(blogId, userId, content);
		
		
	}
	
}
