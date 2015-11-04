/**
 * Javascript Materias Primas
 */

$(document).ready(function(){
	
	
	var opciones = function(cellVal,options,rowObject){
		
		var botones = "<center>";		
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:editarMateriaPrima('" + rowObject.codigo +"'); title='Editar'>";
			botones +="<span class='ui-icon ui-icon-pencil'></span></a></div>&nbsp;";
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:eliminarMateriaPrima('" + rowObject.codigo +"'); title='Eliminar'>";
			botones +="<span class='ui-icon ui-icon-trash' ></span></a></div>";
			botones += "</center>";
		return botones;
	};
	
	
	jQuery("#grilla_mantenimiento_materiasPrimas").jqGrid(
		{
			url:'listarMateriasPrimas.json',
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
					name : 'descMateriaPrima',
					index : 'descMateriaPrima',
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
	
	$.ajax({
		url : "registrarMateriaPrima.json",
		data : parametros,
		dataType: 'json',
		type : 'POST',
		async : false,
		cache : false
	}).done(function(jsondata){
		actualizarListaMateriaPrima();
	});
}


function editarMateriaPrima(){
	
}


function eliminarMateriaPrima(){
	
}

function actualizarListaMateriaPrima(){
	$("#grilla_mantenimiento_materiasPrimas").jqGrid('setGridParam').trigger('reloadGrid');
}
