<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Apartment</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Apartment Id</b></td>
			<td><b>Apartment Name</b></td>
			<td><b>Location</b></td>
			<td><b>Price</b></td>
		</tr>
		
		<c:forEach var="apt" items="${apts}">
			<tr> 
				<td>${apt.aptid}</td>
				<td>${apt.aptName}</td>
				<td>${apt.location}</td>
				<td>${apt.price}</td>
				<td><a href="${contextPath}/admin/deleteApt.htm?name=${apt.aptid}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>