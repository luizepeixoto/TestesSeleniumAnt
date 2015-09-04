package testes.tabelas.libertadores;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.tabelas.libertadores.TabelaLibertadores;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class LibertadoresTest {

	private static TabelaLibertadores libertadores;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(libertadores.getDriver());
	
	@BeforeClass
	public static void before() throws Exception{
		libertadores = new TabelaLibertadores(Navegador.CHROME);
		libertadores.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		libertadores.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeOTituloDaTabelaDaLibertadoresEstaSendoExibidoNoTopoDaPagina() {
		assertTrue(libertadores.exibiuTituloDaTabela());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOMenuEstaSendoExibido() {
		assertTrue(libertadores.exibiuOMenuDaTabela());
	}
	
	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAsFasesDoMenuEstaoSendoExibidas() {
		assertTrue(libertadores.exibiuOpcaoDaFasePrevia());
		assertTrue(libertadores.exibiuOpcaoDaFaseDeGrupos());
		assertTrue(libertadores.exibiuOpcaoDaFaseOitavasDeFinal());
		assertTrue(libertadores.exibiuOpcaoDaFaseQuartasDeFinal());
		assertTrue(libertadores.exibiuOpcaoDaFaseSemifinal());
		assertTrue(libertadores.exibiuOpcaoDaFaseFinal());
	}
	
	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeOsTitulosDasFasesDoMenuEstaoCorretos() {
		assertTrue(libertadores.exibiuTituloDaFasePreviaNoMenu());
		assertTrue(libertadores.exibiuTituloDaFaseDeGruposNoMenu());
		assertTrue(libertadores.exibiuTituloDaFaseOitavasDeFinalNoMenu());
		assertTrue(libertadores.exibiuTituloDaFaseQuartasDeFinalNoMenu());
		assertTrue(libertadores.exibiuTituloDaFaseSemifinalNoMenu());
		assertTrue(libertadores.exibiuTituloDaFaseFinalNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeAFaseAtualEstaSendoExibida() {
		assertTrue(libertadores.exibiuAFaseAtual());
	}
}