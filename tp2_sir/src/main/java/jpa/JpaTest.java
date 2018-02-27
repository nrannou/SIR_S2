package jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			test.createPerson();
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		test.listPerson();

		manager.close();
		System.out.println("ok");
	}

	private void createPerson() {
			//Creation résidence et ajout à la collection
			Collection<Home> residences = new ArrayList<Home>();
			Home residence = new Home();
			residences.add(residence);

			//Creation de person
			Person p1 = new Person("Briac", "Perrin", "perrinbriac@gmail.com", residences);
			Person p2 = new Person("Nicolas", "Rannou", "nicolasrannou@gmail.com", residences);
			

			//Creation de chauffages et ajout à la collection.
			Collection<Heater> chauffages = new ArrayList<Heater>();
			Heater h1 = new Heater(1000);
			Heater h2 = new Heater(1000);
			chauffages.add(h1);
			chauffages.add(h2);
			//Affectation du chauffage a la residence
			h1.setResidence(residence);
			h2.setResidence(residence);
			residence.setChauffages(chauffages);

			
			//Creation des equipement electronique et ajout a la collection 
			Collection<ElectronicDevice> equipements = new ArrayList<ElectronicDevice>();
			ElectronicDevice ed1 = new ElectronicDevice();
			ElectronicDevice ed2 = new ElectronicDevice();
			equipements.add(ed1);
			equipements.add(ed2);
			//Affectation des equipement electronique a la residence
			ed1.setResidence(residence);
			ed2.setResidence(residence);
			residence.setEquipements(equipements);
			
			//Ecriture en base sur le prochain commit de la transaction dans laquelle on se trouve.
			manager.persist(residence);
			manager.persist(h1);
			manager.persist(h2);
			manager.persist(ed1);
			manager.persist(ed2);
			manager.persist(p1);
			manager.persist(p2);
	}

	private void listPerson() {
		List<Person> resultListP = manager.createQuery("Select p From Person p", Person.class).getResultList();
		System.out.println("num of employess:" + resultListP.size());
		for (Person person : resultListP) {
			System.out.println("next employee: " + person);
		}
	}
	
	public List<Person> getPersons() {
		return manager.createQuery("Select p From Person p", Person.class).getResultList();		
	}
}
