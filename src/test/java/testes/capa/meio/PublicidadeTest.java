package testes.capa.meio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioPublicidade;


public class PublicidadeTest {
	
	private static CapaMeioPublicidade colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioPublicidade();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeOBoxDePublicidadeEstaSendoExibidoNaColunaDoMeio(){
		assertTrue(colunaDoMeio.exibiuBoxDePublicidade());
	}
	
	@Test
	public void verificaSeOBoxDePublicidadeEstaSendoExibidoUmaInformacaoValida(){
		assertTrue(colunaDoMeio.oBoxDePublicidadeEstaExibidoUmaPublicidade());
	}
	
	@Test
	public void verificaSeOBoxDePublicidadeEstaExibidoOTituloPublicidade(){
		assertTrue(colunaDoMeio.exibiuOTituloPublicidade());
	}
	
	@Test
	public void verificaSeOTituloPropagandaAcimaDoSuperLeaderboardPossuiUmLink(){
		assertTrue(colunaDoMeio.exibiuOTituloPublicidadePossuiUmLink());
	}
	
	@Test
	public void verificaSeOTituloPropagandaAcimaDoSuperLeaderboardPossuiUmLinkValido(){
		assertTrue(colunaDoMeio.exibiuOTituloPublicidadePossuiUmLinkValido());
	}
	
	@Test
	public void verificaSeOLinkDoTituloPropagandaAcimaDoSuperLeaderboardEstaAbrindoNumaNovaJanela(){
		assertTrue(colunaDoMeio.exibiuOLinkNoTituloPublicidadeComTargetBlank());
	}
}