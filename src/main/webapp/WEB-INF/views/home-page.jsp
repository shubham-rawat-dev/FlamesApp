<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style type="text/css">

.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 35px;
}
</style>
<script type="text/javascript">
	function validateName() {
		var un = document.getElementById("yn").value;

		if (un.length < 1)
			return false;
		else
			return true;
	}
</script>

</head>
<body>
	<h1 align="center">Flames App</h1>
	<hr/>
	<div class="container-fluid mt-5 clip ">
		<form:form action="processHomepage" method="get"
			modelAttribute="userInfo">
			<div align="center">
				<p>
					<label class="form-label" for="yn">Your Name:</label>
					<form:input class="form-input" id="yn" path="userName" />
					<form:errors cssClass="error" path="userName"></form:errors>
				</p>	
				<p>
					<label class="form-label" for="cn">Crush Name:</label>
					<form:input class="form-input" path="crushName" id="cn" />
					<form:errors cssClass="error" path="crushName"></form:errors>

				</p>
				<p>
					<form:checkbox path="checkTermsAndConditions" id="checkbox" />
					<label class="form-check-label" for="checkbox">I am
						agreeing that this is for fun</label>
					<form:errors path="checkTermsAndConditions" cssClass="error"></form:errors>
				</p>
				<input type="submit" value="calculate" />
			</div>
		</form:form>
	</div>
</body>
</html>