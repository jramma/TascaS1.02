package n3ejercicio1;

import java.util.ArrayList;

public class GestionButacas {

	private ArrayList<Butaca> butacas = new ArrayList<Butaca>();

	public GestionButacas() {
		ArrayList<Butaca> butacas = new ArrayList<Butaca>();
		this.butacas=butacas;
		
	}

	public ArrayList<Butaca> getButacas() {
		return butacas;
	}

	public void anadirButaca(Butaca butaca) {

		if (buscarButaca(butaca) == null) {
			butacas.add(butaca);
		} else {
			System.out.println("Este asiento está ocupado. ");
		}

	}

	public void eliminarButaca(int numFila, int asiento) throws ButacaLibreException {
		Butaca butaca = new Butaca(numFila, asiento, "");
		if (buscarButaca(butaca) == null) {
			throw new ButacaLibreException("Error, la butaca esta libre.");
		} else {
			butacas.remove(buscarButaca(butaca));
		}
	}

	public Butaca buscarButaca(Butaca butaca) {
		int i = 0, limite = butacas.size();
		Butaca butaca1 = null;
		while (i < limite && butaca1 == null) {
			if (butacas.get(i).getFila() == butaca.getFila()) {
				butaca1 = butacas.get(i);
			}

			if (butaca1 == butacas.get(i)) {
				if (butaca1.getNumAsietno() != butaca.getNumAsietno()) {
					butaca1 = null;
				}
			}
			i++;
		}
		while (i < limite && butaca1 == null) {
			if (butacas.get(i).getFila() == butaca.getFila()) {
				butaca1 = butacas.get(i);
				if (butaca1.getNumAsietno() != butaca.getNumAsietno()) {
					butaca1 = null;
				}
			}

			i++;
		}
		return butaca1;
	}

}
