package impl.tew.business.resteasy;
import java.util.Arrays;
import java.util.List;
import com.tew.business.resteasy.AdministradorServicesRs;
import com.tew.persistence.exception.NotPersistedException;
import impl.tew.persistence.AdministradorJdbcDao;

public class AdministradorServicesRsImpl implements AdministradorServicesRs{

	@Override
	
	public void borrarUsarios(List<String> a) throws NotPersistedException {
		for(String s :a)System.out.println(s);
		new AdministradorJdbcDao().borrarUsarios(a);
		
	}

	@Override
	public void reiniciarBD() throws Exception {
		new AdministradorJdbcDao().reiniciarBD();
		
	}

	
	

}
