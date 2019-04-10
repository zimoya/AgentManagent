package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "USERS")
public class Users  implements Serializable {

	@Id
	private Long userid;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BALANCE")
	private Double balance;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "ROLEID")
	private Long roleid;

	@Column(name = "TYPEID")
	private Long typeid;

	@Column(name = "CERTIFICATEVALUE")
	private String certificatevalue;

	@Column(name = "LASTLOGINTIME")
	private java.sql.Date lastlogintime;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getCertificatevalue() {
		return certificatevalue;
	}

	public void setCertificatevalue(String certificatevalue) {
		this.certificatevalue = certificatevalue;
	}

	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
}
