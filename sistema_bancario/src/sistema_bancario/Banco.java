package sistema_bancario;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private final Lock lock;
	private final Conta contaLoja1;
    private final Conta contaLoja2;

    public Banco(Conta contaLoja1, Conta contaLoja2) {
        this.lock = new ReentrantLock();
        this.contaLoja1 = contaLoja1;
        this.contaLoja2 = contaLoja2;
    }
    
    public Conta getContaLoja1() {
        return contaLoja1;
    }

    public Conta getContaLoja2() {
        return contaLoja2;
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.sacar(valor)) {
                destino.depositar(valor);
                System.out.printf("Transferência de %.2f de %s para %s\n", valor, origem.getCliente(), destino.getCliente());
            } else {
                System.out.printf("Saldo insuficiente para transferência de %.2f de %s\n", valor, origem.getCliente());
            }
        } finally {
            lock.unlock();
        }
    }
}
