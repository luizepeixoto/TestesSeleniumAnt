package testes.capa.direita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.capa.direita.BoxCotacoesFinanceiras;

import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxCotacoesFinanceirasTest {

	private static BoxCotacoesFinanceiras colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxCotacoesFinanceiras();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	public void exibiuTituloIndicadores(){
		assertEquals("Indicadores", colunaDaDireita.tituloIndicadores());
	}
	
	@Test
	public void exibiuTituloIbovespa(){
		assertEquals("Ibovespa", colunaDaDireita.tituloIbovespa());
	}
	
	@Test
	public void exibiuTituloMoedas(){
		assertEquals("Moedas", colunaDaDireita.tituloMoedas());
	}
	
	@Test
	public void exibiuTituloCompra(){
		assertEquals("Compra", colunaDaDireita.tituloCompra());
	}
	
	@Test
	public void exibiuVariacaoIbovespa(){
		assertTrue(colunaDaDireita.variacaoIbovespa());
	}
	
	@Test
	public void exibiuTituloDolar(){
		assertEquals("Dólar", colunaDaDireita.tituloDolar());
	}
	
	@Test
	public void exibiuTituloEuro(){
		assertEquals("EURO", colunaDaDireita.tituloEuro());
	}
	
	@Test
	public void exibiuValorMoedaDolar(){
		assertTrue(colunaDaDireita.valorMoedaDolar());
	}
	
	@Test
	public void exibiuValorMoedaEuro(){
		assertTrue(colunaDaDireita.valorMoedaEuro());
	}
}