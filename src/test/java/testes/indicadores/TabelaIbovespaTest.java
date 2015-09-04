package testes.indicadores;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.indicadores.Indicadores;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TabelaIbovespaTest {
	
	private static Indicadores ibovespa;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(ibovespa.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		ibovespa = new Indicadores(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		ibovespa.fechar();
	}
	
	@Test
	public void exibiuTabelaIbovespa(){
		assertNotNull(ibovespa.exibiuTabelaIbovespa());
	}
	
	@Test
	public void exibiuTituloDaTabelaIbovespa(){
		String tituloEsperado="IBOVESPA";
		assertEquals(tituloEsperado.toLowerCase(), ibovespa.exibiuTituloDaTabelaIbovespa());
	}
	
	@Test
	public void exibiuAsTabsDaTabelaIbovespa(){
		assertTrue("Não exibiu a Tab de As 10 maiores altas", ibovespa.exibiuTab10MaioresAltasDaIbovespa());
		assertTrue("Não exibiu a Tab de As 10 maiores baixas", ibovespa.exibiuTab10MaioresBaixasDaIbovespa());
	}
	
	@Test
	public void exibiuColunasTabelaDeVariacaoDasAcoesIbovespa(){
		assertTrue("Não exibiu Coluna Papel", ibovespa.exibiuColunaPapelIbovespa());
		assertTrue("Não exibiu Coluna Descrição", ibovespa.exibiuColunaDescricaoIbovespa());
		assertTrue("Não exibiu Coluna Ultimo", ibovespa.exibiuColunaUltimoIbovespa());
		assertTrue("Não exibiu Coluna Maximo", ibovespa.exibiuColunaMaximoIbovespa());
		assertTrue("Não exibiu Coluna Minimo", ibovespa.exibiuColunaMinimoIbovespa());
		assertTrue("Não exibiu Coluna Variacao", ibovespa.exibiuColunaVariacaoIbovespa());
		assertTrue("Não exibiu Coluna Dia Anterior", ibovespa.exibiuColunaDiaAnterioIbovespa());
	}
	
}