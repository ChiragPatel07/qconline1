package org.qcwala1.dfsproject.qcplatform.business;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.qcwala1.dfsproject.qcplatform.service.Userservice;
import org.qcwala1.dfsproject.qcplatform.userinfo.UserBean;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserManager {

	public static UserBean createUserBean(String username) {
		UserBean currentUser = Userservice.createUserBean(username);
		if (currentUser != null) {
			return currentUser;
		}
		return currentUser;

	}

	@PUT
	@Path("{userId}")
	public static void updateUser(@PathParam("userId") String userId, UserBean modifiedUser) {
		modifiedUser.setUser_name(userId);
		new Userservice().updateUser(modifiedUser);

	}

	@POST
	public static void addUser(UserBean modifiedUser) {
		new Userservice().updateUser(modifiedUser);
	}

	@DELETE
	@Path("{userId}")
	public static void deleteUser(@PathParam("userId") String user_id) {

		new Userservice().deleteUser(user_id);
	}

	@GET
	@Path("{userId}")
	public static UserBean getUser(@PathParam("userId") String user_id) {

		UserBean retUser = new Userservice().getUser(user_id);
		if (retUser != null) {
			return retUser;
		}
		return null;
	}

	public static void printUserdetails(List<UserBean> list) {
		for (UserBean user : list) {
			System.out.println(user);
		}
	}

}
