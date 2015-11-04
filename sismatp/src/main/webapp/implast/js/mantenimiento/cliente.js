/**
 * 
 */

$(document).ready(function(){
	
	var opciones = function(cellVal,options,rowObject){
		
		var botones = "<center>";		
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:editarCliente('" + rowObject.codigoCliente +"'); title='Editar'>";
			botones +="<span class='ui-icon ui-icon-pencil'></span></a></div>&nbsp;";
			botones += "<div style='display: inline-block;'>";
			botones += "<a href=javascript:eliminarCliente('" + rowObject.codigoCliente +"'); title='Eliminar'>";
			botones +="<span class='ui-icon ui-icon-trash' ></span></a></div>";
			botones += "</center>";
		return botones;
	};
	
	jQuery("#grilla_mantenimiento_cliente").jqGrid(
			{
				url:'listarClientes.json',
				datatype : 'json',
				mtype : 'POST',
				colNames : ['Código Cliente','Razon Social','Ruc Cliente','Opciones'],
				colModel : [ 
					{
						name : 'codigoCliente',
						index : 'codigoCliente',
						width : 65,
						sortable : false,
						resizable : false
					},{
						name : 'razonSocial',
						index : 'razonSocial',
						width : 350,
						sortable : false,
						resizable : false
					},{
						name : 'ruc',
						index : 'ruc',
						width : 200,
						sortable : false,
						resizable : false
					},{
						name : 'opciones',
						index : 'codigoCliente',
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
				pager : '#pgrilla_mantenimiento_cliente',
				sortname : 'id',
				viewrecords : true,
				sortorder : "desc",
				scrollOffset: 0 //Not space column last
		});
	
	$("#btnRegistrarCliente").click(function(){
		registrarCliente();
	});
});


function registrarCliente(){
	
	$("#inputFields input").each(function(){
	    if ($.trim($(this).val()).length == 0){
	        $(this).addClass("highlight");
	        isFormValid = false;
	        $(this).focus();
	    }
	    else{
	        $(this).removeClass("highlight");
	    }
	});
	
	
	var parametros=new Object();
	parametros.codigoCliente=$("#txtCodigoCliente").val();
	parametros.razonSocial=$("#txtRazonSocial").val();
	parametros.rucCliente=$("#txtRucCliente").val();
	parametros.telefono=$("#txtTelefono").val();
	parametros.nombreContacto=$("#txtNombreContacto").val();
	parametros.apellidosContacto=$("#txtApellidosContacto").val();
	
	$.ajax({
		url:"registrarCliente.json",
		data : parametros,
		dataType:"json",
		type:"POST",
		cache:false,
		async:false	
	}).done(function(jsondata){
		actualizarGrillaCliente();
	});
	
	
	function actualizarGrillaCliente(){
		$("#grilla_mantenimiento_cliente").jqGrid('setGridParam').trigger('reloadGrid');
	}
}