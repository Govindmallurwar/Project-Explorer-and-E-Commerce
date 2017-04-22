<%@page import="com.app.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Master1.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%!double totalPrice;
	double discountPrice;%>
<spring:url value="/order/storeOrder" var="orderMe" />
</head>
<body>
	<div style="padding: 1px">

		<form action="${orderMe}">
			<c:forEach var="entry" items="${orderList}">
				<fieldset
					style="position: relative; left: 20px; width: 715px; height: 150px; border-style: inset;">
					<legend>
						<h1></h1>
					</legend>
					<c:set var="tot" value="${entry.product.prodPrice}"></c:set>
					<c:set var="disctot"
						value="${entry.product.discount.venderDiscount}"></c:set>
					<%
						double tot = ((double) pageContext.getAttribute("tot"));
							double disc = 1-(((double) pageContext.getAttribute("disctot"))/100);
							
							totalPrice = totalPrice + tot;
							discountPrice = discountPrice + tot * disc;
					%>
					<table style="margin-top: 10px; font-size: 18px;"
						cellpadding="10px" cellspacing="10px">
						<tr style="padding-top: 10px">
							<td><h2>Vendor Name:</h2></td>
							<td>${entry.product.user.name}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><h2>Price</h2></td>
						</tr>
						<tr style="padding-top: 10px">
							<td><h2>Product Name:</h2></td>
							<td>${entry.product.prodName}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td rowspan="2"><h1 style="color: red;">Rs
									${entry.product.prodPrice}</h1></td>
						</tr>
						<tr style="padding-top: 10px">
							<td><h2>Discount:</h2></td>
							<td>${entry.product.discount.venderDiscount}</td>
						</tr>
						<tr style="padding-top: 10px">
							<td><h2>Status:</h2></td>
							<td>${entry.status}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td style="padding-left: 45px"><input type="button"
								value="Cancel"></td>
						</tr>
					</table>
					<br>
					<br>
				</fieldset>
				<br>
			</c:forEach>
			<h1 style="margin-left: 16.7em">
				Total Price
				<%=totalPrice%></h1>
			<br>
			<br>
			<h1 style="margin-left: 16.7em">
				Discounted Price
				<%=discountPrice%></h1>
			<br>
			<br>
			<%
				totalPrice = 0;
				discountPrice = 0;
			%>
			<input type="submit" value="Place Order"
				style="margin-left: 16.7em; height: 50px; width: 200px; font-size: 20px">
		</form>
	</div>

</body>
</html>