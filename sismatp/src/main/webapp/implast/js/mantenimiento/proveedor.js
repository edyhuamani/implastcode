/**
 * 
 */

$(document).ready(function(){
	
	$("#btnRegistrarProveedor").click(function(){
		registrarProveedor();
	});
});

function registrarProveedor(){
	var parametros=new Object();
	parametros.codigoProveedor=$("#txtCodigoProveedor").val();
	parametros.razonSocial=$("#txtRazonSocial").val();
	
	$.ajax({
		url : 'registrarProveedor.htm',
		data : parametros,
		type : 'POST',
		async : false,
		cache : false
	}).done(function(jsondata){
		alert("Recibi respuesta");
	});

}








