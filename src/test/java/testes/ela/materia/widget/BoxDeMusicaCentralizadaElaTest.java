package testes.ela.materia.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.MateriaComBoxDeMusicaCentralizadaEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxDeMusicaCentralizadaElaTest {

	private static MateriaComBoxDeMusicaCentralizadaEla materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComBoxDeMusicaCentralizadaEla(Navegador.CHROME);
		materia.esperaCarregar(3);
		materia.scrollAteOBox();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void exibiuBoxDeMusicaCentralizada(){
		assertTrue("Box não está sendo exibido", materia.exibiuBoxDeMusicaCentralizada());
	}
	
	@Test
	public void verificaSeOBoxEstaComAFonteCorreta(){
		assertTrue(materia.exibiuAFonteCorretaNoBoxDeMusica());
	}
	
	@Test
	public void exibiuTituloTopMusicas(){
		assertEquals("TOP MÚSICAS", materia.exibiutituloTopMusicas());
	}
	
	@Test
	public void verificaSeOTituloTopMusicasEstaComOCssCorreto() {
		assertTrue(materia.exibiuOCssCorretoNoTituloTopMusicas());
	}
	
	@Test
	public void exibiuFotoDoArtista(){
		assertTrue(materia.exibiuFotoDoArtista());
	}
	
	@Test
	public void exibiuNomeDoArtista(){
		assertTrue(materia.exibiuNomeDoArtista());
	}
	
	@Test
	public void verificaSeONomeDoArtistaEstaComOCssCorreto() {
		assertTrue(materia.exibiuOCssCorretoNoNomeDoArtista());
	}
	
	@Test
	public void exibiuTextoNoMusicaComBr(){
		String textoCompleto = materia.exibiuTextoNoMusicaComBr();
		String textoMusica = textoCompleto.substring(0,16);
		assertEquals("No musica.com.br",textoMusica);
	}
	
	@Test
	public void exibiuNumeroMaisTextoMusicas(){
		String textoCompleto = materia.exibiuTextoNoMusicaComBr();
		String textoMusica = textoCompleto.substring(0,28);
		assertTrue(!StringUtils.isEmpty(textoMusica));
	}
	
	@Test
	public void exibiuNumeroMaisTextoFas(){
		String textoCompleto = materia.exibiuTextoNoMusicaComBr();
		String textoMusica = textoCompleto.substring(30);
		assertTrue(!StringUtils.isEmpty(textoMusica));
	}
	
	@Test
	public void exibiuBotaoOuvirPlaylist(){
		assertTrue(materia.exibiuBotaoOuvirPlaylist());
	}
	
	@Test
	public void  exibiuListaDeMusicas(){
		assertTrue(materia.exibiuListaDeMusicas());
	}
	
	@Test
	public void exibiuLogoMusicaComBr(){
		assertTrue(materia.exibiuLogoMusicaComBr());
	}
	
	@Test
	public void exibiuLinkMaisLetrasTraducoesEClipes(){
		assertEquals("MAIS LETRAS, TRADUÇÕES E CLIPES >", materia.exibiuLinkMaisLetrasTraducoesEClipes());
	}
	
	@Test
	public void verificaSeOLinkMaisLetrasTraducoesEClipesComOCssCorreto() {
		assertTrue(materia.exibiuOCssCorretoNoLinkMaisLetrasTraducoesEClipes());
	}
}