package testes.tabelas.brasileiro;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.tabelas.brasileiro.TempoRealComTabelaSerieA;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TempoRealComTabelaSerieATest {

	private static TempoRealComTabelaSerieA tabela;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new TempoRealComTabelaSerieA(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar(3);
		tabela.executaScrollParaAparecerOTituloDeUmaPosicao(tabela.acessaTabelaDeClassificacao());
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeATabelaDeClassificacaoEstaSendoExibida() {
		assertTrue(tabela.exibiuATabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeAsColunasDaTabelaDeClassificacaoEstaoSendoExibidas() {
		assertTrue(tabela.exibiuOTituloDasColunasDaTabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeODegradeDasLinhasDaTabelaEstaoSendoCorretamenteExibidas() throws InterruptedException {
		assertTrue(tabela.exibiuLinhaSimELinhaNaoComDegradeParaOTempoReal());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeParaCadaTimeAsColunasDaTabelaDeClassificacaoEstaoSendoExibidasCorretamente() {
		assertTrue(tabela.exibiuAsColunasDaTabelaDeClassificacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeOsQuatroPrimeirosTimesEstaoMarcadosComoClassificado() {
		assertTrue(tabela.exibiuUmaTarjaVerdeAoLadoDasQuatroPrimeirasColunas());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeOsQuatroUltimosTimesEstaoMarcadosComoRebaixados() {
		tabela.executarScroll(tabela.getDriver().findElement(By.className("rebaixado")).getLocation());
		assertTrue(tabela.exibiuUmaTarjaVermelhaAoLadoDasQuatroUltimasColunas());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeALegendaEstaSendoExibidaNoFimDaTabela() {
		assertTrue(tabela.exibiuALegendaNoFimDaPagina());
	}
	
	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeALegendaDeClassificadosEstaExibindoAsInformacoesDeCorTextoEFonteDeFormaCorreta() {
		assertTrue(tabela.exibiuALegendaDeClassificadosCorretamente());
	}
	
	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificaSeALegendaDeRebaixadosEstaExibindoAsInformacoesDeCorTextoEFonteDeFormaCorreta() {
		assertTrue(tabela.exibiuALegendaDeRebaixadosCorretamente());
	}
}