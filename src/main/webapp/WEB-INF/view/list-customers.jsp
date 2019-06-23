<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>customer-list</title>
</head>
<body>
	<div id="wraper">
		<div id="header">
			<h1>Customer Relationship Manager</h1>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input type="button" value="Add Customer"
				onclick="window.location.href='showCustomerAddForm'; return false;"
				class="add-button" />
				
			<form:form action="searchProcess" method="GET">
			Search Customer:
			<input type="text" name="theSearchName" placeholder="First/last Name"/>
			<input type="submit" value="Search" class="add-button"/>
			</form:form>

			<table>
				<tr>
					<th>Customer Id</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customers" items="${customersList}">
				
					<c:url var="updateLink" value="/customer/showCustomerUpdateForm">
					<c:param name="customerId" value="${customers.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/customer/deleteCustomer">
					<c:param name="customerId" value="${customers.id}"/>
					</c:url>
					
					<tr>
					
						<td>${customers.id}</td>
						<td>${customers.firstName}</td>
						<td>${customers.lastName}</td>
						<td>${customers.email}</td>
						
						<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"  onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>