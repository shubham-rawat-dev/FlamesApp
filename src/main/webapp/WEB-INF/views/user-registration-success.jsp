<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
	<h1>Your Registration is successful</h1>
	Name:${userReg.name}
	<br /> User Name:${userReg.userName}
	<br /> Password:${userReg.password}
	<br /> Country:${userReg.countryName}
	<br /> Hobbies:
	<c:forEach var="x" items="${userReg.hobbies}">
${x}
</c:forEach>
	<br /> Gender:${userReg.gender}
	<br /> Email:${userReg.communicationDto.email}
	<br /> Phone:${userReg.communicationDto.phone}
</body>
</html>