package com.dihaitech.managercenter.controller.action.bonus;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Bonus;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Member;
import com.dihaitech.managercenter.service.IBonusService;
import com.dihaitech.managercenter.service.IMemberService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 奖金Action
 * 
 * @author cg
 *
 * @date 2015-02-15
 */
 @SuppressWarnings("serial")
public class BonusAction extends BaseAction {
	private Bonus bonus = new Bonus();
	private IBonusService bonusService;
	
	private IMemberService memberService;
	
	public Bonus getBonus() {
		return bonus;
	}

	public void setBonus(Bonus bonus) {
		this.bonus = bonus;
	}
	public IBonusService getBonusService() {
		return bonusService;
	}

	public void setBonusService(IBonusService bonusService) {
		this.bonusService = bonusService;
	}
	
	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	/* 
	 * 奖金查询
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

			Page pageInfo = bonusService.selectBonus(bonus,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Bonus> resultList = this.bonusService.selectBonus(bonus,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","bonusAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Bonus json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 奖金
	 * @return
	 */
	public String add(){
		String code = this.getRequest().getParameter("code");
		this.getRequest().setAttribute("code", code);
		
		return "add";
	}
	
	/**
	 * 保存添加 奖金
	 * @return
	 */
	public String addSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		bonus.setDealor(manager.getNickname());
		bonus.setDealtime(new Date());
		
//		double realGive = bonus.getServSubsidy() + bonus.getMediaPub() 
//							+ bonus.getEduTrain() + bonus.getAdServ() 
//							+ bonus.getOrgaLead() + bonus.getAllowance() 
//							+ bonus.getMaintain() + bonus.getHelpEach() 
//							+ bonus.getLoveHeart() + bonus.getTax();
//		bonus.setRealGive(realGive);
		
		bonusService.addSave(bonus);
		
		Member member = new Member();
		member.setCode(bonus.getCode());
		member.setIdStr(" CASH_COIN = CASH_COIN +" + bonus.getRealGive());
		
		memberService.editCoin(member);
		return "addSave";
	}
	
	/**
	 * 修改 奖金
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			bonus.setId(id);
		}else{
			return null;
		}
		
		Bonus bonusVO = bonusService.selectBonusById(bonus);
		this.getRequest().setAttribute("bonus", bonusVO);
		return "edit";
	}
	
	/**
	 * 保存修改 奖金
	 * @return
	 */
	public String editSave(){
		bonusService.editSave(bonus);
		return "editSave";
	}
	
	/**
	 * 删除 奖金
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		bonusService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 奖金
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
			bonusService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}