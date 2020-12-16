$(function() 
{
	 var model = new Model();
	 var view = new View();
	 var control = new Controller(model, view);
	 control.init();
}); 


function Model()
{
	this.tablaUsuarios = null;
	 this.load = function(emailUsuario) 
	 {
		 this.tablaUsuarios = UsuariosServicesRs.listadoEnvios("listadoEnvios" + emailUsuario);	 
	 }
};

function View()
{
	 this.list = function (lista) 
	 {
		 $("#tablaUsuarios").html("");
		 $("#tablaUsuarios").html( "<thead>" + "<tr>" + "<th>email</th>" + "<th>rol</th>" + "<th>nombre</th>" + "</tr>" + "</thead>" + "<tbody>" + "</tbody>");
		 
		 for ( var i in lista) 
		 {
			 var usuario = lista[i];
			 $("#tablaUsuarios tbody").append("<tr> <td>" + usuario.email + "</td>" + "<td>" + usuario.rol + "</td>" + "<td>" + usuario.nombre + "</td>" + "</tr>" + "<img src='icons/edit.png' class='botonAceptarAmigo'/>");
		 
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
		 this.model.load("user1@email.es");
		 this.view.list(this.model.tablaUsuarios);
		 $("#tablaUsuarios").on("click", ".botonAceptarAmigo",function(event) 
		    {
				var emailAmigo = that.view.obtenerEmailAmigo($(this));
				that.view.agregarAmigo("user1@email.com",emailAmigo);
			});
	 }
};

this.agregarAmigo = function(correo,correoAmigo) 
{
	var acept = false;
	AmigosServicesRs.saveAmigos({email: correo, emailAmigo: correoAmigo, aceptada: acept, $contentType : "application/json"});
}

This.obtenerEmailAmigo = function(celda) 
{
	var emailAmigo = String(celda.closest('tr').find('td').get(0).innerHTML);
	return emailAmigo;
}