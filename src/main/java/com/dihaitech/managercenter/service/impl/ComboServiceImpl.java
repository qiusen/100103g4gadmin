package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IComboDAO;
import com.dihaitech.managercenter.model.Combo;
import com.dihaitech.managercenter.service.IComboService;

/**
 * 套餐 业务接口 IComboService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-13
 */
public class ComboServiceImpl implements IComboService {

	@Resource
	private IComboDAO comboDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IComboService#addSave(com.dihaitech.managercenter.model.Combo)
	 */
	public int addSave(Combo combo) {
		return comboDAO.addSaveCombo(combo);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IComboService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return comboDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IComboService#editSave(com.dihaitech.managercenter.model.Combo)
	 */
	public int editSave(Combo combo) {
		return comboDAO.editSaveCombo(combo);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IComboService#selectAll()
	 */
	public List<Combo> selectAll() {
		return comboDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IComboService#selectCombo(com.dihaitech.managercenter.model.Combo, int)
	 */
	public Page selectCombo(Combo combo, int pageSize) {
		return new Page(comboDAO.getComboCount(combo), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IComboService#selectCombo(com.dihaitech.managercenter.model.Combo, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Combo> selectCombo(Combo combo, Page page) {
		combo.setStart(page.getFirstItemPos());
		combo.setPageSize(page.getPageSize());
		return comboDAO.selectComboLike(combo);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IComboService#selectComboById(com.dihaitech.managercenter.model.Combo)
	 */
	public Combo selectComboById(Combo combo) {
		return comboDAO.selectComboById(combo);
	}
}
