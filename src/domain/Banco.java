package domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Account> cuentas; // Lista de cuentas bancarias almacenadas en el banco
    private static final Banco instance = new Banco(); // Instancia estática y única de la clase Banco
    private int numeroDeCuentas; // Cantidad total de cuentas en el banco

    private Banco() {
        cuentas = new ArrayList<>(0); // Inicializa la lista de cuentas como una ArrayList vacía
        numeroDeCuentas = 0; // Inicializa el contador de número de cuentas en 0
    }

    public void agregarCuenta(Account cuenta) {
        cuentas.add(cuenta); // Agrega una cuenta a la lista de cuentas del banco
    }

    public static Banco getInstance() {
        return instance; // Devuelve la instancia única del banco (patrón Singleton)
    }

    public int getNumeroDeCuentas() {
        return numeroDeCuentas; // Devuelve el número total de cuentas en el banco
    }

    public List<Account> getCuentas() {
        return cuentas; // Devuelve la lista de cuentas del banco
    }

    public void setCuentas(List<Account> cuentas) {
        this.cuentas = cuentas; // Establece la lista de cuentas del banco con una nueva lista proporcionada
    }

    public Account obtenerCuenta(String n) {
        // Recorre la lista de cuentas para encontrar una cuenta con el número de cuenta "n"
        for (Account cuenta : cuentas) {
            if (cuenta.getAccountNumber().equals(n)) {
                return cuenta; // Devuelve la cuenta si se encuentra con el número de cuenta "n"
            }
        }
        return null; // Si no se encuentra la cuenta con el número de cuenta "n", devuelve null
    }
}
