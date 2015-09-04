package testes.indicadores;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.indicadores.Indicadores;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TabelaPetroleoEOuroTest {
	
	private static Indicadores petroleoEOuro;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(petroleoEOuro.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		petroleoEOuro = new Indicadores(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		petroleoEOuro.fechar();
	}
	
	@Test
	public void exibiuTabelaPetroleoEOuro(){
		assertNotNull(petroleoEOuro.exibiuTabelaDePetroleoEOuro());
	}
	
	@Test
	public void exibiuTituloDePetroleoEOuro(){
		String tituloEsperado="PETRÓLEO E OURO";
		assertEquals(tituloEsperado, petroleoEOuro.exibiuTituloDePetroleoEOuro());
	}
	
	@Test
	public void exibiuColunasTabelaDeVariacaoDasAcoesPetroleoEOuro(){
		assertTrue("Não exibiu Coluna Indice", petroleoEOuro.exibiuColunaIndicePetroleoEOuro());
		assertTrue("Não exibiu Coluna Ultimo", petroleoEOuro.exibiuColunaUltimoPetroleoEOuro());
		assertTrue("Não exibiu Coluna Variação", petroleoEOuro.exibiuColunaVariacaoPetroleoEOuro());
		assertTrue("Não exibiu Coluna Fechamento", petroleoEOuro.exibiuColunaFechamentoPetroleoEOuro());
		assertTrue("Não exibiu Coluna Moeda", petroleoEOuro.exibiuColunaMoedaPetroleoEOuro());
		assertTrue("Não exibiu Coluna Hora", petroleoEOuro.exibiuColunaHoraPetroleoEOuro());
		assertTrue("Não exibiu Coluna Data", petroleoEOuro.exibiuColunaDataPetroleoEOuro());
	}
	
	@Ignore
	@Test
	public void verificaSeAPrimeiraLinhaDaTabelaEstaExibindoInformacoesValidas(){
		assertTrue("Não exibiu primeira linha da coluna Indice", petroleoEOuro.exibiuPrimeiraLinhaDaColunaIndiceDePetroleoEOuro());
		assertTrue("Não exibiu primeira linha da coluna Ultimo", petroleoEOuro.exibiuPrimeiraLinhaDaColunaUltimoPetroleoEOuro());
		assertTrue("Não exibiu primeira linha da coluna Variação", petroleoEOuro.exibiuPrimeiraLinhaDaColunaVariacaoPetroleoEOuro());
		assertTrue("Não exibiu primeira linha da coluna Fechamento", petroleoEOuro.exibiuPrimeiraLinhaDaColunaFechamentoPetroleoEOuro());
		assertTrue("Não exibiu primeira linha da coluna Moeda", petroleoEOuro.exibiuPrimeiraLinhaDaColunaMoedaPetroleoEOuro());
		assertTrue("Não exibiu primeira linha da coluna Hora", petroleoEOuro.exibiuPrimeiraLinhaDaColunaHoraPetroleoEOuro());
		assertTrue("Não exibiu primeira linha da coluna Data", petroleoEOuro.exibiuPrimeiraLinhaDaColunaDataPetroleoEOuro());
	}
}