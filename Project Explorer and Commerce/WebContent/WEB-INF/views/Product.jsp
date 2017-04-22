<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="Master1.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
</head>
<body >

<div style="padding:1px">
 <form:form action="registerProduct" method="post" modelAttribute="productModel">
 
 <fieldset  style=" position: relative; left:20px; width: 715px; height:470px"">
  <legend><h1>Product Register</h1></legend>
    <table style="margin-top: 20px;font-size: 18px;" cellpadding="10px" cellspacing="10px">
     <tr  style="padding-top: 10px"><td><h2>Product Name: </h2></td><td><form:input  path="prodName" placeholder="Product Name"/></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Product Price:</h2> </td><td><form:input  path="prodPrice" placeholder="Product Price"/></td></tr>
    <tr  style="padding-top: 10px"><td><h2>Product discount:</h2> </td><td><form:input  path="prodDiscount" placeholder="Product discount"/></td></tr>
  <tr  style="padding-top: 10px"><td><h2>Description</h2> </td><td> <form:textarea maxlength="500" placeholder="Enter text here..." path="description"/></textarea> </td></tr>
  <tr  style="padding-top: 10px"><td><h2>Categories: </h2></td><td><form:select path="category"><option selected="selected">Information Technology</option><option>Electronics</option><option>Mechanical</option>
     <option>Civil</option><option>Instrumentation</option><option>Electrical</option></select></td></tr> </form:select>  
     <tr  style="padding-top: 10px"><td><h2>Technology: </h2></td><td><form:select path="technology"><option selected="selected">C++</option><option>Java</option><option>HTML,CSS,JS</option>
     <option>.Net</option></select></td></tr>  </form:select>
    <tr  style="margin-top: 20px;"><td colspan="1"><br><input type="submit" value="Register"></td><td colspan="1"><br><input type="reset" value="Cancel"></td></tr>    
    </table><br><br>
 </fieldset>
 </form:form>
 </div>
</body>
</html>