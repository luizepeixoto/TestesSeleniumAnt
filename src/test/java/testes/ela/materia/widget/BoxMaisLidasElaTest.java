package testes.ela.materia.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.BoxMaisLidasEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxMaisLidasElaTest {
	
	private static BoxMaisLidasEla maisLidas;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(maisLidas.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		maisLidas = new BoxMaisLidasEla(Navegador.CHROME);
		maisLidas.executaScrollParaAparecerOTituloDeUmaPosicao(maisLidas.obterBoxDeMaisLidas());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		maisLidas.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeMaisLidasEstaSendoExibido(){
		assertTrue(maisLidas.exibiuBoxDeMaisLidas());
	}
	
	@Test
	public void verificaSeOTituloDeMaisLidasEstaSendoExibido(){
		String resultadoEsperado="MAIS LIDAS";
		assertEquals(resultadoEsperado, maisLidas.oTituloMaisLidasEstaSendoExibida());
	}
	
	@Test
	public void verificaSeOBoxDeMaisLidasEstaExibindoUmaListaDeMaterias(){
		assertTrue(maisLidas.estaSendoExibidoUmaListaDeMaterias());
	}
	
	@Test
	public void verificaSeAListaDeMateriasEhNumerada(){
		assertTrue(maisLidas.aListaDeMateriasEhNumeradas());
	}
	
	@Test
	public void verificaSeAsMateriasDaListaDeMaisLidasPossuemUmTitulo(){
		assertTrue(maisLidas.osItensDaListaDeMateriasPossuemUmTitulo());
	}
	
	@Test
	public void verificaSeAsMateriasDaListaDeMaisLidasPossuemUmTituloComUmaURL(){
		assertTrue(maisLidas.osItensDaListaDeMateriasPossuemUmaURL());
	}
	
	@Test
	public void verificaSeOsLinksDasMateriasDaListaDeMaisLidasSaoValidos(){
		assertTrue(maisLidas.osItensDaListaDeMateriasPossuemUmaURLValida());
	}
}