package br.unicamp.ic.inf335.beans;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAnuncio {
    private AnuncioBean anuncio;
    private ProdutoBean produto;

    @BeforeEach
    public void buildProdutoEAnuncio() throws MalformedURLException {
        produto = new ProdutoBean("5550123", "uva", "e de comer", 2.0, "Nao comida");
        ArrayList<URL> listUrls = new ArrayList<URL>();
        listUrls.add(new URL("http://www.google.com"));
        anuncio = new AnuncioBean(produto, listUrls, 0.2);
    }

    @Test
    public void testGetProduto() {
        assertEquals(produto, anuncio.getProduto());
    }

    @Test
    public void testSetProduto() {
        ProdutoBean novoProduto = new ProdutoBean("0101010", "madeira", "nao e de comer", 100.0, "Saiu da floresta agora");
        anuncio.setProduto(novoProduto);
        assertEquals(novoProduto, anuncio.getProduto());
    }

    @Test
    public void testGetFotosUrl() throws MalformedURLException {
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("http://www.google.com"));
        assertEquals(fotos, anuncio.getFotosUrl());
    }

    @Test
    public void testSetFotosUrl() throws MalformedURLException {
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://www.extecamp.unicamp.br/sistema.asp"));
        anuncio.setFotosUrl(fotos);
        assertEquals(fotos, anuncio.getFotosUrl());
    }

    @Test
    public void testGetDesconto() {
        assertEquals(0.2, anuncio.getDesconto());
    }

    @Test
    public void testSetDesconto() {
        anuncio.setDesconto(0.1);
        assertEquals(0.1, anuncio.getDesconto());
    }

    @Test
    public void testGetValor() {
        double expectedValue = produto.getValor() - (produto.getValor() * anuncio.getDesconto());
        assertEquals(expectedValue, anuncio.getValor());
    }

    @Test
    public void testConstrutor() throws MalformedURLException {
        ProdutoBean produtoTest =  new ProdutoBean("999898", "pc gamer", "Roda crysis", 3000.0, "ne lancou ainda");
        ArrayList<URL> fotos = new ArrayList<>();
        fotos.add(new URL("https://www.pcgamer.com"));
        Double desconto = 0.37;
        AnuncioBean anuncioTest = new AnuncioBean(produtoTest, fotos, desconto);
        assertEquals(produtoTest, anuncioTest.getProduto());
        assertEquals(fotos, anuncioTest.getFotosUrl());
        assertEquals(desconto, anuncioTest.getDesconto());
    }	
}
