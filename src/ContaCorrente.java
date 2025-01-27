public class ContaCorrente extends ContaBancaria {
    // Atributos
    private double taxaManutencao;

    // Construtor
    public ContaCorrente(String titular, int numero, int agencia, double saldo, double taxaManutencao) {
        super(titular, numero, agencia, "Conta Corrente", saldo);
        this.taxaManutencao = taxaManutencao;
    }

    // Getters e Setters
    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    // Métodos da classe
    public void cobrarTaxaManutencao() {
        setSaldo(getSaldo() - taxaManutencao);

        System.out.println("- Taxa de manutenção de R$ " + taxaManutencao + " cobrada com sucesso.");
    }

    // Implementação dos métodos abstratos
    @Override
    public void sacar(double valor) {
        if (valor < 0) {
            System.out.println("Valor inválido para saque.");
        } else if (valor > getSaldo()) {
            System.out.println("Saldo insuficiente.");
        } else {
            setSaldo(getSaldo() - valor);
            System.out.println("- Saque de R$ " + valor + " realizado com sucesso.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor < 0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            setSaldo(getSaldo() + valor);
            System.out.println("- Depósito de R$ " + valor + " realizado com sucesso.");
        }
    }

    // Sobrescrita do método imprimirExtrato
    @Override
    public void imprimirExtrato() {
        System.out.println("========== Extrato da Conta Corrente ==========\n");
        System.out.println("Titular: " + getTitular());
        System.out.println("Número da conta: " + getNumero());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Tipo da conta: " + getTipo());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Taxa de manutenção: R$ " + taxaManutencao);
        System.out.println("\n=============================================");
    }
}
