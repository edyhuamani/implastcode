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
	
	jQuery("#grilla_mantenimiento_maquina").jqGrid(
			
			{
				url:'listarProveedores.json',
				datatype : 'json',
				mtype : 'POST',
				colNames : ['Código Maquina','Descripción Maquina','Opciones'],
				colModel : [ 
					{
						name : 'codigoMaquina',
						index : 'codigoMaquina',
						width : 65,
						sortable : false,
						resizable : false
					},{
						name : 'descMaquina',
						index : 'descMaquina',
						width : 350,
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
				pager : '#pgrilla_mantenimiento_maquina',
				sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				scrollOffset: 0 //Not space column last
		});
	
	$("#btnRegistrarProveedor").click(function(){
		registrarProveedor();
	});
});