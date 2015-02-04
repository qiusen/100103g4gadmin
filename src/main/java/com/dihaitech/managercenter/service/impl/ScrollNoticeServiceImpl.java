package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IScrollNoticeDAO;
import com.dihaitech.managercenter.model.ScrollNotice;
import com.dihaitech.managercenter.service.IScrollNoticeService;

/**
 * 滚动公告 业务接口 IScrollNoticeService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-04
 */
public class ScrollNoticeServiceImpl implements IScrollNoticeService {

	@Resource
	private IScrollNoticeDAO scrollNoticeDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IScrollNoticeService#addSave(com.dihaitech.managercenter.model.ScrollNotice)
	 */
	public int addSave(ScrollNotice scrollNotice) {
		return scrollNoticeDAO.addSaveScrollNotice(scrollNotice);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IScrollNoticeService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return scrollNoticeDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IScrollNoticeService#editSave(com.dihaitech.managercenter.model.ScrollNotice)
	 */
	public int editSave(ScrollNotice scrollNotice) {
		return scrollNoticeDAO.editSaveScrollNotice(scrollNotice);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IScrollNoticeService#selectAll()
	 */
	public List<ScrollNotice> selectAll() {
		return scrollNoticeDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IScrollNoticeService#selectScrollNotice(com.dihaitech.managercenter.model.ScrollNotice, int)
	 */
	public Page selectScrollNotice(ScrollNotice scrollNotice, int pageSize) {
		return new Page(scrollNoticeDAO.getScrollNoticeCount(scrollNotice), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IScrollNoticeService#selectScrollNotice(com.dihaitech.managercenter.model.ScrollNotice, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<ScrollNotice> selectScrollNotice(ScrollNotice scrollNotice, Page page) {
		scrollNotice.setStart(page.getFirstItemPos());
		scrollNotice.setPageSize(page.getPageSize());
		return scrollNoticeDAO.selectScrollNoticeLike(scrollNotice);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IScrollNoticeService#selectScrollNoticeById(com.dihaitech.managercenter.model.ScrollNotice)
	 */
	public ScrollNotice selectScrollNoticeById(ScrollNotice scrollNotice) {
		return scrollNoticeDAO.selectScrollNoticeById(scrollNotice);
	}
}
