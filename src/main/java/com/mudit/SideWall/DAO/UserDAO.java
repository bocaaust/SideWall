/**
 * 
 */
package com.mudit.SideWall.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.mudit.SideWall.Configurations.MyEntityManagerFactory;
import com.mudit.SideWall.Model.User;

/**
 * @author Mudit
 * @since Jan 27, 2017
 */
public class UserDAO {
	
	public User createNewUser(User user) {
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		myEntityManager.persist(user);
		myEntityManager.getTransaction().commit();
		myEntityManager.close();
		return user;
	}
	
	public User getUserById(int id){
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		try{
			User user = myEntityManager.createQuery("SELECT u from User u WHERE u.id= :id", User.class)
					.setParameter("id", id).getSingleResult();
			myEntityManager.getTransaction().commit();
			myEntityManager.close();
			return user;
		}catch (NoResultException e) {
			myEntityManager.getTransaction().rollback();
			myEntityManager.close();
			return null;
		}
	}
	
	public User getUserByEmail(String email){
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		try{
			User user = myEntityManager.createQuery("SELECT u from User u WHERE u.email= :email", User.class)
					.setParameter("email", email).getSingleResult();
			myEntityManager.getTransaction().commit();
			myEntityManager.close();
			return user;
		}catch (NoResultException e) {
			myEntityManager.getTransaction().rollback();
			myEntityManager.close();
			return null;
		}
	}

	/**
	 * @param user
	 * @return
	 */
	public User updateUser(User user) {
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		myEntityManager.merge(user);
		myEntityManager.getTransaction().commit();
		myEntityManager.close();
		return user;
	}
	
}
