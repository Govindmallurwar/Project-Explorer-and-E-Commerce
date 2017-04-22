<%@page import="java.awt.Image"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.io.File"%>
<%@page import="com.app.pojo.Product"%>
<%@page import="java.util.List,java.io.BufferedOutputStream,java.io.ByteArrayOutputStream"%>
<%@page import="java.io.FileInputStream,java.io.FileOutputStream,org.apache.tomcat.util.codec.binary.Base64" %>
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
<spring:url value="/order/addProduct/" var="addMe" />
</head>
<body><br>
<h3 style="color: green;">&nbsp;&nbsp;&nbsp;&nbsp;${status}</h3><br>
<div class="products" style="float: left;  position: relative; left:20px;">
	<c:set var="test" value="${searchResult1}" />
        <div class="cl">&nbsp;</div>
        <ul>
        <c:forEach var="entry" items="${test}">
 
          <li> <a href="${addMe}${entry.prodId}"><img src="data:image/jpeg;base64,${entry.imageAddr}"></a>
            <div class="product-info">
              <h3>${entry.prodName}</h3>
              <div class="product-desc">
                  <span style="color: red;size:3px;background-color: silver;"> ${entry.discount.venderDiscount} </span>
                <strong class="price">Rs ${entry.prodPrice}</strong> </div>
            </div>
          </li>
         </c:forEach> 
         </ul>
      <div class="cl">&nbsp;</div>

        
     <c:set var="test" value="${searchResult2}" />   
      <div class="cl" style="padding: 5px">&nbsp;</div>
        <ul>
          <c:forEach var="entry" items="${test}">
           <li> <a href="${addMe}${entry.prodId}"><img src="data:image/jpeg;base64,${entry.imageAddr}"></a>
            <div class="product-info">
              <h3>${entry.prodName}</h3>
             <div class="product-desc">
                  <span style="color: red;size:3px;background-color: silver;"> ${entry.discount.venderDiscount} </span>
                <strong class="price">Rs ${entry.prodPrice}</strong> </div>
            </div>
          </li>
         </c:forEach> 
         </ul>
       <div class="cl">&nbsp;</div>
        
     <c:set var="test" value="${searchResult3}" /> 
         <div class="cl" style="padding: 5px">&nbsp;</div>
        <ul>
          <c:forEach var="entry" items="${test}">
           <li> <a href="${addMe}${entry.prodId}"><img src="data:image/jpeg;base64,${entry.imageAddr}"></a>
            <div class="product-info">
              <h3>${entry.prodName}</h3>
              <div class="product-desc">
                  <span style="color: red;size:3px;background-color: silver;"> ${entry.discount.venderDiscount} </span>
                <strong class="price">Rs ${entry.prodPrice}</strong> </div>
            </div>
          </li>
         </c:forEach> 
         </ul>
       <div class="cl">&nbsp;</div>
       
      </div>
 
</body>
</html>