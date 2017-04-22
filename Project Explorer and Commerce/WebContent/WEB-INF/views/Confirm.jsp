<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Master1.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/order/changeOrder/" var="changeMe" />
</head>
<body>
	<div style="padding: 1px">
		<c:if test="${noOfOrder < 1}">
			<p style="color: red;">
				<big><big>NO ORDER FOUND......</big></big>
			</p>
		</c:if>


		<c:forEach var="entry" items="${statusOrder}">
			<form action="${changeMe}${entry.orderId}" method="get">
				<fieldset
					style="position: relative; left: 20px; width: 715px; height: 170px; border-style: inset;">
					<legend></legend>
					<table style="margin-top: 10px; font-size: 18px;"
						cellpadding="10px" cellspacing="10px">
						<tr style="padding-top: 10px">
							<td><h2>Product Name:</h2></td>
							<td>${entry.product.prodName}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><c:if test="${entry.status ne 'completed'}">
									<select class="field" name="status">
										<option value="requested"
											<c:if test="${entry.status eq 'requested'}">selected="selected"</c:if>>requested</option>
										<option value="pending"
											<c:if test="${entry.status eq 'pending'}">selected="selected"</c:if>>pending</option>
										<option value="dispatched"
											<c:if test="${entry.status eq 'dispatched'}">selected="selected"</c:if>>dispatched</option>
										<option value="completed"
											<c:if test="${entry.status eq 'completed'}">selected="selected"</c:if>>completed</option>
										<option value="reject"
											<c:if test="${entry.status eq 'reject'}">selected="selected"</c:if>>reject</option>
									</select>
								</c:if> <c:if test="${entry.status eq 'completed'}">
									<h2 style="color: green;"><big><big>Order Completed</big></big></h2>
								</c:if></td>
						</tr>
						<tr style="padding-top: 10px">
							<td><h2>Customer Name:</h2></td>
							<td>${entry.customer.name}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<tr style="padding-top: 10px">
							<td><h2>Email</h2></td>
							<td>${entry.customer.emailId}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td style="padding-left: 0px" rowspan="2"><c:if
									test="${entry.status ne 'completed'}">

									<input type="submit" value="Proceed"
										style="height: 50px; width: 100px; font-size: 15px">
								</c:if></td>
						</tr>
						<tr style="padding-top: 10px">
							<td><h2>Contact No:</h2></td>
							<td>${entry.customer.contactNumber}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr style="padding-top: 10px">
							<td><h2>Address</h2></td>
							<td>${entry.customer.address}</td>
						</tr>
					</table>
					<br> <br>
				</fieldset>
			</form>
			<br>
		</c:forEach>

	</div>
</body>
</html>