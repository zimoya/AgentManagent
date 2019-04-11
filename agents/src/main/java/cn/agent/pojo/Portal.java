package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PORTAL")
public class Portal  implements Serializable {

	@Id
	@Column(name = "PORTALID")
	private Long portalid;

	@Column(name = "CLIENTID")
	private Long clientid;

	@Column(name = "CORPORATE")
	private String corporate;

	@Column(name = "PAPERSTYPE")
	private Long paperstype;

	@Column(name = "PAPERSVALUE")
	private String papersvalue;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "FAX")
	private String fax;

	@Column(name = "CREATETIME")
	private java.sql.Date createtime;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "PROVINCE")
	private String province;

	@Column(name = "CRTY")
	private String crty;

	@Column(name = "DISTRICT")
	private String district;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "REMARK")
	private String remark;

}
