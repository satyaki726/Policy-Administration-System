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
				<h1>Find Policy</h1>
				<div class="container">
					<form:form action="viewPolicy" method="GET"
						modelAttribute="findPolicy">
						<div class="form-group">
							<form:label path="cid">Enter Consumer Id:</form:label>
							<form:input path="cid" class="form-control" id="cid"
								required="required" />
						</div>
						<div class="form-group">
							<form:label path="pid">Enter Policy Id:</form:label>
							<form:input path="pid" class="form-control" id="pid"
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
									<c:forEach items="${list}" var="policy">
										<span><h5>ID</h5> </span>
										<span> : </span>
										<span>${policy.getId()}</span>
										<br />
										<span><h5>Policy Id</h5></span>
										<span> : </span>
										<span>${policy.getPid()}</span>
										<br />
										<span><h5>Property Type</h5></span>
										<span> : </span>
										<span>${policy.getProperty_type()}</span>
										<br />
										<span><h5>Consumer Type</h5></span>
										<span> : </span>
										<span>${policy.getConsumer_type()}</span>
										<br />
										<span><h5>Assured Sum</h5></span>
										<span> : </span>
										<span>${policy.getAssured_sum()}</span>
										<br />
										<span><h5>Tenure</h5></span>
										<span> : </span>
										<span>${policy.getTenure()}</span>
										<br />
										<span><h5>Business Value</h5></span>
										<span> : </span>
										<span>${policy.getBusinessValue()}</span>
										<br />
										<br />
										<span><h5>Property Value</h5></span>
										<span> : </span>
										<span>${policy.getPropertyValue()}</span>
										<br />
										<br />
										<span><h5>Base Location</h5></span>
										<span> : </span>
										<span>${policy.getBase_location()}</span>
										<br />
										<br />
										<span><h5>Type</h5></span>
										<span> : </span>
										<span>${policy.getType()}</span>
										<br />
										<br />
										<span><h5>Accepted Quotes</h5></span>
										<span> : </span>
										<span>${policy.getAcceptedquote()}</span>
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