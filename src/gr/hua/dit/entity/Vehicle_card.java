package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Vehicle")
@Entity
@Table(name = "vehicle_card")
public class Vehicle_card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */

	@Id
	@Column(name = "license_plate")
	private String license_plate;

	@Column(name = "inspection_date")
	private String inspection_date;

	@Column(name = "next_inspection_date")
	private String next_inspection_date;

	@Column(name = "model")
	private String model;

	@Column(name = "cc")
	private int cc;

	@Column(name = "results")
	private String results;

	public Vehicle_card() {
	}

	public Vehicle_card(String license_plate, String inspection_date, String next_inspection_date, String model, int cc,
			String results) {
		super();
		this.license_plate = license_plate;
		this.inspection_date = inspection_date;
		this.next_inspection_date = next_inspection_date;
		this.model = model;
		this.cc = cc;
		this.results = results;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public String getInspection_date() {
		return inspection_date;
	}

	public void setInspection_date(String inspection_date) {
		this.inspection_date = inspection_date;
	}

	public String getNext_inspection_date() {
		return next_inspection_date;
	}

	public void setNext_inspection_date(String next_inspection_date) {
		this.next_inspection_date = next_inspection_date;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Vehicle_card [license_plate=" + license_plate + ", inspection_date=" + inspection_date
				+ ", next_inspection_date=" + next_inspection_date + ", model=" + model + ", cc=" + cc + ", results="
				+ results + "]";
	}

}