package com.blog.beans;

import java.util.Date;


public class Blog {

	private Integer blogId;
	private String blogTitle;
	private String blogText;
	private Integer blogVisit;
	private Integer userId;
	private Date blogDate;
	private Integer blogPv;

	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogText() {
		return this.blogText;
	}

	public void setBlogText(String blogText) {
		this.blogText = blogText;
	}

	public Integer getBlogVisit() {
		return this.blogVisit;
	}

	public void setBlogVisit(Integer blogVisit) {
		this.blogVisit = blogVisit;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getBlogDate() {
		return this.blogDate;
	}

	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}

	public Integer getBlogPv() {
		return this.blogPv;
	}

	public void setBlogPv(Integer blogPv) {
		this.blogPv = blogPv;
	}

}
