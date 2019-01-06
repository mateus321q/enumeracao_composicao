package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY) :");
		Date birthDate = sdf.parse(sc.nextLine());

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		sc.nextLine();

		Order order = new Order(new Date(), status, client);

		System.out.print("how many items to this order? ");
		int x = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= x; i++) {
			System.out.printf("enter #%d item data%n", i);
			System.out.print("Product name: ");
			name = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			sc.hasNextLine();
			Product product = new Product(name, price);

			System.out.print("Quntity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			OrderItem Item = new OrderItem(quantity, price, product);
			order.addItem(Item);

		}

		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);

		sc.close();
	}

}
