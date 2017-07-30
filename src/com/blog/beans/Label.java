package com.blog.beans;
// default package
// Generated 2017-7-21 23:35:03 by Hibernate Tools 5.2.3.Final

/**
 * Label generated by hbm2java
 */
public class Label implements java.io.Serializable {

	private Integer labelId;
	private String labelTitle;
	private int userId;

	public Label() {
	}

	public Label(String labelTitle, int userId) {
		this.labelTitle = labelTitle;
		this.userId = userId;
	}

	public Integer getLabelId() {
		return this.labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public String getLabelTitle() {
		return this.labelTitle;
	}

	public void setLabelTitle(String labelTitle) {
		this.labelTitle = labelTitle;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}