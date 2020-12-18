$(function() 
{
	var model = new Model();
	var control = new Controller(model);
	control.init();
});

function Model() 
{

	this.comprueba = function (user, pass) 
	{
	 	   var usuario = LoginServicesRs.verify({name : user, password : pass, $contentType : "application/json"});   
	 	   console.log(usuario);
	       if(usuario != null)
	       {
	    	   console.log("El usuario no era null");
	    	   console.log(usuario.rol);
	    	   sessionStorage.setItem('token', usuario.rol);
		       sessionStorage.setItem('usuario', user);
		       return true;
	       }
	       console.log("El usuario era null");
	       return false;
	}
};


function Controller(varmodel) 
{
	var that = this;
	this.model = varmodel;
	this.init = function() 
	{
	
		$("#botonEnviar").click(function(event)
		{
			var user=$("#username").val();
			var pass=$("#passwd").val();
		    if (that.model.comprueba(user,pass) == true)
		    {	
		    	window.location.href="index.html";	
		    }
		    else
		    {
		    	alert("Usuario y Contraseña no validos");
		    }
		    	
		    
		});
		
		$("#logout").click(
			function(event)
			{
				sessionStorage.removeItem("token");
				sessionStorage.removeItem('usuario');
				window.location.href="login.html";
			})
		}
			
};	
