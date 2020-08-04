package org.zhxf.sale.web;


import java.util.List;

import org.zhxf.sale.domain.StoreInfo;
import org.zhxf.sale.service.StoreInfoService;
import org.zhxf.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class StoreAction extends BaseAction implements ModelDriven<StoreInfo> {

	private static final long serialVersionUID = -628649677616338668L;
	private StoreInfo model = new StoreInfo();

	@Override
	public StoreInfo getModel() {
		return model;
	}

	// 分页查询
	private Page<StoreInfo> page = new Page<StoreInfo>();
	public Page<StoreInfo> getPage() {
		return page;
	}
	public void setPage(Page<StoreInfo> page) {
		this.page = page;
	}

	private StoreInfoService storeInfoService;
	public void setStoreInfoService(StoreInfoService storeInfoService) {
		this.storeInfoService = storeInfoService;
	}
//	private RoleService roleService;
//	public void setRoleService(RoleService roleService) {
//		this.roleService = roleService;
//	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from StoreInfo";

		storeInfoService.findPage(hql, page, StoreInfo.class, null);

		// 设置分页的url地址
		page.setUrl("storeAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		StoreInfo storeInfo = storeInfoService.get(StoreInfo.class, model.getStoreNo());

		// 放入栈顶
		super.push(storeInfo);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
//		List<Role> roles = roleService.find("from Role", Role.class, null);
//		
//		super.put("roles", roles);
		
		return "tocreate";
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		storeInfoService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		StoreInfo storeInfo = storeInfoService.get(StoreInfo.class, model.getStoreNo());
		super.push(storeInfo);
		
		//List<Role> roles = roleService.find("from Role", Role.class, null);
		//super.put("roles", roles);
				
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		
		// 1.调用业务方法，根据id,得到对象
		StoreInfo storeInfo = storeInfoService.get(StoreInfo.class, model.getStoreNo());
		
		storeInfo.setStoreName(model.getStoreName());
		storeInfo.setStoreAddr(model.getStoreAddr());
		storeInfo.setManager(model.getManager());
		storeInfo.setTel(model.getTel());
		
		storeInfoService.saveOrUpdate(storeInfo);
				
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getStoreNo().split(", ");
		
		//调用业务方法，实现批量删除
		storeInfoService.delete(StoreInfo.class, ids);
		
		return "alist";
	}
}
