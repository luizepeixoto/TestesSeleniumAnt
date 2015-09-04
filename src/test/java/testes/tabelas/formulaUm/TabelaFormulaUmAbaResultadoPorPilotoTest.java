package testes.tabelas.formulaUm;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.formulaUm.TabelaFormulaUmAbaResultadoPorPiloto;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabelaFormulaUmAbaResultadoPorPilotoTest {

	private static TabelaFormulaUmAbaResultadoPorPiloto formulaUm;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(formulaUm.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		formulaUm = new TabelaFormulaUmAbaResultadoPorPiloto(Navegador.CHROME);
		formulaUm.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		formulaUm.esperaCarregar(8);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		formulaUm.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeAoClicarNaOpcaoDaAbaResultadoPorPilotoOBoxDestaAbaEhExibido() {
		assertTrue(formulaUm.exibiuBoxDaAbaResultadoPorPilotoAposClicarNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOTituloDaAbaResultadoPorPilotoEstaSendoExibido() {
		assertTrue(formulaUm.exibiuTituloDaAba());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeATabelaDeResultadoPorPilotoEstaSendoExibida() {
		assertTrue(formulaUm.exibiuATabelaDeResultadoPorPiloto());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeAsColunasDeResultadoPorPilotoEstaoSendoExibidas() {
		assertTrue(formulaUm.exibiuAsColunasDeResultadoPorPiloto());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeONomeDasColunasDeResultadoPorPilotoEstaSendoExibido() {
		assertTrue(formulaUm.exibiuONomeDasColunasDeResultadoPorPiloto());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeNoMinimoUmPilotoEstaSendoExibidoNoResultadoPorPiloto() {
		assertTrue(formulaUm.exibiuNoMinimoUmPilotoNoResultadoPorPiloto());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeParaCadaPilotoAPosicaoONomeAEquipeEOsValoresDestesCamposEstaoSendoExibidos() {
		assertTrue(formulaUm.exibiuAPosicaoONomeAEquipeEOsValoresDestesCamposParaCadaPiloto());
	}
}