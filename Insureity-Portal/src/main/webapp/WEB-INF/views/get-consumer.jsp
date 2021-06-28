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
				<h1>Find Consumer By Id</h1>
				<div class="container">
					<form:form action="getconsumers" method="GET"
						modelAttribute="findconsumer">
						<div class="form-group">
							<form:label path="id">Enter Id:</form:label>
							<form:input path="id" class="form-control" id="id"
								required="required" />
						</div>

						<form:button class="btn">Search</form:button>
					</form:form>
				</div>
				<div class="container result-container center border">
					<h3>Search Result</h3>
					<c:choose>
						<c:when test="${not empty error}">
							<div class="error">${error}</div>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${not empty list}">
									<c:forEach items="${list}" var="consumer">
										<span><h5>ID</h5> </span>
										<span> : </span>
										<span>${consumer.getId()}</span>
										<br />
										<span><h5>Consumer Name</h5></span>
										<span> : </span>
										<span>${consumer.getName()}</span>
										<br />
										<span><h5>D.O.B</h5></span>
										<span> : </span>
										<span>${consumer.getDob()}</span>
										<br />
										<span><h5>Consumer Pan Details</h5></span>
										<span> : </span>
										<span>${consumer.getPandetails()}</span>
										<br />
										<span><h5>Email</h5></span>
										<span> : </span>
										<span>${consumer.getEmail()}</span>
										<br />
										<span><h5>Phone</h5></span>
										<span> : </span>
										<span>${consumer.getPhone()}</span>
										<br />
										<span><h5>Agent Name</h5></span>
										<span> : </span>
										<span>${consumer.getAgentname()}</span>
										<br />
										<span><h5>Agent Id</h5></span>
										<span> : </span>
										<span>${consumer.getAgentid()}</span>
										<br />
										<c:forEach items="${consumer.getBusiness()}" var="business">
											<span><h5>Business Id</h5></span>
											<span> : </span>
											<span>${business.getId()}</span>
											<br />
											<span><h5>Business Category</h5></span>
											<span> : </span>
											<span>${business.getBusinesscategory()}</span>
											<br />
											<span><h5>Business Type</h5></span>
											<span> : </span>
											<span>${business.getBusinesstype()}</span>
											<br />
											<span><h5>Business Turnover</h5></span>
											<span> : </span>
											<span>${business.getBusinessturnover()}</span>
											<br />
											<span><h5>Capital Invested</h5></span>
											<span> : </span>
											<span>${business.getCapitalinvested()}</span>
											<br />
											<span><h5>Total Employees</h5></span>
											<span> : </span>
											<span>${business.getTotalemployees()}</span>
											<br />
											<span><h5>Business Value</h5></span>
											<span> : </span>
											<span>${business.getBusinessvalue()}</span>
											<br />
											<span><h5>Business Age</h5></span>
											<span> : </span>
											<span>${business.getBusinessage()}</span>
											<br />
											<c:forEach items="${business.getProperty()}" var="property">
												<span><h5>Property Id</h5></span>
												<span> : </span>
												<span>${property.getId()}</span>
												<br />
												<span><h5>Property Type</h5></span>
												<span> : </span>
												<span>${property.getPropertytype()}</span>
												<br />
												<span><h5>Building Sqft</h5></span>
												<span> : </span>
												<span>${property.getBuildingsqft()}</span>
												<br />
												<span><h5>Building Type</h5></span>
												<span> : </span>
												<span>${property.getBuildingtype()}</span>
												<br />
												<span><h5>Building Storeys</h5></span>
												<span> : </span>
												<span>${property.getBuildingstoreys()}</span>
												<br />
												<span><h5>Building Age</h5></span>
												<span> : </span>
												<span>${property.getBuildingage()}</span>
												<br />
												<span><h5>Property Value</h5></span>
												<span> : </span>
												<span>${property.getPropertyvalue()}</span>
												<br />
												<span><h5>Cost of the Asset</h5></span>
												<span> : </span>
												<span>${property.getCostoftheasset()}</span>
												<br />
												<span><h5>Usefull Life Of The Asset</h5></span>
												<span> : </span>
												<span>${property.getUsefullifeoftheAsset()}</span>
												<br />
												<span><h5>Salvage Value</h5></span>
												<span> : </span>
												<span>${property.getSalvagevalue()}</span>
												<br />
												<hr />
											</c:forEach>
											<hr />
										</c:forEach>
										<br />
										<hr />
									</c:forEach>
								</c:when>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<%@ include file="fragments/footer.jsp"%>
	</div>
</body>
</html>