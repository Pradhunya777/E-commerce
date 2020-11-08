package org.workshop.cart.model;

public class Product {
	private String code;
	private String title;
	private String description;
	private double amount;
	private String imageUrl;
	
	public Product() {}
	
	public Product(String code, String title, String description, double amount, String imageUrl) {
		this.code = code;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.imageUrl = imageUrl;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public int hashCode() {
		return getCode().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [code=");
		builder.append(code);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append("]");
		return builder.toString();
	}
	
}
