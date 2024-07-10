package br.unicamp.ic.inf335.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

class TestAnunciante {

	private AnuncianteBean anunciante;
	private AnuncioBean anuncio;

	@BeforeEach
	public void buildAnuncioEAnunciante() {
		anuncio = new AnuncioBean();
		ArrayList<AnuncioBean> anuncios = new ArrayList<>();
		anuncios.add(anuncio);
		anunciante = new AnuncianteBean("Matheus Henrique", "000.000.000-00", anuncios);
	}

	@Test
	public void testGetNome() {
		assertEquals("Matheus Henrique", anunciante.getNome());
	}

	@Test
	public void testSetNome() {
		anunciante.setNome("Matheus Silveira");
		assertEquals("Matheus Silveira", anunciante.getNome());
	}

	@Test
	public void testGetCPF() {
		assertEquals("000.000.000-00", anunciante.getCPF());
	}

	@Test
	public void testSetCPF() {
		anunciante.setCPF("123.456.789-00");
		assertEquals("123.456.789-00", anunciante.getCPF());
	}

	@Test
	public void testGetAnuncios() {
		assertEquals(1, anunciante.getAnuncios().size());
		assertEquals(anuncio, anunciante.getAnuncios().get(0));
	}

	@Test
	public void testSetAnuncios() {
		ArrayList<AnuncioBean> novosAnuncios = new ArrayList<>();
		novosAnuncios.add(new AnuncioBean());
		anunciante.setAnuncios(novosAnuncios);
		assertEquals(1, anunciante.getAnuncios().size());
	}

	@Test
	public void testAddAnuncio() {
		AnuncioBean novoAnuncio = new AnuncioBean();
		anunciante.addAnuncio(novoAnuncio);
		assertEquals(2, anunciante.getAnuncios().size());
		assertEquals(novoAnuncio, anunciante.getAnuncios().get(1));
	}

	@Test
	public void testRemoveAnuncio() {
		anunciante.removeAnuncio(0);
		assertEquals(0, anunciante.getAnuncios().size());
	}

	@Test
	public void testValorMedioAnuncios() {
		anunciante.setAnuncios(new ArrayList<AnuncioBean>());
		ProdutoBean produto1 =  new ProdutoBean("999898", "pc gamer", "Roda crysis", 3000.0, "ne lancou ainda");
		AnuncioBean anuncio1 = new AnuncioBean(produto1, new ArrayList<>(), 0.1);

		ProdutoBean produto2 = new ProdutoBean("7456", "Tictac", "Balinha", 20000.0, "lacrado");
		AnuncioBean anuncio2 = new AnuncioBean(produto2, new ArrayList<>(), 0.8);

		anunciante.addAnuncio(anuncio1);
		anunciante.addAnuncio(anuncio2);

		double expectedMedia = (anuncio1.getValor() + anuncio2.getValor()) / 2;
		assertEquals(expectedMedia, anunciante.valorMedioAnuncios());
	}
}
