<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recipeboard</title>
</head>
<body>
<h1>Rezeptbuch-Sammlung</h1>

<form action="/recipeboard/recipe/generate" method="get">
	<p>Benutzername:<br><input name="username" type="text" size="30" maxlength="30"></p>
  	<p>Passwort:<br><input name="password" type="password" size="30" maxlength="40"></p>
  	<p><input type="submit" value="Generieren">
</form> 
</body>
</html>