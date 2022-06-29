package n3ejercicio1;

public class Butaca {
	private int fila;
	private int numAsietno;
	private String reserva;
	
	public Butaca(int fila, int numAsietno, String reserva) {
		
		this.fila = fila;
		this.numAsietno = numAsietno;
		this.reserva = reserva;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getNumAsietno() {
		return numAsietno;
	}

	public void setNumAsietno(int numAsietno) {
		this.numAsietno = numAsietno;
	}

	public String getReserva() {
		return reserva;
	}

	public void setReserva(String reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "> Fila: " + fila + ", Asietno:" + numAsietno + ", reserva: " + reserva + ".";
	}
	
	
	
	
	
	
	
	
	
	
	
}
