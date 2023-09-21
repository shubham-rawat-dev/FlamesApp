<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h1 align="center">Flames App Predicts:</h1>
	<hr />
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div style="background: #e2e2e2;" class="card-body">

						<h2>
							${userInfo.userName} and ${userInfo.crushName} are <br />
							${appResult}
						</h2>
						<span class="text-end"><a
							href="${pageContext.request.contextPath}/sendEmail">Send
								Result to Your Email</a></span>
								<span class="text-end"><a
									href="${pageContext.request.contextPath}/viewAppHistory">Show App History</a></span>

					</div>

				</div>

			</div>
		</div>
	</div>
</body>
</html>