package n1ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// para coger las exception
		// https://jarroba.com/excepciones-exception-en-java-con-ejemplos/
		ArrayList<Producto> productos = new ArrayList<Producto>();
		int precioTotal = 0;
		String respuesta;
		Venda venda = new Venda(productos, precioTotal);
		do {
			System.out.println("Desea añadir algún producto a la cesta?(s/n)");
			respuesta = sc.nextLine();
			respuesta.toLowerCase();
			if (respuesta.charAt(0) == 's') {
				System.out.println("Introduzca el producto a añadir en la Venta:");
				String nombre = sc.nextLine();
				System.out.println("Introduce el precio:");
				int precio = sc.nextInt();
				sc.nextLine();
				Producto producto = new Producto(nombre, precio);
				venda.getProductos().add(producto);
			}
			try {
				venda.calcularTotal();
			} catch (VendaBuidaException e) {
				System.out.println(e.getMessage());
			}
			
		} while (respuesta.charAt(0) == 's');
		
		// Escriu el codi necessari per a generar i capturar una excepció de tipus
		// ArrayIndexOutOfBoundsException:
		//
		try {
			venda.getProductos().get(venda.getProductos().size() + 1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Esto es el finally");
		}

	}

}
