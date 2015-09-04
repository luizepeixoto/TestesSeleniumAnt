package testes.materia.comentario;

import static org.junit.Assert.*;
import login.LoginComentario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.materia.comentario.FormularioBotaoResponder;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class FormularioBotaoResponderTest {
	
	private static FormularioBotaoResponder materia;
	private static LoginComentario login;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new FormularioBotaoResponder(Navegador.CHROME);
		materia.esperaCaixaDeComentarioCarregar();
		materia.executarScroll(materia.getDriver().findElement(By.className("comentarios")).getLocation());
		login = new LoginComentario(materia.getDriver());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeAposEfetuarOLoginACaixaDeComentarioEstaSendoExibida() throws Exception{
		materia.clicarNoBotaoDeComentario();
		login.efetuarLoginCadum();
		materia.esperaCarregar(3);
		assertTrue(materia.exibiuCaixaDeComentario());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeEstaSendoExibidoOBotaoDeResponder() throws Exception{
		assertTrue(materia.exibiuOBotaoDeResponder());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeEstaOTituloResponderEstaSendoExibido() throws Exception{
		String tituloEsperado = "RESPONDER";
		materia.esperaCarregar(3);
		assertEquals(tituloEsperado, materia.exibiuOTituloDeResponder());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAposClicarNoLinkDeResponderUmComentarioUmaNovaCaixaDeComentarioEstaSendoExibida() throws Exception{
		materia.esperaCarregar(3);
		materia.clicarNoBotaoDeResponder();
		materia.esperaCarregar(2);
		assertTrue(materia.exibiuUmaNovaCaixaDeComentario());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeONomeDoUsuarioEstaSendoExibidoNaCaixaDeComentario() {
		materia.executarScroll(materia.listaComTodosOsComentarios().get(0).findElement(By.className("form")).getLocation());
		assertTrue(materia.exibiuONomeDoUsuario());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeOTituloDeCaracteresRestantesEstaoSendoExibidos() {
		assertTrue(materia.exibiuOTituloDeCaracteresRestantes());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeAQuantidadeDeCaracteresRestantesEstaSendoExibido() {
		assertTrue(materia.exibiuOTotalDeCaracteresParaOComentario());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOTextAreaParaInserirOComentarioEstaSendoExibido() {
		assertTrue(materia.exibiuAreaDeComentario());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeOTextoParaPreencherOCaptchaEstaSendoExibido() {
		String tituloEsperado = "Digite as letras ao lado: ";
		assertEquals(tituloEsperado, materia.exibiuCaptchaTexto());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeOTextboxParaPreencherOCaptchaEstaSendoExibido() {
		assertTrue(materia.exibiuAreaDoCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeAImagemDoCaptchaEstaSendoExibida(){
		assertTrue(materia.exibiuImagemDoCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOTextoTrocarImagemEstaSendoExibido(){
		String tituloEsperado = "Trocar imagem";
		assertEquals(tituloEsperado, materia.exibiuTextoDeTrocarImagemDoCaptcha());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOBotaoDePostarEstaSendoExibido(){
		assertTrue(materia.exibiuBotaoEnviar());
	}
}