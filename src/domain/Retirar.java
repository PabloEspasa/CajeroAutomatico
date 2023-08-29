package domain;

import java.util.Scanner;

public class Retirar extends Transacciones {

	private ReposicionCajero rep1; // Variable para mantener la instancia de ReposicionCajero

	public Retirar(String numeroDeCuenta) {
		super(numeroDeCuenta);
		if (rep1 == null) {
			this.rep1 = ReposicionCajero.getInstance(); // Obtener la instancia única de ReposicionCajero
		}
	}

	@Override
	public void ejecutar() {
		Banco banco = Banco.getInstance(); // Obtener la instancia única del Banco
		Account cuenta = banco.obtenerCuenta(numeroDeCuenta); // Obtener la cuenta asociada al número de cuenta

		if (cuenta != null) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Ingrese la cantidad a retirar: ");
			int montoRetiro = scanner.nextInt();

			if (montoRetiro <= cuenta.getBalance()) {
				int cantidadBilletesNecesarios = montoRetiro / 20;

				if (cantidadBilletesNecesarios <= rep1.getCantidadBilletesDisponibles()) {
					if (montoRetiro % 20 == 0) {
						realizarRetiro(cuenta, montoRetiro); // Realizar la transacción de retiro
						System.out.println("Su retiro se ha realizado con éxito");
						System.out.println("Su saldo actual es de " + cuenta.getBalance());
						System.out.println("Los billetes disponibles son " + rep1.getCantidadBilletesDisponibles());

					} else {
						System.out.println("Solo puedo proporcionar billetes de " + rep1.getBillete20());
					}
				} else {
					System.out.println("No hay suficientes billetes disponibles en el cajero");
					System.out.println("Usted puede retirar hasta $" + (rep1.getCantidadBilletesDisponibles() * 20));
				}
			} else {
				System.out.println("Fondos insuficientes en la cuenta");
			}
		} else {
			System.out.println("La cuenta especificada no existe");
		}
	}

	public void realizarRetiro(Account cuenta, int monto) {
		double saldoActual = cuenta.getBalance();
		int cantidadBilletesNecesarios = monto / 20; // Calcular la cantidad de billetes necesarios para el retiro
		cuenta.setBalance(saldoActual - monto); // Actualizar el saldo de la cuenta después del retiro
		rep1.setCantidadBilletesDisponibles(rep1.getCantidadBilletesDisponibles() - cantidadBilletesNecesarios); // Actualizar
																													// la
																													// cantidad
																													// de
																													// billetes
																													// disponibles
																													// en
																													// el
																													// cajero
	}
}