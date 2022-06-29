package n1ejercicio1;

class VendaBuidaException extends Exception {			
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VendaBuidaException (String mensaje) {
		super(mensaje);
	}
	

//	private static final long serialVersionUID = 1237411026655545306L;
//	
//	public static void venderProducto() throws VendaBuidaException{
//		throw new VendaBuidaException("Per fer una venda primer has d'afegir productes");
//	}
//	public VendaBuidaException (String mensaje) {
//		super(mensaje);
//	}
}
