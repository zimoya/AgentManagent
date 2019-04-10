package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LINKMAN")
public class Linkman  implements Serializable {

	@Column(name = "LINKMANID")
	private Long linkmanid;

	@Column(name = "CLIENTID")
	private Long clientid;

	@Column(name = "NAME")
	private String name;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "FAX")
	private String fax;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DUTY")
	private String duty;

}
