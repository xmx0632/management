package org.xmx0632.management.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * UserAccount.
 */
@Entity
@Table(name = "tbl_user_account")
public class UserAccount extends IdEntity {
	public static final String PLATFORM_ERP = "1";
	public static final String PLATFORM_MOBILE = "0";

	public static final String STATUS_NORMAL = "0";
	public static final String STATUS_ABNORMAL = "1";

	public static final String MALE = "0";
	public static final String FEMALE = "1";

	private String customerId;
	private String customerName;
	private String sex = MALE;
	private String mobile;
	private String telephone;
	private String province;
	private String city;
	private String district;
	private String county;
	private String address;
	private String area;
	private String zipCode;
	private String email;
	private Date birthday;
	private String platform = PLATFORM_MOBILE;
	private String username;
	private String password;
	private BigDecimal account = BigDecimal.ZERO;
	private Integer credit = 0;
	private String groupInfo;
	private String remark;
	private Date registerDate;
	private Date createTime;
	private String status = STATUS_NORMAL;

	public UserAccount() {
	}

	public UserAccount(String customerId, String customerName, String sex,
			String mobile, String city, String district, String county,
			String email, Date birthday, String username, String password) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.sex = sex;
		this.mobile = mobile;
		this.city = city;
		this.district = district;
		this.county = county;
		this.email = email;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@NotNull
	@Email
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@NotNull
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getAccount() {
		return this.account;
	}

	public void setAccount(BigDecimal account) {
		this.account = account;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getGroupInfo() {
		return this.groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Transient
	public boolean isNormal() {
		return STATUS_NORMAL.equals(status);
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", sex=" + sex
				+ ", mobile=" + mobile + ", telephone=" + telephone
				+ ", province=" + province + ", city=" + city + ", district="
				+ district + ", county=" + county + ", address=" + address
				+ ", area=" + area + ", zipCode=" + zipCode + ", email="
				+ email + ", birthday=" + birthday + ", platform=" + platform
				+ ", username=" + username + ", password=" + password
				+ ", account=" + account + ", credit=" + credit
				+ ", groupInfo=" + groupInfo + ", remark=" + remark
				+ ", registerDate=" + registerDate + ", createTime="
				+ createTime + ", status=" + status + "]";
	}

}