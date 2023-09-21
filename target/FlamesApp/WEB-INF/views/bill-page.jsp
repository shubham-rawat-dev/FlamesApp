<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Page</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 35px;
}
</style>

</head>
<body>
	<div align="center">
		<h3>Bill</h3>
		<hr />
		<form:form action="processBill" modelAttribute="billDto">
			<p>
				<label>Credit Card:</label>
				<form:input path="creditCard" />
				<form:errors path="creditCard" cssClass="error"></form:errors>
			</p>
			<p>
				<label>Amount:</label>
				<form:input path="amount" />
				<form:errors path="amount" cssClass="error"></form:errors>
			</p>
			<p>
				<label>Currency:</label>
				<form:input path="currency" />
				<form:errors path="currency" cssClass="error"></form:errors>
			</p>
			<p>
				<label>Date:</label>
				<form:input path="date" />
				<form:errors path="date" cssClass="error"></form:errors>
			</p>
			<br />
			<input type="submit" value="pay bill" />

		</form:form>
	</div>
</body>
</html>