package com.yt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteMobile {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

/*		deletes mobile (2-nd is vivo) as well as sims assosiated with vivo ->  
 * 		Mobile_id   sims_id
 *		   2	      3
 *		   2	      4   <== gets's deleted where as 1->Airtel 2->BSNL 3->jio & 4->VI are still exist in the sim-table
 */
		
/* 		NOTE :- In OneToMany Mapping we can delete mobile directly. along with mobile (primary_key)
 *		corresponding primary key of sims get deleted automatically. but as per above 
 *		example sim 1,2,3,4 remain as it is in sims table
 */		
		
		Mobile mobile_2 = entityManager.find(Mobile.class, 2);
//		along with mobile-2 sim_id |2|3| and sim_id |2|4| got deleted (because of primary key)

//		if we attempting to delete (id) which is not present in data-base it will give "Data Not Found"
//		if (mobile_2 != null) {
//			entityTransaction.begin();
//			entityManager.remove(mobile_2);
//			entityTransaction.commit();
//			System.out.println("data deleted");
//
//		} else {
//			System.out.println("Data Not Found !");
//		}

		/* deleting sims from Sim Table */
		
//		NOTE:- In OneToMany Mapping unable to delete sim-1 & sim-2 directly
/*		so for that we need to find all child classes and lastly find parent class . then delete every thing including child and parenet class
 * 		in this case mobile is parent class and sims are child class
 * 		find child classes i.e Sim first then find parent class i.e Mobile delete all 
 * 		in this way we can delete mobile from mobile table , sims from sim table , Mobile_id & Sims_id table as well
 * 
*/
		
		Sim sim_1 = entityManager.find(Sim.class, 1);
		Sim sim_2 = entityManager.find(Sim.class, 2);
		Mobile mobile_1 = entityManager.find(Mobile.class,1);

//		if we attempting to delete (id) which is not present in data-base it will give "Data Not Found"
		
		if (sim_1 != null && sim_2 != null) {
			entityTransaction.begin();
			entityManager.remove(sim_1);
			entityManager.remove(sim_2);
			entityManager.remove(mobile_1);
			entityTransaction.commit();
			System.out.println("data deleted");

		} else {
			System.out.println("Data Not Found !");
		}
//
	}

}
