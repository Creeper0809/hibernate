package creeper0809.data;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity(name = "sinum")
@Table(name = "sinum")
@Setter @Getter
public class SiNum {
	@Id
	@Column(name = "areanum",columnDefinition = "char(2)",nullable = false)
	private String areanum;
	@Column(name = "siname",columnDefinition = "varchar(20)")
	private String siname;
	public SiNum(String areanum,String name) {
		this.siname = name;
		this.areanum = areanum;
	}
	public SiNum() {
		// TODO Auto-generated constructor stub
	}
}
