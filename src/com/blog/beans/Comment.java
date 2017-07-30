package com.blog.beans;


import java.util.Date;

public class Comment {

	private Integer id;
	private int fatherId;
	private int blogId;
	private int userId;
	private String content;
	private Date date;
	private boolean haveReply;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}

	public int getBlogId() {
		return this.blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isHaveReply() {
		return this.haveReply;
	}

	public void setHaveReply(boolean haveReply) {
		this.haveReply = haveReply;
	}

}
