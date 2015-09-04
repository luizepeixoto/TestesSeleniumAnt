package testes.tabelas.libertadores;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.libertadores.TabelaLibertadoresFaseMataMataPaginaPadrao.FasesMataMata;
import pages.tabelas.libertadores.paginaTempoReal.TabelaLibertadoresFaseMataMataPaginaTempoRealPaginaPadrao;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class LibertadoresNoTempoRealFasePreviaTest {

	private static TabelaLibertadoresFaseMataMataPaginaTempoRealPaginaPadrao libertadoresPaginaTempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(libertadoresPaginaTempoReal.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		libertadoresPaginaTempoReal = new TabelaLibertadoresFaseMataMataPaginaTempoRealPaginaPadrao(Navegador.CHROME, FasesMataMata.PREVIA);
		libertadoresPaginaTempoReal.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		libertadoresPaginaTempoReal.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeAoClicarNaOpcaoDaFasePreviaOBoxDosJogosDestaFaseEhExibido() {
		assertTrue(libertadoresPaginaTempoReal.exibiuBoxDosJogosDaFaseAposClicarNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeNoMinimoUmJogoDaFasePreviaEstaSendoExibido() {
		assertTrue(libertadoresPaginaTempoReal.exibiuNoMinimoUmJogoDaFase());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeParaCadaJogoDaFasePreviaAsInformacoesDeDataHoraEstadioNomeDasEquipesEEscudoDasEquipesEstaoSendoExibidas() {
		assertTrue(libertadoresPaginaTempoReal.exibiuAsInformacoesDeDataHoraEstadioNomeDasEquipesEEscudoDasEquipesParaCadaJogoDaFase());
	}
}