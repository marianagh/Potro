package mx.itson.potro.entidades;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Define el inicio de sesion de  Hibernate.
 * @author Mariana Garcia
 *
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static
	{
	    try 
	    { 
	    	Configuration configuration=new Configuration().configure();
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    } catch (HibernateException ex) 
	    { 
	        System.err.println("Ocurri� un error al inicializar la configuraci�n de Hibernate: " + ex); 
	        throw new HibernateException(ex); 
	    } 
	}
	
	/**
	 * Obtiene la sesi�n activa de Hibernate.
	 * @return Sesi�n de Hibernate de tipo SessionFactory.
	 */
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}