package org.workshop.cart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.workshop.cart.model.Cart;
import org.workshop.cart.model.CartItem;
import org.workshop.cart.model.Product;
import org.workshop.cart.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PRODUCTS_PAGE = "products.jsp";
	private final String PRODUCT_DETAILS_PAGE = "productDetails.jsp";
	private final String MESSAGE_KEY = "message";
	private final String IS_ERROR = "isError";
	private String redirectPage = PRODUCTS_PAGE;

	private ProductService service;

	@Override
	public void init() throws ServletException {
		super.init();
		service = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String opr = request.getParameter("opr");
		request.setAttribute(IS_ERROR, false);
		if (opr == null) {
			opr = "list";
		}
		switch (opr) {
		case "list":
			System.out.println("Operation list");
			request.setAttribute("products", readAllProducts());
			redirectPage = PRODUCTS_PAGE;
			break;
		case "read":
			try {
				System.out.println("Operation read");
				String mode = request.getParameter("mode");
				if(mode == null) {
					mode = "VIEW";
				}
				if(mode.equals("CREATE")) {
					request.setAttribute("product", new Product());
				}else {
					request.setAttribute("product", service.read(request.getParameter("code")));
				}
				request.setAttribute("mode", mode);
				redirectPage = PRODUCT_DETAILS_PAGE;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute(IS_ERROR, true);
				request.setAttribute(MESSAGE_KEY, e.getMessage());
			}
			break;
		case "delete": 
			System.out.println("Operation delete");
			String code = request.getParameter("code");
			try {
				service.delete(code);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute(IS_ERROR, true);
				request.setAttribute(MESSAGE_KEY, e.getMessage());
			}
			response.sendRedirect("products");
			break;
		case "addtocart":
			code = (String)request.getParameter("code");
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if(cart == null) {
				cart = new Cart();
			}
			try {
				cart.add(new CartItem(service.read(code)));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute(IS_ERROR, true);
				request.setAttribute(MESSAGE_KEY, e.getMessage());
			}
			request.getSession().setAttribute("cart", cart);
			redirectPage = PRODUCTS_PAGE;
			response.sendRedirect("/MyCart/products");
			break;
		}
		if(!opr.equals("delete") && !opr.equals("addtocart")) {
			request.getRequestDispatcher(redirectPage).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opr = request.getParameter("opr");
		Product product = new Product();
		switch (opr) {
		case "create":
			try {
				product = readProductFromRequest(request);
				product = service.create(product);
				request.setAttribute(MESSAGE_KEY, "Product added successfully");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute(IS_ERROR, true);
				request.setAttribute(MESSAGE_KEY, e.getMessage());
			}
			request.setAttribute("product", product);
			redirectPage = PRODUCT_DETAILS_PAGE;
			break;
		case "update":
			try {
				product = readProductFromRequest(request);
				product = service.update(product);
				request.setAttribute(MESSAGE_KEY, "Product updated successfully");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				request.setAttribute(IS_ERROR, true);
				request.setAttribute(MESSAGE_KEY, e.getMessage());
			}
			request.setAttribute("product", product);
			break;
		}
		response.sendRedirect("products?opr=list");
	}

	private List<Product> readAllProducts() {
		List<Product> products = null;
		try {
			products = service.readAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			products = new ArrayList<>();
		}
		System.out.println("Read " + products.size() + " products");
		return products;
	}

	private Product readProductFromRequest(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Product product = new Product();
		product.setCode(request.getParameter("code"));
		product.setTitle(request.getParameter("title"));
		product.setDescription(request.getParameter("description"));
		product.setAmount(Double.parseDouble(request.getParameter("amount")));
		product.setImageUrl(request.getParameter("imageUrl"));
		return product;
	}
}
