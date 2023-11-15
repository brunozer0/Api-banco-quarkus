package services;

import GlobalExceptionHandler.SaldoInsuficienteException;
import GlobalExceptionHandler.ContaInvalidaException;
import models.ContaCorrente;
public interface ContaCorrenteService {

    ContaCorrente getContaPorNumero(String numeroConta);
    void depositar(String numeroConta, double valor) throws ContaInvalidaException;
    void sacar(String numeroConta, double valor) throws ContaInvalidaException, SaldoInsuficienteException;
    void transferir(String contaOrigem, String contaDestino, double valor) throws ContaInvalidaException, SaldoInsuficienteException;
    ContaCorrente criarConta( String nome, String cpf) throws ContaInvalidaException;

}
