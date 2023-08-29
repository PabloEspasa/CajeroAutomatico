package domain;

public class CajeroAutomatico {
	public static void main(String[] args) {
		Banco banco = Banco.getInstance(); // Obtener la instancia única del Banco

		Account cuenta1 = new Account("12345", "12345", 50000);
		Account cuenta2 = new Account("54321", "54312", 80000);
		Account cuenta3 = new Account("12121", "12121", 100);

		banco.agregarCuenta(cuenta3);
		banco.agregarCuenta(cuenta1);
		banco.agregarCuenta(cuenta2);

		ATM atm = new ATM(); // Crear una nueva instancia del ATM
		atm.ejecutar(); // Iniciar la ejecución del cajero automático
	}
}