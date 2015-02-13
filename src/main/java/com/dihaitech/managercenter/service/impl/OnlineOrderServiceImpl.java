package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IOnlineOrderDAO;
import com.dihaitech.managercenter.model.OnlineOrder;
import com.dihaitech.managercenter.service.IOnlineOrderService;

/**
 * 在线订单 业务接口 IOnlineOrderService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-13
 */
public class OnlineOrderServiceImpl implements IOnlineOrderService {

	@Resource
	private IOnlineOrderDAO onlineOrderDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IOnlineOrderService#addSave(com.dihaitech.managercenter.model.OnlineOrder)
	 */
	public int addSave(OnlineOrder onlineOrder) {
		return onlineOrderDAO.addSaveOnlineOrder(onlineOrder);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IOnlineOrderService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return onlineOrderDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IOnlineOrderService#editSave(com.dihaitech.managercenter.model.OnlineOrder)
	 */
	public int editSave(OnlineOrder onlineOrder) {
		return onlineOrderDAO.editSaveOnlineOrder(onlineOrder);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IOnlineOrderService#selectAll()
	 */
	public List<OnlineOrder> selectAll() {
		return onlineOrderDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IOnlineOrderService#selectOnlineOrder(com.dihaitech.managercenter.model.OnlineOrder, int)
	 */
	public Page selectOnlineOrder(OnlineOrder onlineOrder, int pageSize) {
		return new Page(onlineOrderDAO.getOnlineOrderCount(onlineOrder), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IOnlineOrderService#selectOnlineOrder(com.dihaitech.managercenter.model.OnlineOrder, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<OnlineOrder> selectOnlineOrder(OnlineOrder onlineOrder, Page page) {
		onlineOrder.setStart(page.getFirstItemPos());
		onlineOrder.setPageSize(page.getPageSize());
		return onlineOrderDAO.selectOnlineOrderLike(onlineOrder);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IOnlineOrderService#selectOnlineOrderById(com.dihaitech.managercenter.model.OnlineOrder)
	 */
	public OnlineOrder selectOnlineOrderById(OnlineOrder onlineOrder) {
		return onlineOrderDAO.selectOnlineOrderById(onlineOrder);
	}
}
