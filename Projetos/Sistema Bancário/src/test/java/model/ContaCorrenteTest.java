package model;

import static org.junit.jupiter.api.Assertions.*;

import exception.SaldoInsuficienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaCorrenteTest {

    private Cliente cliente;
    private ContaCorrente conta;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Maria", "123.456.789-00");
        conta = new ContaCorrente(500.0, "1001", "0001", cliente);
    }

    @Test
    void depositoDeveAumentarOSaldo() {
        conta.depositar(200.0);

        assertEquals(200.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueComSaldoSuficienteDeveDiminuirOSaldo() {
        conta.depositar(300.0);

        conta.sacar(100.0);

        assertEquals(200.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueAlemDoSaldoMaisLimiteDeveLancarSaldoInsuficienteException() {
        conta.depositar(100.0);

        SaldoInsuficienteException ex = assertThrows(SaldoInsuficienteException.class,
                () -> conta.sacar(601.0));

        assertTrue(ex.getMessage().contains("600.0"));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueDeveUsarOLimiteDeixandoSaldoNegativo() {
        conta.depositar(100.0);

        conta.sacar(400.0);

        assertEquals(-300.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueExatamenteNoLimiteDeveSerPermitido() {
        conta.sacar(500.0);

        assertEquals(-500.0, conta.getSaldo(), 0.001);
    }

    @Test
    void saqueRecusadoNaoDeveGerarTransacaoNoHistorico() {
        conta.depositar(100.0);

        assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(1000.0));

        assertEquals(1, conta.getHistorico().size());
        assertEquals(TipoTransacao.DEPOSITO, conta.getHistorico().get(0).getTipo());
    }

    @Test
    void historicoDeveRegistrarDepositoESaqueNaOrdem() {
        conta.depositar(100.0);
        conta.sacar(30.0);

        var historico = conta.getHistorico();

        assertEquals(2, historico.size());
        assertEquals(TipoTransacao.DEPOSITO, historico.get(0).getTipo());
        assertEquals(100.0, historico.get(0).getValor(), 0.001);
        assertEquals(TipoTransacao.SAQUE, historico.get(1).getTipo());
        assertEquals(30.0, historico.get(1).getValor(), 0.001);
    }

    @Test
    void transferenciaDeCorrenteParaPoupancaDeveMoverOValor() {
        ContaPoupanca poupanca = new ContaPoupanca(0.01, "2001", "0001", cliente);
        conta.depositar(400.0);

        conta.transferir(150.0, poupanca);

        assertEquals(250.0, conta.getSaldo(), 0.001);
        assertEquals(150.0, poupanca.getSaldo(), 0.001);
    }

    @Test
    void transferenciaSemSaldoNemLimiteNaoDeveAlterarNenhumaConta() {
        ContaPoupanca poupanca = new ContaPoupanca(0.01, "2001", "0001", cliente);
        conta.depositar(100.0);

        assertThrows(SaldoInsuficienteException.class, () -> conta.transferir(700.0, poupanca));

        assertEquals(100.0, conta.getSaldo(), 0.001);
        assertEquals(0.0, poupanca.getSaldo(), 0.001);
        assertTrue(poupanca.getHistorico().isEmpty());
    }
}
