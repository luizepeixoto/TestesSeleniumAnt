package testes.materia.comentario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.materia.comentario.MateriaComUmComentario;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MateriaComUmComentarioTest {
	
	private static MateriaComUmComentario materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComUmComentario(Navegador.CHROME);
		materia.esperaCaixaDeComentarioCarregar();
		materia.executarScroll(materia.getDriver().findElement(By.className("comentarios")).getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOTotalDeComentarioApresentadoNoTituloEhIgualAUm(){
		String resultadoEsperado = "1 comentário";
		assertEquals(resultadoEsperado.toLowerCase(), materia.getTituloDeComentariosIgualUm());
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
	public void verificaSeAListaDeComentariosEhIgualAUm(){
		assertTrue(materia.getTotalDeComentarios());
	}
	
	@Test
	public void verificaSeOBotaoDeCarregarMaisComentariosNaoEstaSendoExibido(){
		assertTrue(materia.exibiuBoxDeCarregarMaisComentarios());
	}
}