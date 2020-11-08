package org.workshop.cart.model;

import java.util.HashSet;
import java.util.Set;

public class Cart {
	private Set<CartItem> items;
	private Double total;
	public Cart() {
		setItems(new HashSet<>());
		setTotal(0d);
	}
	public Set<CartItem> getItems() {
		return items;
	}
	public void setItems(Set<CartItem> items) {
		this.items = items;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void add(CartItem item) {
		for(CartItem it : items) {
			if(it.getProduct().getCode().equals(item.getProduct().getCode())) {
				item.setQuantity(item.getQuantity()+it.getQuantity());
				items.remove(it);
				break;
			}
		}
		items.add(item);
		updateTotal();
	}
	public void remove(CartItem item) {
		if(items.isEmpty()) {
			items.remove(item);
			updateTotal();
		}
	}
	public void updateTotal() {
		Double total = (double) 0;
		for(CartItem item: items) {
			total += (item.getQuantity()*item.getProduct().getAmount());
		}
		setTotal(total);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cart [items=");
		builder.append(items);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
	
}
