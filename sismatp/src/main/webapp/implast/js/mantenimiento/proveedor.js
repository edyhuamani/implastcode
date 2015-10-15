/**
 * 
 */

$(document).ready(function(){
	
	
	var opciones = function(cellVal,options,rowObject){
		
		var botones = "<center>";		
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:editarProveedor('" + rowObject.codigo +"'); title='Editar'>";
			botones +="<span class='ui-icon ui-icon-pencil'></span></a></div>&nbsp;";
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:eliminarProveedor('" + rowObject.codigo +"'); title='Eliminar'>";
			botones +="<span class='ui-icon ui-icon-trash' ></span></a></div>";
			botones += "</center>";
		return botones;
	};
	
	jQuery("#grilla_mantenimiento_proveedor").jqGrid(
			
			{
				url:'listarProveedores.json',
				datatype : 'json',
				mtype : 'POST',
				colNames : ['Código','Descripción','Opciones'],
				colModel : [ 
					{
						name : 'codigoProveedor',
						index : 'codigoProveedor',
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
						name : 'opciones',
						index : 'codigoProveedor',
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

function editarProveedor(){
	
}

function eliminarProveedor(){
	
}






