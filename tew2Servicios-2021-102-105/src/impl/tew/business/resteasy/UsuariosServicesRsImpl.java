package impl.tew.business.resteasy;
import java.util.List;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.Application;
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
			System.out.println("Estamos en getUsuarios");
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

	//Aqui le pasamos primero el email del usuario en sesion y despues el texto a filtrar para mostrar los usuarios adecuados
	@Override
	public List<Usuario> getUsuariosFiltrados(String a, String b) throws Exception 
	{
		return new UsuariosListado().getUsuariosFiltrados(a, b);
	}

	//Muestra los usuarios a los que puede enviar invitacion el usuario con email pasado como parametro
	@Override
	public List<Usuario> getListadoPeticiones(String email) 
	{
		System.out.println(email);
		return new UsuariosListado().getListadoPeticiones(email);
	}

	@Override
	public List<Usuario> listadoEnvios(String email) 
	{
		System.out.println(email);
		return new UsuariosListado().getListadoEnvios(email);
	}

}
