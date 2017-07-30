package com.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.components.ElseIf;

import com.blog.beans.Blog;
import com.blog.dao.BlogDao;
import com.blog.service.BlogService;

public class BlogServiceImpl extends BaseServiceImpl<Blog> implements BlogService {

	private BlogDao blogDao;
	
	public BlogDao getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public List showBlogByPage(Integer userId, Integer pageNum, Integer size) {
		return blogDao.queryBypage(userId, pageNum, size);
	}

	@Override
	public Integer getTotalPages(Integer userId, Integer size) {
		if(blogDao.getTotalNum(userId)==0){
			return 0;
		}
		return (blogDao.getTotalNum(userId)-1)/size+1;
	}

	@Override
	public void saveBlog(Integer userId, String text, String title) {
		Blog blog = new Blog();
		blog.setUserId(userId);;
		blog.setBlogText(text);
		blog.setBlogTitle(title);
		blog.setBlogDate(new Date());
		save(blog);
	}

	@Override
	public Integer getBlogId(Integer userId, String title) {
		return blogDao.getBlogIdByTitle(userId, title);
	}

	@Override
	public Integer getTotalId(Integer userId) {
		return blogDao.getTotalNum(userId);
	}

	@Override
	public List<Blog> getBlogTop10(Integer userId) {
		List<Blog> listBlog= new ArrayList<Blog>();
		List<Blog> blog=blogDao.getBlogByPv(userId);
		if(blog.size()>10)
		{
			for(int i=0;i<10;i++)
			{
				listBlog.add(blog.get(i));
			}
		}else{
				for(int i=0;i<blog.size();i++)
				{
				listBlog.add(blog.get(i));
				}
			 }
		return listBlog;
	}
	

}
