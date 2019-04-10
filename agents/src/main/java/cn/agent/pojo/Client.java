package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CLIENT")
public class Client  implements Serializable {

	@Column(name = "CLIENTID")
	private Long clientid;

	@Column(name = "ENTERPRISENAME")
	private String enterprisename;

	@Column(name = "ENTERPRISETYPE")
	private Long enterprisetype;

	@Column(name = "ENTERPRISEURL")
	private String enterpriseurl;

	@Column(name = "STATUS")
	private Long status;

}
