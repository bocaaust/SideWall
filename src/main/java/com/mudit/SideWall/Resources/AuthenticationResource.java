/**
 * 
 */
package com.mudit.SideWall.Resources;

import java.util.Date;
import java.util.UUID;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.mudit.SideWall.ClassWrapper.ClassWrapper;
import com.mudit.SideWall.DAO.SessionDAO;
import com.mudit.SideWall.DAO.UserDAO;
import com.mudit.SideWall.Model.Session;
import com.mudit.SideWall.Model.User;

/**
 * @author Mudit
 * @since Jan 27, 2017
 */
@Path("authentication")
public class AuthenticationResource {
	
	private static final Logger logger = Logger.getLogger(AuthenticationResource.class);

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public ClassWrapper registerUser(User user){
		UserDAO myUserDAO = new UserDAO();
		ClassWrapper myClassWrapper = new ClassWrapper();
		logger.info("Creating New User : "+ user.getEmail());
		User userInDBWithEMail = myUserDAO.getUserByEmail(user.getEmail());
		if(userInDBWithEMail==null){
			if(user.getPassword().length() >6){
				user = myUserDAO.createNewUser(user);
				if(user!=null){
					user.securePassword();
				}
				myClassWrapper.setData(user);
				myClassWrapper.setMessage("User Registered");
				return myClassWrapper;
			}else{
				myClassWrapper.setData(null);
				myClassWrapper.setMessage("Password Too Short");
				return myClassWrapper;
			}
		}else {
			myClassWrapper.setData(null);
			myClassWrapper.setMessage("Email Already Registered");
			return myClassWrapper;
		}
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public ClassWrapper login(User user){
		UserDAO myUserDAO = new UserDAO();
		SessionDAO mySessionDAO = new SessionDAO();
		ClassWrapper myClassWrapper = new ClassWrapper();
		logger.info("Loggin attempt by : " + user.getEmail());
		System.out.println("Login attempt with : "+ user);
		User userInDB = myUserDAO.getUserByEmail(user.getEmail());
		if(userInDB!=null){
			System.out.println("User found in DB " + userInDB);
			if(user.getPassword().equals(userInDB.getPassword())){
				Session userSession = new Session(UUID.randomUUID().toString(), new Date(System.currentTimeMillis()+36000000), userInDB);
				userSession = mySessionDAO.createNewSession(userSession);
				userSession.getUser().securePassword();
				myClassWrapper.setData(userSession);
				myClassWrapper.setMessage("User Logged In");
				return myClassWrapper;
			}else {
				myClassWrapper.setData(null);
				myClassWrapper.setMessage("Invalid Password");
				return myClassWrapper;
			}
		}else{
			myClassWrapper.setData(null);
			myClassWrapper.setMessage("Email Not Found");
			return myClassWrapper;
		}		
	}
		
	@POST
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	public ClassWrapper logout(Session session){
		ClassWrapper myClassWrapper = new ClassWrapper();
		SessionDAO mySessionDAO = new SessionDAO();
		Session sessionInDB = mySessionDAO.getSessionByToken(session.getToken());
		if(sessionInDB != null){
			boolean result = mySessionDAO.deleteSessionByToken(sessionInDB.getToken());
			if(result){
				myClassWrapper.setData(null);
				myClassWrapper.setMessage("User logged Out");
			}else {
				myClassWrapper.setData(null);
				myClassWrapper.setMessage("User not logged Out");
			}
		}else {
			myClassWrapper.setData(null);
			myClassWrapper.setMessage("Error Occured");
		}
		return myClassWrapper;
	}
}
