package testes.capa.direita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import login.LoginComentario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.capa.direita.BoxDeEnqueteAberta;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeEnqueteAbertaTest {
	
	private static BoxDeEnqueteAberta colunaDaDireita;
	private static LoginComentario login;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxDeEnqueteAberta(Navegador.CHROME);
		login = new LoginComentario(colunaDaDireita.getDriver());
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void clicouNaPrimeiraOpcao() throws InterruptedException{
		colunaDaDireita.clicouNaPrimeiraOpcao();
		login.efetuarLoginCadum();
		colunaDaDireita.esperaCarregar3Segundos();
		colunaDaDireita.esperaCarregar3Segundos();
		colunaDaDireita.clicouNaPrimeiraOpcao();	
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuAEnquete() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuAEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuTituloEnquete(){
		String tituloEsperado = "Enquete";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuTituloEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuPerguntaDaEnquete(){
		assertTrue(colunaDaDireita.exibiuPerguntaDaEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuOpcoesDaEnquete(){
		assertTrue(colunaDaDireita.exibiuOpcoesDaEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuLinkVerResultado(){
		String tituloEsperado = "Ver resultado";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuLinkVerResultado());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuTextoDigiteOCaptcha() throws InterruptedException{
		String tituloEsperado = "Digite o captcha";
		colunaDaDireita.clicouNaPrimeiraOpcao();
		colunaDaDireita.esperaCarregar2Segundos();
		assertEquals(tituloEsperado, colunaDaDireita.exibiuTextoDigiteOCaptcha());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuImagemCaptcha() throws InterruptedException{
		colunaDaDireita.esperaCarregar2Segundos();
		assertTrue(colunaDaDireita.exibiuImagemCaptcha());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuCampoParaDigitarOCodigoCaptcha() throws InterruptedException{
		colunaDaDireita.esperaCarregar2Segundos();
		assertTrue(colunaDaDireita.exibiuCampoParaDigitarOCodigoCaptcha());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void exibiuBotaoTrocarCaptcha() throws InterruptedException{
		colunaDaDireita.esperaCarregar2Segundos();
		assertTrue(colunaDaDireita.exibiuBotaoTrocarCaptcha());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void exibiuBotaoVotar() throws InterruptedException{
		colunaDaDireita.esperaCarregar2Segundos();
		assertTrue(colunaDaDireita.exibiuBotaoVotar());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 12)
	public void verificaSeAoClicarNaImagemDaEnquetaElaSeraAmpliada() throws InterruptedException{
		WebElement primeiraPosicao = colunaDaDireita.getDriver().findElement(By.className("titulo-enquete"));
		colunaDaDireita.executarScroll(primeiraPosicao.getLocation());
		colunaDaDireita.clicarParaAmpliouAImagemDaEnquete();
		colunaDaDireita.esperaCarregar2Segundos();
		assertTrue(colunaDaDireita.ampliouImagemDaEnquete());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 13)
	public void verificaSeAoClicarNoBotaoDeFecharAImagemDeixaDeSerAmpliada() throws InterruptedException{
		colunaDaDireita.clicarParaFechouAmpliacaoDaImagemDaEnquete();
		colunaDaDireita.esperaCarregar2Segundos();
		assertTrue(colunaDaDireita.fechouAmpliacaoDaImagemDaEnquete());
	}
}