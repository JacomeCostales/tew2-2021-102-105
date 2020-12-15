package com.tew.business.resteasy;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.tew.business.PublicacionesService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Publicacion;

@Path("/PublicacionesServicesRs")
public interface PublicacionesServicesRs extends PublicacionesService {

	@GET
	@Path("{email}/{order}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<Publicacion> getPublicacionesPropias(@PathParam("email") String email,@PathParam("order") String order) throws Exception;
	
	@GET
	@Path("{email}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<Publicacion> getPublicacionesAmigos(@PathParam("email") String email) throws Exception;
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	Publicacion findById(@PathParam("id") int id) throws EntityNotFoundException;
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void savePublicacion(Publicacion publicacion) throws EntityAlreadyExistsException;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void updatePublicacion(Publicacion publicacion) throws EntityNotFoundException;
	
	@DELETE
	void deletePublicacion(int id) throws EntityNotFoundException;
}
