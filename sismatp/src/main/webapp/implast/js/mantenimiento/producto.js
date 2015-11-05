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
	
	jQuery("#grilla_mantenimiento_producto").jqGrid(
			
			{
				url:'listarProductos.json',
				datatype : 'json',
				mtype : 'POST',
				colNames : ['Código Producto','Descripción','Opciones'],
				colModel : [ 
					{
						name : 'codigoProducto',
						index : 'codigoProducto',
						width : 65,
						sortable : false,
						resizable : false
					},{
						name : 'descripcion',
						index : 'descripcion',
						width : 350,
						sortable : false,
						resizable : false
					},{
						name : 'opciones',
						index : 'codigoProducto',
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
				pager : '#pgrilla_mantenimiento_producto',
				sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				scrollOffset: 0 //Not space column last
		});
	
	
	
	$("#btnRegistrarProducto").click(function(){
		registrarProducto();
	});
	
	$("#btnAdicionarMatPrimaIngrediente").click(function(){
		adicionarMateriaPrimaIngrediente();
	}); 
});


registrarProducto=function(){
	
	var codigoProducto=$("#txtCodigoProducto").val();
	var descripProducto=$("#txtDescripcionProducto").val();
	
	if (codigoProducto.length>0 && descripProducto.length>0){
		
		var parametros=new Object();
		parametros.codProducto=codigoProducto;
		parametros.descProducto=descripProducto;
		
		$.ajax({
			url:'registrarProducto.json',
			data:parametros,
			dataType:'json',
			type:'POST',
			cache:false,
			async:false
		}).done(function(jsonData){
			actualizarListaProducto();
		});
	}
};

function actualizarListaProducto(){
	$("#grilla_mantenimiento_producto").jqGrid('setGridParam').trigger('reloadGrid');
}



