<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="bootstrap/js/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<title>My Cart</title>
<style type="text/css">
.navbar {
	margin-bottom: 0
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/MyCart/home.jsp">My Cart</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/MyCart/home.jsp"><span
					class="glyphicon glyphicon-home"></span> Home</a></li>
			<li><a href="/MyCart/products"><span
					class="glyphicon glyphicon-leaf"></span> Products</a></li>
			<li><a href="/MyCart/cart.jsp"><span
					class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
			<!-- <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li> -->
		</ul>
	</div>
	</nav>
</body>
</html>