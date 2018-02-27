package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	private Long id;
	private String nom, prenom, email;
	private Collection<Home> residences = new ArrayList<Home>();

	public Person() {		
	}

	public Person(String nom, String prenom, String email, Collection<Home> residences) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.residences = residences;
	}

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany
	@JoinTable(name = "PERS_HOME", joinColumns = @JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID"), 
	inverseJoinColumns = @JoinColumn(name="HOME_ID", referencedColumnName="HOME_ID"))
	public Collection<Home> getResidences() {
		return residences;
	}

	public void setResidences(Collection<Home> residences) {
		this.residences = residences;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

}
