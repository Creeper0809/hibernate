package creeper0809.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "kindinfect")
@Table(name = "kindinfect")
@Setter
@Getter
public class InfectKinds {
	@Id
	@Column(name = "infectnum", columnDefinition = "int", nullable = false)
	private int id;
	@Column(name = "infectname", columnDefinition = "varchar(20)")
	private String name;

	public InfectKinds(String name,int num) {
		id = num;
		this.name = name;
	}
	public InfectKinds() {
	}
}
