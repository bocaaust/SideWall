/**
 * 
 */
package com.mudit.SideWall.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Mudit
 * @since Jan 27, 2017
 */
@XmlRootElement
@Entity
public class Job{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="job_seq")
	@SequenceGenerator(
	    name="job_seq",
	    sequenceName="job_sequence",
	    allocationSize=20
	)
	@Column(name="JOB_ID")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="contactNumber")
	private String contactNumber;
	@Column(name="email")
	private String email;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private int pincode;
	private float latitude;
	private float longitude;
	@JoinColumn(name="offeredBy")
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private User offeredBy;;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="jobs_users",
             joinColumns=
             @JoinColumn(name="job_id", referencedColumnName="JOB_ID"),
       inverseJoinColumns=
             @JoinColumn(name="user_id", referencedColumnName="USER_ID")
     )
	@Fetch(FetchMode.SELECT)
	private List<User> interestedUser;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLine1() {
		return line1;
	}
	
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	
	public String getLine2() {
		return line2;
	}
	
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getPincode() {
		return pincode;
	}
	
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public User getOfferedBy() {
		return offeredBy;
	}
	
	public void setOfferedBy(User offeredBy) {
		this.offeredBy = offeredBy;
	}
	
	public List<User> getInterestedUser() {
		return interestedUser;
	}
	
	public void setInterestedUser(List<User> interestedUser) {
		this.interestedUser = interestedUser;
	}

	public Job() {
		super();
	}

	public Job(String title, String description, String contactNumber, String email, String line1, String line2,
			String city, String state, int pincode, float latitude, float longitude, User offeredBy,
			List<User> interestedUser) {
		super();
		this.title = title;
		this.description = description;
		this.contactNumber = contactNumber;
		this.email = email;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.offeredBy = offeredBy;
		this.interestedUser = interestedUser;
	}

	public Job(int id, String title, String description, String contactNumber, String email, String line1, String line2,
			String city, String state, int pincode, float latitude, float longitude, User offeredBy,
			List<User> interestedUser) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.contactNumber = contactNumber;
		this.email = email;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.offeredBy = offeredBy;
		this.interestedUser = interestedUser;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", contactNumber="
				+ contactNumber + ", email=" + email + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", offeredBy=" + offeredBy + ", interestedUser=" + interestedUser + "]";
	}
	
}
