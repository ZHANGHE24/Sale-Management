package org.zhxf.sale.web;


import java.util.List;

import org.zhxf.sale.domain.Presale;
import org.zhxf.sale.service.PresaleService;
import org.zhxf.sale.utils.Page;
import org.zhxf.sale.domain.Vip;
import org.zhxf.sale.service.VipService;
import org.zhxf.sale.domain.StoreInfo;
import org.zhxf.sale.service.StoreInfoService;
import org.zhxf.sale.domain.ItemInfo;
import org.zhxf.sale.service.ItemInfoService;

import com.opensymphony.xwork2.ModelDriven;

public class PresaleAction extends BaseAction implements ModelDriven<Presale> {

	private static final long serialVersionUID = -628649677616338668L;
	private Presale model = new Presale();

	@Override
	public Presale getModel() {
		return model;
	}

	// 分页查询
	private Page<Presale> page = new Page<Presale>();
	public Page<Presale> getPage() {
		return page;
	}
	public void setPage(Page<Presale> page) {
		this.page = page;
	}

	private PresaleService presaleService;
	public void setPresaleService(PresaleService presaleService) {
		this.presaleService = presaleService;
	}
	private ItemInfoService itemInfoService;
	public void setItemInfoService(ItemInfoService itemInfoService) {
		this.itemInfoService = itemInfoService;
	}
	private StoreInfoService storeInfoService;
	public void setStoreInfoService(StoreInfoService storeInfoService) {
		this.storeInfoService = storeInfoService;
	}
	private VipService vipService;
	public void setVipService(VipService vipService) {
		this.vipService = vipService;
	}
	

	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from Presale";

		presaleService.findPage(hql, page, Presale.class, null);

		// 设置分页的url地址
		page.setUrl("presaleAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Presale presale = presaleService.get(Presale.class, model.getPresale());

		// 放入栈顶
		super.push(presale);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		List<ItemInfo> itemInfo = itemInfoService.find("from ItemInfo", ItemInfo.class, null);
		
		super.put("itemInfo", itemInfo);
		
		List<StoreInfo> storeInfo = storeInfoService.find("from StoreInfo", StoreInfo.class, null);		
		
		super.put("storeInfo", storeInfo);
		
		List<Vip> vip = vipService.find("from Vip", Vip.class, null);		
		
		super.put("vip", vip);
		
		return "tocreate";
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		presaleService.saveOrUpdate(model);
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Presale presale = presaleService.get(Presale.class, model.getPresale());
		super.push(presale);
		
		List<ItemInfo> itemInfo = itemInfoService.find("from ItemInfo", ItemInfo.class, null);
		
		super.put("itemInfo", itemInfo);
		
		List<StoreInfo> storeInfo = storeInfoService.find("from StoreInfo", StoreInfo.class, null);		
		
		super.put("storeInfo", storeInfo);
		
		List<Vip> vip = vipService.find("from Vip", Vip.class, null);		
		
		super.put("vip", vip);
				
		return "toupdate";
	}

	/**
	 * 修改
	 */
	public String update() throws Exception {
		
		// 1.调用业务方法，根据id,得到对象
		Presale presale = presaleService.get(Presale.class, model.getPresale());
		
		presale.setItemInfo(model.getItemInfo());
		presale.setStoreInfo(model.getStoreInfo());
		presale.setVip(model.getVip());
		presale.setSubscription(model.getSubscription());
		presale.setReserveDate(model.getReserveDate());
		presale.setIsRemainder(model.getIsRemainder());
		
		presaleService.saveOrUpdate(presale);
				
		return "alist";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		String ids[] = model.getPresale().split(", ");
		
		//调用业务方法，实现批量删除
		presaleService.delete(Presale.class, ids);
		
		return "alist";
	}
}
