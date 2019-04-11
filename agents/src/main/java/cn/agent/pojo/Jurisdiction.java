package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "JURISDICTION")
public class Jurisdiction  implements Serializable {
	@Id
	@Column(name = "JDID")
	private Long jdid;

	@Column(name = "JDNAME")
	private String jdname;

	@Column(name = "JDURL")
	private String jdurl;

	@Column(name = "CREATETIME")
	private java.sql.Date createtime;

	@Column(name = "STATUS")
	private Long status;

}
