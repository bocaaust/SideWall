/**
 * 
 */
package com.mudit.SideWall.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.mudit.SideWall.Configurations.MyEntityManagerFactory;
import com.mudit.SideWall.Model.Job;

/**
 * @author Mudit
 * @since Feb 5, 2017
 */
public class JobDAO {
	public List<Job> getAllJobs(float lattitude, float longitude) {
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		List<Job> allJobs;
		 
		if(lattitude!=0.0 && longitude!= 0.0){
			allJobs = myEntityManager.createQuery("Select u from Job u WHERE u.lat BETWEEN :startLat AND :endLat AND u.lon BETWEEN :startLon AND :endLon",Job.class).getResultList();
		}else{
			 allJobs = myEntityManager.createQuery("Select u from Job u",Job.class).getResultList();
		}
		myEntityManager.getTransaction().commit();
		myEntityManager.close();
		return allJobs;
	}
	
	public Job createNewJob(Job job) {
		EntityManager myEntityManager = MyEntityManagerFactory.getMy_factory().createEntityManager();
		myEntityManager.getTransaction().begin();
		myEntityManager.persist(job);
		myEntityManager.getTransaction().commit();
		myEntityManager.close();
		return job;
	}
}
