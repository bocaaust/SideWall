/**
 * 
 */
package com.mudit.SideWall.ClassWrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.mudit.SideWall.Model.Job;
import com.mudit.SideWall.Model.Session;
import com.mudit.SideWall.Model.User;

/**
 * @author Mudit
 * @since Feb 5, 2017
 */

@XmlRootElement
@XmlSeeAlso({User.class,Session.class,Job.class})
public class ListWrapper<T> {
	private List<T> data;
	private String message;
	
	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ListWrapper() {
		super();
	}
	
	public ListWrapper(List<T> data, String message) {
		super();
		this.data = data;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ListWrapper [data=" + data + ", message=" + message + "]";
	}
	
	
}
