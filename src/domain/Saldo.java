package domain;

public class Saldo extends Transacciones {

	public Saldo(String numeroDeCuenta) {
		super(numeroDeCuenta);
	}

	@Override
	public void ejecutar() {
		Banco banco = Banco.getInstance(); // Obtener la instancia �nica del Banco
		Account cuenta = banco.obtenerCuenta(numeroDeCuenta); // Obtener la cuenta asociada al n�mero de cuenta

		if (cuenta != null) {
			System.out.println("Su saldo actual es: " + cuenta.getBalance());
		} else {
			throw new IllegalArgumentException("La cuenta es inexistente");
		}
	}
}
