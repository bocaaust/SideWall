/**
 * 
 */
package com.mudit.SideWall.DAO;

import javax.persistence.EntityManager;

import com.mudit.SideWall.Configurations.MyEntityManagerFactory;
import com.mudit.SideWall.Model.Session;

/**
 * @author Mudit
 * @since Feb 3, 2017
 */
public class SessionDAO {
	public Session getSessionByToken(String token) {
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		Session session = myEntityManager.createQuery("SELECT u from Session u WHERE u.token= :token",Session.class).setParameter("token", token).getSingleResult();
		myEntityManager.getTransaction().commit();
		myEntityManager.close();
		return session;
	}
	
	public Session createNewSession(Session session) {
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		myEntityManager.persist(session);
		myEntityManager.getTransaction().commit();
		myEntityManager.close();
		return session;
	}
	
	public boolean deleteSessionByToken(String token){
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		Session session = myEntityManager.createQuery("SELECT u from Session u WHERE u.token= :token",Session.class).setParameter("token", token).getSingleResult();
		myEntityManager.remove(session);
		myEntityManager.getTransaction().commit();
		myEntityManager.close();
		return true;
	}
}
