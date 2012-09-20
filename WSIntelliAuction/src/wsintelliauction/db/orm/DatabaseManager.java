package wsintelliauction.db.orm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import wsintelliauction.util.AppConfig;
import wsintelliauction.util.ErrorLogger;

/**
 * 
 * Manages all object-relational database configuration and transactions,
 * using the Hibernate library, with annotations.
 * Configuration settings for this manager are specified by the
 * 'hibernate_config' property in the application property file.
 * The manager implements all basic database query functions, however
 * the {@link DatabaseManager.query()} method allows for execution
 * of HQL queries, providing greater control than the convenience methods. 
 * <br/>
 * <b>Note</b>
 * <br/>
 * All persistent classes must be annotated with the {@link javax.persistence}
 * library annotations. All persistent classes must also be specified
 * in the hibernate configuration XML file as an element.
 * 
 * @author James Lewis
 * 
 */
public class DatabaseManager {

	/**
	 * Session factory for this manager.
	 */
	private SessionFactory sessionFactory;
	/**
	 * Service registry for building a session factory.
	 */
	private ServiceRegistry serviceRegistry;

	/**
	 * Constructs a new Object-Relational database layer manager. The session
	 * factory for this instance is configured from the configuration file as
	 * specified by <b>CONFIG_FILE</b>
	 */
	public DatabaseManager() {
		configureSessionFactory();

	}

	/**
	 * Creates a new session from the session factory.
	 * 
	 * @return New session instance.
	 */
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
	 *            Object to save or update
	 */
	public void saveOrUpdate(Object tuple) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(tuple);
		transaction.commit();
		session.close();
	}

	/**
	 * Executes a database query statement and returns the result as a list of
	 * objects. <br/>
	 * <b>Note:</b> The query language is in HQL, <b>not</b> SQL. <br/>
	 * <i> The HQL language is very similar to SQL, with a few differences.
	 * Example, to query James from Team in HQL: <br/>
	 * <code>
	 * FROM Team WHERE Name='James'
	 * </code> <br/>
	 * 
	 * HQL is almost identical to SQL. A quick tutorial which describes how to
	 * use it: <br/>
	 * 
	 * <a href=
	 * "http://www.tutorialspoint.com/hibernate/hibernate_query_language.htm">
	 * HQL Tutorial</a>
	 * 
	 * @param stm
	 *            Statement to execute
	 * @return Result set
	 */
	public <E> ArrayList<E> query(String stm) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<E> table = session.createQuery(stm).list();

		transaction.commit();
		session.close();
		return (ArrayList<E>) table;
	}

	/**
	 * Removes the specified object from the database. The object in the
	 * database is removed if it matches the CLASS of the specified tuple as
	 * well as the ID.
	 * 
	 * @param tuple
	 *            Object to remove.
	 */
	public void deleteObject(Object tuple) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		session.delete(tuple);
		transaction.commit();
		session.close();
	}

	/**
	 * Returns an entire table as identified by the specified class (schema).
	 * The parameter must be specified as: ObjectClassName.class.
	 * 
	 * @param schema
	 *            Class type.
	 * @return List of all tuples in the table, or null if table doesn't exist.
	 */
	public <E> ArrayList<E> getTable(Class<E> schema) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<E> table = session.createQuery("FROM " + schema.getSimpleName())
				.list();

		transaction.commit();
		session.close();
		return (ArrayList<E>) table;
	}

	/**
	 * Checks if an object specified by the class and id exists in the database.
	 * 
	 * @param schema
	 *            Class type (use ObjectClassName.class)
	 * @param id
	 *            The primary key value of the object.
	 * @return True if exists, false otherwise.
	 */
	public <E> boolean containsID(Class<E> schema, Long id) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		boolean contains = loadByID(schema, id) == null ? false : true;
		transaction.commit();
		session.close();
		return contains;
	}

	/**
	 * Loads and returns an object which matches the specified class and
	 * identifier.
	 * 
	 * @param schema
	 *            Class type (use ObjectClassName.class)
	 * @param id
	 *            Object identifier (primary key)
	 * @return Object from the database which matches the above criteria.
	 */
	public <E> E loadByID(Class<E> schema, Long id) {
		Session session = newSession();
		Transaction transaction = session.beginTransaction();
		E obj = (E) session.get(schema, id);
		transaction.commit();
		session.close();
		return obj;
	}

	/**
	 * Configures the session factory for this manager. The hibernate
	 * configuration file is specified by the 'hibernate_config' entry in the
	 * properties file.
	 */
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

	/**
	 * Closes the session factory. Should always be called when the factory is
	 * no longer in use.
	 */
	public void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
