package testes.indicadores;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.indicadores.Indicadores;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TabelaBovespaTest {
	
	private static Indicadores bovespa;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(bovespa.getDriver());
	
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		bovespa = new Indicadores(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		bovespa.fechar();
	}
	
	@Test
	public void exibiuTabelaBovespa(){
		assertNotNull(bovespa.exibiuTabelaBovespa());
	}
	
	@Test
	public void exibiuTituloDaTabelaBovespa(){
		String tituloEsperado="BOVESPA";
		assertEquals(tituloEsperado.toLowerCase(), bovespa.exibiuTituloDaTabelaBovespa());
	}
	
	@Test
	public void exibiuAsTabsDaTabelaBovespa(){
		assertTrue("Não exibiu a Tab de As 10 mais negociadas", bovespa.exibiuTab10MaisNegociadas());
		assertTrue("Não exibiu a Tab de As 10 maiores altas", bovespa.exibiuTab10MaioresAltas());
		assertTrue("Não exibiu a Tab de As 10 maiores baixas", bovespa.exibiuTab10MaioresBaixas());
	}
	
	@Test
	public void exibiuColunasTabelaDeVariacaoDasAcoesBovespa(){
		assertTrue("Não exibiu Coluna Papel", bovespa.exibiuColunaPapelBovespa());
		assertTrue("Não exibiu Coluna Descrição", bovespa.exibiuColunaDescricaoBovespa());
		assertTrue("Não exibiu Coluna Ultimo", bovespa.exibiuColunaUltimoBovespa());
		assertTrue("Não exibiu Coluna Maximo", bovespa.exibiuColunaMaximoBovespa());
		assertTrue("Não exibiu Coluna Minimo", bovespa.exibiuColunaMinimoBovespa());
		assertTrue("Não exibiu Coluna Variacao", bovespa.exibiuColunaVariacaoBovespa());
		assertTrue("Não exibiu Coluna Dia Anterior", bovespa.exibiuColunaDiaAnterioBovespa());
	}
	
}