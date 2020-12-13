package impl.tew.business.resteasy;
import com.tew.business.resteasy.AmigosServicesRs;
import java.util.List;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Amigos;

import impl.tew.business.classes.AmigosListaBaja;
import impl.tew.business.classes.AmigosListaBuscar;
import impl.tew.business.classes.AmigosListaListado;
import impl.tew.business.classes.AmigosListaUpdate;
public class AmigosServicesRsImpl implements AmigosServicesRs
{

	@Override
	public List<Amigos> getAmigosLista()
	{
		try 
		{
			return new AmigosListaListado().getAmigosLista();
		} 
		
		catch (Exception e) 
			{
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public Amigos find(Amigos a) throws EntityNotFoundException 
	{
		return new AmigosListaBuscar().find(a);
	}

	@Override
	public void deleteAmigos(Amigos amigos) throws EntityNotFoundException
	{
		new AmigosListaBaja().delete(amigos);
	}

	@Override
	public void saveAmigos(Amigos amigos) throws EntityAlreadyExistsException 
	{
		
	}

	@Override
	public void updateAmigos(Amigos amigos) throws EntityNotFoundException 
	{
		new AmigosListaUpdate().update(amigos);
	}

	@Override
	public List<Amigos> getListadoPeticiones(String email) 
	{
		return new AmigosListaListado().getAmigosListaPeticiones(email);
	}
	
	
}
