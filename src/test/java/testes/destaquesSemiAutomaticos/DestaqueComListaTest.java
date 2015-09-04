package testes.destaquesSemiAutomaticos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.destaques.DestaquesLista;


public class DestaqueComListaTest {
	
	private static DestaquesLista ultimas;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimas = new DestaquesLista();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimas.fechar();
	}
	
	@Test
	public void exibiuChamadaDeListas(){
		assertNotNull(ultimas.acessaChamadaDeLista());
	}
	
	@Test
	public void exibiuOTituloDeListas(){
		assertTrue(ultimas.exibiuTituloDeListas());
	}
	
	@Test
	public void exibiuONumeroDaLista(){
		assertTrue(ultimas.exibiuONumeroDaLista());
	}
	
	@Test
	public void exibiuOTituloDaLista(){
		assertTrue(ultimas.exibiuOTituloDaLista());
	}
	
	@Test
	public void exibiuOTituloDaListaComNoMaximo57Caracteres(){
		assertTrue(ultimas.exibiuOTituloComNoMaximo57Caracteres());
	}
	
	@Test
	public void exibiuLinkNoNumeroENoTituloLista(){
		assertTrue("Não exibiu o link para o número da Lista", ultimas.exibiuLinkNaLista());
		assertTrue("Não exibiu o link para o título", ultimas.exibiuLinkNoTitulo());
	}
	
	@Test
	public void exibiuLinkValido(){
		assertTrue(ultimas.exibiuLinkValido());
	}
	
	@Test
	public void exibiuDescricaoDaLista(){
		assertTrue(ultimas.exibiuADescricaoDaLista());
	}
	
	@Test
	public void exibiuADesricaoDaListaComNoMaximo83Caracteres(){
		assertTrue(ultimas.exibiuADescricaoComNoMaximo83Caracteres());
	}
}