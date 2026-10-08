package model;

import static org.junit.jupiter.api.Assertions.*;

import exception.CpfInvalidoException;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void cpfValidoComOnzeDigitosDeveCriarCliente() {
        Cliente cliente = new Cliente("Maria", "12345678900");

        assertEquals("Maria", cliente.getNome());
        assertEquals("12345678900", cliente.getCpf());
    }

    @Test
    void cpfComPontosETracoDeveSerGuardadoSoComNumeros() {
        Cliente cliente = new Cliente("Maria", "123.456.789-00");

        assertEquals("12345678900", cliente.getCpf());
    }

    @Test
    void cpfComMenosDeOnzeDigitosDeveLancarCpfInvalidoException() {
        assertThrows(CpfInvalidoException.class, () -> new Cliente("Maria", "1234567890"));
    }
}
