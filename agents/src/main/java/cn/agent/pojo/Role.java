package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ROLE")
public class Role  implements Serializable {

	@Column(name = "ROLEID")
	private Long roleid;

	@Column(name = "ROLENAME")
	private String rolename;

	@Column(name = "CREATETIME")
	private java.sql.Date createtime;

	@Column(name = "STATUS")
	private Long status;

}
