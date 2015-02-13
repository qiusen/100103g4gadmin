package com.dihaitech.managercenter.controller.action.onlineOrder;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.OnlineOrder;
import com.dihaitech.managercenter.service.IOnlineOrderService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 在线订单Action
 * 
 * @author cg
 *
 * @date 2015-02-13
 */
 @SuppressWarnings("serial")
public class OnlineOrderAction extends BaseAction {
	private OnlineOrder onlineOrder = new OnlineOrder();
	private IOnlineOrderService onlineOrderService;
	
	public OnlineOrder getOnlineOrder() {
		return onlineOrder;
	}

	public void setOnlineOrder(OnlineOrder onlineOrder) {
		this.onlineOrder = onlineOrder;
	}
	public IOnlineOrderService getOnlineOrderService() {
		return onlineOrderService;
	}

	public void setOnlineOrderService(IOnlineOrderService onlineOrderService) {
		this.onlineOrderService = onlineOrderService;
	}
	/* 
	 * 在线订单查询
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

			Page pageInfo = onlineOrderService.selectOnlineOrder(onlineOrder,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<OnlineOrder> resultList = this.onlineOrderService.selectOnlineOrder(onlineOrder,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","onlineOrderAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("OnlineOrder json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 在线订单
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 在线订单
	 * @return
	 */
	public String addSave(){
		onlineOrderService.addSave(onlineOrder);
		return "addSave";
	}
	
	/**
	 * 修改 在线订单
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			onlineOrder.setId(id);
		}else{
			return null;
		}
		
		OnlineOrder onlineOrderVO = onlineOrderService.selectOnlineOrderById(onlineOrder);
		this.getRequest().setAttribute("onlineOrder", onlineOrderVO);
		return "edit";
	}
	
	/**
	 * 保存修改 在线订单
	 * @return
	 */
	public String editSave(){
		onlineOrder.setStatus(1);
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		onlineOrder.setDealor(manager.getNickname());
		onlineOrder.setDealtime(new Date());
		onlineOrderService.editSave(onlineOrder);
		return "editSave";
	}
	
	/**
	 * 删除 在线订单
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		onlineOrderService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 在线订单
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
			onlineOrderService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}