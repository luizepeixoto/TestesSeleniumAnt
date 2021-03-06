package testes.tabelas.formulaUm;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.formulaUm.TabelaFormulaUmAbaResultadoPorEquipe;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabelaFormulaUmAbaResultadoPorEquipeTest {

	private static TabelaFormulaUmAbaResultadoPorEquipe formulaUm;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(formulaUm.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		formulaUm = new TabelaFormulaUmAbaResultadoPorEquipe(Navegador.CHROME);
		formulaUm.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		formulaUm.esperaCarregar(8);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		formulaUm.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeAoClicarNaOpcaoDaAbaResultadoPorEquipeOBoxDestaAbaEhExibido() {
		assertTrue(formulaUm.exibiuBoxDaAbaResultadoPorEquipeAposClicarNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOTituloDaAbaResultadoPorEquipeEstaSendoExibido() {
		assertTrue(formulaUm.exibiuTituloDaAba());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeATabelaDeResultadoPorEquipeEstaSendoExibida() {
		assertTrue(formulaUm.exibiuATabelaDeResultadoPorEquipe());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeAsColunasDeResultadoPorEquipeEstaoSendoExibidas() {
		assertTrue(formulaUm.exibiuAsColunasDeResultadoPorEquipe());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeONomeDasColunasDeResultadoPorEquipeEstaSendoExibido() {
		assertTrue(formulaUm.exibiuONomeDasColunasDeResultadoPorEquipe());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeNoMinimoUmaEquipeEstaSendoExibidoNoResultadoPorEquipe() {
		assertTrue(formulaUm.exibiuNoMinimoUmaEquipeNoResultadoPorEquipe());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeParaCadaEquipeAPosicaoONomeEOsValoresDestesCamposEstaoSendoExibidos() {
		assertTrue(formulaUm.exibiuAPosicaoONomeEOsValoresDestesCamposParaCadaEquipe());
	}
}