package com.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.EOAddress;
import com.entity.EOPerson;

public class Test {

	public static void main(String[] args) {

		EOAddress eoAddress1 = new EOAddress("Delhi", "NCR", "Inida");
		EOAddress eoAddress2 = new EOAddress("Lucknow", "UP", "Inida");
		EOAddress eoAddress3 = new EOAddress("Patna", "BIHAR", "Inida");
		EOAddress eoAddress4 = new EOAddress("Mumbai", "MAHARASTRA", "Inida");
		EOAddress eoAddress5 = new EOAddress("Ludhiana", "PUNJAB", "Inida");
		EOAddress eoAddress6 = new EOAddress("Jaipur", "RAJSTHAN", "Inida");
		EOAddress eoAddress7 = new EOAddress("Indore", "MP", "Inida");
		
		EOPerson eoPerson1 = new EOPerson("AAA", "aaa@gmail.com", 1000);
		EOPerson eoPerson2 = new EOPerson("BBB", "bbb@gmail.com", 500);
		EOPerson eoPerson3 = new EOPerson("CCC", "ccc@gmail.com", 2000);
		EOPerson eoPerson4 = new EOPerson("DDD", "ddd@gmail.com", 1500);
		List<EOAddress> list1 = new ArrayList<EOAddress>();
		list1.add(eoAddress1);
		list1.add(eoAddress2);
		eoAddress1.setEoPerson(eoPerson1);
		eoAddress2.setEoPerson(eoPerson1);
		
		List<EOAddress> list2 = new ArrayList<EOAddress>();
		list2.add(eoAddress3);
		list2.add(eoAddress4);
		eoAddress3.setEoPerson(eoPerson2);
		eoAddress4.setEoPerson(eoPerson2);
		
		List<EOAddress> list3 = new ArrayList<EOAddress>();
		list3.add(eoAddress5);
		eoAddress5.setEoPerson(eoPerson3);
		
		List<EOAddress> list4 = new ArrayList<EOAddress>();
		list4.add(eoAddress6);
		list4.add(eoAddress7);
		eoAddress6.setEoPerson(eoPerson4);
		eoAddress7.setEoPerson(eoPerson4);
		
		eoPerson1.setAddresses(list1);
		eoPerson2.setAddresses(list2);
		eoPerson3.setAddresses(list3);
		eoPerson4.setAddresses(list4);
	}
}
