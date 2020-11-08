<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>My Cart</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2 class="banner">Welcome to My Cart</h2>
	<a href="firstServlet">First Servlet</a>
	<br><a href="products?opr=list">List Servlet</a>
	<br><a href="firstServlet?opr=add">Add Servlet</a>
	<br><a href="firstServlet?opr=delete">Delete Servlet</a>
	<hr>
	${products}  
</body>
</html>