package n1ejercicio1;

public class Producto {
	private String noombre;
	private int precio;
	
	public Producto(String noombre, int precio) {		
		this.noombre = noombre;
		this.precio = precio;
	}

	public String getNoombre() {
		return noombre;
	}

	public void setNoombre(String noombre) {
		this.noombre = noombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [noombre=" + noombre + ", precio=" + precio + "]";
	}
	
	
}
