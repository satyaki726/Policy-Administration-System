<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/style-table.css">
<link rel="stylesheet" href="/css/style-admin.css">
</head>
<body>
	<div class="main-container-register">
		<%@ include file="fragments/header.jsp"%>
		<div class="section grid">
			<%@ include file="admin-fragments/admin-sidebar.jsp"%>
			<div class="content list-container">
				<h1>Create Policy</h1>
				<div class="container">
					<form:form action="createPolicy" method="POST"
						modelAttribute="policyMaster">
						<div class="form-group">
							<form:label path="property_type">Enter the Property Type:</form:label>
							<form:select path="property_type" class="form-control"
								items="${propertyType}" id="property_type" required="required" />
						</div>
						<div class="form-group">
							<form:label path="consumer_type">Enter the Consumer Type:</form:label>
							<form:select path="consumer_type" class="form-control"
								items="${consumerType}" id="consumer_type" required="required" />
						</div>
						<div class="form-group">
							<form:label path="assured_sum">Enter the Assured Sum:</form:label>
							<form:input path="assured_sum" class="form-control"
								id="assured_sum" required="required" />
						</div>
						<div class="form-group">
							<form:label path="tenure">Enter the tenure:</form:label>
							<form:input path="tenure" class="form-control" id="tenure"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="businessValue">Enter the Business Value:</form:label>
							<form:input path="businessValue" class="form-control"
								id="businessValue" required="required" />
						</div>
						<div class="form-group">
							<form:label path="propertyValue">Enter the Property Value:</form:label>
							<form:input path="propertyValue" class="form-control"
								id="propertyValue" required="required" />
						</div>
						<div class="form-group">
							<form:label path="base_location">Enter the Base Location:</form:label>
							<form:input path="base_location" class="form-control"
								id="base_location" required="required" />
						</div>
						<div class="form-group">
							<form:label path="type">Enter the type of Business:</form:label>
							<form:input path="type" class="form-control" id="type"
								required="required" />
						</div>
						<form:button class="btn">Create</form:button>
					</form:form>
					<h1>${success}</h1>
				</div>

			</div>
		</div>
	</div>
</body>
</html>