package testes.capa.direita;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxDeAgenda;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeAgendaTest {
	
	private static BoxDeAgenda colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxDeAgenda(Navegador.CHROME);
		colunaDaDireita.esperaCarregar(2);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void verificaSeOBoxDeAgendaNaHomeEstaSendoExibido() {
		assertTrue(colunaDaDireita.exibiuOBoxDeAgendaNaHome());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void verificaSeOTituloDaAgendaNaHomeEstaSendoExibido() {
		assertTrue(colunaDaDireita.exibiuOTituloDaAgendaNaHome());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void verificaSeOCalendarioDaAgendaNaHomeEstaSendoExibido() {
		assertTrue(colunaDaDireita.exibiuOCalendarioDaAgendaNaHome());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void verificaSeOMesExibidoNoCalendarioEhIgualAoMesAtual() {
		assertTrue(colunaDaDireita.exibiuOMesNoCalendarioIgualAoMesAtual());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void verificaSeOAnoExibidoNoCalendarioEhIgualAoMesAtual() {
		assertTrue(colunaDaDireita.exibiuOAnoNoCalendarioIgualAoAnoAtual());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void verificaSeOBotaoAnteriorEstaSendoExibidoNoCalendario() {
		assertTrue(colunaDaDireita.exibiuOBotaoAnteriorNoCalendario());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void verificaSeOTitleDoBotaoAnteriorEstaSendoExibidoNoCalendario() {
		assertTrue(colunaDaDireita.exibiuOTitleDoBotaoAnteriorNoCalendario());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void verificaSeOBotaoProximoEstaSendoExibidoNoCalendario() {
		assertTrue(colunaDaDireita.exibiuOBotaoProximoNoCalendario());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void verificaSeOTitleDoBotaoProximoEstaSendoExibidoNoCalendario() {
		assertTrue(colunaDaDireita.exibiuOTitleDoBotaoProximoNoCalendario());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void verificaSeOsSeteDiasDaSemanaEstaoSendoExibidos() {
		assertTrue(colunaDaDireita.exibiuOsSetesDiasDaSemana());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void verificaSeCadaSiglaDosDiasDaSemanaEstaSendoExibida() {
		assertTrue(colunaDaDireita.exibiuASiglaDosDiasDaSemana());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 12)
	public void verificaSeOsDiasDoMesEstaoSendoExibidos() {
		assertTrue(colunaDaDireita.exibiuOsDiasDoMes());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 13)
	public void verificaSeODiaAtualEstaSendoExibidoCorretamente() {
		assertTrue(colunaDaDireita.exibiuODiaAtualCorretamente());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 14)
	public void verificaSeODiaAtualEstaSendoExibidoMarcadoComACorPadrao() {
		assertTrue(colunaDaDireita.exibiuODiaAtualMarcadoComACorPadrao());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 15)
	public void verificaSeOsDiasAnterioresAoDiaAtualEstaoDesabilitados() {
		assertTrue(colunaDaDireita.exibiuOsDiasAnterioresAoDiaAtualDesabilitados());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 16)
	public void verificaSeAposClicarEmUmDiaOEventoEhExibidoNoBoxDeAgenda() {
		assertTrue(colunaDaDireita.exibiuOEventoDeUmDiaNoBoxDeAgenda());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 17)
	public void verificaSeOTituloDoEventoEstaSendoExibido() {
		assertTrue(colunaDaDireita.exibiuOTituloDoEvento());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 18)
	public void verificaSeADataDoEventoExibidoEhIgualAoDiaSelecionado() {
		assertTrue(colunaDaDireita.exibiuADataDoEventoIgualAoDiaSelecionado());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 19)
	public void verificaSeOLinkParaAAgendaEstaSendoExibido() {
		assertTrue(colunaDaDireita.exibiuOLinkParaAAgenda());
	}
}