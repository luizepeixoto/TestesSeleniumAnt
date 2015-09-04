package testes.tabelas.copaAmerica;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.copaAmerica.CopaAmerica;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class CopaAmericaTest {

	private static CopaAmerica tabela;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new CopaAmerica(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar(5);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeOTituloDaTabelaDaLibertadoresEstaSendoExibidoNoTopoDaPagina() {
		assertTrue(tabela.exibiuTituloDaTabela());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeAsFasesDoMenuEstaoSendoExibidas() {
		assertTrue(tabela.exibiuOpcaoDePrimeiraFase());
		assertTrue(tabela.exibiuOpcaoDaFaseQuartasDeFinal());
		assertTrue(tabela.exibiuOpcaoDaFaseSemifinal());
		assertTrue(tabela.exibiuOpcaoDaFaseFinal());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeOsTitulosDasFasesDoMenuEstaoCorretos() {
		String opcaoPrimeiraFaseEsperada="PRIMEIRA FASE";
		String opcaoQuartaDeFinalEsperado="QUARTAS DE FINAL";
		String opcaoSemiFinalEsperada="SEMIFINAL";
		String opcaoFinalEsperada="FINAL";
		
		assertEquals(opcaoPrimeiraFaseEsperada, tabela.exibiuTituloDaPrimeiraFaseNoMenu());
		assertEquals(opcaoQuartaDeFinalEsperado, tabela.exibiuTituloDasQuartasDeFinalNoMenu());
		assertEquals(opcaoSemiFinalEsperada, tabela.exibiuTituloDaSemifinalNoMenu());
		assertEquals(opcaoFinalEsperada, tabela.exibiuTituloDaFinalNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeAFaseAtualEstaSendoExibida() {
		assertTrue(tabela.exibiuAFaseAtualAberta());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeALegendaEstaSendoExibidaNoFimDaTabela() throws InterruptedException {
		tabela.ScrollAteOTitulo(2);
		tabela.esperaCarregar(1);
		assertTrue(tabela.exibiuALegendaNoFimDaPagina());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeALegendaDeClassificadosEstaExibindoAsInformacoesDeCorTextoEFonteDeFormaCorreta() {
		assertTrue(tabela.exibiuALegendaDeClassificadosCorretamente());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeALegendaDeRebaixadosEstaExibindoAsInformacoesDeCorTextoEFonteDeFormaCorreta() {
		assertTrue(tabela.exibiuALegendaDeDoisMelhoresClassificadosCorretamente());
	}
}