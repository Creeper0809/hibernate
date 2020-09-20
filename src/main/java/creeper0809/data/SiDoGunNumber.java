package creeper0809.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity(name = "sidogunnum")
@Table(name = "sidogunnum")
@Setter @Getter
public class SiDoGunNumber {
	@Id
	@Column(name = "citynum",columnDefinition = "char(5)",nullable = false)
	private String cityNum;
	@Column(name = "doname",columnDefinition = "varchar(20)")
	private String doname;
	@ManyToOne
	@JoinColumn(name = "areanum")
	private SiNum sinum;
	public SiDoGunNumber(String cityNum,String name,SiNum sinum) {
		this.cityNum = cityNum;
		this.doname = name;
		this.sinum = sinum;
	}
	public SiDoGunNumber() {
		
	}
}
