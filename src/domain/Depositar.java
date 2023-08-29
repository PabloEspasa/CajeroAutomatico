package domain;

import java.util.Scanner;

public class Depositar extends Transacciones {

	private ReposicionCajero rep1; // Variable para mantener la instancia de ReposicionCajero

	public Depositar(String numeroDeCuenta) {
		super(numeroDeCuenta);
		if (rep1 == null) {
			this.rep1 = ReposicionCajero.getInstance(); // Obtener la instancia �nica de ReposicionCajero
		}
	}

	@Override
	public void ejecutar() {
		Banco banco = Banco.getInstance(); // Obtener la instancia �nica del Banco
		Account cuenta = banco.obtenerCuenta(numeroDeCuenta); // Obtener la cuenta asociada al n�mero de cuenta

		if (cuenta != null) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Ingrese la cantidad a depositar: ");
			int montoDeposito = scanner.nextInt();

			realizarDeposito(cuenta, montoDeposito); // Realizar la transacci�n de dep�sito
			System.out.println("Dep�sito exitoso. Nuevo saldo: " + cuenta.getBalance());
			System.out.println("Los billetes disponibles son " + rep1.getCantidadBilletesDisponibles());
		} else {
			System.out.println("La cuenta especificada no existe");
		}
	}

	public void realizarDeposito(Account cuenta, int monto) {
		double saldoActual = cuenta.getBalance();
		cuenta.setBalance(saldoActual + monto); // Actualizar el saldo de la cuenta despu�s del dep�sito
		int cB = (monto / 20); // Calcular la cantidad de billetes necesarios para el dep�sito
		System.out.println(rep1.getCantidadBilletesDisponibles()); // Imprimir la cantidad actual de billetes
																	// disponibles
		rep1.setCantidadBilletesDisponibles(rep1.getCantidadBilletesDisponibles() + cB); // Actualizar la cantidad de
																							// billetes disponibles en
																							// el cajero
	}
}