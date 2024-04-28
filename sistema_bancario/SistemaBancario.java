package sistema_bancario;

import sistema_bancario.copy.Banco;
import sistema_bancario.copy.Cliente;
import sistema_bancario.copy.Conta;
import sistema_bancario.copy.Funcionario;
import sistema_bancario.copy.Loja;

public class SistemaBancario {
	public static void main(String[] args) {
		Conta contaLoja1 = new Conta("Loja 1", 0);
        Conta contaLoja2 = new Conta("Loja 2", 0);
        Conta contaFuncionarios = new Conta("Contas Funcionários", 0);

        Banco banco = new Banco(contaLoja1, contaLoja2); // Fornecendo as contas necessárias

        Loja loja1 = new Loja(contaLoja1, contaFuncionarios, banco);
        Loja loja2 = new Loja(contaLoja2, contaFuncionarios, banco);

        Funcionario funcionario1 = new Funcionario("Funcionário 1", contaLoja1, contaFuncionarios);
        Funcionario funcionario2 = new Funcionario("Funcionário 2", contaLoja1, contaFuncionarios);
        Funcionario funcionario3 = new Funcionario("Funcionário 3", contaLoja2, contaFuncionarios);
        Funcionario funcionario4 = new Funcionario("Funcionário 4", contaLoja2, contaFuncionarios);

        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1), new Conta("Cliente " + (i + 1), 1000), banco);
            clientes[i].start();
        }

        funcionario1.start();
        funcionario2.start();
        funcionario3.start();
        funcionario4.start();

        while (true) {
            loja1.pagarFuncionarios();
            loja2.pagarFuncionarios();
            try {
                Thread.sleep(3000); // Simula intervalo de tempo entre pagamentos de salários
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
