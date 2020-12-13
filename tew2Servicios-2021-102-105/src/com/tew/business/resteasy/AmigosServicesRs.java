package com.tew.business.resteasy;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.tew.business.AmigosListaService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Amigos;

@Path("/AmigosServicesRs")
public interface AmigosServicesRs extends AmigosListaService
{
	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public List<Amigos> getAmigosLista() throws Exception; 
	 /*
	 @GET
	 @Path("{a}")
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 Amigos find(@PathParam("a") Amigos a) throws EntityNotFoundException;
	 
	 @DELETE
	 @Path("{amigos}")
	 void deleteAmigos(@PathParam("amigos") Amigos amigos) throws EntityNotFoundException;
	 */
	 @PUT
	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 void saveAmigos(Amigos amigos) throws EntityAlreadyExistsException;
	 
	 @POST
	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 void updateAmigos(Amigos amigos) throws EntityNotFoundException;

	 @GET
	 @Path("{email}")
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 public List<Amigos> getListadoPeticiones(@PathParam("email")String email); 
}
