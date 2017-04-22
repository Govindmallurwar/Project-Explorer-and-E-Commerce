<%@page import="com.app.pojo.SearchProduct"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "
http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Shop Around</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />

<spring:url value="/Resources/css/style.css" var="styleCSS" />
<spring:url value="/Resources/js/jquery-1.4.1.min.js" var="jqueryMin" />
<spring:url value="/Resources/js/jquery-func.js" var="jqueryFunc" />
<spring:url value="/Resources/js/jquery.jcarousel.pack.js"
	var="jqueryPack" />
<spring:url value="/utils/contactus" var="contactUs" />
<spring:url value="/product/searchProduct" var="searchMe" />
<spring:url value="/utils/myaccount" var="updateMe" />
<spring:url value="/user/" var="userMe" />
<spring:url value="/utils/searchCategory/" var="searchCatMe" />
<spring:url value="/order/orderProductPassThrough" var="orderMe" />
<spring:url value="/order/showOrder" var="showMe" />
<spring:url value="/Resources/css/images/slide1.jpg" var="slide1" />

<spring:url value="/utils/goToHome" var="goToHome" />

<link rel="stylesheet" href="${styleCSS}" type="text/css" media="all" />
<script src="${jqueryMin}" type="text/javascript"></script>
<script src="${jqueryFunc}" type="text/javascript"></script>
<script src="${jqueryPack}" type="text/javascript"></script>

</head>
<body bgcolor="pink">

	<%
		request.setAttribute("searchModel", new SearchProduct());
	%>

	<!-- Shell -->
	<div class="shell">
		<!-- Header -->
		<div id="header">
			<h1 id="logo">
				<a href="#">shoparound</a>
			</h1>
			<!-- Cart -->
			<div id="cart">
				<a href="${orderMe}" class="cart-link" id="cart123">My Cart</a><i id="ven123" style="color: yellow;"><big> Welcome Vendor</big></i><br /> <a
					href="${userMe}register" class="cart-link1" id="reg123">Sign-Up</a>
				<a href="${userMe}validate" class="cart-link1" id="val123">Login</a>
				<a href="#" class="cart-link1" id="name123"></a> <a
					href="${userMe}invalidate" class="cart-link1" id="signup123"></a>
				<div class="cl">&nbsp;</div>
				</strong></span>
			</div>
			<!-- End Cart -->

			<a id="nana">${user.name}!!</a>
			<c:if test="${!empty user}">
				<script type="text/javascript">
					document.getElementById('reg123').innerHTML = null;
					document.getElementById('val123').innerHTML = null;
					document.getElementById('name123').innerHTML = document
							.getElementById('nana').innerHTML;
					document.getElementById('signup123').innerHTML = "SignOut";
				</script>
			</c:if>
			<c:if test="${empty user}">
				<script type="text/javascript">
					document.getElementById('reg123').innerHTML = "Sign-Up";
					document.getElementById('val123').innerHTML = "Login";
					document.getElementById('name123').innerHTML = null;
					document.getElementById('signup123').innerHTML = null;
					$(document).ready(function(){
						$("#ven123").hide();
				        $("#cart123").show();
				        $("#acc123").show();
				  
				   });
				</script>
			</c:if>
			<!-- Navigation -->
			<div id="navigation">
				<ul>
					<li><a href="${goToHome}" >Home</a></li>
					<li><a href="${updateMe}">My Profile</a></li>
					<li><a href="${showMe}" id="acc123">My Account</a></li>
					<li><a href="#">Offer Zone</a></li>
					<li><a href="${contactUs }">Contact</a></li>

				</ul>
			</div>
			<!-- End Navigation -->
		</div>
		<!-- End Header -->
		
		<c:if test="${!empty user}">
		       <c:if test = "${user.category == 'Vendor'}">
				<script type="text/javascript">
					$(document).ready(function(){
					    
					        $("#cart123").hide();
					        $("#ven123").show();
					        $("#acc123").hide();
					  
					});
				</script>
			 </c:if>
		</c:if>
		<c:if test="${!empty user}">
			<c:if test = "${user.category == 'Customer'}">
				<script type="text/javascript">
				$(document).ready(function(){
					 $("#ven123").hide();
			        $("#cart123").show();
			        $("#acc123").show();
			  
			   });
				</script>
			</c:if>
		  </c:if>
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			<!-- Content -->
			<div id="content">
				<!-- Content Slider -->
				<div id="slider" class="box">
					<div id="slider-holder">
						<ul>
							<li><a href="#"><img src="${slide1}" alt="" /></a></li>
							<li><a href="#"><img src="${slide1}" alt="" /></a></li>
							<li><a href="#"><img src="${slide1}" alt="" /></a></li>
							<li><a href="#"><img src="${slide1}" alt="" /></a></li>
						</ul>
					</div>
					<div id="slider-nav">
						<a href="#" class="active">1</a> <a href="#">2</a> <a href="#">3</a>
						<a href="#">4</a>
					</div>
				</div>

			</div>
			<!-- End Content -->
			<!-- Sidebar -->
			<div id="sidebar">
				<!-- Search -->
				<div class="box search">
					<h2>
						Search by <span></span>
					</h2>
					<div class="box-content">
						<form:form action="${searchMe}/3" method="post"
							modelAttribute="searchModel">
							<label>Project Name</label>
							<input type="text" class="field" name="keyword" />
							<label>Category</label>
							<select class="field" name="category">
								<option selected="selected" value="">All</option>
								<option value="Information Technology">Information Technology</option>
								<option value="Electronics">Electronics</option>
								<option value="Mechanical">Mechanical</option>
								<option value="Civil">Civil</option>
								<option value="Instrumentation">Instrumentation</option>
								<option value="Electrical">Electrical</option>
							</select>
							<div class="inline-field">
								<label>Price</label> <select class="field small-field"
									name="minPrice">
									<option value="0">0</option>
									<option value="500">500</option>
									<option value="1000">1000</option>
									<option value="2000">2000</option>
									<option value="5000">5000</option>
									<option value="10000">10000</option>
									<option value="25000">25000</option>
									<option value="50000">50000</option>
								</select> <label>to:</label> <select class="field small-field"
									name="maxPrice">
									<option value="500">500</option>
									<option value="1000">1000</option>
									<option value="2000">2000</option>
									<option value="5000">5000</option>
									<option value="10000">10000</option>
									<option value="25000">25000</option>
									<option value="50000">50000</option>
								</select>
							</div>
							<input type="submit" class="search-submit" value="Search" />
						</form:form>
					</div>
				</div>

				<div class="box categories">
					<!--  style="width: 20px" >-->

					<h2>
						Categories <span></span>
					</h2>
					<div class="box-content">

						<ul>
							<li><a href="${searchCatMe}1">Information Technology</a></li>
							<li><a href="${searchCatMe}2">Electronics</a></li>
							<li><a href="${searchCatMe}3">Mechanical</a></li>
							<li><a href="${searchCatMe}4">Civil</a></li>
							<li><a href="${searchCatMe}5">Instrumentation</a></li>
							<li><a href="${searchCatMe}6">Electrical</a></li>
						</ul>
					</div>
				</div>
				<div class="box categories" style="border: 0px">
					
				</div>
			</div>
		</div>



	</div>
</body>
</html>

