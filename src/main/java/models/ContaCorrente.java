package models;
import GlobalExceptionHandler.SaldoInsuficienteException;
public class ContaCorrente extends ContaBancaria {
    private static final double TAXA_MANUTENCAO_CC = 0.001;
    private final double taxaManutencao;

    public ContaCorrente(String numeroConta, double saldo, Cliente titular) {
        super(numeroConta, saldo, titular);
        this.taxaManutencao = TAXA_MANUTENCAO_CC;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        double taxa = valor * taxaManutencao;
        super.sacar(valor + taxa);
    }
    public String toString(){
        return "\nConta Corrente" +"\n"+
                "Numero Conta:" + getNumeroConta()+
                "\nSaldo:" + getSaldo()+
                "\nTitular:" + getTitular();
    }
}