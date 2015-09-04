package testes.ela.editoria;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.ela.editoria.DestaquesElaBlog;

import br.com.infoglobo.pages.Navegador;

public class DestaqueElaComBlogTest {
	
	private static DestaquesElaBlog ultimas;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ultimas = new DestaquesElaBlog(Navegador.CHROME);
		ultimas.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		ultimas.executaScrollParaAparecerOTituloDeUmaPosicao(ultimas.exibiuChamadaDeBlog());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ultimas.fechar();
	}
	
	@Test
	public void exibiuChamadaDeBlogEmAlgumDestaqueDaLista(){
		assertNotNull(ultimas.exibiuChamadaDeBlog());
	}
	
	@Test
	public void exibiuImagemDoBlogNoDestaqueDaLista(){
		assertTrue(ultimas.exibiuImagemDoBlog());
	}
	
	@Test
	public void exibiuImagemDoBlogNoDestaqueDaListaComWidthCorreto(){
		assertTrue(ultimas.getImagemDoBlogWidth());
	}

	@Test
	public void exibiuImagemDoBlogNoDestaqueDaListaComHeightCorreto(){
		assertTrue(ultimas.getImagemDoBlogHeight());
	}
	
	@Test
	public void exibiuNomeDoBlogNoDestaqueDaLista(){
		assertTrue(ultimas.exibiuNomeDoBlog());
	}
	
	@Test
	public void exibiuLinkNoNomeDoBlog(){
		assertNotNull(ultimas.exibiuLinkNoNomeDoBlog());
	}
	
	@Test
	public void exibiuUmLinkValidoNoNomeDoBlog(){
		assertTrue(ultimas.exibiuLinkValidoNoNomeDoBlog());
	}
	
	@Test
	public void exibiuAutorDoBlogNoDestaqueDaLista(){
		assertTrue(ultimas.exibiuAutorDoBlog());
	}
	
	@Test
	public void exibiuLinkNoAutorDoBlog(){
		assertNotNull(ultimas.exibiuLinkNoAutorDoBlog());
	}
	
	@Test
	public void exibiuTituloDoPostDoBlog(){
		assertTrue(ultimas.exibiuTituloDoPostDoBlog());
	}
	
	@Test
	public void verificaSeOTituloDoPostDoBlogEstaSendoExibidoComNoMaximo53Caracteres(){
		assertTrue(ultimas.exibiuTituloDoPostComNoMaximo53Caracteres());
	}
	
	@Test
	public void exibiuLinkNoTituloDoPostDoBlog(){
		assertTrue(ultimas.exibiuLinkNoTituloDoPost());
	}
	
	@Test
	public void exibiuDescricaoDoPostDoBlog(){
		assertTrue(ultimas.exibiuDescricaoDoPostDoBlog());
	}
	
	@Test
	public void verificaSeADescricaoDoPostDoBlogEstaSendoExibidoComNoMaximo120Caracteres(){
		assertTrue(ultimas.exibiuDescricaoDoPostDoBlogComNoMaximo120Caracteres());
	}
}