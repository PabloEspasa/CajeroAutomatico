package domain;

public abstract class Transacciones {

    protected String numeroDeCuenta; // Número de cuenta asociado a la transacción

    public Transacciones(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta; // Inicializar el número de cuenta con el valor proporcionado
    }

    public abstract void ejecutar(); // Método abstracto que debe ser implementado por las subclases

    public String getNumeroDeCuenta() {
        return numeroDeCuenta; // Devolver el número de cuenta asociado a la transacción
    }
}
