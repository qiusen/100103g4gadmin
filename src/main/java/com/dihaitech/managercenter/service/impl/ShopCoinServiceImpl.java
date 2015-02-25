package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IShopCoinDAO;
import com.dihaitech.managercenter.model.ShopCoin;
import com.dihaitech.managercenter.service.IShopCoinService;

/**
 * 电商币结算 业务接口 IShopCoinService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-25
 */
public class ShopCoinServiceImpl implements IShopCoinService {

	@Resource
	private IShopCoinDAO shopCoinDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IShopCoinService#addSave(com.dihaitech.managercenter.model.ShopCoin)
	 */
	public int addSave(ShopCoin shopCoin) {
		return shopCoinDAO.addSaveShopCoin(shopCoin);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IShopCoinService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return shopCoinDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IShopCoinService#editSave(com.dihaitech.managercenter.model.ShopCoin)
	 */
	public int editSave(ShopCoin shopCoin) {
		return shopCoinDAO.editSaveShopCoin(shopCoin);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IShopCoinService#selectAll()
	 */
	public List<ShopCoin> selectAll() {
		return shopCoinDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IShopCoinService#selectShopCoin(com.dihaitech.managercenter.model.ShopCoin, int)
	 */
	public Page selectShopCoin(ShopCoin shopCoin, int pageSize) {
		return new Page(shopCoinDAO.getShopCoinCount(shopCoin), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IShopCoinService#selectShopCoin(com.dihaitech.managercenter.model.ShopCoin, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<ShopCoin> selectShopCoin(ShopCoin shopCoin, Page page) {
		shopCoin.setStart(page.getFirstItemPos());
		shopCoin.setPageSize(page.getPageSize());
		return shopCoinDAO.selectShopCoinLike(shopCoin);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IShopCoinService#selectShopCoinById(com.dihaitech.managercenter.model.ShopCoin)
	 */
	public ShopCoin selectShopCoinById(ShopCoin shopCoin) {
		return shopCoinDAO.selectShopCoinById(shopCoin);
	}
}
