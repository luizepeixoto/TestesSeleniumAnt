package testes.tabelas.brasileiro;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.tabelas.brasileiro.TempoRealComTabelaSerieB;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TempoRealComTabelaSerieBTest {

	private static TempoRealComTabelaSerieB tabela;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new TempoRealComTabelaSerieB(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar3Segundos();
		tabela.executarScroll(tabela.getDriver().findElements(By.className("divisor-nivel-1")).get(1).getLocation());
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
	
	@OrdemExecucaoTeste(Ordem = 9)
	@Test
	public void verificaSeALegendaDeClassificadosEstaExibindoAsInformacoesDeCorTextoEFonteDeFormaCorreta() {
		assertTrue(tabela.exibiuALegendaDeClassificadosDaSerieBCorretamente());
	}
	
	@OrdemExecucaoTeste(Ordem = 10)
	@Test
	public void verificaSeALegendaDeRebaixadosEstaExibindoAsInformacoesDeCorTextoEFonteDeFormaCorreta() {
		assertTrue(tabela.exibiuALegendaDeRebaixadosDaSerieBCorretamente());
	}
}