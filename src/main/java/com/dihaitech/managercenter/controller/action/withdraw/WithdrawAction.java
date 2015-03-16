package com.dihaitech.managercenter.controller.action.withdraw;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Member;
import com.dihaitech.managercenter.model.Withdraw;
import com.dihaitech.managercenter.service.IMemberService;
import com.dihaitech.managercenter.service.IWithdrawService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 提现Action
 * 
 * @author cg
 *
 * @date 2015-02-16
 */
 @SuppressWarnings("serial")
public class WithdrawAction extends BaseAction {
	private Withdraw withdraw = new Withdraw();
	private IWithdrawService withdrawService;
	
	private IMemberService memberService;
	
	public Withdraw getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Withdraw withdraw) {
		this.withdraw = withdraw;
	}
	public IWithdrawService getWithdrawService() {
		return withdrawService;
	}

	public void setWithdrawService(IWithdrawService withdrawService) {
		this.withdrawService = withdrawService;
	}
	
	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	/* 
	 * 提现查询
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

			Page pageInfo = withdrawService.selectWithdraw(withdraw,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Withdraw> resultList = this.withdrawService.selectWithdraw(withdraw,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","withdrawAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Withdraw json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	/**
	 * 修改 提现
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			withdraw.setId(id);
		}else{
			return null;
		}
		
		Withdraw withdrawVO = withdrawService.selectWithdrawById(withdraw);
		this.getRequest().setAttribute("withdraw", withdrawVO);
		return "edit";
	}
	
	/**
	 * 保存修改 提现
	 * @return
	 */
	public String editSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		withdraw.setDealor(manager.getNickname());
		withdraw.setStatus(1);
		withdraw.setDealtime(new Date());
		withdrawService.editSave(withdraw);
		
		//扣除用户现金
		Member member = new Member();
		member.setCode(withdraw.getCode());
		member.setIdStr(" CASH_COIN = CASH_COIN -" + withdraw.getCoin());
		
		memberService.editCoin(member);
		
		return "editSave";
	}
	

}