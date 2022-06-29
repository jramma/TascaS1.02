package n3ejercicio1;

import java.util.Scanner;

public class Cine {
	private int filas;
	private int asientosPorFila;
	private GestionButacas gestion;
	static Scanner sc = new Scanner(System.in);

	public Cine() throws FilaIncorrectaExcepcion, AsientoExcepcion, NomIncorrectoException, ButacaLibreException {
		{
			GestionButacas gestion = new GestionButacas();
			this.gestion=gestion;
			
			pedirDatosIniciales();
			iniciar();
		}
	}

	private void pedirDatosIniciales() {
		filas = Entrada.leerInt("¿Cuántas filas tiene la sala?");
		asientosPorFila = Entrada.leerInt("¿Cuántos asientos tiene por fila?");
	}

	private void iniciar()
			throws FilaIncorrectaExcepcion, AsientoExcepcion, NomIncorrectoException, ButacaLibreException {
		int eleccion;
		do {
			eleccion = menu();
			switch (eleccion) {
			case 1:
				mostrarButacas();
				break;
			case 2:
				mostrarButacaPersona();
				break;
			case 3:
				reservarButaca();
				break;
			case 4:
				anularReserva();
				break;
			case 5:
				anularReservaPersona();
				break;
			default:
				System.out.println("Eixint");
			}

		} while (eleccion != 0);
	}

	private void anularReservaPersona() throws NomIncorrectoException {
		String nom = introducirPersona();
		int limite = gestion.getButacas().size();
		for (int i = 0; i < limite; i++) {
			if (gestion.getButacas().get(i).getReserva().equalsIgnoreCase(nom)) {
				gestion.getButacas().remove(i);
			}
			limite = gestion.getButacas().size();
		}
	}

	private void anularReserva() throws ButacaLibreException, AsientoExcepcion, FilaIncorrectaExcepcion {
		int fila = introducirFila();
		int asiento = introducirAsiento();
		gestion.eliminarButaca(fila, asiento);

	}

	private void reservarButaca() throws FilaIncorrectaExcepcion, AsientoExcepcion, NomIncorrectoException {
		int fila = introducirFila();
		int asiento = introducirAsiento();
		String reserva = introducirPersona();
		Butaca butaca = new Butaca(fila, asiento, reserva);
		Butaca butaca1 = gestion.buscarButaca(butaca);
		if (butaca1 == null) {
			gestion.getButacas().add(butaca);
		} else {
			System.out.println("La butaca ya esta reservada");
		}

	}

	private String introducirPersona() throws NomIncorrectoException {
		System.out.println("Introduce el nombre:");
		String nombre = sc.nextLine();
		for (int i = 0; nombre.length() > i; i++) {
			for (int j = 0; j < 10; j++) {
				if (nombre.charAt(i) == j) {
					throw new NomIncorrectoException("Error, el nombre no puede tener numeros");
				}
			}
		}

		return nombre;
	}

	private int introducirAsiento() throws AsientoExcepcion {
		int asiento;

		asiento = Entrada.leerInt("Introduce un numero de Asiento:");
		if (asiento > asientosPorFila || asiento < 0) {
			throw new AsientoExcepcion("Error, el asiento no existe");
		}
		return asiento;
	}

	private int introducirFila() throws FilaIncorrectaExcepcion {
		int fila;

		fila = Entrada.leerInt("Introduce un numero de fila:");

		if (fila > filas || fila < 0) {
			throw new FilaIncorrectaExcepcion("Error, la fila no existe");
		}
		return fila;
	}

	private void mostrarButacaPersona() {
		int limite = gestion.getButacas().size();
		System.out.println("Introduzca el nombre de la reserva");
		String nombre = sc.nextLine();
		for (int i = 0; i < limite; i++) {
			if (gestion.getButacas().get(i).getReserva().equalsIgnoreCase(nombre)) {
				System.out.println("> " + gestion.getButacas().get(i).toString());
			}
		}
		System.out.println("*estas sont todas las reservas a nombre de " + nombre + " .");
	}

	private void mostrarButacas() {
		int limite = gestion.getButacas().size();
		if(limite==0) {
			System.out.println("No hay reservas");
		}else {
		for (int i = 0; i < limite; i++) {
			System.out.println("- " + gestion.getButacas().get(i));
		}
		System.out.println("*Estas son las butacas reservadas*");
		sc.nextLine();
		}
	}

	private int menu() {
		int eleccion;
		do {
			System.out.println("-----------------------------------------");
			System.out.println("1.- Mostrar totes les butaques reservades.");
			System.out.println("2.- Mostrar les butaques reservades per una persona.");
			System.out.println("3.- Reservar una butaca.");
			System.out.println("4.- Anul·lar la reserva d’una butaca.");
			System.out.println("5.- Anul·lar totes les reserves d’una persona.");
			System.out.println("0.- Sortir.");
			eleccion = Entrada.leerInt("");

		} while (eleccion > 5 || eleccion < 0);
		return eleccion;

	}

}
