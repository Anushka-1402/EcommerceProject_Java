
<!-- checking authentication -->

<%@page import="com.anushka.javaproject.helper.Helper"%>
<%@page import="com.anushka.javaproject.helper.FactoryProvider"%>
<%@page import="com.anushka.javaproject.dao.CategoryDao"%>
<%@page import="com.anushka.javaproject.entities.User" %>
<%@page import="com.anushka.javaproject.entities.Product" %>
<%@page import="com.anushka.javaproject.entities.Catalog" %>
<%@page import="com.anushka.javaproject.helper.FactoryProvider" %>
<%@page import="com.anushka.javaproject.helper.Helper" %>
<%@page import="java.util.*" %>

<%
	User user= (User)session.getAttribute("current-user");

	if(user==null){
		session.setAttribute("message", "You are not logged in ! Please Login");
		response.sendRedirect("login.jsp");
		return;
	}
	else if(user.getuType().equals("normal")){
		session.setAttribute("message", "Access Denied ! Only admin users allowed");
		response.sendRedirect("login.jsp");
	}
	
	Map<String,Long> m= Helper.getCounts(FactoryProvider.getFactory());
	
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Portal</title>
<%@include file="components/css-js.jsp" %>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	
	<%@include file="components/cart-modal.jsp" %>
	
	<div class="container admin">
		<div class="container-fluid">
			<%@ include file="components/message.jsp" %>
		</div>
		<!-- row 1 -->
		<div class="row mt-4">
			<!-- column 1 -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:105px;" class="img-fluid rounded-circle" src="images/user.png" alt="user-icon">
						</div>
						<h2><%= m.get("uCount") %></h2>
						<h1>Users</h1>
					</div>
				</div>	
			</div>
			<!-- column 2 -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:105px;" class="img-fluid rounded-circle" src="images/categories.png" alt="category-icon">
						</div>
						<h2><%= m.get("cCount") %></h2>
						<h1>Categories</h1>
					</div>
				</div>
			</div>
			<!-- column 3 -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:105px;" class="img-fluid rounded-circle" src="images/product.png" alt="product-icon">
						</div>
						<h2><%= m.get("pCount") %></h2>
						<h1>Products</h1>
					</div>
				</div>
			</div>
		</div>
		<!-- row 2 -->
		<div class="row mt-4">
			<!-- column 1 -->
			<div class="col-md-6">
				<div class="card" data-toggle="modal" data-target="#addCategoryModal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:105px;" class="img-fluid rounded-circle" src="images/add-category.png" alt="add-category-icon">
						</div>
						<h1>Add Categories</h1>
					</div>
				</div>
			</div>
			<!-- column 2 -->
			<div class="col-md-6">
				<div class="card" data-toggle="modal" data-target="#addProductModal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width:105px;" class="img-fluid rounded-circle" src="images/add-product.png" alt="add-product-icon">
						</div>
						<h1>Add Products</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- Add Category Modal -->
	<div class="modal fade" id="addCategoryModal" tabindex="-1" role="dialog" aria-labelledby="addCategoryModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header custom-bg text-white">
	        <h5 class="modal-title" id="exampleModalLabel">Fill Category Details</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form action="productOperations" method="post">
	        	<input type="hidden" name="operationType" value="addCategory">
	        	<div class="form-group">
	        		<input placeholder="Enter category title" type="text" name="catTitle" class="form-control" required>
	        	</div>
	        	<div class="form-group">
	        		<textarea style="height: 150px;" placeholder="Enter category description" name="catDesc" class="form-control" required></textarea>
	        	</div>
	        	<div class="container text-center">
	        		<button type="submit" class="btn btn-outline-success">Add Category</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	      		</div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<!-- Add Product Modal -->
	<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="addProductModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header custom-bg text-white">
	        <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form action="productOperations" method="post" enctype="multipart/form-data">
	        	<input type="hidden" name="operationType" value="addProduct">
	        	<div class="form-group">
	        		<input placeholder="Enter product name" type="text" name="pName" class="form-control" required>
	        	</div>
	        	<div class="form-group">
	        		<textarea style="height: 150px;" placeholder="Enter product description" name="pDesc" class="form-control" required></textarea>
	        	</div>
	        	<div class="form-group">
	        		<input placeholder="Enter product price" type="number" name="pPrice" class="form-control" required>
	        	</div>
	        	<div class="form-group">
	        		<input placeholder="Enter product discount" type="number" name="pDisc" class="form-control" required>
	        	</div>
	        	<div class="form-group">
	        		<input placeholder="Enter product quantity" type="number" name="pQuantity" class="form-control" required>
	        	</div>
	        	<div class="form-group">
	        	<select name="catId" class="form-control" id="">
	        		<%
	        			CategoryDao catDao= new CategoryDao(FactoryProvider.getFactory());
	        			List<Catalog> clist = catDao.getCategories();
	        			for(Catalog c:clist){
	        				
	        		%>
	        			<option value=<%= c.getCatalogId() %>><%= c.getCatalogName() %></option>
	        		<%
	        			}
	        		%>
	        		</select>
	        	</div>
	        	<div class="form-group">
	        		<label for="pPhoto">Select image of product</label>
	        		<br>
	        		<input type="file" id= "pPhoto" name="pPhoto" required>
	        	</div>
	        	<div class="container text-center">
	        		<button type="submit" class="btn btn-outline-success">Add Product</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>			        
	      		</div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
</html>