package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IBonusDAO;
import com.dihaitech.managercenter.model.Bonus;
import com.dihaitech.managercenter.service.IBonusService;

/**
 * 奖金 业务接口 IBonusService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-15
 */
public class BonusServiceImpl implements IBonusService {

	@Resource
	private IBonusDAO bonusDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBonusService#addSave(com.dihaitech.managercenter.model.Bonus)
	 */
	public int addSave(Bonus bonus) {
		return bonusDAO.addSaveBonus(bonus);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBonusService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return bonusDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBonusService#editSave(com.dihaitech.managercenter.model.Bonus)
	 */
	public int editSave(Bonus bonus) {
		return bonusDAO.editSaveBonus(bonus);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IBonusService#selectAll()
	 */
	public List<Bonus> selectAll() {
		return bonusDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBonusService#selectBonus(com.dihaitech.managercenter.model.Bonus, int)
	 */
	public Page selectBonus(Bonus bonus, int pageSize) {
		return new Page(bonusDAO.getBonusCount(bonus), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBonusService#selectBonus(com.dihaitech.managercenter.model.Bonus, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Bonus> selectBonus(Bonus bonus, Page page) {
		bonus.setStart(page.getFirstItemPos());
		bonus.setPageSize(page.getPageSize());
		return bonusDAO.selectBonusLike(bonus);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IBonusService#selectBonusById(com.dihaitech.managercenter.model.Bonus)
	 */
	public Bonus selectBonusById(Bonus bonus) {
		return bonusDAO.selectBonusById(bonus);
	}
}
