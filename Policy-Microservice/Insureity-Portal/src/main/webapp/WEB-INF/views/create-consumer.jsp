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
				<h1>Create Consumer</h1>
				<div class="container">
					<form:form action="consumers" method="POST"
						modelAttribute="consumerRequest">
						<div class="form-group">
							<form:label path="name">Enter the Name:</form:label>
							<form:input path="name" class="form-control" id="name"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="dob">Enter DOB:</form:label>
							<form:input path="dob" class="form-control" id="dob"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="pandetails">Enter the Pan Details:</form:label>
							<form:input path="pandetails" class="form-control"
								id="pandetails" required="required" />
						</div>
						<div class="form-group">
							<form:label path="email">Enter the Email:</form:label>
							<form:input path="email" class="form-control" id="email"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="phone">Enter the phone number:</form:label>
							<form:input path="phone" class="form-control" id="phone"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="agentname">Enter the agent name:</form:label>
							<form:input path="agentname" class="form-control" id="agentname"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="agentid">Enter the agent id:</form:label>
							<form:input path="agentid" class="form-control" id="agentid"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="businesscategory">Enter the Business Category:</form:label>
							<form:select path="businesscategory" class="form-control"
								id="businesscategory" items="${businessCategory}"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="businesstype">Enter the Business Type:</form:label>
							<form:select path="businesstype" class="form-control"
								id="businesstype" items="${businessType}" required="required" />
						</div>
						<div class="form-group">
							<form:label path="businessturnover">Enter the Business Turnover:</form:label>
							<form:input path="businessturnover" class="form-control"
								id="businessturnover" required="required" />
						</div>
						<div class="form-group">
							<form:label path="capitalinvested">Enter the Capital Invested:</form:label>
							<form:input path="capitalinvested" class="form-control"
								id="capitalinvested" required="required" />
						</div>
						<div class="form-group">
							<form:label path="totalemployees">Enter the Total Employees:</form:label>
							<form:input path="totalemployees" class="form-control"
								id="totalemployees" required="required" />
						</div>
						<div class="form-group">
							<form:label path="businessage">Enter the Business Age:</form:label>
							<form:input path="businessage" class="form-control"
								id="businessage" required="required" />
						</div>
						<div class="form-group">
							<form:label path="propertytype">Enter the Property Type:</form:label>
							<form:select path="propertytype" class="form-control"
								id="propertytype" items="${propertyType}" required="required" />
						</div>
						<div class="form-group">
							<form:label path="buildingsqft">Enter the Building Sqft:</form:label>
							<form:input path="buildingsqft" class="form-control"
								id="buildingsqft" required="required" />
						</div>
						<div class="form-group">
							<form:label path="buildingtype">Enter the Building Type:</form:label>
							<form:select path="buildingtype" class="form-control"
								id="buildingtype" items="${buildingType}" required="required" />
						</div>
						<div class="form-group">
							<form:label path="buildingstoreys">Enter the Building Storeys:</form:label>
							<form:input path="buildingstoreys" class="form-control"
								id="buildingstoreys" required="required" />
						</div>
						<div class="form-group">
							<form:label path="buildingage">Enter the Building Age:</form:label>
							<form:input path="buildingage" class="form-control"
								id="buildingage" required="required" />
						</div>
						<div class="form-group">
							<form:label path="costoftheasset">Enter the Cost of the asset:</form:label>
							<form:input path="costoftheasset" class="form-control"
								id="costoftheasset" required="required" />
						</div>
						<div class="form-group">
							<form:label path="usefullifeoftheAsset">Enter the Useful life of the Asset:</form:label>
							<form:input path="usefullifeoftheAsset" class="form-control"
								id="usefullifeoftheAsset" required="required" />
						</div>
						<div class="form-group">
							<form:label path="salvagevalue">Enter the Salvage Value:</form:label>
							<form:input path="salvagevalue" class="form-control"
								id="salvagevalue" required="required" />
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