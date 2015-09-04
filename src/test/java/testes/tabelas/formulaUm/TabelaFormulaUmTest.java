package testes.tabelas.formulaUm;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.formulaUm.TabelaFormulaUm;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabelaFormulaUmTest {

	private static TabelaFormulaUm formulaUm;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(formulaUm.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		formulaUm = new TabelaFormulaUm(Navegador.CHROME);
		formulaUm.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		formulaUm.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeOTituloDaTabelaDaFormulaUmEstaSendoExibido() {
		assertTrue(formulaUm.exibiuTituloDaTabela());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOMenuEstaSendoExibido() {
		assertTrue(formulaUm.exibiuOMenuDaTabela());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAsOpcoesDoMenuEstaoSendoExibidas() {
		assertTrue(formulaUm.exibiuOpcaoDoCalendario());
		assertTrue(formulaUm.exibiuOpcaoDoResultadoPorPiloto());
		assertTrue(formulaUm.exibiuOpcaoDoResultadoPorEquipe());
		assertTrue(formulaUm.exibiuOpcaoDoResultadoPorCorrida());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeOsTitulosDasOpcoesDoMenuEstaoCorretos() {
		assertTrue(formulaUm.exibiuTituloDaAbaCalendarioNoMenu());
		assertTrue(formulaUm.exibiuTituloDaAbaResultadoPorPilotoNoMenu());
		assertTrue(formulaUm.exibiuTituloDaAbaResultadoPorEquipeNoMenu());
		assertTrue(formulaUm.exibiuTituloDaAbaResultadoPorCorridaNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeAAbaAtualEstaSendoExibidaAbertaPorPadrao() {
		assertTrue(formulaUm.exibiuAAbaAtualAbertaPorPadrao());
	}
	
	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeAImagemDaTabelaFacilEstaSendoExibida() {
		assertTrue(formulaUm.exibiuAImagemDaTabelaFacil());
	}
	
	@OrdemExecucaoTeste(Ordem = 7)
	@Test
	public void verificaSeOLinkDaImagemDaTabelaFacilEstaCorreto() {
		assertTrue(formulaUm.exibiuOLinkDaImagemDaTabelaFacilCorreto());
	}
}