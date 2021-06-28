<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Policy Administration System</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Pinyon+Script&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Potta+One&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/style-table.css">
<link rel="stylesheet" href="/css/style-admin.css">
</head>
<body> 
	<div class="main-container">
		<%@ include file="fragments/header.jsp"%>
		<div class="main">
			<h1>Policy Administration System</h1>
		</div>
		
		<div class="right-main">
			<div class="container login-section">
				<h1>Login here</h1>
				<form:form action="/policy/login" method="post"
					modelAttribute="user">
					<div class="form-group">
						<form:label path="userName" for="username">Username</form:label>
						<form:input type="text" path="userName" class="form-control"
							id="username" name="name" placeholder="Enter Username"
							required="required" autocomplete="off" />

					</div>
					<div class="form-group">
						<form:label path="password" for="password">Password</form:label>
						<form:input type="password" path="password" class="form-control"
							id="password" name="password" placeholder="Enter Password"
							required="required" autocomplete="off" />

					</div>
					<form:button type="submit" class="btn btn-login">Login</form:button>
					<button class="btn btn-reset" onclick="customLoginReset()">Reset</button>
				</form:form>
				<c:choose>
					<c:when test="${not empty errorMessage}">

						<div class="error">${errorMessage}</div>
					</c:when>
				</c:choose>
			</div>
		</div>

		

		<%@ include file="fragments/footer.jsp"%>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/js/script.js"></script>
</body>

</html>