package org.zhxf.sale.web;


import java.util.List;

import org.zhxf.sale.domain.Transfer;
import org.zhxf.sale.domain.TransferId;
import org.zhxf.sale.domain.ItemInfo;
import org.zhxf.sale.domain.StoreInfo;
import org.zhxf.sale.service.ItemInfoService;
import org.zhxf.sale.domain.StoreStockInfo;
import org.zhxf.sale.domain.StoreStockInfoId;
import org.zhxf.sale.service.StoreStockInfoService;
import org.zhxf.sale.service.StoreInfoService;
import org.zhxf.sale.service.TransferService;
import org.zhxf.sale.utils.Page;

import com.opensymphony.xwork2.ModelDriven;

public class TransferAction extends BaseAction implements ModelDriven<Transfer> {

	private static final long serialVersionUID = -628649677616338668L;
	private Transfer model = new Transfer();
	private StoreStockInfo model2 = new StoreStockInfo();

	@Override
	public Transfer getModel() {
		return model;
	}

	// 分页查询
	private Page<Transfer> page = new Page<Transfer>();
	public Page<Transfer> getPage() {
		return page;
	}
	public void setPage(Page<Transfer> page) {
		this.page = page;
	}

	private TransferService transferService;
	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}
	private ItemInfoService itemInfoService;
	public void setItemInfoService(ItemInfoService itemInfoService) {
		this.itemInfoService = itemInfoService;
	}
	private StoreInfoService storeInfoService;
	public void setStoreInfoService(StoreInfoService storeInfoService) {
		this.storeInfoService = storeInfoService;
	}
	private StoreStockInfoService ssService;
	public void setSsService(StoreStockInfoService ssService) {
		this.ssService = ssService;
	}
	/**
	 * 分页查询
	 */
	public String list() throws Exception {
		String hql = "from Transfer";

		transferService.findPage(hql, page, Transfer.class, null);

		// 设置分页的url地址
		page.setUrl("transferAction_list");

		// 将page对象压入栈顶
		super.push(page);
		return "list";
	}

	/**
	 * 查看
	 */
	public String toview() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Transfer Transfer = transferService.get(Transfer.class, model.getId());

		// 放入栈顶
		super.push(Transfer);

		// 3.跳页面
		return "toview";
	}

	/**
	 * 进入新增页面
	 */
	public String tocreate() throws Exception {
		List<ItemInfo> itemInfo = itemInfoService.find("from ItemInfo", ItemInfo.class, null);
		
		super.put("itemInfo", itemInfo);
		
		List<StoreStockInfo> storeStockInfo = ssService.find("from StoreStockInfo", StoreStockInfo.class, null);
		
		super.put("storeStockInfo", storeStockInfo);
		
		
		List<StoreInfo> storeInfo = storeInfoService.find("from StoreInfo", StoreInfo.class, null);		
		
		super.put("storeInfo", storeInfo);
		
		return "tocreate";
	}

	/**
	 * 保存
	 */
	public String insert() throws Exception {
		if(model.getTransferQty()==null) {
			model.setTransferQty(0L);
		}
		if(transferService.get(Transfer.class, model.getId())!=null) {
			Transfer transfer = transferService.get(Transfer.class, model.getId());
			if(transfer.getTransferQty()!=0L) {
				transfer.setTransferQty(model.getTransferQty()+transfer.getTransferQty());
			}
			transfer.setTransferDate(model.getTransferDate());
			transferService.saveOrUpdate(transfer);
		}else {
			transferService.saveOrUpdate(model);
		}
		
		//入库门店
		StoreStockInfoId storeStockInfoId1 = new StoreStockInfoId();
		storeStockInfoId1.setStoreNo(model.getId().getInStoreNo());
		storeStockInfoId1.setItemNo(model.getId().getItemNo());
		//出库门店
		StoreStockInfoId storeStockInfoId2 = new StoreStockInfoId();
		storeStockInfoId2.setStoreNo(model.getId().getOutStoreNo());
		storeStockInfoId2.setItemNo(model.getId().getItemNo());
		StoreStockInfo storeStockInfo2 = ssService.get(StoreStockInfo.class, storeStockInfoId2);
		
		if(ssService.get(StoreStockInfo.class, storeStockInfoId1)==null) {
			StoreInfo model3 = storeInfoService.get(StoreInfo.class, model.getId().getInStoreNo());
			ItemInfo model4 = itemInfoService.get(ItemInfo.class, model.getId().getItemNo());
			System.out.println(model3);
			System.out.println(model4);
			model2.setId(storeStockInfoId1);
			model2.setItemInfo(model4);
			model2.setStoreInfo(model3);
			model2.setSalePrice(0f);
			model2.setQuality(0L);
			ssService.saveOrUpdate(model2);
		}
		StoreStockInfo storeStockInfo1 = ssService.get(StoreStockInfo.class, storeStockInfoId1);
		
		Long num1 = 0L;
		if(storeStockInfo2.getQuality()!=0L) {
			num1 = storeStockInfo2.getQuality();
		}
		storeStockInfo2.setQuality(num1-model.getTransferQty());
		ssService.saveOrUpdate(storeStockInfo2);
		
		//同步门店库存

		storeStockInfo1.setId(storeStockInfoId1);
		storeStockInfo1.setSalePrice(storeStockInfo2.getSalePrice());
		Long num2 = 0L;
		if(storeStockInfo1.getQuality()!=0L) {
			num2 = storeStockInfo1.getQuality();
		}
		storeStockInfo1.setQuality(model.getTransferQty()+num2);
		System.out.println(storeStockInfo1);
		ssService.saveOrUpdate(storeStockInfo1);
		
		
		return "alist";
	}

	/**
	 * 进入修改页面
	 */
	public String toupdate() throws Exception {
		// 1.调用业务方法，根据id,得到对象
		Transfer Transfer = transferService.get(Transfer.class, model.getId());
		super.push(Transfer);
		
		//List<Role> roles = roleService.find("from Role", Role.class, null);
		//super.put("roles", roles);
				
		return "toupdate";
	}

	/**
	 * 修改
	 */
//	public String update() throws Exception {
//		
//		// 1.调用业务方法，根据id,得到对象
//		Transfer Transfer = transferService.get(Transfer.class, model.getId());
//		Transfer transfer = null;
//		Transfer.setOutStoreNo(model.getOutStoreNo());
//		Transfer.setInStoreNo(model.getInStoreNo());
//		Transfer.setItemNo(model.getItemNo());
//		Transfer.setTransferDate(model.getTransferDate());
//		transfer.setTransferQty(model.getTransferQty());
//		
//		transferService.saveOrUpdate(Transfer);
//				
//		return "alist";
//	}

	/**
	 * 删除
	 */
	//联合主键待解决
//	public String delete() throws Exception {
//		String ids[] = model.getOutStoreNo().split(", ");
//		
//		//调用业务方法，实现批量删除
//		transferService.delete(Transfer.class, ids);
//		
//		return "alist";
//	}
}
