public class ContaPoupanca extends ContaBancaria {
    // Atributos
    private double taxaRendimento;

    // Construtor
    public ContaPoupanca(String titular, int numero, int agencia, double saldo, double taxaRendimento) {
        super(titular, numero, agencia, "Conta Poupança", saldo);
        this.taxaRendimento = taxaRendimento;
    }

    // Getters e Setters
    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    // Métodos da classe
    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento;

        setSaldo(getSaldo() + rendimento);

        System.out.println("- Rendimento de R$ " + rendimento + " (" + (taxaRendimento * 100) + "%) aplicado com sucesso.");
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
        System.out.println("========== Extrato da Conta Poupança ==========\n");
        System.out.println("Titular: " + getTitular());
        System.out.println("Número da conta: " + getNumero());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Tipo da conta: " + getTipo());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Taxa de rendimento: " + (taxaRendimento * 100) + "%");
        System.out.println("\n=============================================");
    }
    
}
