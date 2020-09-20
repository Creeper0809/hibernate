package creeper0809.data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "infectinfo")
@Table(name = "infectinfo")
@Setter
@Getter
public class InfectInfo {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	@EmbeddedId
	private infectInfoid id;
	@Column(name = "HowMany", columnDefinition = "varchar(20)")
	private String howMany;

	public InfectInfo(String howMany, infectInfoid id) {
		this.id = id;
		this.howMany = howMany;
	}

	public InfectInfo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return id.getArea().getDoname()+"에서 "+id.getInfectdate()+"날에 "+getHowMany()+"만큼"+id.getInfectnum().getName()+"이 발생하였습니다.";
	}
}
