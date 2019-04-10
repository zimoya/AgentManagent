package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TYPES")
public class Types  implements Serializable {

	@Column(name = "TYPEID")
	private Long typeid;

	@Column(name = "PARENTID")
	private Long parentid;

	@Column(name = "TYPENAME")
	private String typename;

	@Column(name = "STATUS")
	private Long status;

	@Column(name = "TYPEVALUE")
	private Long typevalue;

	@Column(name = "ACTUALVALUE")
	private Long actualvalue;

	@Column(name = "EXIST")
	private Long exist;

}
