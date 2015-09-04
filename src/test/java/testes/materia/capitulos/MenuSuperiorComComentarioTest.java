package testes.materia.capitulos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.capitulo.MenuSuperiorComComentario;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MenuSuperiorComComentarioTest {
	
	private static MenuSuperiorComComentario materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuSuperiorComComentario(Navegador.CHROME);
		materia.esperaCarregar(5);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Materia com 12 capitulos
	Todos os capitulos obrigatoriamente com foto
	Todas as matérias com autor
	Menu obrigatoriamente no topo*/ 
	
	/*Inicio da materia principal*/
	
	@Test
	public void verificaSeOBalaoDeComentarioEstaSendoExibidoNoMenu(){
		assertTrue(materia.exibiuBalaoDeComentarios());
	}
	
	@Test
	public void verificaSeOTituloDeComentariosEstaSendoExibidoNoMenu(){
		assertTrue(materia.exibiuTituloComentarios());
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
}