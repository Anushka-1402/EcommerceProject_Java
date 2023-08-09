
<%@page import="org.hibernate.query.criteria.internal.expression.function.TrimFunction"%>
<%@page import="com.anushka.javaproject.entities.Product"%>
<%@page import="com.anushka.javaproject.helper.FactoryProvider"%>
<%@page import="com.anushka.javaproject.dao.ProductDao"%>
<%@page import="com.anushka.javaproject.dao.CategoryDao" %>
<%@page import="com.anushka.javaproject.entities.Catalog" %>
<%@page import="com.anushka.javaproject.helper.Helper" %>
<%@page import="java.util.*"%>

<html>
	<head>
		<title>ShopZone - Home</title>
		<%@include file="components/css-js.jsp" %>
	</head>
	<body>
		<%@include file="components/navbar.jsp" %>
		
		<%
			String cat= request.getParameter("category");
		
			ProductDao pDao= new ProductDao(FactoryProvider.getFactory());
			List<Product> pList= null;
			
			if(cat==null || cat.trim().equals("all")){
				pList= pDao.getAllProducts();
			}
			else{
				int cid= Integer.parseInt(cat.trim());
				pList= pDao.getProductByCategory(cid); 
			}
		
				
			CategoryDao cDao= new CategoryDao(FactoryProvider.getFactory());
			List<Catalog> cList= cDao.getCategories();
		%>
		
		<div class= "container-fluid">
		
		<div class="row mx-2 mt-5">
		
			<!-- Catalogue -->
			<div class="col-md-2">
			
				<div class="list-group">
					<a href="index.jsp?category=all" class="list-group-item list-group-item-action active">All Products</a>
				<%
				
					for(Catalog c:cList){
						
				%>	
			    
			    	<a href="index.jsp?category=<%= c.getCatalogId() %>" class="list-group-item list-group-item-action"><%= c.getCatalogName() %></a>

				<%
					}
				%>
				</div>
			</div>
			
			<!-- Products -->
			<div class="col-md-10">
				
				<div class="card-columns">
				<%
				
					for(Product p:pList){
						
				%>
					<div class="card pCard">
					  <div class="container text-center">
					  <img  src="images/products/<%= p.getpPhoto() %>" style= " max-height: 200px; max-width=100%; width:auto" alt="<%= p.getpName() %>">
					  </div>
					  <div class="card-body">
					    <h5 class="card-title"><%= p.getpName() %></h5>
					    <p class="card-text"><%= Helper.trimString(p.getpDesc()) %></p>
					   </div>
					   <div class="card-footer">
					    <a href="#" class="btn btn-outline-success" onclick="addToCart(<%= p.getpId() %>, '<%= p.getpName() %>', <%= p.getDiscountedPrice()%>)">Add to Cart</a>
					    <a href="#" class="btn btn-outline-warning" >&#8377;<%= p.getDiscountedPrice() %>/- <span class="text-secondary discount-price" >&#8377;<%= p.getpPrice() %>/-</span> <span class="text-secondary discount-label"> <%= p.getpDisc() %>% off</span></a>
					  </div>
					</div>
				
				<%
					}
				%>
				
				</div>
			<%
				
				if(pList.size()==0){
				
			%>
				
			<h3>Sorry! Currently no items in this Category</h3>
				
			<%
				
				}
				
			%>
		</div>
		</div>
		</div>
		
		<%@include file="components/cart-modal.jsp" %>
		
	</body>	
		
</html>
