package testes.enquete;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.enquete.EnqueteEnriquecidaPaginaGeral;

import br.com.infoglobo.pages.Navegador;

public class EnqueteEnriquecidaListagemGeralTest {
	
	private static EnqueteEnriquecidaPaginaGeral enqueteSimples;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enqueteSimples = new EnqueteEnriquecidaPaginaGeral(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		enqueteSimples.fechar();
	}
	
	/*	Enquete de bloco de carnaval dever ser configurada com:
			Opção de busca habilitada
			Lista de opções para a enquete apresentada
	 */	
	
	@Test
	public void verificaSeOBannerSuperLeaderboardEstaSendoExibido(){
		assertNotNull(enqueteSimples.exibiuSuperLeaderboard());
	}
	
	@Test
	public void verificaSeAOpcaoDeBuscaDasEnquetesEstaSendoExibida(){
		assertTrue(enqueteSimples.exibiuBusca());
	}
	
	@Test
	public void verificaSeOTituloDaEnqueteEstaSendoExibido(){
		assertTrue(enqueteSimples.exibiuTituloDaEnquete());
	}
	
	@Test
	public void verificaSeOSubtituloDaEnqueteEstaSendoExibido(){
		assertTrue(enqueteSimples.exibiuSubtituloDaEnquete());
	}
	
	@Test
	public void verificaSeOBannerArrobaEstaSendoExibido(){
		assertNotNull(enqueteSimples.exibiuBannerArroba());
	}
	
	@Test
	public void verificaSeAEnqueteEstaExibidoUmaListaDeOpcoes(){
		assertTrue(enqueteSimples.exibiuListaDeOpcoes());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmTitulo(){
		assertTrue(enqueteSimples.exibiuAsOpcoesDeVotoComUmTitulo());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmSubtitulo(){
		assertTrue(enqueteSimples.exibiuAsOpcoesDeVotoComUmSubtitulo());
	}
	
	@Test
	public void verificaSeCadaUmaDasOpcoesPossuiUmBotaoDeVotar(){
		assertTrue(enqueteSimples.exibiuOBotaoDeVotarEmCadaUmaDasOpcoes());
	}
	
	@Test
	public void verificaSeOBotaoDeVotarDeCadaUmaDasOpcoesPossuiUmLink(){
		assertTrue(enqueteSimples.exibiuOBotaoDeVotarComUmLink());
	}
	
	@Test
	public void verificaSeCadaUmDosBotoesDeVotarPossuiOTituloCorreto(){
		assertTrue(enqueteSimples.exibiuOTituloVotar());
	}
}