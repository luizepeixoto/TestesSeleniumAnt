package testes.barreira;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.barreira.Paywall;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class BarreiraLoginPaywallTest {
	
	private static Paywall paywall;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		paywall = new Paywall(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		paywall.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOTituloExclusivoParaAssinanesEstaSendoExibido() throws InterruptedException{
		String tituloEsperado="EXCLUSIVO PARA ASSINANTES";
		paywall.executarScroll(paywall.acessaClasseVantagens().getLocation());
		assertEquals(tituloEsperado, paywall.exibiuOTituloDeExclusivoParaAssinantes());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeAsVantagensOGloboEstaSendoExibidoCorretamente() throws InterruptedException{
		assertTrue(paywall.exibiuVantagensOGloboParaAssinantes());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAsVantagensDaEdicaoDigitalEstaoSendoExibidosCorretamente() throws InterruptedException{
		assertTrue(paywall.exibiuVantagensDigitaisParaAssinantes());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAsVantagensDoAcervoEstaoSendoExibidosCorretamente() throws InterruptedException{
		assertTrue(paywall.exibiuVantagensAcervoParaAssinantes());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAsVantagensDoEbooksEstaoSendoExibidosCorretamente() throws InterruptedException{
		assertTrue(paywall.exibiuVantagensDoEbooksParaAssinantes());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void exibiuOTextoFAQRegisterWall() throws InterruptedException{
		String resultadoEsperado="faq paywall";
		paywall.executarScroll(paywall.acessaClassePaywall().getLocation());
		assertEquals(resultadoEsperado, paywall.exibiuOTextoFAQRegisterWall());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void exibiuPerguntaComRespostasNoFAQ() throws InterruptedException{
		assertTrue(paywall.exibiuOPerguntasComRespostas());
	}

	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void exibiuPaginaInicialAoClicarEmVoltar() throws InterruptedException{
		assertTrue(paywall.exibiuPaginaInicial());
	}
}