

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.primary-background{
/*background:#2196f3!important;*/
background:#e2e2e2!important;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body class="primary-background">
	<nav class="navbar bg-primary navbar-expand-lg bg-body-tertiary" data-bs-theme="dark" >
		<div class="container-fluid">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">FlamesApp</a>
			
			
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item d-flex justify-content-end"><a class="nav-link "
						aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath}/register">Register
							Here</a></li>
							<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/viewAppHistory">App History
							</a></li>
					
				</ul>
			
			</div>
		</div>
	</nav>
</body>
</html>