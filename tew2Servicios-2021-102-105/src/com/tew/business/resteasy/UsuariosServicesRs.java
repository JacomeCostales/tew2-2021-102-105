package com.tew.business.resteasy;
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
import com.tew.business.UsuariosService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Usuario;

@Path("/UsuariosServicesRs")
public interface UsuariosServicesRs extends UsuariosService
{
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<Usuario> getUsuarios() throws Exception;
	
	@GET
	@Path("email")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	Usuario findByEmail(@PathParam("email") String email) throws EntityNotFoundException;
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void saveUsuario(Usuario usuario) throws EntityAlreadyExistsException;
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void updateUsuario(Usuario usuario) throws EntityNotFoundException;
	
	@DELETE
	@Path("email")
	void deleteUsuario(@PathParam("email") String email) throws EntityNotFoundException;
	
	@GET
	@Path("{a}/{b}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<Usuario> getUsuariosFiltrados(@PathParam("a") String a, @PathParam("b") String b) throws Exception;
	
	@GET
	@Path("{email")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<Usuario> getListadoPeticiones(@PathParam("email") String email);
	
	@GET
	@Path("email")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	List<Usuario> listadoEnvios(@PathParam("email") String email);
}
