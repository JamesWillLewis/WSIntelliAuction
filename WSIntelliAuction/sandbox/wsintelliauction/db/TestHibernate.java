package wsintelliauction.db;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import wsintelliauction.util.AppConfig;

public class TestHibernate {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;


	public static void main(String[] args) {


	
		Session session = configureSessionFactory().openSession();
		TestObject testObject = new TestObject("James", "Lewis", 21);
		Transaction tx = session.beginTransaction();
		
		
		session.saveOrUpdate(testObject);

		tx.commit();
		session.close();
		
	}
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure(new File(AppConfig.getProperty("hibernate_config")));
	    

		new SchemaExport(configuration).create(true, true);
	    
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}


}
