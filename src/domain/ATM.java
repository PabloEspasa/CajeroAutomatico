package domain;

import java.util.Scanner;

public class ATM {
	private Banco banco; // Instancia del banco para gestionar las cuentas
	private Scanner scanner; // Instancia del scanner para leer la entrada del usuario
	private ReposicionCajero cajero; // Instancia del cajero para gestionar los billetes

	public ATM() {
		banco = Banco.getInstance(); // Obtener la instancia única del Banco
		scanner = new Scanner(System.in);
		cajero = new ReposicionCajero(); // Crear una nueva instancia del cajero
	}

	public void ejecutar() {
		boolean autenticado = false; // Variable para controlar la autenticación del usuario
		Account cuentaActual = null; // Variable para almacenar la cuenta actualmente autenticada

		// Bucle para solicitar al usuario las credenciales de autenticación
		while (!autenticado) {
			System.out.println("Bienvenido a nuestra red de cajeros!");
			System.out.println("Ingrese su número de cuenta: ");
			String numeroCuenta = scanner.nextLine();

			System.out.println("Ingrese su NIP: ");
			String nip = scanner.nextLine();

			// Verificar si las credenciales proporcionadas son válidas
			for (Account cuenta : banco.getCuentas()) {
				if (cuenta.getAccountNumber().equals(numeroCuenta) && cuenta.getNip().equals(nip)) {
					autenticado = true; // El usuario está autenticado
					cuentaActual = cuenta; // Almacenar la cuenta actual autenticada
					break;
				}
			}

			if (!autenticado) {
				System.out.println("Credenciales inválidas. Por favor, intente nuevamente.");
			}
		}

		System.out.println("¡Autenticación exitosa!");
		System.out.println("Bienvenido, " + cuentaActual.getAccountNumber() + ".");

		boolean salir = false;

		// Loop para mostrar las opciones disponibles después de la autenticación
		while (!salir) {
			System.out.println("Seleccione una opción:");
			System.out.println("1. Consultar saldo");
			System.out.println("2. Realizar retiro");
			System.out.println("3. Realizar depósito");
			System.out.println("4. Salir");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				Transacciones saldo = new Saldo(cuentaActual.getAccountNumber());
				saldo.ejecutar(); // Ejecutar la transacción de consultar saldo
				break;
			case 2:
				Transacciones retiro = new Retirar(cuentaActual.getAccountNumber());
				retiro.ejecutar(); // Ejecutar la transacción de realizar retiro
				break;
			case 3:
				Transacciones deposito = new Depositar(cuentaActual.getAccountNumber());
				deposito.ejecutar(); // Ejecutar la transacción de realizar depósito
				break;
			case 4:
				salir = true; // Salir del loop y finalizar la ejecución del ATM
				ejecutar(); // Volver a ejecutar el ATM para otro usuario
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		}

		System.out.println("Gracias por utilizar el ATM. ¡Hasta pronto!");
	}
}
