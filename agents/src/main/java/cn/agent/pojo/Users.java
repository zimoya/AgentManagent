package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
@Entity
@Table(name = "USERS")
public class Users  implements Serializable {
	/**
	 * 用户编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	/**
	 * 用户名称
	 */
	@Column(name = "USERNAME")
	private String username;
	/**
	 * 密码
	 */
	@Column(name = "PASSWORD")
	private String password;
	/**
	 * 姓名
	 */
	@Column(name = "NAME")
	private String name;
	/**
	 * 账户余额
	 */
	@Column(name = "BALANCE")
	private Double balance;
	/**
	 * 电话
	 */
	@Column(name = "TELEPHONE")
	private String telephone;
	/**
	 * 证件类型id
	 */
	@Column(name = "TYPEID")
	private Long typeid;
	/**
	 * 证件编号
	 */
	@Column(name = "CERTIFICATEVALUE")
	private String certificatevalue;
	/**
	 * 最后一次登录时间
	 */
	@Column(name = "LASTLOGINTIME")
	private Date lastlogintime; //最后一次登录时间
	/**
	 * 角色
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ROLEID")
	private Role role;

	/**
	 * 财务明细
	 */
	@OneToMany(mappedBy = "users",cascade = CascadeType.MERGE)
	private Set<Finance> finances=new HashSet<Finance>();
	/**
	 * 日志
	 */
	@OneToMany(mappedBy = "users",cascade = CascadeType.MERGE)
	private Set<Log> logs=new HashSet<Log>();
	/**
	 * 客户
	 */
	@OneToMany(mappedBy = "users",cascade = CascadeType.MERGE)
	private Set<Client> clients=new HashSet<Client>();
	/**
	 * 关键字
	 */
	@OneToMany(mappedBy = "users",cascade = CascadeType.MERGE)
	private Set<Keyword> keywords=new HashSet<Keyword>();

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Set<Finance> getFinances() {
		return finances;
	}

	public void setFinances(Set<Finance> finances) {
		this.finances = finances;
	}

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}
}
