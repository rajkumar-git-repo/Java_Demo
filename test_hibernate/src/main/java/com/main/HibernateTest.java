package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.entity.ActiveEmployee;
import com.entity.Answer;
import com.entity.Customer;
import com.entity.EOAddress;
import com.entity.EOPerson;
import com.entity.Employee;
import com.entity.Order;
import com.entity.Question;
import com.entity.RetiredEmployee;
import com.entity.Student;
import com.entity.University;

import util.PersistenceUtil;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = PersistenceUtil.getSessionFactoryInstance();
		Session session = factory.openSession();
		session.getTransaction().begin();
		
		//List<EOPerson> eopPersons = session.createQuery("from EOPerson p join fetch p.addresses",EOPerson.class).getResultList();
		
		Criteria criteria = session.createCriteria(EOPerson.class);
		criteria.setFetchMode("addresses", FetchMode.EAGER);
		criteria.add(Restrictions.eq("id", 1));
		List<EOPerson> eopPersons = criteria.list();
		
		for(EOPerson eoPerson : eopPersons) {
			System.out.println("Name:"+eoPerson.getName());
			List<EOAddress> eoAddresses = eoPerson.getAddresses();//session.createQuery("from EOAddress a where a.eoPerson.id =:id").setParameter("id", eoPerson.getId()).getResultList();
			for(EOAddress address : eoAddresses) {
				System.out.println("City :"+address.getCity()+" State:"+address.getState()+" Country:"+address.getCountry());
			}
		}
		
		session.getTransaction().commit();
		factory.close();

	}
}
