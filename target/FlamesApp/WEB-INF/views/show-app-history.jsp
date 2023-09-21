<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1 align="center">Flames App History:</h1>
	<hr />
  <div class="container">
  <div class="row">
    <div class="col-md-8 offset-md-2">
     
        <div class="table-responsive">
              <table class="table table-bordered table-hover mt-3">
                  <thead class="table-dark">
                    <tr>
                      <th scope="col">User-Name</th>
                      <th scope="col">Crush-Name</th>
                      <th scope="col">Result</th>
                    </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${appHistory}" var="itr">
                    <tr>
                      <td><c:out value="${itr.userName}"></c:out></td>
                      <td><c:out value="${itr.crushName}"></c:out></td>
                      <td><c:out value="${itr.appResult}"></c:out></td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
      
      
          
        </div>

    </div>
</div>
</div>
</body>
</html>