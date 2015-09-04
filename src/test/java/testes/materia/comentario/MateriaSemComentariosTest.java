package testes.materia.comentario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.materia.comentario.MateriaSemComentarios;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MateriaSemComentariosTest {
	
	private static MateriaSemComentarios materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaSemComentarios(Navegador.CHROME);
		materia.esperaCaixaDeComentarioCarregar();
		materia.executarScroll(materia.getDriver().findElement(By.className("comentarios")).getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeComentarEstaSendoExibidoNoMenu(){
		assertNotNull(materia.exibiuComentarNoMenu());
	}
	
	@Test
	public void verificaSeTituloComentarEstaSendoExibidoNoMenu(){
		String resultadoEsperado="Comentar";
		assertEquals(resultadoEsperado.toLowerCase(), materia.getComentarioMenuTexto());
	}
	
	@Test
	public void verificaSeAChamadaDoComentarioNoMenuEstaExibindoUmLink(){
		assertTrue(materia.exibiuLinkNoComentarDoMenu());
	}
	
	@Test
	public void verificaSeOTituloComOAlertaParaLogarEstaSendoExibido() throws InterruptedException {
		String resultadoEsperado = "Para comentar esta notícia é necessário entrar com seu login.";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuTituloParaComentar());
	}

	@Test
	public void verificaSeOBotaoDeComentarEstaSendoExibido() {
		assertNotNull(materia.exibiuBotaoDeComentar());
	}

	@Test
	public void verificaSeOTituloComOAlertaParaLogarEstaExibindoOLinkParaLogar() {
		String resultadoEsperado = "Comentar";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuTituloComentarDentroDoBotao());
	}

	@Test
	public void verificaSeOTextoDeResponsabilidadeDoAutorEstaSendoExibido() throws InterruptedException {
		assertTrue(materia.exibiuTextoDeResponsabilidadeDoAutor());
	}

	@Test
	public void verificaSeOTituloDePerguntasMaisFrequentesEstaSendoExibido() throws InterruptedException {
		String resultadoEsperado = "Perguntas mais frequentes";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuTituloPerguntasFrequentes());
	}

	@Test
	public void verificaSeOTituloDePerguntasMaisFrequentesPossuiUmLink() throws InterruptedException {
		assertTrue(materia.exibiuLinkNoTituloPerguntasFrequentes());
	}

	@Test
	public void verificaSeOTituloDeTermosDeUsoEstaSendoExibido() throws InterruptedException {
		String resultadoEsperado = "Termos de uso";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuTituloTermosDeUso());
	}

	@Test
	public void verificaSeOTituloDeTermosDeUsoPossuiUmLink() throws InterruptedException {
		assertTrue(materia.exibiuLinkNoTituloTermosDeUso());
	}
	
	@Test
	public void verificaSeExibeMensagemSejaPrimeiroAhComentar(){
		String resultadoEsperado = "Seja o primeiro a comentar";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuMensagemSejaOPrimeiroAComentar());
	}
}