<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer-list</title>
</head>
<body>
	<div id="wraper">
		<div id="header">
			<h1>Customer Relationship Manager</h1>
		</div>
		${customersList}
		${num}
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
				</tr>
				<c:forEach var="customers" items="${customersList}">
					<tr>
						<td>${customers.firstName}</td>
						<td>${customers.lastName}</td>
						<td>${customers.email}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>