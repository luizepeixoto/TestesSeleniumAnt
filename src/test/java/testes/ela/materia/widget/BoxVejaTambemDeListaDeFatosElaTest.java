package testes.ela.materia.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.BoxVejaTambemDeListaDeFatosEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxVejaTambemDeListaDeFatosElaTest {
	
	private static BoxVejaTambemDeListaDeFatosEla materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxVejaTambemDeListaDeFatosEla(Navegador.CHROME);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.getBoxVeja());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDoVejaTambemEstaSendoExibidoUmaListaDeFatos(){
		assertNotNull(materia.getBoxVeja());
	}
	
	@Test
	public void verificaSeOTituloDoBoxVejaTambemEstaSendoExibido(){
		assertEquals("VEJA TAMBÉM",materia.getBoxTitulo());
	}
	
	@Test
	public void verificaSeOBoxEstaExibindoUmaListaDeFatos(){
		assertTrue(materia.getBoxListaTamanho());
	}
	
	@Test
	public void verificaSeCadaUmDosFatosPossuiTitulo(){
		assertTrue(materia.getBoxListaTitulos());
	}
	
	@Test
	public void verificaSeOTituloDeCadaUmDosFatosPossuiUmLink(){
		assertTrue(materia.getBoxLinks());
	}
	
	@Test
	public void verificaSeOTituloDeCadaUmDosFatosPossuiUmLinkValido(){
		assertTrue(materia.getBoxLinksValidos());
	}
}