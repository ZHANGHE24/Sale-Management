package org.zhxf.sale.domain;
// Generated 2019-6-14 11:15:34 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StoreItemsale generated by hbm2java
 */
@Entity
@Table(name = "store_itemsale", catalog = "saletest")
public class StoreItemsale implements java.io.Serializable {

	private StoreItemsaleId id;
	private ItemInfo itemInfo;
	private StoreInfo storeInfo;
	private Long saleQty;
	private Float amount;
	private Date saleDate;

	public StoreItemsale() {
	}

	public StoreItemsale(StoreItemsaleId id, ItemInfo itemInfo, StoreInfo storeInfo, Date saleDate) {
		this.id = id;
		this.itemInfo = itemInfo;
		this.storeInfo = storeInfo;
		this.saleDate = saleDate;
	}

	public StoreItemsale(StoreItemsaleId id, ItemInfo itemInfo, StoreInfo storeInfo, Long saleQty, Float amount,
			Date saleDate) {
		this.id = id;
		this.itemInfo = itemInfo;
		this.storeInfo = storeInfo;
		this.saleQty = saleQty;
		this.amount = amount;
		this.saleDate = saleDate;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "storeNo", column = @Column(name = "Store_no", nullable = false, length = 13)),
			@AttributeOverride(name = "itemNo", column = @Column(name = "Item_no", nullable = false, length = 13)) })
	public StoreItemsaleId getId() {
		return this.id;
	}

	public void setId(StoreItemsaleId id) {
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

	@Column(name = "Sale_qty")
	public Long getSaleQty() {
		return this.saleQty;
	}

	public void setSaleQty(Long saleQty) {
		this.saleQty = saleQty;
	}

	@Column(name = "Amount", precision = 8)
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Sale_date", nullable = false, length = 19)
	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

}
