package model;

import static org.junit.jupiter.api.Assertions.*;

import exception.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaPoupancaTest {

    private Cliente cliente;
    private ContaPoupanca conta;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("João", "987.654.321-00");
        conta = new ContaPoupanca(0.05, "2002", "0001", cliente);
    }

    @Test
    void depositoDeveAumentarOSaldo() {
        conta.depositar(250.0);

        assertEquals(250.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueComSaldoSuficienteDeveDiminuirOSaldo() {
        conta.depositar(500.0);

        conta.sacar(200.0);

        assertEquals(300.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueAlemDoSaldoDeveLancarSaldoInsuficienteException() {
        conta.depositar(100.0);

        SaldoInsuficienteException ex = assertThrows(SaldoInsuficienteException.class,
                () -> conta.sacar(100.01));

        assertTrue(ex.getMessage().contains("100.0"));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void poupancaNaoDevePermitirSaldoNegativo() {
        assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(1.0));

        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void aplicarRendimentoDeveSomarSaldoVezesTaxaAoSaldo() {
        conta.depositar(1000.0);

        conta.aplicarRendimento();

        assertEquals(1050.0, conta.getSaldo(), 0.001);
    }

    @Test
    void aplicarRendimentoEmContaVaziaNaoDeveAlterarOSaldo() {
        conta.aplicarRendimento();

        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueRecusadoNaoDeveGerarTransacaoNoHistorico() {
        conta.depositar(50.0);

        assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(80.0));

        assertEquals(1, conta.getHistorico().size());
        assertEquals(TipoTransacao.DEPOSITO, conta.getHistorico().get(0).getTipo());
    }

    @Test
    void transferenciaDePoupancaParaCorrenteDeveMoverOValor() {
        ContaCorrente corrente = new ContaCorrente(300.0, "1002", "0001", cliente);
        conta.depositar(600.0);

        conta.transferir(250.0, corrente);

        assertEquals(350.0, conta.getSaldo(), 0.001);
        assertEquals(250.0, corrente.getSaldo(), 0.001);
    }

    @Test
    void transferenciaAlemDoSaldoDaPoupancaNaoDeveAlterarNenhumaConta() {
        ContaCorrente corrente = new ContaCorrente(300.0, "1002", "0001", cliente);
        conta.depositar(100.0);

        assertThrows(SaldoInsuficienteException.class, () -> conta.transferir(200.0, corrente));

        assertEquals(100.0, conta.getSaldo(), 0.001);
        assertEquals(0.0, corrente.getSaldo(), 0.001);
        assertTrue(corrente.getHistorico().isEmpty());
    }
}
