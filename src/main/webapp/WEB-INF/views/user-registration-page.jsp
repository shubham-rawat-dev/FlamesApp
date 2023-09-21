<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="base.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
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
	<h1 align="center">Please Register Here</h1>
	<form:form action="registrationSuccess" modelAttribute="userReg">
		<div align="center">
			<p>
				<label for="name">User:</label>
				<form:input id="name" path="name" />
				<form:errors path="name" cssClass="error"></form:errors>
			</p>
			<p>
				<label for="userName">UserName:</label>
				<form:input id="userName" path="username" />
				<form:errors path="username" cssClass="error"></form:errors>
			</p>
			<p>
				<label for="pwd">Password:</label>
				<form:password id="pwd" path="password" />
			</p>
			<p>
				<label for="age">Age:</label>
				<form:input id="age" path="age" />
				<form:errors path="age" cssClass="error"></form:errors>
			</p>
			<p>
				<label>Country:</label>
				<form:select path="countryName">
					<form:option value="Ind" label="India">
					</form:option>
					<form:option value="Usa" label="United States">
					</form:option>
					<form:option value="Pak" label="Pakistan">
					</form:option>
					<form:option value="Sl" label="Sri Lanka">
					</form:option>
				</form:select>
			</p>
			<p>
				<label>Hobbies:</label> Cricket:
				<form:checkbox path="hobbies" value="cricket" />
				Reading:
				<form:checkbox path="hobbies" value="reading" />
				Travel:
				<form:checkbox path="hobbies" value="travel" />
				Coding:
				<form:checkbox path="hobbies" value="coding" />
			</p>
			<p>
				<label>Gender:</label> Male:
				<form:radiobutton path="gender" value="male" />
				Female:
				<form:radiobutton path="gender" value="female" />
			</p>
				<p>
				<label>Account Enabled</label> True
				<form:radiobutton path="enabled" value="true" />
				False:
				<form:radiobutton path="enabled" value="false" />
				
			</p>

			<div align="center">
				<h3>Communication</h3>
				<p>
					<label>Email:</label>
					<form:input path="communicationDto.email" />
					<form:errors path="communicationDto.email" cssClass="error"></form:errors>
				</p>
				<p>
					<label>Phone:</label>
					<form:input path="communicationDto.phone" />
				</p>
			</div>

			<input type="submit" value="register" />
		</div>
	</form:form>
</body>
</html>