package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VehicleDB")
@Entity
@Table(name = "vehicleDB")
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "license_plate")
	private String license_plate;

	@Column(name = "insurance")
	private String insurance;

	@Column(name = "type")
	private String type;

	@Column(name = "sub_type")
	private int sub_type;

	public Vehicle() {
	}

	public Vehicle(String license_plate, String insurance, String type, int sub_type) {
		super();
		this.license_plate = license_plate;
		this.insurance = insurance;
		this.type = type;
		this.sub_type = sub_type;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSub_type() {
		return sub_type;
	}

	public void setSub_type(int sub_type) {
		this.sub_type = sub_type;
	}

	@Override
	public String toString() {
		return "Vehicle [license_plate=" + license_plate + ", insurance=" + insurance + ", type=" + type + ", sub_type="
				+ sub_type + "]";
	}

}