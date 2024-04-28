package sistema_bancario;

public class Loja {
	private final Conta conta;
    private final Banco banco;
    private final Conta contaFuncionarios;

    public Loja(Conta conta, Conta contaFuncionarios, Banco banco) {
        this.conta = conta;
        this.banco = banco;
        this.contaFuncionarios = contaFuncionarios;
    }

    public void pagarFuncionarios() {
        if (conta.getSaldo() >= 1400) {
            banco.transferir(conta, contaFuncionarios, 1400);
            System.out.println("Pagamento de salários dos funcionários realizado.");
        } else {
            System.out.println("Saldo insuficiente para pagar salários dos funcionários.");
        }
    }
}
