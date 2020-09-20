package creeper0809.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import creeper0809.health.ReadScv;
import creeper0809.hibernate.HibernateAnnotationUtil;

public class SCVMain {

	public static void main(String[] args) throws IOException {
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		ReadScv readScv = new ReadScv(session);
		readScv.readSiNum();
		readScv.readSiDoGunNum();
		readScv.readInfectName();
		readScv.readInfectInfo();
		session.close();
		sessionFactory.close();
	}

}
