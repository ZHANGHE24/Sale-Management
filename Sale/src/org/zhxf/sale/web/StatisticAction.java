package org.zhxf.sale.web;

//门店销售统计信息



import java.util.List;

import org.zhxf.sale.domain.StoreItemsale;
import org.zhxf.sale.service.StoreItemsaleService;
import org.zhxf.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class StatisticAction extends BaseAction implements ModelDriven<StoreItemsale> {

	private static final long serialVersionUID = -628649677616338668L;
	private StoreItemsale model = new StoreItemsale();

	@Override
	public StoreItemsale getModel() {
		return model;
	}

	// 分页查询
	private Page<StoreItemsale> page = new Page<StoreItemsale>();
	public Page<StoreItemsale> getPage() {
		return page;
	}
	public void setPage(Page<StoreItemsale> page) {
		this.page = page;
	}

	private StoreItemsaleService storeitemsaleService;
	public void setStoreitemsaleService(StoreItemsaleService storeitemsaleService) {
		this.storeitemsaleService = storeitemsaleService;
	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from StoreItemsale";

		storeitemsaleService.findPage(hql, page, StoreItemsale.class, null);  //User是实体

		// 设置分页的url地址
		page.setUrl("statisticAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		StoreItemsale user = storeitemsaleService.get(StoreItemsale.class, model.getId());

		// 放入栈顶
		super.push(user);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		//List<Role> roles = roleService.find("from Role", Role.class, null);
		
		//super.put("roles", roles);
		
		return "tocreate";
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		storeitemsaleService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
//	public String toupdate() throws Exception {
//		// 1.调用业务方法，根据id,得到对象
//		StoreItemsale user = storeitemsaleService.get(StoreItemsale.class, model.getId());
//		super.push(user);
//		
//		//List<Role> roles = roleService.find("from Role", Role.class, null);
//		//super.put("roles", roles);
//				
//		return "toupdate";
//	}

	/**
	 * 修改
	 */
//	public String update() throws Exception {
//		
//		// 1.调用业务方法，根据id,得到对象
//		StoreItemsale user = storeitemsaleService.get(StoreItemsale.class, model.getId());
//		
//		user.setStoreNo(model.getStoreNo());
//		user.setItemNo(model.getItemNo());
//		user.setSaleDate(model.getSaleDate());
//		
//		storeitemsaleService.saveOrUpdate(user);
//				
//		return "alist";
//	}

	/**
	 * 删除
	 */
//	public String delete() throws Exception {
//		String ids[] = model.getId().split(", ");
//		
//		//调用业务方法，实现批量删除
//		userService.delete(User.class, ids);
//		
//		return "alist";
//	}
}
