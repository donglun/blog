package com.blog.beans;

import java.util.Date;


public class UserInfo  {

	private Integer userinfoId;
	private Integer userId;
	private String userName;
	private Boolean userSex;
	private Date userBirthday;
	private String userJob;
	private String userPost;
	private String userIntroduction;
	private Integer userPlace;
	private String userImage;
	private Date userRecentLoginTime;
	private Integer userPv;

	public Integer getUserinfoId() {
		return this.userinfoId;
	}

	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Boolean userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserJob() {
		return this.userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getUserPost() {
		return this.userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserIntroduction() {
		return this.userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	public Integer getUserPlace() {
		return this.userPlace;
	}

	public void setUserPlace(Integer userPlace) {
		this.userPlace = userPlace;
	}

	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Date getUserRecentLoginTime() {
		return this.userRecentLoginTime;
	}

	public void setUserRecentLoginTime(Date userRecentLoginTime) {
		this.userRecentLoginTime = userRecentLoginTime;
	}

	public Integer getUserPv() {
		return this.userPv;
	}

	public void setUserPv(Integer userPv) {
		this.userPv = userPv;
	}

}
