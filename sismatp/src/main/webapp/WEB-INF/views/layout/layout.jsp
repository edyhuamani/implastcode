<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta http-equiv="Expires" content="-1" />



<title><tiles:insertAttribute name="title" /></title>

<!-- menu api inicio -->
<link type="text/css" href="<%=request.getContextPath()%>/jquery/js/menu.css" rel="stylesheet" />
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/js/menu.js"></script>
<!-- menu api fin  -->

<!-- jqgrid -->
<!-- <script type="text/javascript" src="<%=request.getContextPath()%>/jqgrid/jquery-1.11.0.min.js"></script>-->
<script type="text/javascript" src="<%=request.getContextPath()%>/jqgrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jqgrid/grid.locale-es.js"></script>
<!-- jqgrid fin -->

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jqgrid/ui.jqgrid.css" />

</head>
<body>
	<div id="container">
	    <tiles:insertAttribute name="header" />
	    <tiles:insertAttribute name="body" />
	    <tiles:insertAttribute name="footer" />
	</div>
</body>
</html>