package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IWithdrawDAO;
import com.dihaitech.managercenter.model.Withdraw;
import com.dihaitech.managercenter.service.IWithdrawService;

/**
 * 提现 业务接口 IWithdrawService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-16
 */
public class WithdrawServiceImpl implements IWithdrawService {

	@Resource
	private IWithdrawDAO withdrawDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IWithdrawService#addSave(com.dihaitech.managercenter.model.Withdraw)
	 */
	public int addSave(Withdraw withdraw) {
		return withdrawDAO.addSaveWithdraw(withdraw);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IWithdrawService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return withdrawDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IWithdrawService#editSave(com.dihaitech.managercenter.model.Withdraw)
	 */
	public int editSave(Withdraw withdraw) {
		return withdrawDAO.editSaveWithdraw(withdraw);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IWithdrawService#selectAll()
	 */
	public List<Withdraw> selectAll() {
		return withdrawDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IWithdrawService#selectWithdraw(com.dihaitech.managercenter.model.Withdraw, int)
	 */
	public Page selectWithdraw(Withdraw withdraw, int pageSize) {
		return new Page(withdrawDAO.getWithdrawCount(withdraw), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IWithdrawService#selectWithdraw(com.dihaitech.managercenter.model.Withdraw, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Withdraw> selectWithdraw(Withdraw withdraw, Page page) {
		withdraw.setStart(page.getFirstItemPos());
		withdraw.setPageSize(page.getPageSize());
		return withdrawDAO.selectWithdrawLike(withdraw);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IWithdrawService#selectWithdrawById(com.dihaitech.managercenter.model.Withdraw)
	 */
	public Withdraw selectWithdrawById(Withdraw withdraw) {
		return withdrawDAO.selectWithdrawById(withdraw);
	}
}
