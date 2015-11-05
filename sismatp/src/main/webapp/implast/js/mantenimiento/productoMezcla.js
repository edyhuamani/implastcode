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
	
	jQuery("#grilla_mantenimiento_mezcla").jqGrid(
			{
				colNames : ['Código Materia Prima','Descripcion','Porcentaje','Cantidad','Opciones'],
				colModel : [ 
					{
						name : 'codigoMateriaPrima',
						index : 'codigoMateriaPrima',
						width : 150,
						sortable : false,
						jsonmap:"materiaPrima.codigoMateriaPrima",
						resizable : false
					},{
						name : 'descMateriaPrima',
						index : 'descMateriaPrima',
						jsonmap:"materiaPrima.descMateriaPrima",
						width : 350,
						sortable : false,
						resizable : false
					},{
						name : 'porcentaje',
						index : 'porcentaje',
						width : 250,
						sortable : false,
						resizable : false
					},{
						name : 'cantidad',
						index : 'cantidad',
						width : 250,
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
				pager : '#pgrilla_mantenimiento_mezcla',
				sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				scrollOffset: 0 //Not space column last
		});
	
	$("#btnRegistrarProveedor").click(function(){
		registrarProveedor();
	});
});

function adicionarMateriaPrimaIngrediente(){
	
	var parametros=new Object();
	parametros.codigoMateriaPrima=$("#cmbMateriaPrimaP").val();
	parametros.porcentaje=$("#txtPorcenMateriaPrima").val();
	parametros.cantidad=$("#txtCantMateriaPrima").val();

	$.ajax({
		url:'registrarIngrediente.json',
		data:parametros,
		dataType:'json',
		type:'POST',
		cache:false,
		async:false
	}).done(function(jsonData){
		alert("Ingrediente adicionado");
		actualizarGrillaMezcla();
	});	
	
}

function actualizarGrillaMezcla(){
		
		$("#grilla_mantenimiento_mezcla").jqGrid('setGridParam',
		{
			url : 'listar-ingredientes.json',
			//postData : parametros,
			datatype : 'json', 
			mtype : 'GET',
			page : 1
		}).trigger('reloadGrid');
}