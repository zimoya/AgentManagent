package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "SERVICETIME")
public class Servicetime  implements Serializable {

	@Column(name = "STID")
	private Long stid;

	@Column(name = "STNAME")
	private String stname;

	@Column(name = "STVALUE")
	private Long stvalue;

}
