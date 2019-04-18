package cn.agent.pojo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 客户
 */
@Entity
@Table(name = "CLIENT")
public class Client  implements Serializable {
	/**
	 * 客户编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientid;
	/**
	 * 用户编号
	 */
	/*@Column(name="USERSID")
	private Long usersid; //用户编号*/
	/**
	 * 用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERSID")
	private Users users;
	/**
	 * 企业名称
	 */
	@Column(name = "ENTERPRISENAME")
	private String enterprisename; //企业名称

	/*@Column(name = "ENTERPRISETYPE")
	private Long enterprisetype;  //企业类型*/
	/**
	 * 	客户类型
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPEID")
	private Types types;
	/**
	 * 企业主页
	 */
	@Column(name = "ENTERPRISEURL")
	private String enterpriseurl;
	/**
	 * 使用状态
	 */
	@Column(name = "STATUS")
	private Long status;

	/**
	 * 联系人
	 */
	@OneToMany(mappedBy = "client",cascade = CascadeType.MERGE)
	private Set<Linkman> linkmen=new HashSet<Linkman>();

	public Long getClientid() {
		return clientid;
	}

	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getEnterprisename() {
		return enterprisename;
	}

	public void setEnterprisename(String enterprisename) {
		this.enterprisename = enterprisename;
	}

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public String getEnterpriseurl() {
		return enterpriseurl;
	}

	public void setEnterpriseurl(String enterpriseurl) {
		this.enterpriseurl = enterpriseurl;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Set<Linkman> getLinkmen() {
		return linkmen;
	}

	public void setLinkmen(Set<Linkman> linkmen) {
		this.linkmen = linkmen;
	}

}
