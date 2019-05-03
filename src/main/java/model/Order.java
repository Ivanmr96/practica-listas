/*
* Clase: Order
*
* */
package main.java.model;
import java.util.ArrayList;
import java.util.List;

import main.java.util.Articulo;
import main.java.util.ListaArticulos;

public class Order {
	
	public Order(Integer code, String consumer, Supermarket supermarket) {
		this.code = code;
		this.consumer = consumer;
		this.supermarket = supermarket;
		this.orderLines = new ArrayList<OrderLine>();
		this.linkedOrderLines = new ListaArticulos();
	}

	private Integer code;
	private String consumer;
	
	private Supermarket supermarket;
	private List<OrderLine> orderLines;
	
	//SEGUNDA PARTE
	private ListaArticulos linkedOrderLines;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	public Supermarket getSupermarket() {
		return supermarket;
	}
	public void setSupermarket(Supermarket supermarket) {
		this.supermarket = supermarket;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}	
	public ListaArticulos getListaPedidos() {
		return linkedOrderLines;
	}
	public void setListaPedidos(ListaArticulos linkedOrderLines) {
		this.linkedOrderLines = linkedOrderLines;
	}
	
	public String toString() {
		return String.format("%o - %s   Supermarket: %s", this.code, this.consumer, this.supermarket.getName());
	}
	
	//Métodos a completar
	//PRIMERA PARTE
	/*
	* INTERFAZ
	* Comentario: Este método añade un objeto de tipo OrderLine a la lista orderLines de la clase Order
	* Signatura: public void addOrderLine(OrderLine orderLine)
	* Precondiciones: Por referencia se pasa un objeto de tipo OrderLine
	* Entradas: OrderLine orderLine
	* Salidas:
	* Postcondiciones: asociado al nombre no devuelve nada. Queda añadido un objeto más a la lista orderLines.
	 * */
	public void addOrderLine(OrderLine orderLine) {
		//TODO Añadir artículo
		orderLines.add(orderLine);

	}

	/*
	 * INTERFAZ
	 * Comentario: Este método elimina un objeto de tipo OrderLine de la lista orderLines de la clase Order. Elimina la primera coincidencia, si existe.
	 * Signatura: public void removeOrderLine(OrderLine orderLine)
	 * Precondiciones: Por referencia se pasa un objeto de tipo OrderLine
	 * Entradas: OrderLine orderLine
	 * Salidas:
	 * Postcondiciones: asociado al nombre no devuelve nada. Queda eliminado un objeto de la lista orderLines, que será la primera
	 * 					coincidencia, si la hubiera.
	 * */
	public void removeOrderLine(OrderLine orderLine) {
		//TODO Eliminar artículo
		orderLines.remove(orderLine);
		
	}

	/*
	 * INTERFAZ
	 * Comentario: Este método devuelve el objeto de tipo OrderLine cuya posicion coincida con la pasada por parametros, de la lista de orderLines.
	 * Signatura: public OrderLine getOrderLine(int position)
	 * Precondiciones: Por valor se pasa un entero que es la posición del objeto en la lista que se devolverá.
	 * 					La posicion debera ser una posicion existente dentro de la lista.
	 * Entradas: int position
	 * Salidas: objeto OrderLine
	 * Postcondiciones: asociado al nombre se devuelve un objeto OrderLine que es el elemento x de la lista, donde x es la posicion pasada por parámetro.
	 * */
	public OrderLine getOrderLine(int position) {
		//TODO Coger artículo

		return orderLines.get(position);
	}
	
	//SEGUNDA PARTE
	public void addLinkedOrderLine(OrderLine orderLine) {
		//TODO Añadir artículo
		Articulo art = new Articulo();
		art.setOrderLine(orderLine);
		linkedOrderLines.add(art);
		
	}
	
	public void removeLinkedOrderLine(OrderLine orderLine) {
		//TODO Eliminar artículo
		Articulo art = new Articulo();
		art.setOrderLine(orderLine);
		linkedOrderLines.remove(art);
		
	}
	
	public OrderLine getLinkedOrderLine(int position) {
		//TODO Coger artículo
		Articulo art ;
		art = linkedOrderLines.get(position);
		return art.getOrderLine();
	}
	
	public OrderLine getLastOrderLine() {
		//TODO Coger último artículo

		return linkedOrderLines.get(linkedOrderLines.getSize()-1).getOrderLine();
	}
	
	//TERCERA PARTE
	public Double getTotalPrice() {
		//TODO Calcular el total del pedido
		double totalPrice = 0.0;
		for (int i = 0; i < this.getOrderLines().size(); i ++){
			totalPrice += this.getOrderLine(i).getProduct().getPrice() * this.getOrderLine(i).getQuantity();
		}
		return totalPrice;
	}

}
