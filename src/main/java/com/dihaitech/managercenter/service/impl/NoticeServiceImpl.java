package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.INoticeDAO;
import com.dihaitech.managercenter.model.Notice;
import com.dihaitech.managercenter.service.INoticeService;

/**
 * 新闻公告 业务接口 INoticeService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-05
 */
public class NoticeServiceImpl implements INoticeService {

	@Resource
	private INoticeDAO noticeDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.INoticeService#addSave(com.dihaitech.managercenter.model.Notice)
	 */
	public int addSave(Notice notice) {
		return noticeDAO.addSaveNotice(notice);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.INoticeService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return noticeDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.INoticeService#editSave(com.dihaitech.managercenter.model.Notice)
	 */
	public int editSave(Notice notice) {
		return noticeDAO.editSaveNotice(notice);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.INoticeService#selectAll()
	 */
	public List<Notice> selectAll() {
		return noticeDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.INoticeService#selectNotice(com.dihaitech.managercenter.model.Notice, int)
	 */
	public Page selectNotice(Notice notice, int pageSize) {
		return new Page(noticeDAO.getNoticeCount(notice), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.INoticeService#selectNotice(com.dihaitech.managercenter.model.Notice, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Notice> selectNotice(Notice notice, Page page) {
		notice.setStart(page.getFirstItemPos());
		notice.setPageSize(page.getPageSize());
		return noticeDAO.selectNoticeLike(notice);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.INoticeService#selectNoticeById(com.dihaitech.managercenter.model.Notice)
	 */
	public Notice selectNoticeById(Notice notice) {
		return noticeDAO.selectNoticeById(notice);
	}
}
