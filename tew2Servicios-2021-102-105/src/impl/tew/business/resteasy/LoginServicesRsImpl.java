package impl.tew.business.resteasy;

import com.tew.business.resteasy.LoginServicesRs;
import com.tew.model.User;
import com.tew.model.Usuario;

import impl.tew.business.SimpleLoginService;

public class LoginServicesRsImpl implements LoginServicesRs{

	@Override
	public User verify(String name, String password) {
		return new SimpleLoginService().verify(name, password);
	}

	@Override
	public void registry(Usuario usuarioRegistrar) {
		new SimpleLoginService().registry(usuarioRegistrar);
		
	}

	@Override
	public Usuario compruebaExiste(String emailRegistrado) {
		return new SimpleLoginService().compruebaExiste(emailRegistrado);
	}

}
