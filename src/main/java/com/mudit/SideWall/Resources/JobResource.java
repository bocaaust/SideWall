/**
 * 
 */
package com.mudit.SideWall.Resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.mudit.SideWall.ClassWrapper.ClassWrapper;
import com.mudit.SideWall.ClassWrapper.ListWrapper;
import com.mudit.SideWall.DAO.JobDAO;
import com.mudit.SideWall.Model.Job;

/**
 * @author Mudit
 * @since Feb 5, 2017
 */

@Path("job")
public class JobResource {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ClassWrapper createNewJob(Job job){
		ClassWrapper myClassWrapper = new ClassWrapper();
		JobDAO myJobDAO = new JobDAO();
		String address = job.getLine1() + job.getLine2() + job.getCity() +  job.getPincode();
		System.out.println(address);
		String urlGoogle = "https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key=AIzaSyCF9yFkKP2zeEQSqHrUw_Wq3NjKEm375TU";
		urlGoogle = urlGoogle.replace(" ", "+");
		System.out.println(urlGoogle);
		try{
			URL obj = new URL(urlGoogle);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + urlGoogle);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	
			//print result
			JSONObject myObject = new JSONObject(response.toString());
			System.out.println(response);
			job.setLongitude(Float.parseFloat(myObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lng").toString()));
			job.setLatitude(Float.parseFloat(myObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lat").toString()));
			job = myJobDAO.createNewJob(job);
			myClassWrapper.setData(job);
			myClassWrapper.setMessage("New Job Created");
			return myClassWrapper;
		}catch (Exception e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
			return myClassWrapper;
		}
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public ListWrapper<Job> getAllJobs(@QueryParam("lattitude") float lattitude,@QueryParam("longitude") float longitude ){
		ListWrapper<Job> myListWrapper = new ListWrapper<Job>();
		JobDAO myJobDAO = new JobDAO();
		myListWrapper.setData(myJobDAO.getAllJobs(lattitude,longitude));
		myListWrapper.setMessage("Jobs Found");
		return myListWrapper;
	}
}
