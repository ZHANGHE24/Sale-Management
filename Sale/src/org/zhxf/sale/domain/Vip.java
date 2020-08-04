package org.zhxf.sale.domain;
// Generated 2019-6-14 11:15:34 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vip generated by hbm2java
 */
@Entity
@Table(name = "vip", catalog = "saletest")
public class Vip implements java.io.Serializable {

	private String vipNo;
	private Long currentPoint;
	private Long totalPoint;
	private Set<Presale> presales = new HashSet<Presale>(0);
	private Set<Sale> sales = new HashSet<Sale>(0);

	public Vip() {
	}

	public Vip(String vipNo) {
		this.vipNo = vipNo;
	}

	public Vip(String vipNo, Long currentPoint, Long totalPoint, Set<Presale> presales, Set<Sale> sales) {
		this.vipNo = vipNo;
		this.currentPoint = currentPoint;
		this.totalPoint = totalPoint;
		this.presales = presales;
		this.sales = sales;
	}

	@Id

	@Column(name = "VIP_no", unique = true, nullable = false, length = 12)
	public String getVipNo() {
		return this.vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}

	@Column(name = "Current_point")
	public Long getCurrentPoint() {
		return this.currentPoint;
	}

	public void setCurrentPoint(Long currentPoint) {
		this.currentPoint = currentPoint;
	}

	@Column(name = "Total_point")
	public Long getTotalPoint() {
		return this.totalPoint;
	}

	public void setTotalPoint(Long totalPoint) {
		this.totalPoint = totalPoint;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vip")
	public Set<Presale> getPresales() {
		return this.presales;
	}

	public void setPresales(Set<Presale> presales) {
		this.presales = presales;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vip")
	public Set<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

}
