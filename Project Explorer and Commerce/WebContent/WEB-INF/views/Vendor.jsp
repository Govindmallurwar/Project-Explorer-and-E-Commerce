<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Master1.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/product/registerProductPassThrough" var="registerMe" />
<spring:url value="/order/showOrderVendor/" var="statusMe" />

<spring:url value="/product/removeOrder/" var="removeOrderMe" />


<spring:url value="/product/passThroughUpdateProduct/" var="updateMe123" />

</head>
<body>
	<br>
	<br>
	<fieldset
		style="position: relative; left: 17px; width: 715px; height: 100px; border-style: solid;">
		<legend>Status</legend>
		<table style="margin-top: 10px; font-size: 18px; width: 50px;"
			cellpadding="10px" cellspacing="10px" border="1px">
			<tr style="padding-top: 10px; width: 10px">
				<td>
					<table>
						<tr>
							<td>Received(${countNoOfRequest})</td>
						</tr>
						<tr>
							<td><a href="${statusMe}1">NoOfOrders</a></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td>Pending(${countNoOfPending})</td>
						</tr>
						<tr>
							<td><a href="${statusMe}2">NoOfOrders</a></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td>Dispatched(${countNoOfDispatched})</td>
						</tr>
						<tr>
							<td><a href="${statusMe}3">NoOfOrders</a></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td>Completed(${countNoOfCompleted})</td>
						</tr>
						<tr>
							<td><a href="${statusMe}4">NoOfOrders</a></td>
						</tr>
					</table>
				</td>
				
				<td>
					<table>
						<tr>
							<td><a href="${registerMe}">AddNewProduct</a></td>
						</tr>
					</table>
				</td>
				
			</tr>
		</table>
		
		
		
	</fieldset>
	<br>
	<div class="products" style="float: left;  position: relative; left:20px;">
	<c:set var="test" value="${searchResult1}" />
        <div class="cl">&nbsp;</div>
        <ul>
        
        <c:forEach var="entry" items="${test}">
 			
          <li> <a href="${updateMe123}${entry.prodId}"><img src="data:image/jpeg;base64,${entry.imageAddr}"></a>
            <div class="product-info">
              <h3>${entry.prodName}</h3>
              <div class="product-desc">
                  <span style="color: red;size:3px;background-color: silver;"> ${entry.discount.venderDiscount} </span>
                <strong class="price">Rs ${entry.prodPrice}</strong>
                <a href="${removeOrderMe}${entry.prodId}" style="color: red;">Remove</a>
                 </div>
                 
            </div>
          </li>
          
         </c:forEach> 
         </ul>
      <div class="cl">&nbsp;</div>

        
     <c:set var="test" value="${searchResult2}" />   
      <div class="cl" style="padding: 5px">&nbsp;</div>
        <ul>
          <c:forEach var="entry" items="${test}">
           <li> <a href="${updateMe123}${entry.prodId}"><img src="data:image/jpeg;base64,${entry.imageAddr}"></a>
            <div class="product-info">
              <h3>${entry.prodName}</h3>
              <div class="product-desc">
                  <span style="color: red;size:3px;background-color: silver;"> ${entry.discount.venderDiscount} </span>
                <strong class="price">Rs ${entry.prodPrice}</strong>
                <a href="${removeOrderMe}${entry.prodId}" style="color: red;">Remove</a>
                 </div>
                 
            </div>
          </li>
         </c:forEach> 
         </ul>
       <div class="cl">&nbsp;</div>
        
     <c:set var="test" value="${searchResult3}" /> 
         <div class="cl" style="padding: 5px">&nbsp;</div>
        <ul>
          <c:forEach var="entry" items="${test}">
           <li> <a href="${updateMe123}${entry.prodId}"><img src="data:image/jpeg;base64,${entry.imageAddr}"></a>
            <div class="product-info">
              <h3>${entry.prodName}</h3>
              <div class="product-desc">
                  <span style="color: red;size:3px;background-color: silver;"> ${entry.discount.venderDiscount} </span>
                <strong class="price">Rs ${entry.prodPrice}</strong>
                <a href="${removeOrderMe}${entry.prodId}" style="color: red;">Remove</a>
                 </div>
                 
            </div>
          </li>
         </c:forEach> 
         </ul>
       <div class="cl">&nbsp;</div>
       
      </div>
 

	<br>
	

</body>
</html>