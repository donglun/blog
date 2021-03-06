package com.blog.service;

import com.blog.beans.User;

public interface UserService extends BaseService<User>{
	public Boolean loginCheck(String account,String password);
	public Boolean registerCheck(String account,String password);
	public Boolean loginCheck(String account);
	public Boolean existCheck(String account);
	public Integer loadUserId(String account);
}
