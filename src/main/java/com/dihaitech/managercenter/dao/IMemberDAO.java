package com.dihaitech.managercenter.dao;

import java.util.List;


import com.dihaitech.managercenter.model.Member;

/**
 * 会员 DAO 接口
 * 
 * @author cg
 * 
 * @since 2015-02-05
 */
public interface IMemberDAO {

	/**
	 * 根据条件查询会员 条数
	 * 
	 * @param member
	 * @return
	 */
	public Long getMemberCount(Member member);

	/**
	 * 分页查找会员
	 * 
	 * @param member
	 * @param page
	 * @return
	 */
	public List<Member> selectMemberLike(Member member);

	/**
	 * 添加会员
	 * 
	 * @param member
	 * @return
	 */
	public int addSaveMember(Member member);

	/**
	 * 根据ID获取指定的会员信息
	 * 
	 * @param member
	 * @return
	 */
	public Member selectMemberById(Member member);

	/**
	 * 修改会员
	 * 
	 * @param member
	 * @return
	 */
	public int editSaveMember(Member member);

	/**
	 * 根据ID删除指定的会员
	 * 
	 * @param str
	 * @return
	 */
	public int deleteByIds(String str);

	/**
	 * 查询所有会员
	 * 
	 * @return
	 */
	public List<Member> selectAll();

	/**
	 * 修改并审核 
	 * @param member
	 */
	public void editSaveAndCheck(Member member);

	/**
	 * 增加区域人数
	 * @param member
	 */
	public void editABCount(Member member);

	/**
	 * 根据编号查询会员
	 * @param member
	 * @return
	 */
	public Member selectMemberByCode(Member member);

	/**
	 * 修改币
	 * @param member
	 */
	public void editCoin(Member member);
	
}
