package com.dihaitech.managercenter.controller.action.notice;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Notice;
import com.dihaitech.managercenter.service.INoticeService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 新闻公告Action
 * 
 * @author cg
 *
 * @date 2015-02-05
 */
 @SuppressWarnings("serial")
public class NoticeAction extends BaseAction {
	private Notice notice = new Notice();
	private INoticeService noticeService;
	
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public INoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	/* 
	 * 新闻公告查询
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

			Page pageInfo = noticeService.selectNotice(notice,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Notice> resultList = this.noticeService.selectNotice(notice,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","noticeAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Notice json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 新闻公告
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 新闻公告
	 * @return
	 */
	public String addSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		notice.setCreator(manager.getNickname());
		notice.setCreatetime(new Date());
		notice.setUpdator(manager.getNickname());
		notice.setUpdatetime(new Date());
		
		noticeService.addSave(notice);
		return "addSave";
	}
	
	/**
	 * 修改 新闻公告
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			notice.setId(id);
		}else{
			return null;
		}
		
		Notice noticeVO = noticeService.selectNoticeById(notice);
		this.getRequest().setAttribute("notice", noticeVO);
		return "edit";
	}
	
	/**
	 * 保存修改 新闻公告
	 * @return
	 */
	public String editSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		notice.setUpdator(manager.getNickname());
		notice.setUpdatetime(new Date());
		
		noticeService.editSave(notice);
		return "editSave";
	}
	
	/**
	 * 删除 新闻公告
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		noticeService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 新闻公告
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
			noticeService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}