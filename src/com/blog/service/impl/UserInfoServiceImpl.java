package com.blog.service.impl;

import java.util.Date;
import java.util.List;

import com.blog.beans.UserInfo;
import com.blog.common.Constant;
import com.blog.dao.UserInfoDao;
import com.blog.service.UserInfoService;

public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {
	private UserInfoDao userInfoDao;
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void saveUserInfo(Integer userId, String userName, Boolean sex, Date userBirthday, String userJob,
			String post, String userIntroduction, Integer userPlace, String userImage) {
		UserInfo userInfo=new UserInfo();
		userInfo.setUserId(userId);
		userInfo.setUserSex(sex);
		userInfo.setUserBirthday(userBirthday);
		if(userImage==null)userImage=Constant.DEFAULT_IMAGE_URL;//默认头像
		userInfo.setUserImage(userImage);
		userInfo.setUserIntroduction(userIntroduction);
		userInfo.setUserJob(userJob);
		userInfo.setUserName(userName);
		userInfo.setUserPost(post);
		userInfo.setUserPlace(userPlace);
		userInfoDao.saveUserInfo(userInfo);
		
	}

	@Override
	public void updateDetail(Integer userId, String userName, Boolean sex, Date userBirthday, String userJob,
			String post, String userIntroduction, Integer userPlace) {
		UserInfo userInfo=userInfoDao.loadUserInfoByUserId(userId);
		if(userName!=null&&userName!="")userInfo.setUserName(userName);
		if(sex!=null)userInfo.setUserSex(sex);
		if(userBirthday!=null)userInfo.setUserBirthday(userBirthday);
		if(userJob!=null&&userJob!="")userInfo.setUserJob(userJob);
		if(userIntroduction!=null&&userIntroduction!="")userInfo.setUserIntroduction(userIntroduction);
		userInfo.setUserPlace(userPlace);
		if(post!=null&post!="")userInfo.setUserPost(post);
		if(userInfo.getUserImage()==null)userInfo.setUserImage(Constant.DEFAULT_IMAGE_URL);
		userInfoDao.updateUserInfo(userInfo);
		
	}

	@Override
	public void updateUserImage(Integer userId, String userImageURL) {
		userInfoDao.updateImageURL(userId, userImageURL);
		
	}

	@Override
	public String loadUserNameById(Integer userId) {
		UserInfo userInfo=userInfoDao.loadUserInfoByUserId(userId);
		return userInfo.getUserName();
	}

	@Override
	public UserInfo getUserInfoByUserId(Integer userId) {
		return userInfoDao.loadUserInfoByUserId(userId);
	}

	@Override
	public Integer getUserIdRandomly(Integer userId) {
		List<UserInfo> userInfoList=userInfoDao.allOtherUserInfo(userId);
		int size = userInfoList.size();
		if(size!=0){
			int x = (int)(Math.random()*size);
			int id = userInfoList.get(x).getUserId();
			return id;
		}
		return 0;
	}

}
