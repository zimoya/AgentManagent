package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "REROLEJD")
public class Rerolejd  implements Serializable {
	@Id
	@Column(name = "ROID")
	private Long roid;

	@Column(name = "JDID")
	private Long jdid;

}
