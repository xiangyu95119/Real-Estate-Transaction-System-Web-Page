<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form action="${contextPath}/admin/newApt.htm" method="POST">
    
        <table>
        <tr>
            <td>Apartment Name:</td>
            <td><input type="text" name="aptName"></td>
        </tr>
        
        <tr>
            <td>Location:</td>
            <td><input type="text" name="location"></td>
        </tr>
        
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price"></td>
        </tr>
        
        <tr>
            <td colspan="2"><input type="submit" value="Create" /></td>
        </tr>
                
        </table>
        
    </form>
</body>
</html>