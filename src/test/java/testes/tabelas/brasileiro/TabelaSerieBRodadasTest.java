package testes.tabelas.brasileiro;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.tabelas.brasileiro.TabelaSerieBRodadas;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TabelaSerieBRodadasTest {

	private static TabelaSerieBRodadas tabela;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tabela.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		tabela = new TabelaSerieBRodadas(Navegador.CHROME);
		tabela.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
		tabela.esperaCarregar3Segundos();
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tabela.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeATabelaLateralComAsRodadasDoCampeonatoEstaSendoExibido() {
		assertTrue(tabela.exibiuTabelaDeRodadas());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeATabelaEstaExibindo38Rodadas() {
		assertTrue(tabela.exibiuOTotalEsperadoDeRodadas());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAPaginacaoDasRodadasEstaSendoExibidaNoTopoDaTabela() {
		assertTrue(tabela.exibiuBoxDeNavegacao());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeParaCadaUmaDasRodadasDaTabelaEstaSendoExibidoONomeOEscudoOPlacarADataOEstadioEOHorarioDeCadaPartida() throws InterruptedException {
		assertTrue(tabela.exibiuTituloEInformacoesDosJogosDeCadaRodada());
	}
}