package com.dihaitech.managercenter.controller.action.shopCoin;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Member;
import com.dihaitech.managercenter.model.ShopCoin;
import com.dihaitech.managercenter.service.IMemberService;
import com.dihaitech.managercenter.service.IShopCoinService;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 电商币结算Action
 * 
 * @author cg
 *
 * @date 2015-02-25
 */
 @SuppressWarnings("serial")
public class ShopCoinAction extends BaseAction {
	private ShopCoin shopCoin = new ShopCoin();
	private IShopCoinService shopCoinService;
	
	private IMemberService memberService;
	
	public ShopCoin getShopCoin() {
		return shopCoin;
	}

	public void setShopCoin(ShopCoin shopCoin) {
		this.shopCoin = shopCoin;
	}
	public IShopCoinService getShopCoinService() {
		return shopCoinService;
	}

	public void setShopCoinService(IShopCoinService shopCoinService) {
		this.shopCoinService = shopCoinService;
	}
	
	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}

	/* 
	 * 电商币结算查询
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

			Page pageInfo = shopCoinService.selectShopCoin(shopCoin,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<ShopCoin> resultList = this.shopCoinService.selectShopCoin(shopCoin,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","shopCoinAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("ShopCoin json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 电商币结算
	 * @return
	 */
	public String add(){
		String code = this.getRequest().getParameter("code");
		Member member = new Member();
		member.setCode(code);
		Member targetMember = memberService.selectMemberByCode(member);
		if(targetMember==null){
			return null;
		}
		this.getRequest().setAttribute("targetMember", targetMember);
		
		return "add";
	}
	
	/**
	 * 保存添加 电商币结算
	 * @return
	 */
	public String addSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		shopCoin.setDealor(manager.getNickname());
		shopCoin.setDealtime(new Date());
		
		
		shopCoinService.addSave(shopCoin);
		
		Member member = new Member();
		member.setCode(shopCoin.getCode());
		member.setIdStr(" SHOP_COIN = SHOP_COIN +" + shopCoin.getCoin());
		
		memberService.editCoin(member);
		
		return "addSave";
	}
	
	/**
	 * 修改 电商币结算
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			shopCoin.setId(id);
		}else{
			return null;
		}
		
		ShopCoin shopCoinVO = shopCoinService.selectShopCoinById(shopCoin);
		this.getRequest().setAttribute("shopCoin", shopCoinVO);
		return "edit";
	}
	
	/**
	 * 保存修改 电商币结算
	 * @return
	 */
	public String editSave(){
		shopCoinService.editSave(shopCoin);
		return "editSave";
	}
	
	/**
	 * 删除 电商币结算
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		shopCoinService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 电商币结算
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
			shopCoinService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}