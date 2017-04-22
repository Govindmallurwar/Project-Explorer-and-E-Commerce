<%@page import="com.app.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="Master1.jsp" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<spring:url value="/order/storeOrder" var="orderMe" />

<spring:url value="/feedback/passThroughFeedback/" var="feedbackMe" />
</head>
<body >
<div style="padding:1px">

 <c:forEach var="entry" items="${orderList}">

  <fieldset  style=" position: relative;
  left:20px; width: 715px; height:150px; border-style:inset;">
  <legend><h1></h1></legend>
  <c:set var="tot" value="${entry.product.prodPrice}"></c:set>
    <table style="margin-top: 10px;font-size: 18px;" cellpadding="10px" cellspacing="10px">
    <tr  style="padding-top: 10px"><td> </td><td></td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><h2>Price(With Discount)</h2> </td></tr>
    <tr  style="padding-top: 10px"><td><h2>Product Name: </h2></td><td>${entry.product.prodName}</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td rowspan="2"><h1 style="color: red;">Rs ${entry.product.prodPrice}</h1></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Vendor Name: </h2></td><td>${entry.product.user.name}</td></tr>
    <tr  style="padding-top: 10px"><td><h2>Status: </h2></td><td>${entry.status}</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td style="padding-left: 45px"></td></tr>
     <tr  style="padding-top: 10px"><td><c:if test="${entry.status eq 'completed'}"><a href="${feedbackMe}${entry.orderId}">feedback</a></c:if></td></tr>
    </table><br><br>
  </fieldset>
  <br>
 </c:forEach>
	
 </div>
 
</body>
</html>