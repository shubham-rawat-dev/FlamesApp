<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container text-center">
	<h1>Hi ${userName}</h1>
	<h2>Send result to your email</h2>
	<form:form class="mt-5" action="processEmail" modelAttribute="emailDto">

		<label>Enter your Email:</label>
		<form:input path="userEmail" />
		<input type="submit" value="send" />
	</form:form>
	</div>
</body>
</html>