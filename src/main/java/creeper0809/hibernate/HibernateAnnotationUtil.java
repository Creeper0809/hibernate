package creeper0809.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import creeper0809.data.InfectInfo;
import creeper0809.data.InfectKinds;
import creeper0809.data.SiDoGunNumber;
import creeper0809.data.SiNum;
import creeper0809.data.infectInfoid;

public class HibernateAnnotationUtil {
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

	static {
		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

			// 예제1
			configuration.addAnnotatedClass(SiNum.class);
			configuration.addAnnotatedClass(SiDoGunNumber.class);
			configuration.addAnnotatedClass(InfectKinds.class);
			configuration.addAnnotatedClass(InfectInfo.class);
			configuration.addAnnotatedClass(infectInfoid.class);

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
