package testes.ela.materia.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.BoxVejaTambemEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxVejaTambemElaTest {
	
	private static BoxVejaTambemEla materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxVejaTambemEla(Navegador.CHROME);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.getBoxVeja());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDoVejaTambemEstaSendoExibidoNaMateria(){
		assertNotNull("Erro",materia.getBoxVeja());
	}
	
	@Test
	public void verificaSeOTituloDoBoxVejaTambemEstaSendoExibido(){
		assertEquals("VEJA TAMBÉM",materia.getBoxTitulo());
	}
	
	@Test
	public void verificaSeOTituloDoBoxDoVejaTambemEstaSendoExibidoComUmaFonteDiferenciada(){
		assertTrue("Erro",materia.getBoxTituloTag());
	}
	
	@Test
	public void verificaSeAListaDeMateriasDoBoxDoVejaTambemEhMaiorQueZero(){
		assertTrue("Erro",materia.getBoxListaTamanho());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDoVejaTambemPossuemUmTitulo(){
		assertTrue("Erro",materia.getBoxListaTitulos());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDoVejaTambemPossuemUmLink(){
		assertTrue("Erro",materia.getBoxLinks());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDoVejaTambemPossuemUmLinkValido(){
		assertTrue("Erro",materia.getBoxLinksValidos());
	}
}