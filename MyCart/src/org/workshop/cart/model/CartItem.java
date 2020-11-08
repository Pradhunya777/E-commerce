package org.workshop.cart.model;

public class CartItem {
	private Product product;
	private Long quantity;
	private Double amount;
	
	public CartItem(Product product) {
		this.product = product;
		setQuantity(1L);
		setAmount(product.getAmount());
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
		setAmount(this.quantity*this.product.getAmount());
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (product.getCode().equals(((CartItem)obj).getProduct().getCode()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartItem [product=");
		builder.append(product.getTitle());
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
}
