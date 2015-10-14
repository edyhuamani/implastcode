/**
 * Javascript Materias Primas
 */

$(document).ready(function(){
	
	
	var opciones = function(cellVal,options,rowObject){
		
		var botones = "<center>";		
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:editarProducto('" + rowObject.codigo +"'); title='Editar'>";
			//botones += "<img src='../../opera/img/editar.png' border='0' title='Editar'/></a>&emsp;";
			botones +="<span class='ui-icon ui-icon-pencil'></span></a></div>&nbsp;";
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:eliminarProducto('" + rowObject.codigo +"'); title='Eliminar'>";
			//botones += "<img src='../../opera/img/cancel_16x16.png' border='0' title='Eliminar'/></a>&emsp;";
			botones +="<span class='ui-icon ui-icon-trash' ></span></a></div>";
			botones += "</center>";
		return botones;
	};
	
	
	jQuery("#grilla_mantenimiento_materiasPrimas").jqGrid(
		{
			url:'listarMateriasPrimas.json',
			dataType : 'json',
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
			height: 240,
			//width: '100%',
			rowList : [ 10, 20, 30 ],
			pager : '#pgrilla_mantenimiento_materiasPrimas',
			sortname : 'id',
			viewrecords : true,
			sortorder : "desc",
			scrollOffset: 0 //Not space column last
	});
	
	$("#btnRegistrarMateriaPrima").click(function(){
		
		registrarMateriaPrima();
	});
	
});

function registrarMateriaPrima(){
	
	var parametros=new Object();
	parametros.codigoMateriaPrima=$("#txtCodigoMateriaPrima").val();
	parametros.descripcion=$("#txtDescripcion").val();
	alert("estoy en este punto");
	
	$.ajax({
		url : "registrarMateriaPrima.json",
		data : parametros,
		dataType: 'json',
		type : 'POST',
		async : false,
		cache : false
	}).done(function(jsondata){
		alert("recibi respuesta");
	});
}

