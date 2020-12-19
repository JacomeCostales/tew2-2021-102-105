$(function() 
		{
	if(sessionStorage.getItem('token')!=null && sessionStorage.getItem('usuario')!=null)
	{
		var model = new Model();
		var view = new View();
		var control = new Controller(model, view);
		control.init();
	}
	else
	{
		alert("Usted no se ha autenticado");
		window.location.href="index.html";
	}
		}); 


//Clase que contiene el Modelo de la aplicación.
function Model(){
	//Lista de alumnos.
	this.tbPublicaciones = null;
	
	// Carga los datos del servicio sobreescribiendo el dato this.tbAlumnos.
	 this.load = function(email_user,order_user) 
	 {
		 var email = sessionStorage.getItem("usuario");
		 var token = sessionStorage.getItem("token");
		 this.tbPublicaciones = PublicacionesServicesRs.getPublicacionesPropias({email : email_user,order : order_user, N : email, T : token,$contentType : "application/json"});
		 
	 }
	 

	
};
//Clase que contiene la gestión de la capa Vista
function View(){
	 this.list = function (lista) {
		 $("#tblPublicaciones").html("");
		 $("#tblPublicaciones").html( "<thead>" + "<tr>" + "<th>ID</th>" + "<th>email</th>" + "<th>titulo</th>" + "<th>texto</th>" + "<th>Fecha</th>" + "</tr>" + "</thead>" + "<tbody>" + "</tbody>");
		 
		 for ( var i in lista) {
			 var publicacion = lista[i];
			 $("#tblPublicaciones tbody").append("<tr> <td>" + publicacion.id + "</td>" + "<td>" + publicacion.email + "</td>" + "<td>" + publicacion.titulo + "</td>" + "<td>" + publicacion.texto + "</td>" + "<td>" + publicacion.fecha_format + "</td></tr>");
		 }
	 } 
	
	 
	 
};

function Controller(varmodel, varview) {
	 
	 var that = this;
	 
	 this.model = varmodel;
	 
	 this.view = varview;
	 
	 // Funcion de inicialización para cargar modelo y vista, definición de manejadores
	 this.init = function() {
		 
		 this.model.load(sessionStorage.getItem("usuario"),"fecha");
		 
		 this.view.list(this.model.tbPublicaciones);

		 
		 $("#btnFecha").click(
					
					function() {
					 
				 		that.model.load(sessionStorage.getItem("usuario"),"fecha");
				 
				 		that.view.list(that.model.tbPublicaciones);
					});
		 
		 $("#btnTitulo").click(
					
					function() {
					 
						that.model.load(sessionStorage.getItem("usuario"),"titulo");
				 
						that.view.list(that.model.tbPublicaciones);
					});
	 }
	 
	 
	 
	 
	}; 