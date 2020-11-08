package org.workshop.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.workshop.cart.model.Product;

public class ProductDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public Product create(Product product) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO PRODUCT (code, title, description, amount, imageUrl) values(?,?,?,?,?)";
		try {
			conn = ConnectionManager.openConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, product.getCode());
			stmt.setString(2, product.getTitle());
			stmt.setString(3, product.getDescription());
			stmt.setDouble(4, product.getAmount());
			stmt.setString(5, product.getImageUrl());
			stmt.execute();
			return product;
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	public Product read(String code) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM Product WHERE code=?";
		Product product = new Product();
		try {
			conn = ConnectionManager.openConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, code);
			if(stmt.execute()) {
				rs = stmt.getResultSet();
			}
			while(rs.next()) {
				product.setCode(rs.getString("code"));
				product.setTitle(rs.getString("title"));
				product.setAmount(rs.getDouble("amount"));
				product.setDescription(rs.getString("description"));
				product.setImageUrl(rs.getString("imageUrl"));
			}
			return product;
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	public Product update(Product product) throws ClassNotFoundException, SQLException {
		String query = "UPDATE Product SET title=?, description=?, amount=?, imageUrl=? WHERE code=?";
		try {
			conn = ConnectionManager.openConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, product.getTitle());
			stmt.setString(2, product.getDescription());
			stmt.setDouble(3, product.getAmount());
			stmt.setString(4, product.getImageUrl());
			stmt.setString(5, product.getCode());
			stmt.execute();
			return product;
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	public void delete(String code) throws ClassNotFoundException, SQLException {
		String query = "DELETE FROM Product WHERE code=?";
		try {
			conn = ConnectionManager.openConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, code);
			stmt.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
	public List<Product> readAll() throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM Product";
		List<Product> products = new ArrayList<>();
		try {
			conn = ConnectionManager.openConnection();
			stmt = conn.prepareStatement(query);
			if(stmt.execute()) {
				rs = stmt.getResultSet();
			}
			while(rs.next()) {
				products.add(new Product(rs.getString("code"), rs.getString("title"), 
						rs.getString("description"), rs.getDouble("amount"), rs.getString("imageUrl")));
			}
			return products;
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}finally {
			ConnectionManager.closeConnection(conn);
		}
	}
}
