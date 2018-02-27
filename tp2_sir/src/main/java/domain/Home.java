package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Home {

	private int nbPiece;
	private long id, taille;
	private Collection<Heater> chauffages = new ArrayList<Heater>();
	private Collection<ElectronicDevice> equipements = new ArrayList<ElectronicDevice>();
	private Collection<Person> owners;
	
	public Home() {
	}
	
	public Home(long id, long taille, int nbPiece, Collection<Heater> chauffages,Collection<ElectronicDevice> equipements) {
		this.id = id;
		this.taille = taille;
		this.nbPiece = nbPiece;
		this.chauffages = chauffages;
		this.equipements = equipements;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "HOME_ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTaille() {
		return taille;
	}
	public void setTaille(long taille) {
		this.taille = taille;
	}
	public int getNbPiece() {
		return nbPiece;
	}
	public void setNbPiece(int nbPiece) {
		this.nbPiece = nbPiece;
	}
	

	@ManyToMany(mappedBy="residences")
	public Collection<Person> getOwners() {
		return owners;
	}

	public void setOwners(Collection<Person> owners) {
		this.owners = owners;
	}

	@OneToMany(mappedBy="residence")
	public Collection<Heater> getChauffages() {
		return chauffages;
	}
	public void setChauffages(Collection<Heater> chauffages) {
		this.chauffages = chauffages;
	}
	
	@OneToMany(mappedBy="residence")
	public Collection<ElectronicDevice> getEquipements() {
		return equipements;
	}
	public void setEquipements(Collection<ElectronicDevice> equipements) {
		this.equipements = equipements;
	}

	@Override
	public String toString() {
		return "Residence [id=" + id + ", taille=" + taille + ", nbPiece=" + nbPiece + "]";
	}	
}
