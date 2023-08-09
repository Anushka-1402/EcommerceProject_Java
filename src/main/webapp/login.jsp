<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Portal</title>
<%@include file="components/css-js.jsp" %>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card mt-5">
					<div class="card-header custom-bg text-white">
						<h3 class="text-center">Login Here</h3>
					</div>
					<div class="card-body">
					<%@include file="components/message.jsp" %>	
						<form action="login" method="post">
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email address</label>
						    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">Password</label>
						    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
						  </div>
						  <a href="register.jsp" class="text-center d-block mb-4">Do not have an account? Register Here!!</a>
						  <div class="container text-center">
						  <button type="submit" class="btn btn-outline-success">Submit</button>
						  <button class="btn btn-outline-warning">Reset</button>
						  </div> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>