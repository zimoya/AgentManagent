package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 */
@Entity
@Table(name = "ROLE")
public class Role  implements Serializable {
	/**
	 * 角色id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleid;
	/**
	 * 角色名
	 */
	@Column(name = "ROLENAME")
	private String rolename;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATETIME")
	private java.sql.Date createtime;
	/**
	 * 是否启用
	 */
	@Column(name = "STATUS")
	private Long status;
	/**
	 * 是否存在
	 */
	@Column(name="EXISTSTATUS")
	private Long existstatus;
	/**
	 * 用户
	 */
	@OneToMany(mappedBy = "role",cascade = CascadeType.MERGE)
	private Set<Users> users=new HashSet<Users>();
	/**
	 * 权限
	 */
	@ManyToMany(targetEntity = Jurisdiction.class,cascade = CascadeType.MERGE)
	private Set<Jurisdiction> jurisdictions=new HashSet<Jurisdiction>();

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getExiststatus() {
		return existstatus;
	}

	public void setExiststatus(Long existstatus) {
		this.existstatus = existstatus;
	}
}
