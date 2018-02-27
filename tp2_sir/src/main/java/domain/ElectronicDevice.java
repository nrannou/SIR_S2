package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice {
		
	private double average;
	private long id;
	Home residence;
	
	public ElectronicDevice() {
		average = 0.00;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ED_ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	@ManyToOne
	@JoinColumn(name="HOME_ED", referencedColumnName="HOME_ID")
	public Home getResidence() {
		return residence;
	}

	public void setResidence(Home residence) {
		this.residence = residence;
	}
	@Override
	public String toString() {
		return "Equipement [id=" + id + ", average=" + average + "]";
	}
}
