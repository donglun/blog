package com.blog.beans;

import java.util.Date;


public class Fans  {

	private Integer id;
	private Integer userId;
	private Integer noticerId;
	private Date date;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNoticerId() {
		return this.noticerId;
	}

	public void setNoticerId(Integer noticerId) {
		this.noticerId = noticerId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
