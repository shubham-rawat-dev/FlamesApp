<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="base.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container text-center">

<h2 class="mt-3">Login Page</h2>
<c:if test="${param.error!=null}">

<i style="color:red;position:absolute;margin-left:-120px;">*Invalid Login and Password Credentials..</i>

</c:if>
<c:if test="${param.logout!=null}">

<i style="color:green;position:absolute;margin-left:-120px;">*Successfully Logged out ! Login Again</i>

</c:if>
<form:form action="processLogin">
<div class="mt-5">
<p>
<label for="userName">Enter Username:</label>
<input class="form-group" id="userName" name="username"/>
</p>
<p>
<label for="pwd">Enter Password:</label>
<input class="form-group" id="pwd" name="password"/>
</p>
<input type="submit" value="login"/>
</div>
</form:form>
</div>
</body>
</html>