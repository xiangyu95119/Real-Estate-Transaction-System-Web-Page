<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to the Apartment Trading System !  
</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<a href="${contextPath}/user/login.htm">Login</a>
<a href="${contextPath}/user/create.htm">Register</a>
</body>
</html>
