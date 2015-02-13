package com.dihaitech.managercenter.service.impl;

import java.util.List;
import javax.annotation.Resource;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.dao.IProductDAO;
import com.dihaitech.managercenter.model.Product;
import com.dihaitech.managercenter.service.IProductService;

/**
 * 产品 业务接口 IProductService 实现类
 * 
 * @author cg
 *
 * @date 2015-02-13
 */
public class ProductServiceImpl implements IProductService {

	@Resource
	private IProductDAO productDAO;

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IProductService#addSave(com.dihaitech.managercenter.model.Product)
	 */
	public int addSave(Product product) {
		return productDAO.addSaveProduct(product);
	}
	
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IProductService#deleteByIds(java.lang.String)
	 */
	public int deleteByIds(String str) {
		return productDAO.deleteByIds(str);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IProductService#editSave(com.dihaitech.managercenter.model.Product)
	 */
	public int editSave(Product product) {
		return productDAO.editSaveProduct(product);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.IProductService#selectAll()
	 */
	public List<Product> selectAll() {
		return productDAO.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IProductService#selectProduct(com.dihaitech.managercenter.model.Product, int)
	 */
	public Page selectProduct(Product product, int pageSize) {
		return new Page(productDAO.getProductCount(product), pageSize);
	}
	
	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IProductService#selectProduct(com.dihaitech.managercenter.model.Product, com.dihaitech.managercenter.controller.helper.Page)
	 */
	public List<Product> selectProduct(Product product, Page page) {
		product.setStart(page.getFirstItemPos());
		product.setPageSize(page.getPageSize());
		return productDAO.selectProductLike(product);
	}

	/* (non-Javadoc)
	 * @see com.dihaitech.managercenter.service.IProductService#selectProductById(com.dihaitech.managercenter.model.Product)
	 */
	public Product selectProductById(Product product) {
		return productDAO.selectProductById(product);
	}
}
