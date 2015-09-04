package testes.materia.comentario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.materia.comentario.MateriaComBotaoMaisComentarios;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class MateriaComBotaoMaisComentariosTest {
	
	private static MateriaComBotaoMaisComentarios materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComBotaoMaisComentarios(Navegador.CHROME);
		materia.esperaCaixaDeComentarioCarregar();
		materia.executarScroll(materia.getDriver().findElement(By.className("comentarios")).getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOs5PrimeirosComentariosDaMateriaEstaoSendoExibidos(){
		assertTrue(materia.exibiu5PrimeirosComentarios());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOBoxDoBotaoDeMaisComentariosEstaSendoExibido(){
		assertNotNull(materia.exibiuBotaoDeMaisComentario());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOBotaoDeMaisComentariosEstaSendoExibido(){
		String resultadoEsperado = "CARREGAR MAIS COMENTÁRIOS";
		assertEquals(resultadoEsperado.toLowerCase(), materia.getTextoBotaoMaisComentarios());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeONovoTotalDeComentariosAposClicarNoBotaoMaisComentariosEhIgualA10() throws InterruptedException{
		assertTrue(materia.getBoxListaComentario10());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeONovoTotalDeComentariosAposOSegundoClickNoBotaoMaisComentariosEhIgualA15() throws InterruptedException{
		assertTrue(materia.getBoxListaComentario15());
	}
	
	@Ignore
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAposFinalizarAExibicaoDosComentariosOBotaoNaoEstaSendoExibido() throws InterruptedException{
		assertTrue(materia.getBotaoMaisComentarios());
	}
}