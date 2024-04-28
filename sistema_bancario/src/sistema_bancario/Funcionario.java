package sistema_bancario;

public class Funcionario extends Thread {
	private final String nome;
    private final Conta contaSalario;
    private final Conta contaInvestimentos;

    public Funcionario(String nome, Conta contaSalario, Conta contaInvestimentos) {
        super(nome);
        this.nome = nome;
        this.contaSalario = contaSalario;
        this.contaInvestimentos = contaInvestimentos;
    }

    @Override
    public void run() {
        while (true) {
            receberSalario();
            try {
                Thread.sleep(200); // Simula intervalo de tempo entre salários
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void receberSalario() {
        double salario = 1400;
        contaSalario.depositar(salario);
        double valorInvestimento = salario * 0.2;
        contaSalario.sacar(valorInvestimento);
        contaInvestimentos.depositar(valorInvestimento);
        System.out.println("Funcionário " + nome + " recebeu salário de R$ " + salario + " e investiu R$ " + valorInvestimento);
    }
}
