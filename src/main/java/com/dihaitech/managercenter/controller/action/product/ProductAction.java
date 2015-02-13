package com.dihaitech.managercenter.controller.action.product;

import java.util.Date;
import java.util.List;

import com.dihaitech.managercenter.common.Property;
import com.dihaitech.managercenter.controller.action.BaseAction;
import com.dihaitech.managercenter.util.Page;
import com.dihaitech.managercenter.util.TypeUtil;
import com.dihaitech.managercenter.util.json.JSONUtil;
import com.dihaitech.managercenter.model.Manager;
import com.dihaitech.managercenter.model.Product;
import com.dihaitech.managercenter.service.IProductService;

/**
 * 产品Action
 * 
 * @author cg
 *
 * @date 2015-02-13
 */
 @SuppressWarnings("serial")
public class ProductAction extends BaseAction {
	private Product product = new Product();
	private IProductService productService;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	/* 
	 * 产品查询
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		try {
			String pageSizeStr = this.getRequest().getParameter("pageSize");
			String pageNoStr = this.getRequest().getParameter("pageNo");
			int pageSize = 0;
			int pageNo = 0;
			
			pageSize = TypeUtil.stringToInt(pageSizeStr);
			if (pageSize <= 0) {
				pageSize = Property.PAGESIZE;
			}

			pageNo = TypeUtil.stringToInt(pageNoStr);
			if (pageSize > 0) {
				this.setManagerPageSize(pageSize);
			}else{
				this.setManagerPageSize(Property.PAGESIZE);
			}

			Page pageInfo = productService.selectProduct(product,this.getManagerPageSize());
			
			if (pageNo > 0) {
				pageInfo.setPage(pageNo);
			} else {
				pageInfo.setPage(0);
			}
			
			List<Product> resultList = this.productService.selectProduct(product,pageInfo);
			
			this.getRequest().setAttribute("pageInfo", pageInfo);
			this.getRequest().setAttribute("resultList", resultList);
			this.getRequest().setAttribute("actionName","productAction");

			String json = "\"Rows\":" + JSONUtil.objectArrayToJson(resultList)+", \"Total\":" + pageInfo.getResultCount();
			System.out.println("Product json:::::::::::::::::::" + json);
			this.getRequest().setAttribute("json", json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 添加 产品
	 * @return
	 */
	public String add(){
		return "add";
	}
	
	/**
	 * 保存添加 产品
	 * @return
	 */
	public String addSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		product.setCreator(manager.getNickname());
		product.setCreatetime(new Date());
		product.setUpdator(manager.getNickname());
		product.setUpdatetime(new Date());
		
		productService.addSave(product);
		return "addSave";
	}
	
	/**
	 * 修改 产品
	 * @return
	 */
	public String edit(){
		String idStr = this.getRequest().getParameter("id");
		int id = 0;
		id = TypeUtil.stringToInt(idStr);
		if(id>0){
			product.setId(id);
		}else{
			return null;
		}
		
		Product productVO = productService.selectProductById(product);
		this.getRequest().setAttribute("product", productVO);
		return "edit";
	}
	
	/**
	 * 保存修改 产品
	 * @return
	 */
	public String editSave(){
		Manager manager = (Manager)this.getSession().getAttribute("manager");
		product.setUpdator(manager.getNickname());
		product.setUpdatetime(new Date());
		
		productService.editSave(product);
		return "editSave";
	}
	
	/**
	 * 删除 产品
	 * @return
	 */
	public String delete(){
		String id = this.getRequest().getParameter("id");
		StringBuffer strbuf = new StringBuffer(" where id =");
		strbuf.append(id);
		productService.deleteByIds(strbuf.toString());
		return "deleteSuccess";
	}

	/**
	 * 删除 产品
	 * @return
	 */
	public String deleteByIds(){
		String[] ids = this.getRequest().getParameterValues("id");
		StringBuffer strbuf = new StringBuffer(" where id in(");
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				if (i != 0) {
					strbuf.append("," + ids[i]);
				} else {
					strbuf.append(ids[i]);
				}
			}
			strbuf.append(")");
			productService.deleteByIds(strbuf.toString());
			return "deleteSuccess";
		}
		return "deleteFailure";
	}
}