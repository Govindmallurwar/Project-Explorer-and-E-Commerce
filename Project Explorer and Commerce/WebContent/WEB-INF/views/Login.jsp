<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Master1.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/user/validate" var="validateMe" />
<spring:url value="/user/forgotPassword" var="forgotMe" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >


<h2 style="color: green;">&nbsp;&nbsp;&nbsp;&nbsp; ${msg}</h2>

<div style="padding:1px">
  
  <fieldset  style=" position: relative;
  left:20px; width: 715px; height:300px">
  
  <legend><h1>Login:</h1></legend>
  <form:form action="${validateMe}" method="post" modelAttribute="userModel">
    <table style="margin-top: 20px;font-size: 18px;" cellpadding="10px" cellspacing="10px">
    <tr  style="padding-top: 10px"><td><h2>Name:</h2> </td><td><input type="text" name="userName" placeholder="Username"></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Password: </h2></td><td><input type="password" name="password" placeholder="Password"></td></tr>
    <tr  style="margin-top: 20px;"><td colspan="2"><input type="submit" value="Login"></td></tr>
    </table><br><br>
     </form:form>
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="${forgotMe}" class="bul">Forgot Password..?</a><br><br>
    &nbsp;&nbsp;&nbsp;&nbsp;<a href="register" class="bul">New User..?</a>
 </fieldset>

 </div>
</body>
</html>