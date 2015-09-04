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

public class TabelaCambioMoedasTest {
	
	private static Indicadores cambioEMoedas;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(cambioEMoedas.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		cambioEMoedas = new Indicadores(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		cambioEMoedas.fechar();
	}
	
	@Test
	public void exibiuTabelaCambiosEMoedas(){
		assertNotNull(cambioEMoedas.exibiuTabelaBolsasMundiais());
	}
	
	@Test
	public void exibiuTituloDeCambiosEMoedas(){
		String tituloEsperado="CÂMBIO / MOEDAS";
		assertEquals(tituloEsperado.toLowerCase(), cambioEMoedas.exibiuTituloDeCambiosEMoedas());
	}
	
	@Test
	public void exibiuColunasTabelaDeVariacaoDasAcoesCambiosEMoedas(){
		assertTrue("Não exibiu Coluna Papel", cambioEMoedas.exibiuColunaPapelCambiosEMoedas());
		assertTrue("Não exibiu Coluna Descricao", cambioEMoedas.exibiuColunaDescricaoCambiosEMoedas());
		assertTrue("Não exibiu Coluna Ultimo", cambioEMoedas.exibiuColunaUltimoCambiosEMoedas());
		assertTrue("Não exibiu Coluna Compra", cambioEMoedas.exibiuColunaCompraCambiosEMoedas());
		assertTrue("Não exibiu Coluna Venda", cambioEMoedas.exibiuColunaVendaCambiosEMoedas());
		assertTrue("Não exibiu Coluna Variação", cambioEMoedas.exibiuColunaVariacaoCambiosEMoedas());
	}
	
	@Ignore
	@Test
	public void verificaSeAPrimeiraLinhaDaTabelaEstaExibindoInformacoesValidas(){
		assertTrue("Não exibiu primeira linha da coluna Papel", cambioEMoedas.exibiuPrimeiraLinhaDaColunaPapelCambiosEMoedas());
		assertTrue("Não exibiu primeira linha da coluna Descricao", cambioEMoedas.exibiuPrimeiraLinhaDaColunaDescricaoCambiosEMoedas());
		assertTrue("Não exibiu primeira linha da coluna Ultimo", cambioEMoedas.exibiuPrimeiraLinhaDaColunaUltimoCambiosEMoedas());
		assertTrue("Não exibiu primeira linha da coluna Compra", cambioEMoedas.exibiuPrimeiraLinhaDaColunaCompraCambiosEMoedas());
		assertTrue("Não exibiu primeira linha da coluna Venda", cambioEMoedas.exibiuPrimeiraLinhaDaColunaVendaCambiosEMoedas());
		assertTrue("Não exibiu primeira linha da coluna Variação", cambioEMoedas.exibiuPrimeiraLinhaDaColunaVariacaoCambiosEMoedas());
	}
	
	@Test
	public void exibiuOTextoDeConversorDeMoedas(){
		String tituloEsperado="> CONVERSOR DE MOEDAS (SITE DO BANCO CENTRAL DO BRASIL)";
		assertEquals(tituloEsperado.toLowerCase(), cambioEMoedas.exibiuOTextoDeConversorDeMoedas());
	}
	
	@Test
	public void exibiuLinkNoTextoDeConversorDeMoedas(){
		assertTrue(cambioEMoedas.exibiuLinkNoTextoDeConversorDeMoedas());
	}
	
	@Test
	public void exibiuLinkValidoNoTextoDeConversorDeMoedas(){
		assertTrue(cambioEMoedas.exibiuLinkValidoNoTextoDeConversorDeMoedas());
	}
}