<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="Master1.jsp" %>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.FieldError{color: red;}

</style>


<spring:url value="/user/register" var="updateMe" />


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
</head>
<body >
<script type="text/javascript">
function validateMe() 
{
	var first=document.getElementById("first").value;
	var second=document.getElementById("second").value;
	if(first!=second)
	{
		alert("Please comfirm your password");
		return false;
	}
	
}

</script>
<div style="padding:1px">
 <form:form action="${updateMe}" method="post" modelAttribute="updateModel" onsubmit="return validateMe()">
  <fieldset  style=" position: relative;
 left:20px; width: 715px; height:470px"">
  <legend><h1>Sign Up</h1></legend>
    <table style="margin-top: 20px;font-size: 18px;" cellpadding="10px" cellspacing="10px">
    <tr  style="padding-top: 10px"><td><h2>Id: </h2></td><td><form:input  path="userId" readonly="readonly" id="id321"/></td></tr>
   
      <tr  style="padding-top: 10px"><td><h2>Name:</h2></td><td><form:input  path="name" placeholder="Userpath"/></td><td><form:errors path="name" cssClass="FieldError"></form:errors></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Username: </h2> </td><td><form:input  path="userName" placeholder="Username"/></td><td><form:errors path="userName" cssClass="FieldError"></form:errors><span class="FieldError">${msgToSignUp}</span></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Password: </h2></td><td><form:input   path="password" placeholder="Password" id="first"/></td><td><form:errors path="password" cssClass="FieldError"></form:errors></td></tr>
    
    <tr  style="padding-top: 10px"><td><h2>Address: </h2></td><td><form:input path="address" placeholder="Address"/></td><td><form:errors path="address" cssClass="FieldError"></form:errors></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Email: </h2></td><td><form:input path="emailId" placeholder="abc@gmail.com"/></td><td><form:errors path="emailId" cssClass="FieldError"></form:errors></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Contact No: </h2></td><td><form:input path="contactNumber" placeholder="ex:9876543210"/></td><td><form:errors path="contactNumber" cssClass="FieldError"></form:errors></td></tr>
    
     <tr  style="padding-top: 10px"><td><h2>Category: </h2></td><td><form:select path="category"><option value="Customer" selected="selected">Customer</option><option value="Vendor">Vendor</option></form:select></td><td><form:errors path="category" cssClass="FieldError"></form:errors></td></tr>
      <tr  style="padding-top: 10px"><td><h2>Company Details</h2> </td><td> <form:textarea path="companyDetails" maxlength="50" placeholder="Enter text here..."/></td><td><form:errors path="companyDetails" cssClass="FieldError"></form:errors></td></tr>
    <tr  style="margin-top: 20px;"><td colspan="1"><br><input type="submit" value="Update"></td><td colspan="1"><br><input type="submit" value="Cancel"></td></tr>
    </table><br><br>
     <script type="text/javascript">
    $(document).ready(function(){
						$("#id321").hide();
				   });
    </script>
 </fieldset>
 </form:form>
 </div>
</body>
</html>