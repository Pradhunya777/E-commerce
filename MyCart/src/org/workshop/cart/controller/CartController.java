package org.workshop.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.workshop.cart.model.Cart;
import org.workshop.cart.model.CartItem;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CART_PAGE = "cart.jsp";
	private final String MESSAGE_KEY = "message";
	private final String CART = "cart";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opr = request.getParameter("opr");
		Cart cart = (Cart) request.getSession().getAttribute(CART);
		if(cart == null) {
			cart = new Cart();
		}
		if (opr == null) {
			opr = "list";
		}
		switch (opr) {
		case "list":
			break;
		case "update":
			String code = request.getParameter("code");
			Long qty = Long.parseLong(request.getParameter("qty"));
			for(CartItem item: cart.getItems()) {
				if(item.getProduct().getCode().equals(code)) {
					item.setQuantity(qty);
					break;
				}
			}
			cart.updateTotal();
			break;
		case "reset":
			cart.getItems().clear();
			cart.updateTotal();
			break;
		}
		request.getSession().setAttribute(CART, cart);
		request.getRequestDispatcher(CART_PAGE).forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opr = request.getParameter("opr");
		Cart cart = (Cart) request.getSession().getAttribute(CART);
		switch (opr) {
		case "checkout":
			request.setAttribute(MESSAGE_KEY, "Your order has been placed successfully");
			cart.getItems().clear();
			cart.updateTotal();
			break;
		}
		request.getSession().setAttribute(CART, cart);
		request.getRequestDispatcher(CART_PAGE).forward(request, response);
	}

}
