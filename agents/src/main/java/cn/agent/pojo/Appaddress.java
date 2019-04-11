package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "APPADDRESS")
public class Appaddress  implements Serializable {

	@Id
	@Column(name = "APPID")
	private Long appid;

	@Column(name = "CONFIGNAME")
	private String configname;

	@Column(name = "CONFIGVALUE")
	private String configvalue;

	public
	Long getAppid() {
		return appid;
	}

	public
	void setAppid(Long appid) {
		this.appid = appid;
	}

	public
	String getConfigname() {
		return configname;
	}

	public
	void setConfigname(String configname) {
		this.configname = configname;
	}

	public
	String getConfigvalue() {
		return configvalue;
	}

	public
	void setConfigvalue(String configvalue) {
		this.configvalue = configvalue;
	}
}
