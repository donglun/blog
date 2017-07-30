package com.blog.service.impl;


import com.blog.beans.User;
import com.blog.dao.UserDao;
import com.blog.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements UserService  {
	private UserDao userDao;
	

	public UserDao getUserdao() {
		return userDao;
	}

	public void setUserdao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Boolean loginCheck(String account, String password) {
        User user=userDao.loadByAccount(account);
        if(user !=null &&user.getuserPassword().equals(password))
        {
        	return true;
        }
		return false;
	}

	@Override
	public Boolean registerCheck(String account, String password) {
		User user=userDao.loadByAccount(account);
		if(user == null){
			return true;
		}
		return false;
}

	@Override
	public Boolean loginCheck(String account) {
		User user=userDao.loadByAccount(account);
		if(user == null){
			return false;
		}
		return true;
	}

	@Override
	public Boolean existCheck(String account) {
		User user=userDao.loadByAccount(account);
		if(user == null){
			return true;
		}
		return false;
	}

	@Override
	public Integer loadUserId(String account) {
		User user=userDao.loadByAccount(account);
		return user.getuserId();
	}

}
