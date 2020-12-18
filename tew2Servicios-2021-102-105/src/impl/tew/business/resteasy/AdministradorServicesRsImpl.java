package impl.tew.business.resteasy;
import java.util.HashSet;
import java.util.List;
import com.tew.business.resteasy.AdministradorServicesRs;
import com.tew.business.resteasy.AlmacenServidor;
import com.tew.model.User;
import com.tew.persistence.exception.NotPersistedException;
import impl.tew.persistence.AdministradorJdbcDao;

public class AdministradorServicesRsImpl implements AdministradorServicesRs{

	@Override
	
	public void borrarUsarios(List<String> a) throws NotPersistedException {
		
		HashSet<User> usuariosLogged = (HashSet<User>) AlmacenServidor.getAlmacen().getUsuariosLogged();
		boolean borrar = true;
		for(User u : usuariosLogged) {
			if(u.getLogin().equals(a.get(0))){borrar=false;}
		}
		if(borrar)new AdministradorJdbcDao().borrarUsarios(a);
		
	}

	@Override
	public void reiniciarBD() throws Exception {
		new AdministradorJdbcDao().reiniciarBD();
		
	}

	
	

}
