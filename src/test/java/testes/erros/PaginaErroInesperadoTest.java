package testes.erros;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.erros.PaginaErroInesperado;


public class PaginaErroInesperadoTest {
	
	private static PaginaErroInesperado pagina;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		pagina = new PaginaErroInesperado();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		pagina.fechar();
	}
	
	@Test
	public void exibiuOTituloPaginaDeErroInesperado(){
		String tituloEsperado="Erro Inesperado";
		assertEquals(tituloEsperado, pagina.exibiuOTituloNaPagina());
	}
	
	@Test
	public void exibiuDescricaoDaPaginaNaoEncontrada(){
		String tituloEsperado="Desculpe-nos, não foi possível localizar a página solicitada. Mas queremos ajudá-lo a encontrar o que você está procurando. Por favor, faça uma busca pelo assunto desejado ou volte para a página inicial.";
		assertEquals(tituloEsperado, pagina.exibiuDescricaoNaPagina());
	}
	
	@Test
	public void exibiuLinkDePaginaInicial(){
		String linkEsperado="página inicial";
		assertEquals(linkEsperado, pagina.exibiuLinkDePaginaInicial());
	}
	
	@Test
	public void exibiuUmLinkValidoNaPaginaInicial(){
		assertTrue(pagina.exibiuLinkValidoEmPaginaInicial());
	}
	
	@Test
	public void exibiuTituloDeBusca(){
		String tituloDeBuscaEsperado="Faça uma busca em seu conteúdo:";
		assertEquals(tituloDeBuscaEsperado, pagina.exibiuTituloDeBusca());
	}
	
	@Test
	public void exibiuCampoDeBusca(){
		assertNotNull(pagina.exibiuBusca());
	}
	
	@Test
	public void exibiuBotaoDeBusca(){
		assertTrue(pagina.exibiuBotaoDeBusca());
	}
}