package com.dihaitech.managercenter.controller.action.scrollNotice;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.ScrollNotice;
import com.dihaitech.managercenter.service.IScrollNoticeService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 滚动公告Action
 * 
 * @author cg
 *
 * @date 2015-02-04
 */
 @SuppressWarnings("serial")
public class ScrollNoticeAction extends BaseAction {
	private ScrollNotice scrollNotice = new ScrollNotice();
	private IScrollNoticeService scrollNoticeService;
	
	private int edit = 0;
	
	public ScrollNotice getScrollNotice() {
		return scrollNotice;
	}

	public void setScrollNotice(ScrollNotice scrollNotice) {
		this.scrollNotice = scrollNotice;
	}
	public IScrollNoticeService getScrollNoticeService() {
		return scrollNoticeService;
	}

	public void setScrollNoticeService(IScrollNoticeService scrollNoticeService) {
		this.scrollNoticeService = scrollNoticeService;
	}
	
	public int getEdit() {
		return edit;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

	/* 
	 * 滚动公告查询
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute2(){
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

			Page pageInfo = scrollNoticeService.selectScrollNotice(scrollNotice,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<ScrollNotice> resultList = this.scrollNoticeService.selectScrollNotice(scrollNotice,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","scrollNoticeAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("ScrollNotice json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 滚动公告
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 滚动公告
	 * @return
	 */
	public String addSave(){
		scrollNoticeService.addSave(scrollNotice);
		return "addSave";
	}
	
	/**
	 * 修改 滚动公告
	 * @return
	 */
	public String execute(){
		scrollNotice.setId(1);
		
		ScrollNotice scrollNoticeVO = scrollNoticeService.selectScrollNoticeById(scrollNotice);
		this.getRequest().setAttribute("scrollNotice", scrollNoticeVO);
		return "edit";
	}
	
	/**
	 * 保存修改 滚动公告
	 * @return
	 */
	public String editSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");

		scrollNotice.setId(1);
		scrollNotice.setUpdator(manager.getNickname());
		scrollNotice.setUpdatetime(new Date());
		
		int c = scrollNoticeService.editSave(scrollNotice);
		if(c<=0){
			scrollNoticeService.addSave(scrollNotice);
		}
		this.edit=1;
		return "editSave";
	}
	
	/**
	 * 删除 滚动公告
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		scrollNoticeService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 滚动公告
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
			scrollNoticeService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}