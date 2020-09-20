package creeper0809.health;

import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;

import creeper0809.data.InfectKinds;

public class ReadInfectName implements Scvs{
	ArrayList<InfectKinds> infectkind = new ArrayList<InfectKinds>();
	@Override
	public void readScv(Session session) throws IOException {
		session.beginTransaction();
		session.save(new InfectKinds("감기",1));
		infectkind.add(new InfectKinds("감기",1));
		session.save(new InfectKinds("눈병",2));
		infectkind.add(new InfectKinds("눈병",2));
		session.save(new InfectKinds("천식",3));
		infectkind.add(new InfectKinds("천식",3));
		session.save(new InfectKinds("피부염",4));
		infectkind.add(new InfectKinds("피부염",4));
		session.getTransaction().commit();
	}
	public InfectKinds getInfect(String name) { 
		for (int i = 0; i < infectkind.size(); i++) {
			if (infectkind.get(i).getName().equals(name))
				return infectkind.get(i);
		}
		return null;
	}
}
