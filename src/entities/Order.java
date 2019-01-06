package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOterderItem() {
		return orderItem;
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}

	public Double total() {
		double sum = 0;
		for (OrderItem x : orderItem) {
			sum += x.subTotal();
		}
		return sum;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("order momment: ");
		sb.append(sdf.format(moment) + "%n");
		sb.append("Order status:" + status + "%n");
		sb.append(client + "%n");
		sb.append("Order Item: \n");
		for (OrderItem x : orderItem) {
			sb.append(x);
		}
		sb.append("Total Price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	
	}

}
