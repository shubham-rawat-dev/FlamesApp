<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Response</title>
</head>
<body>
<div class="text-center">
	<h2>Hi ${userName}</h2>
	<label>Email Sent Successfully to ${emailDto.userEmail}</label>
</div>
</body>
</html>