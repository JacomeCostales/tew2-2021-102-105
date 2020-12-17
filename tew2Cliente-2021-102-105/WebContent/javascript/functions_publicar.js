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
	
	 
	 
	 this.add = function(publicacion) {
		 
		 PublicacionesServicesRs.savePublicacion({$entity : publicacion,$contentType : "application/json"});
		 
		 this.load();
	 }
	
	
};

function View(){
	 
	 
	 this.loadPublicacionFromForm = function () {
		 
		 var fecha_actual = new Date();
		 var id_asig = Math.floor(Math.random() * 1000000); 
		 var publicacion = {
				 id : id_asig,
				 email : "user1@email.es",
				 titulo : $("#titulo").val(),
				 texto : $("#texto").val(),
				 fecha_format : fecha_actual
				 };
		 return publicacion;
		 
	 } 
	 
	 
};

function Controller(varmodel, varview) {
	 // Definimos una copia de this para evitar el conflicto con el this (del
	 // objeto que recibe el evento)
	 // en los manejadores de eventos
	 var that = this;
	 // referencia al modelo
	 this.model = varmodel;
	 // refefencia a la vista
	 this.view = varview;
	 
	 // Funcion de inicialización para cargar modelo y vista, definición de manejadores
	 this.init = function() {
		
		 
		// Manejador del botón submit del formulario de Alta y Edición
		 $("#frmPublicar").bind("submit",
			 
			 function(event) {
			 
			 publicacion = that.view.loadPublicacionFromForm();
			
			that.model.add(publicacion);
			 
			 
			
		}); 

	 }
	}; 