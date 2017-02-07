/**
 * 
 */
package com.mudit.SideWall.Configurations;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Mudit
 * @since Dec 26, 2016
 */
public class MyEntityManagerFactory {
	private static EntityManagerFactory myEntityManagerFactory;

	private MyEntityManagerFactory() {
		// TODO Auto-generated constructor stub
	}

	public static EntityManagerFactory getMy_factory() {
		if (myEntityManagerFactory == null) {
			synchronized (MyEntityManagerFactory.class) {
				myEntityManagerFactory = Persistence.createEntityManagerFactory("sidewalljpa");
			}
		}
		return myEntityManagerFactory;
	}

	public static void setMy_factory(EntityManagerFactory myEntityManagerFactory) {
		MyEntityManagerFactory.myEntityManagerFactory = myEntityManagerFactory;
	}
}
