public class App {
    public static void main(String[] args) throws Exception {
        // Polimorfismo de inclusão
        ContaBancaria contaCorrente = new ContaCorrente("João", 152552, 456, 1000, 10);
        ContaBancaria contaPoupanca = new ContaPoupanca("Lúcio", 138867, 101, 2000, 0.05);

        // Polimorfismo de sobrescrita
        System.out.println();
        contaCorrente.imprimirExtrato();
        System.out.println();
        contaCorrente.sacar(500);
        System.out.println();
        contaCorrente.depositar(1000);
        System.out.println();
        ((ContaCorrente) contaCorrente).cobrarTaxaManutencao();
        System.out.println();
        contaCorrente.imprimirExtrato();

        System.out.println();
        contaPoupanca.imprimirExtrato();
        System.out.println();
        contaPoupanca.sacar(500);
        System.out.println();
        contaPoupanca.depositar(1000);
        System.out.println();
        ((ContaPoupanca) contaPoupanca).aplicarRendimento();
        System.out.println();
        contaPoupanca.imprimirExtrato();

        // Polimorfismo de sobrecarga
        System.out.println();
        contaCorrente.transferir(contaPoupanca, 300);
        System.out.println();
        contaPoupanca.transferir(contaCorrente, 200, "Transferência para conta corrente (Teste de sobrecarga).");
    }
}
