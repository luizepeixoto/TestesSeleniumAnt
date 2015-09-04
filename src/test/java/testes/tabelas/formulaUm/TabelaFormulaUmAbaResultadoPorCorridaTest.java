package testes.tabelas.formulaUm;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.formulaUm.TabelaFormulaUmAbaResultadoPorCorrida;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabelaFormulaUmAbaResultadoPorCorridaTest {

	private static TabelaFormulaUmAbaResultadoPorCorrida formulaUm;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(formulaUm.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		formulaUm = new TabelaFormulaUmAbaResultadoPorCorrida(Navegador.CHROME);
		formulaUm.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		formulaUm.esperaCarregar(8);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		formulaUm.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeAoClicarNaOpcaoDaAbaResultadoPorCorridaOBoxDestaAbaEhExibido() {
		assertTrue(formulaUm.exibiuBoxDaAbaResultadoPorCorridaAposClicarNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOTituloDaAbaResultadoPorCorridaEstaSendoExibido() {
		assertTrue(formulaUm.exibiuTituloDaAba());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAsBandeirasDosPaisesSedesDeCorridaEstaoSendoExibidas() {
		assertTrue(formulaUm.exibiuAsBandeirasDosPaisesSedesDeCorrida());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeParaCadaCorridaATabelaDeResultadoPorCorridaEstaSendoExibida() {
		assertTrue(formulaUm.exibiuATabelaDeResultadoPorCorridaParaCadaCorrida());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeAsColunasEONomeDasColunasDeResultadoPorCorridaEstaoSendoExibidosParaCadaCorrida() throws InterruptedException {
		assertTrue(formulaUm.exibiuAsColunasEONomeDasColunasDeResultadoPorCorridaParaCadaCorrida());
	}
}