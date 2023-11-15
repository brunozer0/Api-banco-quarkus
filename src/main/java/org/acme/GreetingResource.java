package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import GlobalExceptionHandler.ContaInvalidaException;
import GlobalExceptionHandler.SaldoInsuficienteException;
import models.ContaCorrente;
import services.ContaCorrenteService;
import services.ContaCorrenteServiceImpl;


@Path("/contacorrente")
public class GreetingResource {
    List<ContaCorrente> listadeContas = new ArrayList<>();
    ContaCorrenteService contaCorrenteService= new ContaCorrenteServiceImpl(listadeContas);
    @POST
    @Path("/criarconta")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String criarConta(@FormParam("nome") String nome, @FormParam("cpf") String cpf ) {
        try {
            ContaCorrente contaCorrente = contaCorrenteService.criarConta(nome, cpf);
            return "Conta Criada! " + contaCorrente.toString();
        } catch (ContaInvalidaException e) {
            return e.getMessage();
        }
    }

    @POST
    @Path("/depositar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String depositar(@FormParam("numeroConta") String numeroConta, @FormParam("valor") double valor) {
        try {
            contaCorrenteService.depositar(numeroConta,valor);
            return "O valor: " + valor + " foi depositado na conta " + numeroConta;
        }catch (ContaInvalidaException e) {
           return e.getMessage();
        }
    }
    @PATCH
    @Path("/sacar")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String sacar(@FormParam("numeroConta") String numeroConta, @FormParam("valor") double valor) {
        try {
            contaCorrenteService.sacar(numeroConta,valor);
            return "O valor: " + valor + " foi sacado da conta " + numeroConta;
        }catch (SaldoInsuficienteException | ContaInvalidaException e) {
            return e.getMessage();
        }
    }
    @PATCH
    @Path("/transferir")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String transferir(
            @FormParam("contaOrigem") String contaOrigem,
            @FormParam("contaDestino")String contaDestino,
            @FormParam("valor") double valor) {
        try {
            contaCorrenteService.transferir(contaOrigem, contaDestino, valor);
           return "Transferência realizada"+ "\n"+ "Conta Origem: " +contaOrigem + "\n" +"Conta destino: " + contaDestino + "\n"+ "valor da transferência: " + valor;
        }catch (ContaInvalidaException | SaldoInsuficienteException e) {
            return e.getMessage();
        }
    }

    @GET
    @Path("/listarcontas")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)

    public String listarContas(){
        return listadeContas.toString();
    }
}
