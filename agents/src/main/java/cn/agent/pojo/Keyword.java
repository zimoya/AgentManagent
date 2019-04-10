package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "KEYWORD")
public class Keyword  implements Serializable {

	@Column(name = "KWID")
	private Long kwid;

	@Column(name = "CLIENTID")
	private Long clientid;

	@Column(name = "USERID")
	private Long userid;

	@Column(name = "KWNAME")
	private String kwname;

	@Column(name = "TYPESID")
	private Long typesid;

	@Column(name = "APPLYLIMIT")
	private Long applylimit;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "APPLYTIME")
	private java.sql.Date applytime;

	@Column(name = "LASTTIME")
	private java.sql.Date lasttime;

	@Column(name = "STATUS")
	private Long status;

	@Column(name = "AUDITSTATUS")
	private Long auditstatus;

	@Column(name = "USESTATUS")
	private Long usestatus;

}
