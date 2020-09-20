package creeper0809.main;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import creeper0809.data.InfectInfo;
import creeper0809.data.InfectQueryInfo;
import creeper0809.data.infectInfoid;
import creeper0809.hibernate.HibernateAnnotationUtil;

public class FreemarkerMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select a from InfectInfo a,InfectKinds b,SiDoGunNumber c where a.id.area = c.doname and a.id.infectnum = b.name",InfectInfo.class);
		Iterator<InfectInfo> queryinfo = query.getResultList().iterator();
		while(queryinfo.hasNext()) {
			InfectInfo info = queryinfo.next();
			System.out.println(info);
		}
//		Session session = sessionFactory.openSession();
//		try {
//			Query query = session.createQuery("FROM Person Where first_name=:name");
//            query.setParameter("name", name);
//            Iterator<Person> iterator = query.getResultList().iterator();
//			while(iterator.hasNext()){
//				Person person = (Person) iterator.next(); 
//				System.out.print("Find First Name: " + person.getFirstName()); 
//				System.out.print("Find Last Name: " + person.getLastName()); 
//				System.out.println("Find Salary: " + person.getSalary()); 
//			}
//		} catch (HibernateException e) {
//			e.printStackTrace(); 
//		} finally {
//			session.close(); 
//		}
	}

}
