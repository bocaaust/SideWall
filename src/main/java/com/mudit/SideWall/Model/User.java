/**
 * 
 */
package com.mudit.SideWall.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Mudit
 * @since Jan 27, 2017
 */
@XmlRootElement
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_seq")
	@SequenceGenerator(
	    name="user_seq",
	    sequenceName="user_sequence",
	    allocationSize=20
	)
	@Column(name="USER_ID")
	private int id;
	@Column(name="email",unique=true)
	private String email;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="password")
	private String password;
	@Column(name="createdOn")
	private Date createdOn;
	@Column(name="lastLogin")
	private Date lastLogin;
	@Column(name="lattitude")
	private float lattitude;
	@Column(name="longitude")
	private float longitude;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String pincode;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Date getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public float getLattitude() {
		return lattitude;
	}
	
	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
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
	
	public String getPincode() {
		return pincode;
	}
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public User() {
		super();
	}

	public User(String email, String firstName, String lastName, String password, Date createdOn, Date lastLogin,
			float lattitude, float longitude, String line1, String line2, String city, String state, String pincode) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public User(int id, String email, String firstName, String lastName, String password, Date createdOn,
			Date lastLogin, float lattitude, float longitude, String line1, String line2, String city, String state,
			String pincode) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", createdOn=" + createdOn + ", lastLogin=" + lastLogin + ", lattitude="
				+ lattitude + ", longitude=" + longitude + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	public void securePassword(){
		this.password = "User Password"; 
	}
	
	
}
