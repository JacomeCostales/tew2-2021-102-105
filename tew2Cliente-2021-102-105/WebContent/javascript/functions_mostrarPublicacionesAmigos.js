$(function() {
	 // Creamos el modelo con los datos y la conexión al servicio web.
	 var model = new Model();
	 // Creamos la vista que incluye acceso al modelo.
	 var view = new View();
	 // Creamos el controlador
	 var control = new Controller(model, view);
	 // Iniciamos la aplicación
	 control.init();
}); 


//Clase que contiene el Modelo de la aplicación.
function Model(){
	//Lista de alumnos.
	this.tbPublicaciones = null;
	
	// Carga los datos del servicio sobreescribiendo el dato this.tbAlumnos.
	 this.load = function(email_user) {
		 this.tbPublicaciones = PublicacionesServicesRs.getPublicacionesAmigos({email : email_user,$contentType : "application/json"});
		 
	 }
	 

	
};
//Clase que contiene la gestión de la capa Vista
function View(){
	 this.list = function (lista) {
		 $("#tblPublicacionesAmigos").html("");
		 $("#tblPublicacionesAmigos").html( "<thead>" + "<tr>" + "<th>ID</th>" + "<th>email</th>" + "<th>titulo</th>" + "<th>texto</th>" + "<th>Fecha</th>" + "</tr>" + "</thead>" + "<tbody>" + "</tbody>");
		 
		 for ( var i in lista) {
			 var publicacion = lista[i];
			 $("#tblPublicacionesAmigos tbody").append("<tr> <td>" + publicacion.id + "</td>" + "<td>" + publicacion.email + "</td>" + "<td>" + publicacion.titulo + "</td>" + "<td>" + publicacion.texto + "</td>" + "<td>" + publicacion.fecha_format + "</td></tr>");
		 }
	 } 
	
	 
	 
};

function Controller(varmodel, varview) {
	 
	 var that = this;
	 
	 this.model = varmodel;
	 
	 this.view = varview;
	 
	 // Funcion de inicialización para cargar modelo y vista, definición de manejadores
	 this.init = function() {
		 
		 this.model.load("user2@email.es");
		 
		 this.view.list(this.model.tbPublicaciones);

		 
		 
	 }
	 
	 
	 
	 
	}; 