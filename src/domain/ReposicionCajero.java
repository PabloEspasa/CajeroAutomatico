package domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ReposicionCajero {
	private static final ReposicionCajero instance = new ReposicionCajero();
	private static final int BILLETE_20 = 20;
	private static final int CANTIDAD_INICIAL = 500;
	private int cantidadBilletesDisponibles;

	private LocalDateTime ultimaRecarga; // Almacena la fecha y hora de la última recarga del cajero.

	public ReposicionCajero() {
		// Inicializa la cantidad de billetes disponibles con la cantidad inicial.
		cantidadBilletesDisponibles = CANTIDAD_INICIAL;
		// Guarda la fecha y hora actual en la variable ultimaRecarga.
		ultimaRecarga = LocalDateTime.now();
		// Programa la recarga diaria del cajero.
		configurarRecargaDiaria();
	}

	public int getCantidadBilletesDisponibles() {
		return cantidadBilletesDisponibles;
	}

	public void setCantidadBilletesDisponibles(int cantidadBilletesDisponibles) {
		this.cantidadBilletesDisponibles = cantidadBilletesDisponibles;
	}

	public int getBillete20() {
		return BILLETE_20;
	}

	public int obtenerCantidadBilletesDisponibles() {
		return cantidadBilletesDisponibles;
	}

	
	private void recargarCajero() { 
		cantidadBilletesDisponibles = CANTIDAD_INICIAL;
		ultimaRecarga = LocalDateTime.now();
	}// Recarga el cajero estableciendo la cantidad de billetes disponibles a la cantidad inicial.

	private void configurarRecargaDiaria() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				recargarCajero();
			}
		};
		long delay = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusDays(1)).toMillis();
		timer.schedule(task, delay, 24 * 60 * 60 * 1000); // Recarga diaria cada 24 horas
	}//Configura la recarga diaria del cajero utilizando la clase Timer. Crea un temporizador (timer) y una tarea (task) que ejecutará el método recargarCajero() cada 24 horas.


	public LocalDateTime getUltimaRecarga() {
		return ultimaRecarga;
	} // Devuelve la fecha y hora de la última recarga del cajero.

	public static ReposicionCajero getInstance() {
		return instance;
	}
}
