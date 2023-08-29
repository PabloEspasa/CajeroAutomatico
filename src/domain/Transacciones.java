package domain;

public abstract class Transacciones {

    protected String numeroDeCuenta; // N�mero de cuenta asociado a la transacci�n

    public Transacciones(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta; // Inicializar el n�mero de cuenta con el valor proporcionado
    }

    public abstract void ejecutar(); // M�todo abstracto que debe ser implementado por las subclases

    public String getNumeroDeCuenta() {
        return numeroDeCuenta; // Devolver el n�mero de cuenta asociado a la transacci�n
    }
}
