package testes.listas;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.lista.ListaSemFoto;
import static org.junit.Assert.*;

public class ListaSemFotoTest {
	
	private static ListaSemFoto lista;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		lista = new ListaSemFoto();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		lista.fechar();
	}
	
	@Test
	public void exibiuTituloDaLista() {
		assertTrue(lista.exibiuTitulo());
	}
	
	@Test
	public void exibiuUmaListaDeMaterias() {
		assertTrue(lista.exibiuListaDeMaterias());
	}
	
	@Test
	public void exibiuTituloDaMateria() {
		assertTrue(lista.exibiuTituloDaMateria());
	}
	
	@Test
	public void exibiuDescricaoDaMateria() {
		assertTrue(lista.exibiuDescricaoDaMateria());
	}
	
	@Test
	public void exibiuDescricaoCom1300Caracteres() {
		assertTrue(lista.exibiuDescricaoSemFotoCom1300Caracteres());
	}
	
	@Test
	public void exibiuTotalDeFatosNoFimDaPagina() {
		assertTrue(lista.exibiuTotalDeFatos());
	}
	
	@Test
	public void verificaSeNaoEstaSendoExibidoImagemParaCadaUmDosFatos() {
		assertTrue(lista.exibiuImagem());
	}
}
