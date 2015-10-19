/**
 * 
 */


$(document).ready(function(){
	
	
	var opciones = function(cellVal,options,rowObject){
		
		var botones = "<center>";		
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:editarOperador('" + rowObject.codigoOperador +"'); title='Editar'>";
			botones +="<span class='ui-icon ui-icon-pencil'></span></a></div>&nbsp;";
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:eliminarOperador('" + rowObject.codigoOperador +"'); title='Eliminar'>";
			botones +="<span class='ui-icon ui-icon-trash' ></span></a></div>";
			botones += "</center>";
		return botones;
	};
	

	jQuery("#grilla_mantenimiento_operador").jqGrid(
		{
			url:'listarOperador.json',
			datatype : 'json',
			mtype : 'POST',
			colNames : ['Código Operador','Nombres y Apellidos','Opciones'],
			colModel : [ 
			            
				{
					name : 'codigoOperador',
					index : 'codigoOperador',
					width : 65,
					sortable : false,
					resizable : false
				},{
					name : 'nombreOperador',
					index : 'nombreOperador',
					width : 300,
					sortable : false,
					resizable : false
				},{
					name : 'opciones',
					index : 'codigoOperador',
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
			pager : '#pgrilla_mantenimiento_operador',
			sortname : 'id',
			viewrecords : true,
			sortorder : "desc",
			scrollOffset: 0 //Not space column last
	});
	
	
	$("#btnRegistrarOperador").click(function(){
		registrarOperador();
	});
});	



function registrarOperador(){
	
	_codigoOperador=$("#txtCodigoOperador").val();
	_nombreOperador=$("#txtNombreOperador").val();
	var parametros=new Object();
	parametros.codigoOperador=_codigoOperador;
	parametros.nombreOperador=_nombreOperador;
	
	$.ajax({
		url : "registrarOperador.json",
		data : parametros,
		dataType: 'json',
		type : 'POST',
		async : false,
		cache : false
	}).done(function(jsondata){
		actualizarListaOperador();
	});
}

function editarOperador(){
	
}


function eliminarOperador(){
	
}

function actualizarListaOperador(){
	$("#grilla_mantenimiento_operador").jqGrid('setGridParam').trigger('reloadGrid');
}