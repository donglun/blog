package com.blog.service.impl;

import java.util.Date;
import java.util.List;

import com.blog.beans.Comment;
import com.blog.dao.CommentDao;
import com.blog.service.CommentService;

public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
    private CommentDao commentDao;
    
	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> getCommentByBlogId(Integer blogId) {
		return commentDao.getAllCommentByBlog(blogId);
	}

	@Override
	public void reply(Integer fatherId, Integer blogId, Integer userId, String content) {
		Comment comment=new Comment();
		comment.setBlogId(blogId);
		comment.setContent(content);
		comment.setDate(new Date());
		comment.setFatherId(fatherId);
		comment.setHaveReply(false);
		comment.setUserId(userId);
		commentDao.saveComment(comment);

	}

	@Override
	public void setReply(Integer commentId) {
		Comment comment=commentDao.loadComment(commentId);
		comment.setHaveReply(true);
		update(comment);
	}

	@Override
	public void addComment(Integer blogId, Integer userId, String content) {
		Comment comment=new Comment();
		comment.setBlogId(blogId);
		comment.setUserId(userId);
		comment.setContent(content);
		comment.setDate(new Date());
		comment.setHaveReply(false);
		comment.setFatherId(0);
		save(comment);
		
	}

}
