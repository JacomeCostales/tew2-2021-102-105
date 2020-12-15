package impl.tew.business.resteasy;

import java.util.List;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.PublicacionesServicesRs;
import com.tew.model.Publicacion;

import impl.tew.business.classes.*;

public class PublicacionesServicesRsImpl implements PublicacionesServicesRs{

	@Override
	public List<Publicacion> getPublicacionesPropias(String email, String order) throws Exception {
		try {
			return new PublicacionesPropiasListado().getPublicacionesPropias(email,order);
			} catch (Exception e) {
			
			e.printStackTrace();
			return null;
			}
	}

	@Override
	public List<Publicacion> getPublicacionesAmigos(String email) throws Exception {
		try {
			return new PublicacionesAmigosListado().getPublicacionesAmigos(email);
			} catch (Exception e) {
			
			e.printStackTrace();
			return null;
			}
	}

	@Override
	public Publicacion findById(int id) throws EntityNotFoundException {
		
		return new PublicacionesBuscar().find(id);
	}

	@Override
	public void savePublicacion(Publicacion publicacion) throws EntityAlreadyExistsException {
		new PublicacionesAlta().save(publicacion);
		
	}

	@Override
	public void updatePublicacion(Publicacion publicacion) throws EntityNotFoundException {
		new PublicacionesUpdate().update(publicacion);
		
	}

	@Override
	public void deletePublicacion(int id) throws EntityNotFoundException {
		new PublicacionesBaja().delete(id);
		
	}

}
