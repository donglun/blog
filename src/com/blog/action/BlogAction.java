package com.blog.action;

import java.util.Map;

import com.blog.service.BlogService;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport {
	private BlogService blogService;
	private Map<String,Object> jsonMap;
	
	public BlogService getBlogService() {
		return blogService;
	}

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}
	
	

}
