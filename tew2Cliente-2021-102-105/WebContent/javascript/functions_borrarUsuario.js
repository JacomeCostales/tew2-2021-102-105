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
	this.listUsuarios = null;
	
	// Carga los datos del servicio sobreescribiendo el dato this.tbAlumnos.
	 this.load = function() {
		 this.listUsuarios = UsuariosServicesRs.getUsuarios();
	 }
	 
	 
	 
	// Eliminación un alumno existente
	 this.remove = function() {
		 // Llamamos al servicio de borrado de alumno
		 AdministradorServicesRs.borrarUsarios(["user9@email.es"]);
		 
		 // Recargamos la lista de alumnos.
		 this.load();
	 }
	
	
};
//Clase que contiene la gestión de la capa Vista
function View(){
	 this.list = function (lista) {
		
		 for ( var i in lista) {
			 var usuario = lista[i];
			 $("#listaUsuarios").append("<input type='checkbox' id='usuario"+i+"' name='usuario"+i+"' value="+usuario.email+"><label for='usuario"+i+"'> "+usuario.email+"</label><br>");
		 }
	 } 

};

function Controller(varmodel, varview) {
	 
	 var that = this;
	 
	 this.model = varmodel;
	 
	 this.view = varview;
	  
	 this.init = function() {
		 
		 this.model.load();
		 
		 this.view.list(this.model.listUsuarios);
		 
		 
		 
		 $("#btnBorrar").click(
					
				function() {
					that.model.remove();
					that.model.load();
					that.view.list(that.model.listUsuarios);
				});

	 }
	}; 