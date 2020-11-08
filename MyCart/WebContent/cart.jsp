<%@page import="org.workshop.cart.model.CartItem"%>
<%@page import="org.workshop.cart.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
</head>
<script type="text/javascript">
	function updateCart(code){  
		var qty = document.getElementById(code).value
		var url = "/MyCart/cart?opr=update&code="+code+"&qty="+qty
		document.getElementById(code+"_x").href=url
	}
</script>
<body>
	<jsp:include page="components/header.jsp" />
	<%
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null)
			cart = new Cart();
		String message = (String) request.getAttribute("message");
		if (message == null || message.isEmpty()) {
			message = "Your cart is empty";
		}
	%>
	<div class="container">
		<h2>Verify Products</h2>
		<form id="checkoutAction" action="/MyCart/cart?opr=checkout"
			method="post">
			<div class="alert alert-info text-center"
				<%=cart.getItems().size() == 0 ? "" : "style=\"display:none\""%>>
				<strong><%=message%></strong>
			</div>
			<ul class="list-group"
				<%=cart.getItems().size() > 0 ? "" : "disabled"%>>
				<%
					for (CartItem item : cart.getItems()) {
				%>
				<li class="list-group-item">
					<!-- Left-aligned -->
					<div class="media">
						<div class="media-left">
							<img src="<%=item.getProduct().getImageUrl()%>" class="media-object"
								style="width: 100px; height: 80px">
						</div>
						<div class="media-body">
							<div class="col-sm-12">
								<div class="col-sm-6">
									<h4 class="media-heading"><%=item.getProduct().getTitle()%></h4>
									<p><%=item.getProduct().getCode()%></p>
									<p><%=item.getProduct().getDescription()%></p>
								</div>
								<div class="col-sm-6">
									<!-- <form id="updateAction" action="/MyCart/cart?opr=update" method="post"> -->
										<div class="col-sm-12">
											<div class="col-sm-3">
												<input type="hidden" name="code"
													value="<%=item.getProduct().getCode()%>"> <input
													type="number" class="form-control col-sm3" id="<%=item.getProduct().getCode()%>"
													placeholder="Quantity" value="<%=item.getQuantity()%>"
													min="1" name="qty" onchange="updateCart('<%=item.getProduct().getCode()%>')">
											</div>
											<div class="col-sm-3">
												Rs.<%=item.getAmount()%>/-
											</div>
											<div class="col-sm-4">
												<!-- <button type="submit" class="btn btn-primary"
													form="updateAction">Update</button> -->
												<a id="<%=item.getProduct().getCode()%>_x" class="btn btn-warning" href="#">Update</a>
											</div>
											<div class="col-sm-2">
												<button class="btn btn-danger">
													<span class="glyphicon glyphicon-trash"></span>
												</button>
											</div>
										</div>
									<!-- </form> -->
								</div>
							</div>
						</div>
					</div>
				</li>
				<%
					}
				%>
				<li class="list-group-item"
					<%=cart.getItems().size() > 0 ? "" : "style=\"display:none\""%>>
					<div align="right" style="padding-right: 25%">
						<span style="font-size: 18px">Total:</span> <span
							style="font-size: 21px">Rs.<%=cart.getTotal()%>/-
						</span>
					</div>
				</li>
				<li class="list-group-item">
					<div align="center">
						<button type="submit" class="btn btn-primary"
							<%=cart.getItems().size() > 0 ? "" : "disabled"%>>Checkout</button>
						<a class="btn btn-warning" href="/MyCart/products">Continue to
							shopping</a> <a href="/MyCart/cart?opr=reset" class="btn btn-danger">Cancel</a>
					</div>
				</li>
			</ul>
		</form>
	</div>
	<jsp:include page="components/footer.jsp" />
</body>
</html>