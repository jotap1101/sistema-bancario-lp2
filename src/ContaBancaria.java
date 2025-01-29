public abstract class ContaBancaria {
    // Atributos
    private String titular;
    private int numero;
    private int agencia;
    private String tipo;
    private double saldo;

    // Construtor
    public ContaBancaria(String titular, int numero, int agencia, String tipo, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    // Getters e Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Métodos abstratos
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    // Método para sobrescrever nas classes filhas (Polimorfismo de sobrescrita)
    public void imprimirExtrato() {
        System.out.println("Extrato da conta do(a) titular: " + this.titular);
    }

    // Métodos de sobrecarga (Polimorfismo de sobrecarga)
    public void transferir(ContaBancaria contaDestino, double valor) {
        if (valor > 0) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                contaDestino.saldo += valor;

                System.out.println("- Transferência de R$ " + valor + " realizada com sucesso (De " + this.titular + " para " + contaDestino.titular + ").");
                System.out.println("- Conta de origem: " + this.titular + " - Saldo atual: R$ " + this.saldo);
                System.out.println("- Conta de destino: " + contaDestino.titular + " - Saldo atual: R$ " + contaDestino.saldo);
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        } else {
            System.out.println("Valor inválido para transferência.");
        }
    }

    public void transferir(ContaBancaria contaDestino, double valor, String descricao) {
        if (valor > 0) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                contaDestino.saldo += valor;

                System.out.println("- Transferência de R$ " + valor + " realizada com sucesso (De " + this.titular + " para " + contaDestino.titular + ").");
                System.out.println("- Descrição: " + descricao);
                System.out.println("- Conta de origem: " + this.titular + " - Saldo atual: R$ " + this.saldo);
                System.out.println("- Conta de destino: " + contaDestino.titular + " - Saldo atual: R$ " + contaDestino.saldo);
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        } else {
            System.out.println("Valor inválido para transferência.");
        }
    }
}
