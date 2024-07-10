package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.ProdutoBean;

class TestProduto {

	private ProdutoBean produto;

    @BeforeEach
    public void buildProduto() {
        produto = new ProdutoBean("5550123", "Graviola", "Fruta", 5.0, "Nao comida");
    }

    @Test
    public void testGetCodigo() {
        assertEquals("5550123", produto.getCodigo());
    }

    @Test
    public void testSetCodigo() {
        produto.setCodigo("123-322");
        assertEquals("123-322", produto.getCodigo());
    }

    @Test
    public void testGetNome() {
        assertEquals("Graviola", produto.getNome());
    }

    @Test
    public void testSetNome() {
        produto.setNome("Abobrinha");
        assertEquals("Abobrinha", produto.getNome());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Fruta", produto.getDescricao());
    }

    @Test
    public void testSetDescricao() {
        produto.setDescricao("Cucurbitaceae");
        assertEquals("Cucurbitaceae", produto.getDescricao());
    }

    @Test
    public void testGetValor() {
        assertEquals(5.0, produto.getValor());
    }

    @Test
    public void testSetValor() {
        produto.setValor(6.0);
        assertEquals(6.0, produto.getValor());
    }

    @Test
    public void testGetEstado() {
        assertEquals("Nao comida", produto.getEstado());
    }

    @Test
    public void testSetEstado() {
        produto.setEstado("Comida pela metade");
        assertEquals("Comida pela metade", produto.getEstado());
    }

    @Test
    public void testCompareTo() {
        ProdutoBean verdura = new ProdutoBean("123-322", "Graviola", "Cucurbitaceae", 6.0, "Comida pela metade");
        assertTrue(produto.compareTo(verdura) < 0);

        verdura.setValor(5.0);
        assertTrue(produto.compareTo(verdura) == 0);

        verdura.setValor(4.0);
        assertTrue(produto.compareTo(verdura) > 0);
    }
}
