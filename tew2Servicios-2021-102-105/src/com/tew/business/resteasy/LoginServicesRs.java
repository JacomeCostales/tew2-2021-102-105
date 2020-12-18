package com.tew.business.resteasy;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.LoginService;
import com.tew.model.User;
import com.tew.model.Usuario;

@Path("/LoginServicesRs")
public interface LoginServicesRs extends LoginService 
{

	@GET
	@Path("verify/{name}/{password}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	User verify(@PathParam("name") String name, @PathParam("password") String password);
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void registry(Usuario usuarioRegistrar);
	
	@GET
	@Path("compruebaExiste/{emailRegistrado}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	Usuario compruebaExiste(@PathParam("emailRegistrado") String emailRegistrado);

	@GET
	@Path("validLogin/{name}/{password}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	boolean validLogin(String name, String password);
}
