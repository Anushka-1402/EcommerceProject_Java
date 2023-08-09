<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Portal</title>
<%@include file="components/css-js.jsp" %>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	<div class="container-fluid">
	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				
				<%@include file="components/message.jsp" %>	

				<div class="card-body px-5">
					<h3 class="text-center">Sign Up</h3>
					<form action="register" method="post">
						<div class="form-group">
						    <label for="user_name">User Name</label>
						    <input name="uName" type="text" class="form-control" id="user_name" required>
						</div>
						<div class="form-group">
						    <label for="user_email">Email id</label>
						    <input name="uEmail" type="email" class="form-control" id="user_email" required>
						</div>
						<div class="form-group">
						    <label for="user_password">Password</label>
						    <input name="uPassword" type="password" class="form-control" id="user_password" required>
						</div>
						<div class="form-group">
						    <label for="user_phone">Phone number</label>
						    <input name="uPhone" type="number" class="form-control" id="user_phone" required>
						</div>
						<div class="form-group">
						    <label for="exampleInputEmail1">Address</label>
						    <input name="uAddress" style="height:100px;" type="text" class="form-control" id="user_address" required>
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-success">Register</button>
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