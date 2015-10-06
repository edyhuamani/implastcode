package pe.com.implast.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static ServiceRegistry serviceRegistry;
	static SessionFactory sessionFactory;
	
	static{
		
		Configuration cfg=new Configuration().configure("hiberate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	    cfg.getProperties()). build();
		cfg.buildSessionFactory(serviceRegistry);
		
	}
	
	
	public static SessionFactory getFactorySession(){
		
		
		
		return sessionFactory;
	}
}
