package testes.tabelas.libertadores;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.libertadores.TabelaLibertadoresFaseMataMataPaginaPadrao;
import pages.tabelas.libertadores.TabelaLibertadoresFaseMataMataPaginaPadrao.FasesMataMata;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class LibertadoresFaseQuartasDeFinalTest {

	private static TabelaLibertadoresFaseMataMataPaginaPadrao libertadores;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(libertadores.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		libertadores = new TabelaLibertadoresFaseMataMataPaginaPadrao(Navegador.CHROME, FasesMataMata.QUARTAS);
		libertadores.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		libertadores.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeAoClicarNaOpcaoDaFaseQuartasDeFinalOBoxDosJogosDestaFaseEhExibido() {
		assertTrue(libertadores.exibiuBoxDosJogosDaFaseAposClicarNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeNoMinimoUmJogoDaFaseQuartasDeFinalEstaSendoExibido() {
		assertTrue(libertadores.exibiuNoMinimoUmJogoDaFase());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeParaCadaJogoDaFaseQuartasDeFinalAsInformacoesDeDataHoraEstadioNomeDasEquipesEEscudoDasEquipesEstaoSendoExibidas() {
		assertTrue(libertadores.exibiuAsInformacoesDeDataHoraEstadioNomeDasEquipesEEscudoDasEquipesParaCadaJogoDaFase());
	}
}