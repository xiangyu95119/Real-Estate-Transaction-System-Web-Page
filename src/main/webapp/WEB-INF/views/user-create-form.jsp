<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form action="${contextPath}/user/create.htm" method="POST">
    
        <table>
        <tr>
            <td>User Name:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password"></td>
        </tr>
        
        <tr>
            <td>Email:</td>
            <td><input type="text" name="useremail"></td>
        </tr>
        
        <tr>
        <td>Role:</td>
        <td><select name = "userRole">
        <option value ="admin">admin</option>
        <option value ="user" >user</option></select></td>
        </tr>
        
        <tr>
            <td colspan="2"><input type="submit" value="Create" /></td>
        </tr>
                
        </table>
        
    </form>
</body>
</html>