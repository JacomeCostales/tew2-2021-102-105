package com.tew.business.resteasy;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.AdministradorService;
import com.tew.persistence.exception.NotPersistedException;


@Path("/AdministradorServicesRs")
public interface AdministradorServicesRs extends AdministradorService{
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void borrarUsarios(List<String> a)  throws NotPersistedException;
	
	@POST
	void reiniciarBD() throws Exception;
}
