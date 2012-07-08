<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rezeptzettel</title>
</head>
<body>
<h1>Rezeptzettel-Sammlung</h1>

<p>Greetings, it is now <c:out value="${now}"/></p>

<form action="/generate.htm" method="post">
	<p>Benutzername:<br><input name="username" type="text" size="30" maxlength="30"></p>
  	<p>Passwort:<br><input name="password" type="password" size="30" maxlength="40"></p>
  	<p><input type="submit" value="Generieren">
</form> 
</body>
</html>