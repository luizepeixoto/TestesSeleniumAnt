package testes.erros;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.erros.Pagina404VaiRio;

import br.com.infoglobo.pages.Navegador;

public class Pagina404VaiRioTest {
	
	private static Pagina404VaiRio editoriaDesativada;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoriaDesativada = new Pagina404VaiRio(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		editoriaDesativada.fechar();
	}
	
	@Test
	public void exibiuPaginaNaoEncontrada(){
		assertNotNull(editoriaDesativada.exibiuClasseErroContainer());
	}
	
	@Test
	public void exibiuOTituloPaginaNaoEncontrada(){
		String tituloEsperado="Página não encontrada";
		assertEquals(tituloEsperado, editoriaDesativada.exibiuOTituloNaPagina());
	}
	
	@Test
	public void exibiuDescricaoDaPaginaNaoEncontrada(){
		String tituloEsperado="Desculpe-nos, não foi possível localizar a página solicitada. Mas queremos ajudá-lo a encontrar o que você está procurando. Por favor, faça uma busca pelo assunto desejado ou volte para a página inicial.";
		assertEquals(tituloEsperado, editoriaDesativada.exibiuDescricaoNaPagina());
	}
	
	@Test
	public void exibiuLinkDePaginaInicial(){
		String linkEsperado="página inicial";
		assertEquals(linkEsperado, editoriaDesativada.exibiuLinkDePaginaInicial());
	}
	
	@Test
	public void exibiuUmLinkValidoNaPaginaInicial(){
		assertTrue(editoriaDesativada.exibiuLinkValidoEmPaginaInicial());
	}
	
	@Test
	public void exibiuTituloDeBusca(){
		String tituloDeBuscaEsperado="Faça uma busca em seu conteúdo:";
		assertEquals(tituloDeBuscaEsperado, editoriaDesativada.exibiuTituloDeBusca());
	}
	
	@Test
	public void exibiuCampoDeBusca(){
		assertNotNull(editoriaDesativada.exibiuBusca());
	}
	
	@Test
	public void exibiuBotaoDeBusca(){
		assertTrue(editoriaDesativada.exibiuBotaoDeBusca());
	}
}