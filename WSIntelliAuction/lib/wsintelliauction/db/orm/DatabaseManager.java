package wsintelliauction.db.orm;

import java.io.File;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import wsintelliauction.db.TestObject;
import wsintelliauction.util.AppConfig;
import wsintelliauction.util.ErrorLogger;

public class DatabaseManager {

	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	/**
	 * Constructs a new Object-Relational database layer manager. The session
	 * factory for this instance is configured from the configuration file as
	 * specified by <b>CONFIG_FILE</b>
	 */
	public DatabaseManager() {
		configureSessionFactory();

	}

	private Session newSession() {
		return sessionFactory.openSession();
	}

	/**
	 * If the tuple doesn't exist in the tuplet's table, it is appended to the
	 * table. If the tuple already exists, the tuple is is updated. If the table
	 * doesn't exist for the tuple's schema, the schema is exported to the
	 * database and the tuple is appended.
	 * 
	 * @param tuplet
	 */
	public void saveOrUpdate(Object tuple) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(tuple);
		transaction.commit();
		session.close();
	}

	public void delete(Object tuple) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		session.delete(tuple);
		transaction.commit();
		session.close();
	}

	public List query(Class table) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		List result = session.createQuery("from "+table).list();
	
		transaction.commit();
		session.close();
		
		return result;
	}

	private void configureSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure(new File(AppConfig
					.getProperty("hibernate_config")));
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException e) {
			ErrorLogger.log(e.getMessage());
		}
	}

	public void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
