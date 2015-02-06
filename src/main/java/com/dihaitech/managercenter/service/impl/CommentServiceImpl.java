package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.ICommentDAO;
import com.dihaitech.managercenter.model.Comment;
import com.dihaitech.managercenter.service.ICommentService;

/**
 * 留言 业务接口 ICommentService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-05
 */
public class CommentServiceImpl implements ICommentService {

	@Resource
	private ICommentDAO commentDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.ICommentService#addSave(com.dihaitech.managercenter.model.Comment)
	 */
	public int addSave(Comment comment) {
		return commentDAO.addSaveComment(comment);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.ICommentService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return commentDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.ICommentService#editSave(com.dihaitech.managercenter.model.Comment)
	 */
	public int editSave(Comment comment) {
		return commentDAO.editSaveComment(comment);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.ICommentService#selectAll()
	 */
	public List<Comment> selectAll() {
		return commentDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.ICommentService#selectComment(com.dihaitech.managercenter.model.Comment, int)
	 */
	public Page selectComment(Comment comment, int pageSize) {
		return new Page(commentDAO.getCommentCount(comment), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.ICommentService#selectComment(com.dihaitech.managercenter.model.Comment, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Comment> selectComment(Comment comment, Page page) {
		comment.setStart(page.getFirstItemPos());
		comment.setPageSize(page.getPageSize());
		return commentDAO.selectCommentLike(comment);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.ICommentService#selectCommentById(com.dihaitech.managercenter.model.Comment)
	 */
	public Comment selectCommentById(Comment comment) {
		return commentDAO.selectCommentById(comment);
	}
}
