package org.zhxf.sale.domain;
// Generated 2019-6-14 11:15:34 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StoreStockInfo generated by hbm2java
 */
@Entity
@Table(name = "store_stock_info", catalog = "saletest")
public class StoreStockInfo implements java.io.Serializable {

	private StoreStockInfoId id;
	private ItemInfo itemInfo;
	private StoreInfo storeInfo;
	private Float salePrice;
	private Long quality;

	public StoreStockInfo() {
	}

	public StoreStockInfo(StoreStockInfoId id, ItemInfo itemInfo, StoreInfo storeInfo) {
		this.id = id;
		this.itemInfo = itemInfo;
		this.storeInfo = storeInfo;
	}

	public StoreStockInfo(StoreStockInfoId id, ItemInfo itemInfo, StoreInfo storeInfo, Float salePrice, Long quality) {
		this.id = id;
		this.itemInfo = itemInfo;
		this.storeInfo = storeInfo;
		this.salePrice = salePrice;
		this.quality = quality;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "storeNo", column = @Column(name = "Store_no", nullable = false, length = 13)),
			@AttributeOverride(name = "itemNo", column = @Column(name = "Item_no", nullable = false, length = 13)) })
	public StoreStockInfoId getId() {
		return this.id;
	}

	public void setId(StoreStockInfoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Item_no", nullable = false, insertable = false, updatable = false)
	public ItemInfo getItemInfo() {
		return this.itemInfo;
	}

	public void setItemInfo(ItemInfo itemInfo) {
		this.itemInfo = itemInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Store_no", nullable = false, insertable = false, updatable = false)
	public StoreInfo getStoreInfo() {
		return this.storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}

	@Column(name = "Sale_price", precision = 8)
	public Float getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name = "Quality")
	public Long getQuality() {
		return this.quality;
	}

	public void setQuality(Long quality) {
		this.quality = quality;
	}

}
