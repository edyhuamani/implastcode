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
	
	$("#btnRegistrarSalida").click(function(){
		registrarSalidaExtrusionCabecera(); 
	});
	
});



function registrarSalidaExtrusionCabecera(){

	var parametros=new Object();
	parametros.ordenTrabajo=$("#txtIdOrdenTrabajo").val();
	parametros.fecOrdenTrabajo=$("#txtFechaOrdenTrabajo").val();
	parametros.fecEntrega=$("#txtFechaEntrega").val();
	parametros.codSap=$("#txtSAP").val();
	parametros.codMaquina=$("#cmbMaquina").val();
	parametros.status=$("#txtStatus").val();
	parametros.codCliente=$("#cmbCliente").val();
	parametros.codProducto=$("#cmbProducto").val();
	parametros.ancho=$("#txtAncho").val();
	parametros.espesor=$("#txtEspesor").val();
	parametros.codMaquina=$("#cmbTratado").val();
	parametros.solapa=$("#txtSolapa").val();
	parametros.fuelle=$("#txtFuelle").val();
	parametros.grMin=$("#txtGrMin").val();
	parametros.max=$("#txtMax").val();
	parametros.min=$("#txtMin").val();
	parametros.maxProd=$("#txtMaxProduccion").val();
	parametros.minProd=$("#txtMinProduccion").val();
	parametros.scrap=$("#txtScrapMaximo").val();
	parametros.codTipoManga=$("#cmbTipoManga").val();
	
	$.ajax({
		url:"registrarParteExtrusion.json",
		data:parametros,
		dataType:"json",
		type:"POST",
		cache:false,
		async:false,
	}).done(function(jsonData){
		alert("Se registro extrusion");
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