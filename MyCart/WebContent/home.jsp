<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
</head>
<body>
	<jsp:include page="components/header.jsp" />
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->    
		<ol class="carousel-indicators">  
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" style="height:350px">
			<div class="item active">
				<img src="images/banner-1.jpg" >
			</div>

			<div class="item">
				<img src="images/banner-2.jpg" height="300px">
			</div>

			<div class="item">
				<img src="images/banner-3.jpg" height="300px">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<div class="container-fluid">
		<h2>Our best selling products</h2>
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-body" align="center">
						<img src="images/jacket-1.jpg" height="200px" width="300px"
							alt="Image">
					</div>
					<div class="panel-footer">Product 1</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-body" align="center">
						<img src="images/jacket-2.jpg" height="200px" width="200px"
							alt="Image">
					</div>
					<div class="panel-footer">Product 2</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-body" align="center">
						<img src="images/jacket-3.jpg" height="200px" width="200px"
							alt="Image">
					</div>
					<div class="panel-footer">Product 3</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="components/footer.jsp" />
</body>
</html>