package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "FINANCE")
public class Finance  implements Serializable {
	@Id
	@Column(name = "FINAID")
	private Long finaid;

	@Column(name = "USERID")
	private Long userid;

	@Column(name = "FINATYPE")
	private String finatype;

	@Column(name = "BALANCE")
	private Double balance;

	@Column(name = "OPERATIONMONEY")
	private Double operationmoney;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATETIME")
	private java.sql.Date createtime;

}
