package org.zhxf.sale.domain;
// Generated 2019-6-14 11:15:34 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LocalTemporaryRecord generated by hbm2java
 */
@Entity
@Table(name = "local_temporary_record", catalog = "saletest")
public class LocalTemporaryRecord implements java.io.Serializable {

	private String orderNo;
	private String vipNo;
	private Long accuPoints;

	public LocalTemporaryRecord() {
	}

	public LocalTemporaryRecord(String orderNo) {
		this.orderNo = orderNo;
	}

	public LocalTemporaryRecord(String orderNo, String vipNo, Long accuPoints) {
		this.orderNo = orderNo;
		this.vipNo = vipNo;
		this.accuPoints = accuPoints;
	}

	@Id

	@Column(name = "Order_no", unique = true, nullable = false, length = 25)
	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name = "VIP_no", length = 11)
	public String getVipNo() {
		return this.vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}

	@Column(name = "accu_points")
	public Long getAccuPoints() {
		return this.accuPoints;
	}

	public void setAccuPoints(Long accuPoints) {
		this.accuPoints = accuPoints;
	}

}
