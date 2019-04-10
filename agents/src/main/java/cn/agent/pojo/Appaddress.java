package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "APPADDRESS")
public class Appaddress  implements Serializable {

	@Column(name = "APPID")
	private Long appid;

	@Column(name = "CONFIGNAME")
	private String configname;

	@Column(name = "CONFIGVALUE")
	private String configvalue;

}
