package org.workshop.cart.service;

import java.sql.SQLException;
import java.util.List;

import org.workshop.cart.dao.ProductDao;
import org.workshop.cart.model.Product;

public class ProductService {
	private ProductDao dao;
	public ProductService() {
		dao = new ProductDao();
	}
	public Product create(Product product) throws ClassNotFoundException, SQLException {
		return dao.create(product);
	}
	public Product read(String code) throws ClassNotFoundException, SQLException {
		return dao.read(code);
	}
	public Product update(Product product) throws ClassNotFoundException, SQLException {
		return dao.update(product);
	}
	public void delete(String code) throws ClassNotFoundException, SQLException {
		dao.delete(code);
	}
	public List<Product> readAll() throws ClassNotFoundException, SQLException {
		return dao.readAll();
	}
}
