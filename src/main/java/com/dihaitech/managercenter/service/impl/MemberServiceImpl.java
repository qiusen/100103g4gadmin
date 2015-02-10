package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IMemberDAO;
import com.dihaitech.managercenter.model.Member;
import com.dihaitech.managercenter.service.IMemberService;

/**
 * 会员 业务接口 IMemberService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-05
 */
public class MemberServiceImpl implements IMemberService {

	@Resource
	private IMemberDAO memberDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IMemberService#addSave(com.dihaitech.managercenter.model.Member)
	 */
	public int addSave(Member member) {
		return memberDAO.addSaveMember(member);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IMemberService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return memberDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IMemberService#editSave(com.dihaitech.managercenter.model.Member)
	 */
	public int editSave(Member member) {
		return memberDAO.editSaveMember(member);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IMemberService#selectAll()
	 */
	public List<Member> selectAll() {
		return memberDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IMemberService#selectMember(com.dihaitech.managercenter.model.Member, int)
	 */
	public Page selectMember(Member member, int pageSize) {
		return new Page(memberDAO.getMemberCount(member), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IMemberService#selectMember(com.dihaitech.managercenter.model.Member, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Member> selectMember(Member member, Page page) {
		member.setStart(page.getFirstItemPos());
		member.setPageSize(page.getPageSize());
		return memberDAO.selectMemberLike(member);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IMemberService#selectMemberById(com.dihaitech.managercenter.model.Member)
	 */
	public Member selectMemberById(Member member) {
		return memberDAO.selectMemberById(member);
	}


	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IMemberService#editSaveAndCheck(com.dihaitech.managercenter.model.Member)
	 */
	@Override
	public void editSaveAndCheck(Member member) {
		// TODO Auto-generated method stub
		memberDAO.editSaveAndCheck(member);
	}
}
