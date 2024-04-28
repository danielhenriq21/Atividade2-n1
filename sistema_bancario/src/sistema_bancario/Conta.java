package sistema_bancario;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
	private final String cliente;
    private double saldo;
    private final Lock lock;

    public Conta(String cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.lock = new ReentrantLock();
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        lock.lock();
        try {
            saldo += valor;
        } finally {
            lock.unlock();
        }
    }

    public boolean sacar(double valor) {
        lock.lock();
        try {
            if (saldo >= valor) {
                saldo -= valor;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
