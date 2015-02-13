package com.dihaitech.managercenter.controller.action.deposit;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Deposit;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Member;
import com.dihaitech.managercenter.service.IDepositService;
import com.dihaitech.managercenter.service.IMemberService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 充值Action
 * 
 * @author cg
 *
 * @date 2015-02-13
 */
 @SuppressWarnings("serial")
public class DepositAction extends BaseAction {
	private Deposit deposit = new Deposit();
	private IDepositService depositService;
	
	private IMemberService memberService;
	
	public Deposit getDeposit() {
		return deposit;
	}

	public void setDeposit(Deposit deposit) {
		this.deposit = deposit;
	}
	public IDepositService getDepositService() {
		return depositService;
	}

	public void setDepositService(IDepositService depositService) {
		this.depositService = depositService;
	}
	
	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	/* 
	 * 充值查询
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

			Page pageInfo = depositService.selectDeposit(deposit,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Deposit> resultList = this.depositService.selectDeposit(deposit,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","depositAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Deposit json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 充值
	 * @return
	 */
	public String add(){
		String code = this.getRequest().getParameter("code");
		this.getRequest().setAttribute("code", code);
		return "add";
	}
	
	/**
	 * 保存添加 充值
	 * @return
	 */
	public String addSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		deposit.setDealor(manager.getNickname());
		deposit.setDealtime(new Date());
		depositService.addSave(deposit);
		
		//给会员字段加值
		Member member = new Member();
		member.setCode(deposit.getCode());
		member.setIdStr(" TAX_COIN = TAX_COIN +" + deposit.getTaxCoin());
		memberService.editCoin(member);
		return "addSave";
	}
	
}