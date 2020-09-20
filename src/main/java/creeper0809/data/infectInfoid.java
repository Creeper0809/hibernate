package creeper0809.data;

import java.awt.Composite;
import java.io.Serializable;
import java.util.Objects;

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
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass())return false;
		infectInfoid i = (infectInfoid) o;
		if(infectdate != i.infectdate) return false;
		if(area.getCityNum() != i.getArea().getCityNum()) return false;
		return infectnum.getId() == i.getInfectnum().getId();
	}
	@Override
	public int hashCode() {
		return Objects.hash(infectdate,infectnum,area);
	}
}
