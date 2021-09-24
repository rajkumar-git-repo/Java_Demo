package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersistenceUtil {

	private static SessionFactory factory = null;
	
	private PersistenceUtil() {
		
	}
	
	public static SessionFactory getSessionFactoryInstance() {
		if(factory == null) {
			StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		    Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
		     factory=meta.getSessionFactoryBuilder().build();  
		}
		return factory;
	}
}
