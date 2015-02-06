package com.dihaitech.managercenter.controller.action.comment;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Comment;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.service.ICommentService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 留言Action
 * 
 * @author cg
 *
 * @date 2015-02-05
 */
 @SuppressWarnings("serial")
public class CommentAction extends BaseAction {
	private Comment comment = new Comment();
	private ICommentService commentService;
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}
	/* 
	 * 留言查询
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		try {
			String pageSizeStr = this.getRequest().getParameter("pageSize");
			String pageNoStr = this.getRequest().getParameter("pageNo");
			int pageSize = 0;
			int pageNo = 0;
			
			pageSize = TypeUtil.stringToInt(pageSizeStr);
			if (pageSize <= 0) {
				pageSize = Property.PAGESIZE;
			}

			pageNo = TypeUtil.stringToInt(pageNoStr);
			if (pageSize > 0) {
				this.setManagerPageSize(pageSize);
			}else{
				this.setManagerPageSize(Property.PAGESIZE);
			}

			Page pageInfo = commentService.selectComment(comment,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Comment> resultList = this.commentService.selectComment(comment,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","commentAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Comment json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 留言
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 留言
	 * @return
	 */
	public String addSave(){
		commentService.addSave(comment);
		return "addSave";
	}
	
	/**
	 * 修改 留言
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			comment.setId(id);
		}else{
			return null;
		}
		
		Comment commentVO = commentService.selectCommentById(comment);
		this.getRequest().setAttribute("comment", commentVO);
		return "edit";
	}
	
	/**
	 * 保存修改 留言
	 * @return
	 */
	public String editSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		comment.setRevetor(manager.getNickname());
		comment.setRevettime(new Date());
		
		commentService.editSave(comment);
		return "editSave";
	}
	
	/**
	 * 删除 留言
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		commentService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 留言
	 * @return
	 */
	public String deleteByIds(){
		String[] ids = this.getRequest().getParameterValues("id");
		StringBuffer strbuf = new StringBuffer(" where id in(");
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				if (i != 0) {
					strbuf.append("," + ids[i]);
				} else {
					strbuf.append(ids[i]);
				}
			}
			strbuf.append(")");
			commentService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}