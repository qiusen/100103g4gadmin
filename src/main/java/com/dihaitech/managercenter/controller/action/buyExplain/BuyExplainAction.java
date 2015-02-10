package com.dihaitech.managercenter.controller.action.buyExplain;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.BuyExplain;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.service.IBuyExplainService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 购买说明Action
 * 
 * @author cg
 *
 * @date 2015-02-10
 */
 @SuppressWarnings("serial")
public class BuyExplainAction extends BaseAction {
	private BuyExplain buyExplain = new BuyExplain();
	private IBuyExplainService buyExplainService;
	
	private int edit;
	
	public BuyExplain getBuyExplain() {
		return buyExplain;
	}

	public void setBuyExplain(BuyExplain buyExplain) {
		this.buyExplain = buyExplain;
	}
	public IBuyExplainService getBuyExplainService() {
		return buyExplainService;
	}

	public void setBuyExplainService(IBuyExplainService buyExplainService) {
		this.buyExplainService = buyExplainService;
	}
	
	public int getEdit() {
		return edit;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

	/* 
	 * 购买说明查询
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

			Page pageInfo = buyExplainService.selectBuyExplain(buyExplain,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<BuyExplain> resultList = this.buyExplainService.selectBuyExplain(buyExplain,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","buyExplainAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("BuyExplain json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 购买说明
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 购买说明
	 * @return
	 */
	public String addSave(){
		buyExplainService.addSave(buyExplain);
		return "addSave";
	}
	
	/**
	 * 修改 购买说明
	 * @return
	 */
	public String execute(){
		buyExplain.setId(1);
		
		BuyExplain buyExplainVO = buyExplainService.selectBuyExplainById(buyExplain);
		this.getRequest().setAttribute("buyExplain", buyExplainVO);
		return SUCCESS;
	}
	
	/**
	 * 保存修改 购买说明
	 * @return
	 */
	public String editSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		buyExplain.setUpdator(manager.getNickname());
		buyExplain.setUpdatetime(new Date());
		
		int c = buyExplainService.editSave(buyExplain);
		if(c<=0){
			buyExplainService.addSave(buyExplain);
		}
		this.edit = 1;
		return "editSave";
	}
	
	/**
	 * 删除 购买说明
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		buyExplainService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 购买说明
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
			buyExplainService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}