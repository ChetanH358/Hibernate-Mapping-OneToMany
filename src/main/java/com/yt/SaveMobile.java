package com.yt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMobile {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile1 = new Mobile();
		mobile1.setBrand("realme");
		mobile1.setCost(40000);
		mobile1.setColor("black");
		mobile1.setRAM("6GB");

		Mobile mobile2 = new Mobile();
		mobile2.setBrand("vivo");
		mobile2.setCost(28000);
		mobile2.setColor("blue");
		mobile2.setRAM("6GB");

		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("4G");
		sim1.setPhno(9858431610l);
		sim1.setCost(350);

		Sim sim2 = new Sim();
		sim2.setProvider("BSNL");
		sim2.setType("3G");
		sim2.setPhno(9858431615l);
		sim2.setCost(300);

		Sim sim3 = new Sim();
		sim3.setProvider("jio");
		sim3.setType("4G");
		sim3.setPhno(9858431475l);
		sim3.setCost(399);

		Sim sim4 = new Sim();
		sim4.setProvider("VI");
		sim4.setType("4G");
		sim4.setPhno(9858431620l);
		sim4.setCost(250);

		List<Sim> list_1 = new ArrayList<Sim>();
		list_1.add(sim1);
		list_1.add(sim2);

		List<Sim> list_2 = new ArrayList<Sim>();
		list_2.add(sim3);
		list_2.add(sim4);

		mobile1.setSims(list_1);
		mobile2.setSims(list_2);

		entityTransaction.begin();
		entityManager.persist(mobile1);
		entityManager.persist(mobile2);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		entityManager.persist(sim4);
		entityTransaction.commit();

	}

}
