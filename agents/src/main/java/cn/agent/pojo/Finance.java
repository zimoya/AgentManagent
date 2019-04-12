package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 财务明细
 */
@Entity
@Table(name = "FINANCE")
public class Finance  implements Serializable {
	/**
	 * 财务明细编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long finaid;  //财务明细编号

	/*@Column(name = "USERID")
	private Long userid;  //用户编号*/
	/**
	 * 用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USERID")
	private Users users;

	/*@Column(name = "FINATYPE")
	private String finatype; //财务类型*/
	/**
	 * 财务类型
	 */
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="TYPEID")
	private Types types;
	/**
	 * 账户余额
	 */
	@Column(name = "BALANCE")
	private Double balance;
	/**
	 * 操作资金
	 */
	@Column(name = "OPERATIONMONEY")
	private Double operationmoney;
	/**
	 * 操作描述
	 */
	@Column(name = "DESCRIPTION")
	private String description;
	/**
	 *操作时间
	 */
	@Column(name = "CREATETIME")
	private Date createtime;

	public Long getFinaid() {
		return finaid;
	}

	public void setFinaid(Long finaid) {
		this.finaid = finaid;
	}

	/*public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}*/

	/*public String getFinatype() {
		return finatype;
	}

	public void setFinatype(String finatype) {
		this.finatype = finatype;
	}*/

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getOperationmoney() {
		return operationmoney;
	}

	public void setOperationmoney(Double operationmoney) {
		this.operationmoney = operationmoney;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}
}
