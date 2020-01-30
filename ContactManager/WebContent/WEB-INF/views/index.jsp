<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Manager Home</title>
</head>
<body>
	<div align="center">
		<h1>Contact List</h1>
		<h3>
			<a href="new">New Contact</a>
		</h3>
		<table border="1" cellPadding="s">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listContacts }" var="contact" varStatus="status">
				<tr>
					<td>${contact.id }</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.phone}</td>
					<td><a href="edit?id=${contact.id}">Edit</a></td>
					<td><a href="delete?id=${contact.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>