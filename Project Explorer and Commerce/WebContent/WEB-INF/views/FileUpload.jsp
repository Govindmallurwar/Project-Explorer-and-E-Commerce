<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="Master1.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
</head>
<body >

<div style="padding:1px">
<h3 style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;${errorInFileUpload}</h3>
<form method="POST" enctype="multipart/form-data" action="upload">
  <fieldset  style=" position: relative;
 left:20px; width: 715px; height:470px"">
  <legend><h1>Product Register</h1></legend>
    <table style="margin-top: 20px;font-size: 18px;" cellpadding="10px" cellspacing="10px">
		 <tr  style="margin-top: 20px;"><td><h2>File to upload: </h2></td><td><input type="file" name="file"></td><td colspan="1"><br></td></tr>
		  <tr  style="margin-top: 20px;"><td><input type="submit" value="Upload"></td></tr>
    </table><br><br>
 </fieldset>
 </form>
 </div>
</body>
</html>