package org.zhxf.sale.web;


import java.util.List;

import org.zhxf.sale.domain.ItemInfo;
import org.zhxf.sale.service.ItemInfoService;
import org.zhxf.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class ItemAction extends BaseAction implements ModelDriven<ItemInfo> {

	private static final long serialVersionUID = -628649677616338668L;
	private ItemInfo model = new ItemInfo();

	@Override
	public ItemInfo getModel() {
		return model;
	}

	// 分页查询
	private Page<ItemInfo> page = new Page<ItemInfo>();
	public Page<ItemInfo> getPage() {
		return page;
	}
	public void setPage(Page<ItemInfo> page) {
		this.page = page;
	}

	private ItemInfoService itemInfoService;
	public void setItemInfoService(ItemInfoService itemInfoService) {
		this.itemInfoService = itemInfoService;
	}
//	private RoleService roleService;
//	public void setRoleService(RoleService roleService) {
//		this.roleService = roleService;
//	}

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from ItemInfo";
		itemInfoService.findPage(hql, page, ItemInfo.class, null);
		// 设置分页的url地址
		page.setUrl("itemAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		ItemInfo item = itemInfoService.get(ItemInfo.class, model.getItemNo());
		// 放入栈顶
		super.push(item);

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
		itemInfoService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		ItemInfo item = itemInfoService.get(ItemInfo.class, model.getItemNo());
//		System.out.println(item);
		super.push(item);
//		
//		List<ItemInfo> itemInfo = itemInfoService.find("from ItemInfo", ItemInfo.class, null);
//		super.put("itemInfo", itemInfo);
				
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		
		// 1.调用业务方法，根据id,得到对象
		ItemInfo item = itemInfoService.get(ItemInfo.class, model.getItemNo());
		
		item.setItemName(model.getItemName());
		item.setItemType(model.getItemType());
		item.setUnit(model.getUnit());
		
		itemInfoService.saveOrUpdate(item);
				
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getItemNo().split(", ");
		
		//调用业务方法，实现批量删除
		itemInfoService.delete(ItemInfo.class, ids);
		
		return "alist";
	}
}
