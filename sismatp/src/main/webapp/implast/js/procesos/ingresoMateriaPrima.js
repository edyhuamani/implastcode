/**
 * 
 */

$(document).ready(function(){
	
	
	var opciones = function(cellVal,options,rowObject){
		
	var botones = "<center>";		
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:editarMateriaPrima('" + rowObject.codigoMateriaPrima +"'); title='Editar'>";
			botones +="<span class='ui-icon ui-icon-pencil'></span></a></div>&nbsp;";
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:eliminarMateriaPrima('" + rowObject.codigoMateriaPrima +"'); title='Eliminar'>";
			botones +="<span class='ui-icon ui-icon-trash' ></span></a></div>";
			botones += "</center>";
	return botones;
	};
	
	jQuery("#grilla_mantenimiento_ingresoMateriaPrima").jqGrid({
		//url:'listarProveedores.json',
		//datatype : 'json',
		//mtype : 'POST',
		colNames : ['Código Materia Prima','Descripción','Cantidad','Opciones'],
		colModel : [ 
			{
				name : 'codigoMateriaPrima',
				index : 'codigoMateriaPrima',
				width : 90,
				sortable : false,
				resizable : false
			},{
				name : 'descMateriaPrima',
				index : 'descMateriaPrima',
				width : 350,
				sortable : false,
				resizable : false
			},{
				name : 'cantidad',
				index : 'cantidad',
				width : 150,
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
		pager : '#pgrilla_mantenimiento_ingresoMateriaPrima',
		sortname : 'id',
		viewrecords : true,
		sortorder : "desc",
		scrollOffset: 0 //Not space column last
	});
	
	
	$("#btnAdicionarMateriaPrima").click(function(){
		adicionarMateriaPrima();
	});
	
	
	
});

function editarMateriaPrima(){
	
}


function eliminarMateriaPrima(){
	
}

function adicionarMateriaPrima(){
	var parametros=new Object();
	parametros.codigoMateriaPrima=$("#cmbMateriaPrima").val();
	parametros.cantidadMateriaPrima=$("#txtCantidadIngresoMP").val();
	
	$.ajax({
		url : 'adicionarMateriaPrima.json',
		data : parametros,
		dataType:'json',
		type : 'POST',
		async : false,
		cache : false
	}).done(function(){
		actualizarListaIngresos();
	});
}

function actualizarListaIngresos(){
    $("#grilla_mantenimiento_ingresoMateriaPrima").jqGrid('setGridParam',
		{
			url : 'recargar-grilla-adicionarMateriaPrima.json',
			datatype : 'json', 
			mtype : 'POST',
			page : 1
	}).trigger('reloadGrid');
	
	
}