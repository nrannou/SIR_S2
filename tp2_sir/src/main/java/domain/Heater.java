package domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Heater {
	
	private long id, puissance;
	Home residence = new Home();
	
	
	public Heater(long puissance) {
		this.puissance = puissance;
	}

	public Heater() {
	}
	
	@Id
	@GeneratedValue
	@Column(name = "CHAUFFAGE_ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getPuissance() {
		return puissance;
	}

	public void setPuissance(long puissance) {
		this.puissance = puissance;
	}

	@ManyToOne
	@JoinColumn(name="HOME_HEATER", referencedColumnName="HOME_ID")
	public Home getResidence() {
		return residence;
	}

	public void setResidence(Home residence) {
		this.residence = residence;
	}


	@Override
	public String toString() {
		return "Chauffage [id=" + id + "]";
	}	
}
