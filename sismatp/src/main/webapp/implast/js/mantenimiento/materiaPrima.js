/**
 * 
 */

$(document).ready(function(){
	
	$("#btnRegistrarMateriaPrima").click(function(){
		
		registrarMateriaPrima();
	});
	
});

function registrarMateriaPrima(){
	var parametros=new Object();
	parametros.codigoMateriaPrima=$("#txtCodigoMateriaPrima").val();
	parametros.descripcion=$("#txtDescripcion").val();
	
	$.ajax({
		url : 'registrarMateriaPrima.htm',
		data : parametros,
		type : 'POST',
		async : false,
		cache : false
	}).done(function(jsondata){
		alert("recibi respuesta");
	});
}

