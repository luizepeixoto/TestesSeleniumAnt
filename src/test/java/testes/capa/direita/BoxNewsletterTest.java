package testes.capa.direita;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxNewsletter;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxNewsletterTest {
	
	private static BoxNewsletter boxNewsletter;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(boxNewsletter.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		boxNewsletter = new BoxNewsletter(Navegador.CHROME);
		boxNewsletter.esperaCarregar(1);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste(){
		boxNewsletter.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeOBoxDeNewsletterEstaSendoExibido() {
		assertTrue(boxNewsletter.exibiuOBoxDeNewsletter());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOTituloDoBoxDeNewsletterEstaSendoExibido() {
		assertTrue(boxNewsletter.exibiuOTituloDoBoxDeNewsletter());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAFraseInformativaDoBoxDeNewsletterEstaSendoExibida() {
		assertTrue(boxNewsletter.exibiuAFraseInformativaDoBoxDeNewsletter());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeOIntputDoBoxDeNewsletterEstaSendoExibido() {
		assertTrue(boxNewsletter.exibiuOInputDoBoxDeNewsletter());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeOPlaceHolderDoIntputDoBoxDeNewsletterEstaSendoExibido() {
		assertTrue(boxNewsletter.exibiuOPlaceHolderDoIntputDoBoxDeNewsletter());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeOBotaoReceberDoBoxDeNewsletterEstaSendoExibido() {
		assertTrue(boxNewsletter.exibiuOBotaoReceberDoBoxDeNewsletter());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeAoClicarNoBotaoReceberSemPreencherOInputUmaMensagemDeErroEhExibida() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuMensagemDeErroAoNaoInformarUmEmail());
	}
	
	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeAoPreencherOInputComEmailInvalidoEClicarNoBotaoReceberUmaMensagemDeErroEhExibida() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuMensagemDeErroAoInformarEmailInvalido());
	}
	
	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificaSeAoPreencherOInputComEmailValidoEClicarNoBotaoReceberUmIconeDeLoadingEhExibido() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuUmIconeDeLoadingNoBotaoReceber());
	}
	
	@OrdemExecucaoTeste(Ordem = 10)
	@Test
	public void verificaSeAoPreencherOInputComEmailJaAtivadoEClicarNoBotaoReceberUmaMensagemDeErroEhExibida() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuMensagemDeErroAoInformarEmailAtivado());
	}
	
	@OrdemExecucaoTeste(Ordem = 11)
	@Test
	public void verificaSeAoPreencherOInputComEmailValidoEClicarNoBotaoReceberUmaMensagemDeSucessoEhExibida() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuMensagemDeSucessoAoInformarEmailValido());
	}
	
	@OrdemExecucaoTeste(Ordem = 12)
	@Test
	public void verificaSeAoPreencherOInputComEmailValidoEClicarNoBotaoReceberUmaSetaVerdeEstaSendoExibida() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuUmaSetaVerdeAoInformarEmailValido());
	}
	
	@OrdemExecucaoTeste(Ordem = 13)
	@Test
	public void verificaSeAoPreencherOInputComEmailValidoEClicarNoBotaoReceberUmTextoMaiorEstaSendoExibido() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuUmTextoMaiorAoInformarEmailValido());
	}
	
	@OrdemExecucaoTeste(Ordem = 14)
	@Test
	public void verificaSeAoPreencherOInputComEmailValidoEClicarNoBotaoReceberDemaisTextosEstaoSendoExibidos() throws InterruptedException {
		assertTrue(boxNewsletter.exibiuDemaisTextosAoInformarEmailValido());
	}
}