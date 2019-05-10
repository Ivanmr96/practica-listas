package main.test;

import main.java.model.Order;
import main.java.model.OrderLine;
import main.java.model.Product;
import main.java.model.Supermarket;
import main.java.util.CodeUtils;

public class Test1 {

	public static void main(String[] args) {
		
		Supermarket s1 = new Supermarket("Supermercado Nervión", CodeUtils.getSupermarketCode());
		
		Product p1 = new Product(1, "Champó 5L Familiar", 25.00, s1);
		Product p2 = new Product(2, "Cerveza Alhambra 1925", 1.00, s1);
		Product p3 = new Product(3, "Aceitunas chupadeos", 5.00, s1);
		Product p4 = new Product(4, "Pizza 4 quesos", 2.20, s1);
		
		Order o1 = new Order(CodeUtils.getOrderCode(), "Juan Uno", s1);
		
		OrderLine ol1 = new OrderLine(CodeUtils.getOrderLineCode(), 2, o1, p2);
		OrderLine ol2 = new OrderLine(CodeUtils.getOrderLineCode(), 1, o1, p4);
		OrderLine ol3 = new OrderLine(CodeUtils.getOrderLineCode(), 2, o1, p1);
		
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);

		s1.addOrder(o1);

		s1.addProduct(p1);
		s1.addProduct(p2);
		s1.addProduct(p3);
		s1.addProduct(p4);



		System.out.println(s1.getOrder(0));

		System.out.println(s1.getProduct(0));
		
		//SEGUNDA PARTE
		o1.getOrderLines().add(ol1);
		o1.getOrderLines().add(ol2);
		o1.getOrderLines().add(ol3);
		
		s1.getOrders().add(o1);
		
		s1.getProducts().add(p1);
		s1.getProducts().add(p2);
		s1.getProducts().add(p3);
		s1.getProducts().add(p4);
		
		
		System.out.println(s1.getOrders());
		System.out.println(s1.getProducts());
		
		System.out.println(s1.getOrders().get(0));
		System.out.println(s1.getProducts().get(0));
		
		for(int i = 0 ; i < 4 ; i++)
		{
			System.out.println("Cantidad del producto "+ (i+1) +" vendidas: " + s1.getQuantitySold(i+1));
		}
		
		System.out.println("Producto más vendido: " + s1.getBestSellingProduct());
		
		System.out.println("Producto menos vendido: " + s1.getWorstSellingProduct());
		
	}

}
