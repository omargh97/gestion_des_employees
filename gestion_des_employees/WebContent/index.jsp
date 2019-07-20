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
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/style.css" >

	<script type="text/javascript">
		function confirmer(url){  
			
			var rep=confirm("Etes vous sur de vouloir supprimer ?");
			if(rep==true){
				document.location=url;
			}
			
		}
	</script>
</head> 
<body>
 
<div>
		<form action="controleur" method="post"> 
				<table>
					<tr> 
						<td>Mot Clé:  </td>
						<td> <input type="text" name="motCle" value="<%= model.getMotCle() %>"/></td>
						<td><input type="submit" name="action" value="chercher" /> </td>
					</tr>
				</table>
		</form>
</div>

<div>
		<form action="controleur" method="post"> 
		<input type="hidden" name="saveORediter" value="<%= model.getSaveORediter() %>"/>
				<table>
					
					<tr> 
						<td>Nom:  </td>
						<td> <input type="text" name="nom"  value="<%= model.getEmploye().getNom() %>"/></td>
					</tr>
					
					<tr> 
						<td>Prenom:  </td>
						<td> <input type="text" name="prenom"  value="<%= model.getEmploye().getPrenom() %>" /></td>
					</tr>
					
					<tr> 
						<td>Matricule:  </td>
						<% if( model.getSaveORediter().equals("editer")) {  %>
							<td>  <%= model.getEmploye().getMatricule()%> <input type="hidden" name="referenceEmployeToEdit" value="<%= model.getEmploye().getMatricule()%>"/></td>
						<%  } else { %>
							<td> <input type="text" name="reference"  value="<%= model.getEmploye().getMatricule()%>" /></td>	
						
						<% } %> 
					 </tr>
					 
					<tr> 
						<td>Sexe:  </td>
						<td> <input type="text" name="Sexe" value="<%= model.getEmploye().getSexe() %>" /></td>
					</tr>
					
					<tr> 
						<td>Note:  </td>
						<td> <input type="text" name="Note" value="<%= model.getEmploye().getNote() %>" /></td>
					</tr>
					
					<tr> 
						<td>Service:  </td>
						<td> <input type="text" name="Service" value="<%= model.getEmploye().getService() %>" /></td>
					</tr>
					
					<tr> 
						<td>Date_eval:  </td>
						<td> <input type="text" name="Date_eval" value="<%= model.getEmploye().getDate_eval() %>" /></td>
					</tr>
					
					<tr> 
						<td>Historique_maladie:  </td>
						<td> <input type="text" name="Historique_maladie" value="<%= model.getEmploye().getHistorique_maladie() %>" /></td>
					</tr>
					
					
					
					<tr>  
						<td> <input type="submit" name="action" value="save"/></td>
					</tr>
					
				</table>
		</form>
</div>


<div>
		<table class="table1">
			<tr>
					<th>nom </th> <th>prenom </th> <th>matricule </th> <th>sexe </th> <th>note </th>
	<th>service </th>	<th>date_eval </th> <th>hostorique_maladie </th> </tr>
			 
			 <% 
			    Iterator<Employe>  empl=model.getEmployeParMC().iterator();
				while( empl.hasNext()) {
				 	Employe e= empl.next(); 
			 %>
			 
			 <tr> 
					 <td><%= e.getNom() %> </td>
					 <td><%= e.getPrenom() %>  </td>
					 <td> <%= e.getMatricule() %> </td>
					 <td><%= e.getSexe() %>  </td>
					 <td><%= e.getNote() %>  </td>
					 <td><%= e.getService() %>  </td>
					 <td><%= e.getDate_eval() %>  </td>
					 <td><%= e.getHistorique_maladie() %>  </td>
					 <td> <a href="javascript:confirmer('controleur.php?action=delete&ref=<%= e.getMatricule() %>')"> supprimer </a> </td>
					 <td> <a href="controleur.php?action=editer&ref=<%= e.getMatricule() %>"> editer </a> </td>
			 </tr>
		 <% } %>
		</table>

</div>




</body>
</html>


