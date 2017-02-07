/**
 * 
 */
package com.mudit.SideWall.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Mudit
 * @since Feb 3, 2017
 */
@XmlRootElement
@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="session_seq")
	@SequenceGenerator(
	    name="session_seq",
	    sequenceName="session_sequence",
	    allocationSize=20
	)
	@Column(name="SESSION_ID")
	private long id;
	private String token;
	private Date validity;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user")
	private User user;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Date getValidity() {
		return validity;
	}
	
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Session() {
		super();
	}

	public Session(long id, String token, Date validity, User user) {
		super();
		this.id = id;
		this.token = token;
		this.validity = validity;
		this.user = user;
	}

	public Session(String token, Date validity, User user) {
		super();
		this.token = token;
		this.validity = validity;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", token=" + token + ", validity=" + validity + ", user=" + user + "]";
	}
	
	
}
