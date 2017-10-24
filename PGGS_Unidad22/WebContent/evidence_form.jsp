<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evidence Form</title>
</head>
<body>

<form action="EvidenceController">

		<label>Code:</label><br>
		<input type = "text" name= "code" value = "${evidence.code}" /><br>
		
		<label>AssociationId:</label><br>
		<input type = "text" name= "associationId" value = "${evidence.associationId}" /><br>
		
		<label>DbxrefId:</label><br>
		<input type = "text" name= "dbxrefId" value = "${evidence.dbxrefId}" /><br>
		
		<label>SeqAcc:</label><br>
		<input type = "text" name= "seqAcc" value = "${evidence.seqAcc}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>

</form>

</body>
</html>