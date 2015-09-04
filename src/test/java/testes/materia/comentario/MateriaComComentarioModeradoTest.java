package testes.materia.comentario;

import static org.junit.Assert.*;
import login.LoginComentario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.materia.comentario.MateriaComComentarioModerado;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class MateriaComComentarioModeradoTest {
	
	private static MateriaComComentarioModerado materia;
	private static LoginComentario login;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComComentarioModerado(Navegador.CHROME);
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
		String mensagemDeComentarioModerado = "Os comentários para esta matéria são moderados. Envie o seu e aguarde a aprovação.";
		materia.esperaCarregar(5);
		assertEquals(mensagemDeComentarioModerado, materia.exibiuDeComentarioModerado());
	}
}