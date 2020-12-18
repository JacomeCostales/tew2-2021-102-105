$(function() 
{
	 var model = new Model();
	 var view = new View();
	 var control = new Controller(model, view);
	 control.init();
}); 


function Model()
{
	this.tablaPeticiones = null;
	 this.load = function(emailUsuario) 
	 {
		 console.log(emailUsuario);
		 this.tablaPeticiones = UsuariosServicesRs.getListadoPeticiones({email : emailUsuario, $contentType : "application/json"});	 
	 }
	 
	 this.obtenerPeticionAceptar = function(lista, celda) 
		{
		    var nombreAmigo = String(celda.closest('tr').find('td').get(0).innerHTML);
		    var emailAmigo = "";
		    for ( var i in lista) 
		    {
		    	var usuario = lista[i];
		    	if(usuario.nombre == nombreAmigo)
		    	{
		    		emailAmigo = usuario.email;
		    	}
		    }
		    console.log(emailAmigo);
		    console.log(nombreAmigo);
			return emailAmigo;
		}
	 
	this.createAmigo = function(emailUsuario, emailAmigo) 
	{
		var amigo = 
		{
				email_usuario : emailAmigo,
				email_amigo : emailUsuario,
				aceptada : true
		};
	    return amigo;
	}
		
	this.aceptarAmigo = function(amigo) 
	{
		AmigosServicesRs.updateAmigos({$entity : amigo, $contentType : "application/json"});
	}
};

function View()
{
	
	this.obtenerEmailAmigo = function(celda) 
	{
		var emailAmigo = String(celda.closest('tr').find('td').get(0).innerHTML);
		return emailAmigo;
	}
	
	 this.list = function (lista) 
	 {
		 $("#tablaPeticiones").html("");
		 $("#tablaPeticiones").html( "<thead>" + "<tr>" + "<th>Nombre</th>" + "<th>Aceptar Amigo</th>" + "</tr>" + "</thead>" + "<tbody>" + "</tbody>");
		 
		 for ( var i in lista) 
		 {
			 var usuario = lista[i];
			 $("#tablaPeticiones tbody").append("<tr>"+ "<td>" + usuario.nombre + "</td>" + "<td>" + "<input type='button' value='Aceptar Amigo' class='botonAceptarAmigo'/>" + "</td>"  + "</tr>");
		 }
	 } 
};

function Controller(varmodel, varview) 
{
	 var that = this;
	 this.model = varmodel;
	 this.view = varview;
	 this.init = function() 
	 {
		 this.model.load(sessionStorage.getItem('usuario'));
		 this.view.list(this.model.tablaPeticiones);
		 
		 $("#tablaPeticiones").on("click", ".botonAceptarAmigo", function(event) 
		    {
				var emailAmigo = that.model.obtenerPeticionAceptar(that.model.tablaPeticiones, $(this));
				var amigos = that.model.createAmigo(sessionStorage.getItem('usuario'), emailAmigo);
				that.model.aceptarAmigo(amigos);
				that.model.load(sessionStorage.getItem('usuario')); 
				that.view.list(that.model.tablaPeticiones);
			});
	 }
};