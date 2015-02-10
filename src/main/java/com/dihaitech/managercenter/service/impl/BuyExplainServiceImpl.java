package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IBuyExplainDAO;
import com.dihaitech.managercenter.model.BuyExplain;
import com.dihaitech.managercenter.service.IBuyExplainService;

/**
 * 购买说明 业务接口 IBuyExplainService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-10
 */
public class BuyExplainServiceImpl implements IBuyExplainService {

	@Resource
	private IBuyExplainDAO buyExplainDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBuyExplainService#addSave(com.dihaitech.managercenter.model.BuyExplain)
	 */
	public int addSave(BuyExplain buyExplain) {
		return buyExplainDAO.addSaveBuyExplain(buyExplain);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBuyExplainService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return buyExplainDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBuyExplainService#editSave(com.dihaitech.managercenter.model.BuyExplain)
	 */
	public int editSave(BuyExplain buyExplain) {
		return buyExplainDAO.editSaveBuyExplain(buyExplain);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IBuyExplainService#selectAll()
	 */
	public List<BuyExplain> selectAll() {
		return buyExplainDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBuyExplainService#selectBuyExplain(com.dihaitech.managercenter.model.BuyExplain, int)
	 */
	public Page selectBuyExplain(BuyExplain buyExplain, int pageSize) {
		return new Page(buyExplainDAO.getBuyExplainCount(buyExplain), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBuyExplainService#selectBuyExplain(com.dihaitech.managercenter.model.BuyExplain, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<BuyExplain> selectBuyExplain(BuyExplain buyExplain, Page page) {
		buyExplain.setStart(page.getFirstItemPos());
		buyExplain.setPageSize(page.getPageSize());
		return buyExplainDAO.selectBuyExplainLike(buyExplain);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBuyExplainService#selectBuyExplainById(com.dihaitech.managercenter.model.BuyExplain)
	 */
	public BuyExplain selectBuyExplainById(BuyExplain buyExplain) {
		return buyExplainDAO.selectBuyExplainById(buyExplain);
	}
}
