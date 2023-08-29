package domain;

public class Account {

    protected double balance; // Saldo de la cuenta
    private String numeroDeCuenta; // Número de cuenta
    private String nip; // NIP (Número de Identificación Personal) de la cuenta

    protected Account(String numeroDeCuenta, String nip, double balance) {
        super();
        this.nip = nip; // Inicializar el NIP con el valor proporcionado
        this.balance = balance; // Inicializar el saldo con el valor proporcionado
        this.numeroDeCuenta = numeroDeCuenta; // Inicializar el número de cuenta con el valor proporcionado
    }

    public double getBalance() {
        return balance; // Devolver el saldo de la cuenta
    }

    public void setBalance(double balance) {
        this.balance = balance; // Establecer el saldo de la cuenta con el valor proporcionado
    }

    public String getAccountNumber() {
        return numeroDeCuenta; // Devolver el número de cuenta de la cuenta
    }

    public String getNip() {
        return nip; // Devolver el NIP de la cuenta
    }

    @Override
    public String toString() {
        return "Account [balance=" + balance + ", accountNumber=" + numeroDeCuenta + ", nip=" + nip + "]";
        // Devolver una representación en cadena de la cuenta con su saldo, número de cuenta y NIP
    }
}