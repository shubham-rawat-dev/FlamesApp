<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Result Page</title>
</head>
<body>
	<h1 align="center">Bill Result</h1>
	<hr />
	Bill against credit card number
	<span style="color: blue;"> ${billDto.creditCard}</span> amounts to
	<span style="color: blue;">${billDto.amount}</span> ${billDto.currency}
	generated dated on
	<span style="color: blue;"> ${billDto.date}</span>
</body>
</html>