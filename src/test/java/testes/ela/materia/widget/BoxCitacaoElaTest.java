package testes.ela.materia.widget;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.BoxCitacaoEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxCitacaoElaTest {
	
	private static BoxCitacaoEla materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxCitacaoEla(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxEstaSendoExibido(){
		assertTrue(materia.exibiuOBoxCitacao());
	}
	
	@Test
	public void verificaSeOBoxNaoPossuiBorda(){
		assertTrue(materia.exibiuOBoxCitacaoSemBorda());
	}
	
	@Test
	public void verificaSeOBoxEstaComAFonteCorreta(){
		assertTrue(materia.exibiuAFonteCorretaNoBoxCitacao());
	}
	
	@Test
	public void verificaSeAFraseEstaSendoExibida(){
		assertTrue(materia.getBoxCitacaoFrase());
	}
	
	@Test
	public void verificaSeAFrasePossuiAspasSimplesNoInicioENoFinal(){
		assertTrue(materia.exibiuAspasSimplesNoInicioENoFinalDaFrase());
	}
	
	@Test
	public void verificaSeOCssDaFraseEstaCorreto(){
		assertTrue(materia.exibiuOCssCorretoNaFrase());
	}
	
	@Test
	public void verificaSeOAutorEstaSendoExibido(){
		assertTrue(materia.getBoxCitacaoAutor());
	}
	
	@Test
	public void verificaSeOCssDoAutorEstaCorreto(){
		assertTrue(materia.exibiuOCssCorretoNoAutor());
	}
	
	@Test
	public void verificaSeOCargoDoAutorEstaSendoExibido(){
		assertTrue(materia.getBoxCitacaoCargo());
	}
	
	@Test
	public void verificaSeOCssDoCargoDoAutorEstaCorreto(){
		assertTrue(materia.exibiuOCssCorretoNoCargoDoAutor());
	}
}