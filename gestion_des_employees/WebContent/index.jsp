<%@page import="java.util.Iterator"%>
<%@page import="gestion_des_employees.Employe"%>
<%@page import="java.util.List"%>
<%@page import="gestion_des_employees.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%
Model model=new Model();
if(request.getAttribute("model") != null){
	 model=(Model)request.getAttribute("model");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Employes</title>
<link rel="stylesheet"" type="text/css"  href="<%=request.getContextPath()%>/css/style.css" >

	<script type="text/javascript">
		function confirmer(url){  
			
			var rep=confirm("Etes vous sur de vouloir supprimer ?");
			if(rep==true){
				document.location=url;
			}
			
		}
	</script>


