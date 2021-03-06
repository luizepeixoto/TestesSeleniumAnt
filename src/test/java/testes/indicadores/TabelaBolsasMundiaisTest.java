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

public class TabelaBolsasMundiaisTest {
	
	private static Indicadores bolsasMundiais;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(bolsasMundiais.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		bolsasMundiais = new Indicadores(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		bolsasMundiais.fechar();
	}
	
	@Test
	public void exibiuTabelaBolsasMundiais(){
		assertNotNull(bolsasMundiais.exibiuTabelaBolsasMundiais());
	}
	
	@Test
	public void exibiuTituloDaTabelaBolsasMundiais(){
		String tituloEsperado="BOLSAS MUNDIAIS";
		assertEquals(tituloEsperado.toLowerCase(), bolsasMundiais.exibiuTituloDaTabelaBolsasMundiais());
	}
	
	@Test
	public void exibiuColunasTabelaDeVariacaoDasAcoesBolsasMundiais(){
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaIndiceBolsasMundiais());
		assertTrue("Não exibiu Coluna Ultimo", bolsasMundiais.exibiuColunaUltimoBolsasMundiais());
		assertTrue("Não exibiu Coluna Maximo", bolsasMundiais.exibiuColunaMaximoBolsasMundiais());
		assertTrue("Não exibiu Coluna Minimo", bolsasMundiais.exibiuColunaMinimoBolsasMundiais());
		assertTrue("Não exibiu Coluna Variacao", bolsasMundiais.exibiuColunaVariacaoBolsasMundiais());
		assertTrue("Não exibiu Coluna Dia Anterior", bolsasMundiais.exibiuColunaDiaAnterioBolsasMundiais());
	}
	
	@Ignore
	@Test
	public void verificaSeAPrimeiraLinhaDaTabelaEstaExibindoInformacoesValidas(){
		assertTrue("Não exibiu a bandeira na primeira linha", bolsasMundiais.exibiuPrimeiraBandeiraIndiceBolsasMundiais());
		assertTrue("Não exibiu primeira linha da coluna Indice", bolsasMundiais.exibiuPrimeiraLinhaDaColunaIndiceBolsasMundiais());
		assertTrue("Não exibiu primeira linha da coluna Ultimo", bolsasMundiais.exibiuPrimeiraLinhaDaColunaUltimoBolsasMundiais());
		assertTrue("Não exibiu primeira linha da coluna Maximo", bolsasMundiais.exibiuPrimeiraLinhaDaColunaMaximoBolsasMundiais());
		assertTrue("Não exibiu primeira linha da coluna Minimo", bolsasMundiais.exibiuPrimeiraLinhaDaColunaMinimoBolsasMundiais());
		assertTrue("Não exibiu primeira linha da coluna Variacao", bolsasMundiais.exibiuPrimeiraLinhaDaColunaDiaAnteriorBolsasMundiais());
		assertTrue("Não exibiu primeira linha da coluna Variacao", bolsasMundiais.exibiuPrimeiraLinhaDaColunaVariacaoBolsasMundiais());
		assertTrue("Não exibiu primeira linha da coluna Dia Anterior", bolsasMundiais.exibiuPrimeiraLinhaDaColunaDiaAnterioBolsasMundiais());
	}
	
	@Test
	public void exibiuASegundaTabelaDeBolsasMundiais(){
		assertNotNull(bolsasMundiais.exibiuSegundaTabelaDentroDeBolsasMundiais());
	}
	
	@Test
	public void exibiuColunasNaSegundaTabelaDeVariacaoDasAcoesBolsasMundiais(){
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaIndiceNaSegundaTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Dia Anterior", bolsasMundiais.exibiuColunaDiaAnteriorNaSegundaTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Variacao", bolsasMundiais.exibiuColunaVariacaoNaSegundaTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaDataNaSegundaTabelaBolsasMundiais());
	}
	
	@Ignore
	@Test
	public void verificaSeAPrimeiraLinhaDaSegundaTabelaEstaExibindoInformacoesValidas(){
		assertTrue("Não exibiu a bandeira na primeira linha", bolsasMundiais.exibiuBandeiraNaPrimeiraLinhaDaSegundaTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaIndiceNaPrimeiraLinhaNaSegundaTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Dia Anterior", bolsasMundiais.exibiuColunaDiaAnteriorNaPrimeiraLinhaDaSegundaTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Variacao", bolsasMundiais.exibiuColunaVariacaoNaPrimeiraLinhaDaSegundaTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaDataNaPrimeiraLinhaDaSegundaTabelaBolsasMundiais());
	}
	
	@Test
	public void exibiuATerceiraTabelaDeBolsasMundiais(){
		assertNotNull(bolsasMundiais.exibiuTerceiraTabelaDentroDeBolsasMundiais());
	}
	
	@Test
	public void exibiuColunasNaTerceiraTabelaDeVariacaoDasAcoesBolsasMundiais(){
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaIndiceNaTerceiraTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Dia Anterior", bolsasMundiais.exibiuColunaDiaAnteriorNaTerceiraTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Variacao", bolsasMundiais.exibiuColunaVariacaoNaTerceiraTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaDataNaTerceiraTabelaBolsasMundiais());
	}
	
	@Ignore
	@Test
	public void verificaSeAPrimeiraLinhaDaTerceiraTabelaEstaExibindoInformacoesValidas(){
		assertTrue("Não exibiu a bandeira na primeira linha", bolsasMundiais.exibiuBandeiraNaPrimeiraLinhaDaTerceiraTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaIndiceNaPrimeiraLinhaNaTerceiraTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Dia Anterior", bolsasMundiais.exibiuColunaDiaAnteriorNaPrimeiraLinhaDaTerceiraTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Variacao", bolsasMundiais.exibiuColunaVariacaoNaPrimeiraLinhaDaTerceiraTabelaBolsasMundiais());
		assertTrue("Não exibiu Coluna Indice", bolsasMundiais.exibiuColunaDataNaPrimeiraLinhaDaTerceiraTabelaBolsasMundiais());
	}
	
	@Test
	public void exibiuOTextoDeFechamentoDoDiaAnterior(){
		assertTrue(bolsasMundiais.exibiuOTextoDeFechamentoDoDiaAnterior());
	}
}