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
	
	jQuery("#grilla_mantenimiento_salidaMateriaPrima").jqGrid({
		//url:'listarProveedores.json',
		//datatype : 'json',
		//mtype : 'POST',
		colNames : ['Cod. Materia Prima','Descripción','Tolva','Piso','Abastecido','Consumo','Tolva','Piso','Opciones'],
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
				width : 350,
				sortable : false,
				resizable : false
			},{
				name : 'tolvaInicial',
				index : 'tolvaInicial',
				width : 120,
				sortable : false,
				resizable : false
			},{
				name : 'pisoInicial',
				index : 'pisoInicial',
				width : 120,
				sortable : false,
				resizable : false
			},{
				name : 'abastecido',
				index : 'abastecido',
				width : 120,
				sortable : false,
				resizable : false
			},{
				name : 'consumo',
				index : 'consumo',
				width : 120,
				sortable : false,
				resizable : false
			},{
				name : 'tolvaFinal',
				index : 'tolvaFinal',
				width : 120,
				sortable : false,
				resizable : false
			},{
				name : 'pisoFinal',
				index : 'pisoFinal',
				width : 120,
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
		pager : '#pgrilla_mantenimiento_salidaMateriaPrima',
		sortname : 'id',
		viewrecords : true,
		sortorder : "desc",
		scrollOffset: 0 //Not space column last
	});
	
	
	$("#btnAdicionarMateriaPrima").click(function(){
		adicionarMateriaPrima();
	});
	
	$("#btnRegistrarSalida ").click(function(){
		registrarSalidaExtrusionCabecera(); 
	});
	
});



function registrarSalidaExtrusionCabecera(){

	var parametros=new Object();
	$.ajax({
		
	});
}

function editarMateriaPrima(){
	
}

function eliminarMateriaPrima(){
	
}

function adicionarMateriaPrima(){
	var parametros=new Object();
	parametros=$("#").val();
	
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
	$("#grilla_mantenimiento_salidaMateriaPrima").jqGrid('setGridParam').trigger('reloadGrid');
}