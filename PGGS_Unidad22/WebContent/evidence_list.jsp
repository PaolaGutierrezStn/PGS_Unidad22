<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evidences</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="EvidenceController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Code</th>
			 <th>AssociationId</th>
			  <th>DbxrefId</th>
			  <th>SeqAcc</th>
			
		</tr>
		<c:forEach var="evidence" items="${evidences}">
		
		<tr>
			<td>
				<form action= "EvidenceController">
					<input type = "hidden" name = "id" value= "${evidence.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${evidence.id}</td>
			<td> ${evidence.code}</td>
			<td> ${evidence.associationId}</td>
			<td> ${evidence.dbxrefId}</td>
			<td> ${evidence.seqAcc}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>