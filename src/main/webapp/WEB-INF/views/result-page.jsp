<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h1 align="center">Flames App Predicts:</h1>
	<hr />

	${userInfo.userName} and ${userInfo.crushName} are
	<br /> ${appResult}
	<a href="${pageContext.request.contextPath}/sendEmail">Send Result
		to Your Email</a>
</body>
</html>