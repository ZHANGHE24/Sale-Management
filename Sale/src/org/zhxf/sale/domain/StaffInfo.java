package org.zhxf.sale.domain;
// Generated 2019-6-14 11:15:34 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * StaffInfo generated by hbm2java
 */
@Entity
@Table(name = "staff_info", catalog = "saletest")
public class StaffInfo implements java.io.Serializable {

	private String staffNo;
	private StoreInfo storeInfo;
	private String staffName;
	private Long basicSalary;
	private Long commission;
	private Set<Sale> sales = new HashSet<Sale>(0);

	public StaffInfo() {
	}

	public StaffInfo(String staffNo) {
		this.staffNo = staffNo;
	}

	public StaffInfo(String staffNo, StoreInfo storeInfo, String staffName, Long basicSalary, Long commission,
			Set<Sale> sales) {
		this.staffNo = staffNo;
		this.storeInfo = storeInfo;
		this.staffName = staffName;
		this.basicSalary = basicSalary;
		this.commission = commission;
		this.sales = sales;
	}

	@Id

	@Column(name = "Staff_no", unique = true, nullable = false, length = 10)
	public String getStaffNo() {
		return this.staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Store_no")
	public StoreInfo getStoreInfo() {
		return this.storeInfo;
	}

	public void setStoreInfo(StoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}

	@Column(name = "Staff_name", length = 20)
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Column(name = "Basic_salary")
	public Long getBasicSalary() {
		return this.basicSalary;
	}

	public void setBasicSalary(Long basicSalary) {
		this.basicSalary = basicSalary;
	}

	@Column(name = "Commission")
	public Long getCommission() {
		return this.commission;
	}

	public void setCommission(Long commission) {
		this.commission = commission;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffInfo")
	public Set<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

}
