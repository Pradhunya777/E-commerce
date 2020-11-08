<%@page import="org.workshop.cart.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<jsp:include page="components/header.jsp" />  
	<div class="container">
		<div>
			<div class="pull-right">
				<a href="/MyCart/products?opr=read&mode=CREATE"
					class="btn btn-success">Add</a>
			</div>
			<h2>Select Products</h2>
		</div>
		<div>
			<ul class="list-group">
				<%
					List<Product> products = (List<Product>) request.getAttribute("products");
					for (Product product : products) {
				%>
				<li class="list-group-item">
					<!-- Left-aligned -->
					<div class="media">
						<div class="media-left">
							<img src="<%=product.getImageUrl()%>" class="media-object"
								style="width: 100px; height: 80px">
						</div>
						<div class="media-body">
							<a href="/MyCart/products?opr=read&code=<%=product.getCode()%>">
								<h4 class="media-heading"><%=product.getTitle()%></h4>
							</a>
							<p><%=product.getCode()%></p>
							<p>
								Rs.
								<%=product.getAmount()%>/-
							</p>
						</div>
						<div class="media-right">
							<div class="btn-group">
								<a href="/MyCart/products?opr=read&mode=EDIT&code=<%=product.getCode()%>" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="/MyCart/products?opr=delete&code=<%=product.getCode()%>" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a>
							</div>
							<br><br>
							<a href="/MyCart/products?opr=addtocart&code=<%=product.getCode()%>" class="btn btn-primary">Add To Cart</a>
						</div>
					</div>
				</li>
				<%
					}
				%>
			</ul>
		</div>
		<jsp:include page="components/footer.jsp" />
</body>
</html>