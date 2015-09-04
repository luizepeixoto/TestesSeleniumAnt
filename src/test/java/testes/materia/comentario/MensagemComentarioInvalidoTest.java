package testes.materia.comentario;

import static org.junit.Assert.*;
import login.LoginComentario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.materia.comentario.ComentarioInvalido;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class MensagemComentarioInvalidoTest {
	
	private static ComentarioInvalido materia;
	private static LoginComentario login;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new ComentarioInvalido(Navegador.CHROME);
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
	public void verificaSeAMensagemDeComentarioInvalidoEstaSendoExibido() throws InterruptedException {
		String mensagemDeErroEsperada = "Comentário inválido.";
		materia.preencherComentarioComTextoInvalido();
		materia.preencherOCaptcha();
		materia.apertarOEnter();
		materia.esperaCarregar(3);
		assertEquals(mensagemDeErroEsperada, materia.exibiuMensagemDeErro());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificarSeAoClicarDuasVezesMensagemDeValidacaoParaPreencherOTextoEstaSendoExibidaMaisDeUmavez() throws Exception{
		materia.esperaCarregar(2);
		materia.apertarOEnter();
		materia.apertarOEnter();
		assertTrue(materia.exibiuMensagemParaPreencherOTextoApenasUmaVez());
	}
}