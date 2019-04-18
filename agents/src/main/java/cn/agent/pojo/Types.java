package cn.agent.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 类型
 */
@Entity
@Table(name = "TYPES")
public class Types  implements Serializable {
	/**
	 * 类型编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long typeid;
	/**
	 * 父类编号
	 */
	@Column(name = "PARENTID")
	private Long parentid;
	/**
	 * 类型名称
	 */
	@Column(name = "TYPENAME")
	private String typename;
	/**
	 * 状态，是否启用
	 */
	@Column(name = "STATUS")
	private Long status;
	/**
	 * 类型数值
	 */
	@Column(name = "TYPEVALUE")
	private Long typevalue;
	/**
	 * 实际数值
	 */
	@Column(name = "ACTUALVALUE")
	private Long actualvalue;
	/**
	 * 存在表示，是否存在
	 */
	@Column(name = "EXIST")
	private Long exist;
	/**
	 * 财务明细
	 */
	@OneToMany( mappedBy = "types",cascade = CascadeType.MERGE)
	private Set<Finance> finances=new HashSet<Finance>();
	/**
	 * 客户
	 */
	@OneToMany(mappedBy = "types",cascade = CascadeType.MERGE)
	private Set<Client> clients=new HashSet<Client>();
	/**
	 * 门户
	 */
	@OneToMany(mappedBy = "types",cascade = CascadeType.MERGE)
	private  Set<Portal> portals=new HashSet<Portal>();
	/**
	 * 关键字
	 */
	@OneToMany(mappedBy = "types",cascade = CascadeType.MERGE)
	private Set<Keyword> keywords=new HashSet<Keyword>();
	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getTypevalue() {
		return typevalue;
	}

	public void setTypevalue(Long typevalue) {
		this.typevalue = typevalue;
	}

	public Long getActualvalue() {
		return actualvalue;
	}

	public void setActualvalue(Long actualvalue) {
		this.actualvalue = actualvalue;
	}

	public Long getExist() {
		return exist;
	}

	public void setExist(Long exist) {
		this.exist = exist;
	}

	public Set<Finance> getFinances() {
		return finances;
	}

	public void setFinances(Set<Finance> finances) {
		this.finances = finances;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Portal> getPortals() {
		return portals;
	}

	public void setPortals(Set<Portal> portals) {
		this.portals = portals;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}
}
