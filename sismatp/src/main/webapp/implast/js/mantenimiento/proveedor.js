/**
 * 
 */

$(document).ready(function(){
	
	jQuery("#grilla_mantenimiento_proveedor").jqGrid(
			
			{
				url:'listarProveedores.json',
				datatype : 'json',
				mtype : 'POST',
				colNames : ['Código','Descripción','Proveedor', 'Opciones'],
				colModel : [ 
					{
						name : 'codigoMateriaPrima',
						index : 'codigoMateriaPrima',
						width : 65,
						sortable : false,
						resizable : false
					},{
						name : 'descripcion',
						index : 'descripcion',
						width : 300,
						sortable : false,
						resizable : false
					},{
						name : 'codigoProveedor',
						index : 'codigoProveedor',
						width : 100,
						sortable : false,
						resizable : false
					},{
						name : 'opciones',
						index : 'codigoMateriaPrima',
						width : 60,
						formatter:opciones,
						sortable : false,
						resizable : false,
						title : false
					}
				],
				rowNum : 10,
				height: 270,
				//width: '100%',
				rowList : [ 10, 20, 30 ],
				pager : '#pgrilla_mantenimiento_proveedor',
				sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				scrollOffset: 0 //Not space column last
		});
	
	$("#btnRegistrarProveedor").click(function(){
		registrarProveedor();
	});
});

function registrarProveedor(){
	var parametros=new Object();
	parametros.codigoProveedor=$("#txtCodigoProveedor").val();
	parametros.razonSocial=$("#txtNombreRazonSocial").val();
	
	$.ajax({
		url : 'registrarProveedor.json',
		data : parametros,
		dataType:'json',
		type : 'POST',
		async : false,
		cache : false
	}).done(function(jsondata){
		alert("Recibi respuesta");
	});

}








