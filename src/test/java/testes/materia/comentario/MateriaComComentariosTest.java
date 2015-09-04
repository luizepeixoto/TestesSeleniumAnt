package testes.materia.comentario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.comentario.MateriaComComentarios;


public class MateriaComComentariosTest {
	
	private static MateriaComComentarios materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComComentarios();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOComentarioEstaSendoExibidoNoMenu(){
		assertNotNull(materia.exibiuComentarioNoMenu());
	}
	
	@Test
	public void verificaSeAChamadaDoComentarioNoMenuEstaExibindoOTextoComentar(){
		String resultadoEsperado = "Comentar";
		assertEquals(resultadoEsperado.toLowerCase(), materia.exibiuTextoComentar());
	}
	
	@Test
	public void verificaSeAChamadaDoComentarioNoMenuEstaExibindoUmLink(){
		assertTrue(materia.exibiuComentarioDoMenuComLink());
	}
	
	@Test
	public void verificaSeAChamadaDaURLDoComentarioNoMenuEhValida(){
		assertTrue(materia.exibiuComentarioDoMenuComUmLinkValido());
	}
	
	@Test
	public void verificaSeOBoxDeComentariosEstaSendoExibido(){
		assertNotNull(materia.exibiuBoxDeComentarioNaMateria());
	}
	
	@Test
	public void verificaSeOTotalDeComentarioEstaSendoExibidoAbaixoDoTituloDeLogin(){
		assertTrue(materia.exibiuTotalDeComentarios());
	}
	
	@Test
	public void verificaSeAMateriaEstaExibindoUmaListaDeComentarios(){
		assertTrue( materia.exibiuListaDeComentarios());
	}
	
	@Test
	public void verificaSeOComentarioEstaExibindoOAutor(){
		assertTrue(materia.exibiuAutorParaOsComentarios());
	}
	
	@Test
	public void verificaSeOComentarioEstaExibindoUmBulletAposOAutor(){
		assertTrue(materia.exibiuBulletAoLadoDoAutor());
	}
	
	@Test
	public void verificaSeOComentarioEstaExibindoOTempoDecorrido(){
		assertTrue(materia.exibiuTempoParaOsComentarios());
	}
	
	@Test
	public void verificaSeOComentarioEstaExibindoUmTexto(){
		assertTrue(materia.exibiuUmTextoEmCadaUmDosComentarios());
	}
	
	@Test
	public void verificaSeUmaRespostaDeComentarioEstaExibindoOAutor(){
		assertTrue(materia.exibiuAutorParaCadaUmaDasRespostas());
	}
	
	@Test
	public void verificaSeUmaRespostaDeComentarioEstaExibindoUmBulletAposOAutor(){
		assertTrue(materia.exibiuUmBulletParaCadaAutor());
	}
	
	@Test
	public void verificaSeUmaRespostaDeComentarioEstaExibindoOTempoDePublicacao(){
		assertTrue(materia.exibiuTempoDecorridoParaCadaUmaDasRespostas());
	}
	
	@Test
	public void verificaSeUmaRespostaDeComentarioEstaExibindoOTexto(){
		assertTrue(materia.getComentarioRespostaTexto());
	}
	
	@Test
	public void verificaSeOBotaoDeMaisComentariosEstaSendoExibido(){
		assertTrue(materia.exibiuBotaoDeMaisComentarios());
	}
	
	@Test
	public void verificaSeOBotaoDeMaisComentariosPossuiUmLink(){
		assertTrue(materia.getBotaoMaisComentarioLink());
	}
	
	@Test
	public void verificaSeOBotaoDeMaisComentariosPossuiUmLinkValido(){
		assertTrue(materia.getBotaoMaisComentarioLinkValido());
	}
	
	@Test
	public void verificaSeOTextoCarregarMaisComentariosDoBotaoDeMaisComentariosEstaSendoExibido(){
		String resultadoEsperado = "Carregar mais comentários";
		assertEquals(resultadoEsperado, materia.getBotaoMaisComentarioTexto());
	}
	
	@Test
	public void verificaSeOTextoVerMaisComentariosDoTitleDoBotaoDeMaisComentariosEstaSendoExibidoNoMouseover(){
		String resultadoEsperado = "Ver mais comentários";
		assertEquals(resultadoEsperado, materia.exibiuOTitleCorretoParaOBotaoMaisComentario());
	}
}