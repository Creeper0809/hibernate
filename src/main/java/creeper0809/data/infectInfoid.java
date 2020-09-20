package creeper0809.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
@Embeddable
@Setter @Getter
public class infectInfoid implements Serializable{
	@ManyToOne
	@JoinColumn(name = "citynum")
	private SiDoGunNumber area;
	@Column(name = "infectdate",columnDefinition = "char(8)")
	private String infectdate;
	@ManyToOne
	@JoinColumn(name = "infectnum")
	private InfectKinds infectnum;
	public infectInfoid(String date, SiDoGunNumber area,InfectKinds kinds) {
		this.area = area;
		this.infectdate = date;
		infectnum = kinds;
	}
	public infectInfoid() {
		// TODO Auto-generated constructor stub
	}
}
