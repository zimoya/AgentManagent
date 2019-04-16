package cn.agent.pojo;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * log日志表
 */
@Entity
@Table(name = "LOG")
public class Log  implements Serializable {
	/**
	 * 日志id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logid;
/*	*//**
	 * 用户id
	 *//*
	@Column(name = "USERID")
	private Long userid;*/
	/**
	 * 用户
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="USERID")
	private Users users;

	/**
	 * 日志信息
	 */
	@Column(name = "LOGINFO")
	private String loginfo;
	/**
	 * 操作信息
	 */
	@Column(name = "LOGTIME")
	private Date logtime;

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

/*	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}*/

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getLoginfo() {
		return loginfo;
	}

	public void setLoginfo(String loginfo) {
		this.loginfo = loginfo;
	}

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}

}
