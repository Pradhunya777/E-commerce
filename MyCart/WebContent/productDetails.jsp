<%@page import="org.workshop.cart.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<jsp:include page="components/header.jsp" />  
	<% 
		Product product = (Product)request.getAttribute("product");
		String mode = (String)request.getAttribute("mode");
	%>
	<div class="container">
		<div class="col-sm-8 col-sm-offset-2">
			<%=mode%>
			<form action="<%=mode.equals("EDIT") ?  "/MyCart/products?opr=update" : "/MyCart/products?opr=create"%>" method="post">
				<h2>Product Details</h2>
				<div class="form-group">
					<label>Code:</label> 
					<input class="form-control" value="<%=product.getCode()%>" <%=mode.equals("CREATE") ? "" : "readonly"%>
					name="code">
				</div>
				<div class="form-group">
					<label>Title:</label> 
					<input class="form-control" <%=mode.equals("VIEW") ? "readonly" : ""%>
					value="<%=product.getTitle()%>" name="title">
				</div>
				<div class="form-group">
					<label>Description:</label>
					<textarea class="form-control" rows="5" <%=mode.equals("VIEW") ? "readonly" : ""%>
					name="description"><%=product.getDescription()%></textarea>
				</div>
				<div class="form-group">
					<label>Amount:</label> 
					<input type="number" class="form-control" <%=mode.equals("VIEW") ? "readonly" : ""%>
					value="<%=product.getAmount()%>" name="amount">
				</div>
				<div class="form-group">
					<label>Image:</label> 
					<input class="form-control" <%=mode.equals("VIEW") ? "readonly" : ""%>
					value="<%=product.getImageUrl()%>" name="imageUrl">
				</div>
				<div align="right">
					<button class="btn btn-primary" type="submit" class="btn btn-primary" <%=mode.equals("VIEW") ? "disabled" : ""%>>Save</button>
					<a href="/MyCart/products?opr=list" class="btn btn-default">Cancel</a>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="components/footer.jsp" />
</body>
</html>