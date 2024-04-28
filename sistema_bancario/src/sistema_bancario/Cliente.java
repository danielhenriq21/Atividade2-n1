package sistema_bancario;

public class Cliente extends Thread{
	private final Conta conta;
    private final Banco banco;

    public Cliente(String nome, Conta conta, Banco banco) {
        super(nome);
        this.conta = conta;
        this.banco = banco;
    }

    @Override
    public void run() {
    	while (true) {
            double valor = Math.random() < 0.5 ? 100 : 200;
            Conta outraConta = conta.getSaldo() < valor ? conta : banco.getContaLoja1().getCliente().endsWith("1") ? banco.getContaLoja2() : banco.getContaLoja1();
            banco.transferir(conta, outraConta, valor);
            try {
                Thread.sleep(100); // Simula tempo de compra
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}