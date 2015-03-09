package com.dihaitech.managercenter.controller.action.member;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Member;
import com.dihaitech.managercenter.service.IMemberService;
import com.dihaitech.managercenter.util.MD5Util;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;

/**
 * 会员Action
 * 
 * @author cg
 *
 * @date 2015-02-05
 */
 @SuppressWarnings("serial")
public class MemberAction extends BaseAction {
	private Member member = new Member();
	private IMemberService memberService;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	public IMemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}
	/* 
	 * 会员查询
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

			Page pageInfo = memberService.selectMember(member,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Member> resultList = this.memberService.selectMember(member,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","memberAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Member json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 会员
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 会员
	 * @return
	 */
	public String addSave(){
		memberService.addSave(member);
		return "addSave";
	}
	
	/**
	 * 修改 会员
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			member.setId(id);
		}else{
			return null;
		}
		
		Member memberVO = memberService.selectMemberById(member);
		this.getRequest().setAttribute("member", memberVO);
		return "edit";
	}
	
	/**
	 * 保存修改 会员
	 * @return
	 */
	public String editSave(){
		String passwd1 = this.getRequest().getParameter("passwd1");
		String passwd2 = this.getRequest().getParameter("passwd2");
		String passwd3 = this.getRequest().getParameter("passwd3");
		
		if(passwd1!=null && passwd1.trim().length()>0){
			member.setPasswd1(MD5Util.stringToMD5(passwd1));
		}
		if(passwd2!=null && passwd2.trim().length()>0){
			member.setPasswd2(MD5Util.stringToMD5(passwd2));
		}
		if(passwd3!=null && passwd3.trim().length()>0){
			member.setPasswd3(MD5Util.stringToMD5(passwd3));
		}
		
		
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		member.setUpdator(manager.getNickname());
		member.setUpdatetime(new Date());
		
		//防止进入死循环
		if(member.getCode().equalsIgnoreCase(member.getManagerCode())){
			member.setManagerCode("-");
		}
		
		int check = TypeUtil.stringToInt(this.getRequest().getParameter("check"));
		if(check==1){
			member.setExator(manager.getNickname());
			member.setExatetime(new Date());
			memberService.editSaveAndCheck(member);
			
			Member memberTemp = new Member();
			memberTemp.setCode(member.getManagerCode());
			
			if(member.getArea().equals("A")){	//管理人A区人数 +1
				memberTemp.setIdStr(" AC= AC +1 ");
			}
			if(member.getArea().equals("B")){	//管理人B区人数 +1
				memberTemp.setIdStr(" BC= BC +1 ");
			}
			
			editAllManagerABCount(memberTemp);
			
		}else{
			memberService.editSave(member);
		}
		
		
		return "editSave";
	}
	
	/**
	 * 递规所有上层管理人区域人数+1
	 * @param member
	 */
	private void editAllManagerABCount(Member member){
		
		
		
		memberService.editABCount(member);
		
		Member memberVO = memberService.selectMemberByCode(member);
		
		member.setCode(memberVO.getManagerCode());
		Member managerMember = memberService.selectMemberByCode(member);
		
		if(managerMember!=null){
			managerMember.setIdStr(member.getIdStr());
			if(memberVO.getArea().equals("A")){	//管理人A区人数 +1
				managerMember.setIdStr(" AC= AC +1 ");
			}
			if(memberVO.getArea().equals("B")){	//管理人B区人数 +1
				managerMember.setIdStr(" BC= BC +1 ");
			}
			
			editAllManagerABCount(managerMember);
		}
	}
	
	/**
	 * 删除 会员
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		memberService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 会员
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
			memberService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}