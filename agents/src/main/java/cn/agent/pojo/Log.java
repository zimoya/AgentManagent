package cn.agent.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LOG")
public class Log  implements Serializable {

	@Column(name = "LOGID")
	private Long logid;

	@Column(name = "USERID")
	private Long userid;

	@Column(name = "LOGINFO")
	private String loginfo;

	@Column(name = "LOGTIME")
	private java.sql.Date logtime;

}
