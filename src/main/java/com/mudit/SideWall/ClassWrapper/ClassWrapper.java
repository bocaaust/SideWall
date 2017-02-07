/**
 * 
 */
package com.mudit.SideWall.ClassWrapper;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.mudit.SideWall.Model.Job;
import com.mudit.SideWall.Model.Session;
import com.mudit.SideWall.Model.User;

/**
 * @author Mudit
 * @since Feb 3, 2017
 */
@XmlRootElement
@XmlSeeAlso({User.class,Job.class,Session.class})
public class ClassWrapper {
	private Object data;
	private String message;
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ClassWrapper() {
		super();
	}

	public ClassWrapper(Object data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ClassWrapper [data=" + data + ", message=" + message + "]";
	}
	
	
}
