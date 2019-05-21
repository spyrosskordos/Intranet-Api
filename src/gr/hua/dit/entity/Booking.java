package gr.hua.dit.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Booking")
@Table(name = "bookings")
@Entity

public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4310661683443846471L;

	/**
	 * 
	 */

	
	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private Time time;
	
	@Column(name = "username")
	private String username;
	@Id	
	@Column(name = "vehicleToCheck")
	private String vehicleToCheck;

	@Column(name = "confirmed")
	private boolean confirmed;

	public Booking() {
	}

	
	public Booking( Date date, Time time, String username, String vehicleToCheck, boolean confirmed) {
		super();
	
		this.date = date;
		this.time = time;
		this.username = username;
		this.vehicleToCheck = vehicleToCheck;
		this.confirmed = confirmed;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getVehicleToCheck() {
		return vehicleToCheck;
	}


	public void setVehicleToCheck(String vehicleToCheck) {
		this.vehicleToCheck = vehicleToCheck;
	}


	public boolean isConfirmed() {
		return confirmed;
	}


	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Booking [date=" + date + ", time=" + time + ", username=" + username + ", vehicleToCheck="
				+ vehicleToCheck + ", confirmed=" + confirmed + "]";
	}

}