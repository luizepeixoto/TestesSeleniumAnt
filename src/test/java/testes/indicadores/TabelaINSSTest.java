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

public class TabelaINSSTest {
	
	private static Indicadores inss;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(inss.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		inss = new Indicadores(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		inss.fechar();
	}
	
	@Test
	public void exibiuTabelaDeINSS(){
		assertNotNull(inss.exibiuTabelaDoINSS());
	}
	
	@Test
	public void exibiuTituloDeINSS(){
		String tituloEsperado="INSS";
		assertEquals(tituloEsperado, inss.exibiuTituloDoINSS());
	}
	
	@Test
	public void exibiuColunasTabelaDeVariacaoDasAcoesINSS(){
		assertTrue("Não exibiu Coluna Salário De Contribuição", inss.exibiuColunaSalarioDeContribuicaoDoINSS());
		assertTrue("Não exibiu Coluna Aliquota", inss.exibiuColunaAliquotaDoINSS());
	}
	
	@Ignore
	@Test
	public void verificaSeAPrimeiraLinhaDaTabelaDeINSSEstaExibindoInformacoesValidas(){
		assertTrue("Não exibiu primeira linha da coluna Salário De Contribuição", inss.exibiuPrimeiraLinhaDaSalarioDeContribuicaoDoINSS());
		assertTrue("Não exibiu primeira linha da coluna Aliquota", inss.exibiuPrimeiraLinhaDaColunaAliquotaDoINSS());
	}
	
	@Test
	public void exibiuOBoxDeObservacao(){
		String textoEsperadoNoPrimeiroParagrafo="Obs: Percentuais incidentes de forma não cumulativa (artigo 22 do regulamento da Organização e do Custeio da Seguridade Social).";
		String textoEsperadoNoSegundoParagrafo="TRABALHADOR AUTÔNOMO";
		String textoEsperadoNoTerceiroParagrafo="Para o contribuinte individual e facultativo, o valor da contribuição deverá ser de 20% do salário-base, que poderá variar de R$ 622 a R$ 3.916,2";
		assertEquals("Não exibiu O texto do primeiro parágrafo de observações INSS", textoEsperadoNoPrimeiroParagrafo, inss.exibiuPrimeiroParagrafoDeObservacao());
		assertEquals("Não exibiu O texto do Segundo parágrafo de observações INSS", textoEsperadoNoSegundoParagrafo, inss.exibiuSegundoParagrafoDeObservacao());
		assertEquals("Não exibiu O texto do Terceiro parágrafo de observações INSS", textoEsperadoNoTerceiroParagrafo, inss.exibiuTerceiroParagrafoDeObservacao());
	}
}