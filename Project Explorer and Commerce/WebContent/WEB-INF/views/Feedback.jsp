<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="Master1.jsp" %>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
<spring:url value="/Resources/css/style1.css" var="style1CSS" />

<spring:url value="/feedback/processFeedback" var="giveFeedback" />

<link rel="stylesheet" href="${style1CSS}" />
</head>
<body >

<div style="padding:1px">
 <form:form action="${giveFeedback}" id="ratingsForm" modelAttribute="feedbackModel" method="post">
  <fieldset  style=" position: absolute;
  top: 250px;
  right:150px;
  width: 730px;
  height: 250px;">
  <legend><h1>Feedback:</h1></legend>
    <table style="margin-top: 20px;font-size: 18px;" cellpadding="10px" cellspacing="10px">
    
    <tr  style="padding-top: 10px"><td><h2>Comment</h2> </td><td> <textarea name="comments" maxlength="500" placeholder="Enter text here..."></textarea> </td></tr>
   
 
  <tr><td><h2>Rating</h2></td><td><div class="stars">
		<input type="radio" name="score" class="star-1" id="star-1" value="1"/>
		<label class="star-1" for="star-1">1</label>
		<input type="radio" name="score" class="star-2" id="star-2" value="2"/>
		<label class="star-2" for="star-2">2</label>
		<input type="radio" name="score" class="star-3" id="star-3" value="3"/>
		<label class="star-3" for="star-3">3</label>
		<input type="radio" name="score" class="star-4" id="star-4" value="4"/>
		<label class="star-4" for="star-4">4</label>
		<input type="radio" name="score" class="star-5" id="star-5" value="5"/>
		<label class="star-5" for="star-5">5</label>
		<span></span>
	</div></td></tr>
	 <tr  style="margin-top: 20px;"><td colspan="2"><input type="submit" value="submit"></td></tr>
	
 </table><br><br>
 </fieldset>
 
 
 
 </form:form>
 </div>
	
</body>
</html>