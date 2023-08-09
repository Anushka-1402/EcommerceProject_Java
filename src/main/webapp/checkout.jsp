
<!-- checking authentication -->

<%@page import="com.anushka.javaproject.helper.FactoryProvider"%>
<%@page import="com.anushka.javaproject.entities.User" %>

<%
	User user= (User)session.getAttribute("current-user");

	if(user==null){
		session.setAttribute("message", "You are not logged in ! Please Login");
		response.sendRedirect("login.jsp");
		return;
	}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Details</title>
<%@include file="components/css-js.jsp" %>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	
	<%@include file="components/cart-modal.jsp" %>
	
	<div class="container">
	
		<div class="row mt-5">
		
			<div class="col-md-6">
			
				<!-- cart -->
				<div class="card">
				<h2 class="text-center mt-3">Your Selected Items</h2>
					<div class="card-body">
						<div class="cart-body"></div>
					</div>
				</div>
				
			</div>	
			
			<div class="col-md-6">
			
				<!-- order details -->
				<div class="card">
				<h2 class="text-center mt-3">Your Shipping Details</h2>
					<div class="card-body">
					
						<form action="payment" method="post">
						  <div class="form-group">
						    <label for="exampleInputEmail1">User Name</label>
						    <input value="<%= user.getuName() %>" name="name" type="text" class="form-control" id="exampleInputName" aria-describedby="nameHelp" placeholder="Enter user name" required>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email address</label>
						    <input value="<%= user.getuEmail() %>" name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputEmail1">Phone Number</label>
						    <input value="<%= user.getuPhone() %>" name="phone" type="number" class="form-control" id="exampleInputPhone" aria-describedby="phoneHelp" placeholder="Enter phone number" required>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputEmail1">Shipping Address</label>
						    <textarea style="height: 
						    50px;" placeholder="Enter address" name="address" class="form-control" required></textarea>
						  </div>
						  <div class="container text-center">
							<button class="btn btn-outline-success">Place Order</button>
							<button class="btn btn-outline-info">Continue Shopping</button>
						  </div>
						 </form>
						  
					</div>
				</div>
				
			</div>	
			
		</div>
		
	</div>
</body>
</html>