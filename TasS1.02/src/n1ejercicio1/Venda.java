package n1ejercicio1;

import java.util.ArrayList;

public class Venda {
	private ArrayList <Producto> productos;
	private int precioTotal;

	public Venda(ArrayList<Producto> productos, int precioTotal) {
		super();
		this.productos = productos;
		this.precioTotal = precioTotal;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void calcularTotal() throws VendaBuidaException {

		if (productos.size() == 0) {
			throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
		} else {
			System.out.println("Su carrito contiene:");
			for (int i = 0; i < productos.size(); i++) {
				System.out.println("- " + productos.get(i));
				precioTotal = precioTotal + productos.get(i).getPrecio();
			}
			System.out.println("Total : " + precioTotal + " euros.");
		}
	}

}
