package impl.tew.business.resteasy;
import java.util.List;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.UsuariosServicesRs;
import com.tew.model.Usuario;
import impl.tew.business.classes.UsuariosAlta;
import impl.tew.business.classes.UsuariosBaja;
import impl.tew.business.classes.UsuariosBuscar;
import impl.tew.business.classes.UsuariosListado;
import impl.tew.business.classes.UsuariosUpdate;

public class UsuariosServicesRsImpl implements UsuariosServicesRs
{

	@Override
	public List<Usuario> getUsuarios() throws Exception 
	{
		try 
		{
			return new UsuariosListado().getUsuarios();
		} 
		
		catch (Exception e) 
			{
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public Usuario findByEmail(String email) throws EntityNotFoundException 
	{
		return new UsuariosBuscar().find(email);
	}

	@Override
	public void saveUsuario(Usuario usuario) throws EntityAlreadyExistsException 
	{
		new UsuariosAlta().save(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) throws EntityNotFoundException 
	{
		new UsuariosUpdate().update(usuario);
	}

	@Override
	public void deleteUsuario(String email) throws EntityNotFoundException 
	{
		new UsuariosBaja().delete(email);
	}

	@Override
	public List<Usuario> getUsuariosFiltrados(String a, String b) throws Exception 
	{
		return new UsuariosListado().getUsuariosFiltrados(a, b);
	}

	@Override
	public List<Usuario> getListadoPeticiones(String email) 
	{
		return new UsuariosListado().getListadoPeticiones(email);
	}

	@Override
	public List<Usuario> listadoEnvios(String email) 
	{
		return new UsuariosListado().getListadoEnvios(email);
	}

}
