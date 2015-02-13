package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IDepositDAO;
import com.dihaitech.managercenter.model.Deposit;
import com.dihaitech.managercenter.service.IDepositService;

/**
 * 充值 业务接口 IDepositService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-13
 */
public class DepositServiceImpl implements IDepositService {

	@Resource
	private IDepositDAO depositDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepositService#addSave(com.dihaitech.managercenter.model.Deposit)
	 */
	public int addSave(Deposit deposit) {
		return depositDAO.addSaveDeposit(deposit);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepositService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return depositDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepositService#editSave(com.dihaitech.managercenter.model.Deposit)
	 */
	public int editSave(Deposit deposit) {
		return depositDAO.editSaveDeposit(deposit);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IDepositService#selectAll()
	 */
	public List<Deposit> selectAll() {
		return depositDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepositService#selectDeposit(com.dihaitech.managercenter.model.Deposit, int)
	 */
	public Page selectDeposit(Deposit deposit, int pageSize) {
		return new Page(depositDAO.getDepositCount(deposit), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepositService#selectDeposit(com.dihaitech.managercenter.model.Deposit, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Deposit> selectDeposit(Deposit deposit, Page page) {
		deposit.setStart(page.getFirstItemPos());
		deposit.setPageSize(page.getPageSize());
		return depositDAO.selectDepositLike(deposit);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IDepositService#selectDepositById(com.dihaitech.managercenter.model.Deposit)
	 */
	public Deposit selectDepositById(Deposit deposit) {
		return depositDAO.selectDepositById(deposit);
	}
}
