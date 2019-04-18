package cn.agent.pojo;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 服务年限
 */
@Entity
@Table(name = "SERVICETIME")
public class Servicetime  implements Serializable {
	/**
	 * 服务年限id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stid;
	/**
	 * 服务年限名称
	 */
	@Column(name = "STNAME")
	private String stname;
	/**
	 * 服务年限值
	 */
	@Column(name = "STVALUE")
	private Long stvalue;

}
