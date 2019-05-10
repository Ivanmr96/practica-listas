package main.java.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Supermarket {
	
	public Supermarket(String name, Integer code) {
		this.name = name;
		this.code = code;
		this.products = new ArrayList<Product>();
		this.orders = new ArrayList<Order>();
		this.orderQueue = new LinkedList<Order>();	//añadido
	}
	
	private String name;
	private Integer code;
	
	private List<Product> products;
	private List<Order> orders;
	
	//TERCERA PARTE
	private Queue<Order> orderQueue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public Queue<Order> getOrderQueue() {
		return orderQueue;
	}

	public void setOrderQueue(Queue<Order> orderQueue) {
		this.orderQueue = orderQueue;
	}

	public String toString() {
		return String.format("%o - %s", this.code, this.name);
	}
	
	//MÃ©todos a completar
	//PRIMERA PARTE
	
	/* INTERFAZ
	 * Comentario: Añade un producto a la lista de productos
	 * Prototipo: public void addProduct(Product product)
	 * Entrada: Un Product a añadir
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: Añade un producto a la lista de productos
	 */
	public void addProduct(Product product) {
		products.add(product);
	}
	
	/* INTERFAZ
	 * Comentario: Borra un producto de la lista de productos
	 * Prototipo: public void removeProduct(Product product)
	 * Entrada: Un Product a borrar
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: Borrar el producto determinado de la lista, si el producto no se encuentra en la lista, no hace nada.
	 */
	public void removeProduct(Product product) {
		products.remove(product);
	}
	
	/* INTERFAZ
	 * Comentario: Obtiene un producto dada una posicion de la lista
	 * Prototipo: public Product getProduct(int position)
	 * Entrada: Un int con la posicion del producto
	 * Precondiciones: La posicion a buscar debe existir
	 * Salida: el Product de la posicion determinada
	 * Postcondiciones: Asociado al nombre devuelve el producto de la posicion determinada.
	 */
	public Product getProduct(int position) {
		return products.get(position);
	}
	
	/* INTERFAZ
	 * Comentario: Añade un pedido (order) a la lista de pedidos
	 * Prototipo: public void addOrder(Order order)
	 * Entrada: Un Order con el pedido a añadir
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: El Order determinado queda añadido en la lista
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	/* INTERFAZ
	 * Comentario: Borra un pedido de la lista de pedidos
	 * Prototipo: public void removeOrder(Order order)
	 * Entrada: El Order a borrar de la lista de pedidos
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: Borra el pedido determinado de la lista, si el pedido no existe, no borra nada.
	 */
	public void removeOrder(Order order) {
		orders.remove(order);
	}
	
	/* INTERFAZ
	 * Comenario: Obtiene un pedido de la lista de pedidos dada una posicion
	 * Prototipo: public Order getOrder(int position)
	 * Entrada: Un int con la posicion del pedido a obtener
	 * Precondiciones: La posicion debe existir en la lista
	 * Salida: el Order de la posicion determinada
	 * Postcondiciones: Asociado al nombre devuelve el Order de la posición determinada
	 */
	public Order getOrder(int position) {
		return orders.get(position);
	}
	
	//TERCERA PARTE
	//Cola de pedidos
	public void pushOrder(Order order) {
		//TODO AÃ±adir pedido
		orderQueue.add(order);
		
	}
	
	public Order popOrder() {
		//TODO Obtener pedido
		return orderQueue.poll();
	}
	
	public Order getFront() {
		//TODO Devuelve el primer pedido de la cola
		//OJO!! No hay que sacarlo, solo devolver el primer pedido
		return orderQueue.element();
	}
	
	//Operaciones
	public Product getMinPriceProduct() {
		//TODO Devolver el producto con el precio mÃ¡s bajo
		double minimo = Double.POSITIVE_INFINITY;
		Product productoMin = null;
		for(int i = 0; i < this.getProducts().size(); i ++){
			if (this.getProduct(i).getPrice() < minimo ){
				minimo = this.getProduct(i).getPrice();
				productoMin = this.getProduct(i);
			}
		}
		return productoMin;
	}
	
	public Product getMaxPriceProduct() {
		//TODO Devolver el producto con el precio mÃ¡s alto
		double maximo = Double.NEGATIVE_INFINITY;
		Product productoMax = null;
		for(int i = 0; i < this.getProducts().size(); i ++){
			if (this.getProduct(i).getPrice() > maximo ){
				maximo = this.getProduct(i).getPrice();
				productoMax = this.getProduct(i);
			}
		}
		return productoMax;
		
	}
	
	public double getAvgPriceProduct() {
		//TODO Devolver la media de precios de los productos
		double avg = 0;
		double sum = 0;
		for(int i = 0; i < this.getProducts().size(); i ++){
			sum += this.getProduct(i).getPrice();
		}
		avg = sum / (this.getProducts().size());

		return avg;
	}
	
	public double getPriceByCode(Integer productCode) {
		//TODO Delvover el precio del producto
		double precio = 0.0;
		for(int i = 0; i < this.getProducts().size(); i ++){
			if (this.getProduct(i).getCode().equals(productCode)){
				precio = this.getProduct(i).getPrice();
			}
		}
	return precio;
	}
	
	/* INTERFAZ
	 * Comentario: Devuelve el producto más vendido del supermercado
	 * Prototipo: public Product getBestSellingProduct() 
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: un Product con el producto más vendido
	 * Postcondiciones: Asociado al nombre devuelve un Product con el producto mas vendido, o null si no hay ningun producto vendido
	 */
	public Product getBestSellingProduct() 
	{
		Product bestSellingProduct = new Product(0, " ", 0.0, null);
		
		for(Product product:products)
		{
			if(this.getQuantitySold(product.getCode()) > this.getQuantitySold(bestSellingProduct.getCode()))
			{
				bestSellingProduct = product;
			}
		}
		
		return bestSellingProduct;
	}
	
	/*INTERFAZ
	 * Comentario: Devuelve la cantidad vendida del producto indicado:
	 * Prototipo: public int getQuantitySold(int code)
	 * Entrada: Un int con la ID del producto del que se desea saber la cantidad vendida
	 * Precondiciones: No hay
	 * Salida: Un int con la cantidad vendida del producto
	 * Postcondiciones: Asociado al nombre devuelve un int con la cantidad vendida en el supermercado del producto determinado.
	 */
	public int getQuantitySold(int code)
	{
		int quantitySold = 0;
		
		for(Order pedido:orders)
		{
			for(OrderLine lineaPedidos:pedido.getOrderLines())
			{
				if(lineaPedidos.getProduct().getCode() == code)
				{
					quantitySold += lineaPedidos.getQuantity();
				}
			}
		}
		
		return quantitySold;
	}
	
	/* INTERFAZ
	 * Comentario: Devuelve el producto menos vendido del supermercado
	 * Prototipo: public Product getWorstSellingProduct() 
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: un Product con el producto menos vendido
	 * Postcondiciones: Asociado al nombre devuelve un Product con el producto menos vendido, o null si no hay ningun producto vendido
	 */
	public Product getWorstSellingProduct() 
	{
		Product worstSellingProduct = this.getProduct(0);
		
		for(Product product:products)
		{
			if(this.getQuantitySold(product.getCode()) < this.getQuantitySold(worstSellingProduct.getCode()))
			{
				worstSellingProduct = product;
			}
		}
		
		return worstSellingProduct;
	}
	
}
