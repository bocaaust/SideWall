package com.mudit.SideWall.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mudit.SideWall.ClassWrapper.ClassWrapper;
import com.mudit.SideWall.DAO.UserDAO;
import com.mudit.SideWall.Model.User;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("user")
public class UserResource {

    @POST
    @Path("/updatelocation/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public ClassWrapper updatelocation(@PathParam("id") int id,@QueryParam("lattitude") float lattitude,@QueryParam("longitude") float longitude) {
    	ClassWrapper myClassWrapper = new ClassWrapper();
    	UserDAO myUserDAO = new UserDAO();
    	User user = myUserDAO.getUserById(id);
    	user.setLattitude(lattitude);
    	user.setLongitude(longitude);
    	myClassWrapper.setData(myUserDAO.updateUser(user));
    	myClassWrapper.setMessage("User Updated");
    	return myClassWrapper;
    }
}
