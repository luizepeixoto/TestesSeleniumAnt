package testes.agenda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.agenda.AgendaEventos;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class AgendaEventosTest {
	
	private static AgendaEventos agenda;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(agenda.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		agenda = new AgendaEventos(Navegador.FIREFOX);
		agenda.esperaSuperLeaderboardVoltarAoTamanhoNormal(150);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		agenda.fechar();
	}
	
	/*	Eventos da agenda com:
			Foto, título, descrição, endereço, horário, valor(se existir), link no final*/
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeADataDosEventosEstaSendoExibida() throws InterruptedException {
		agenda.scroll();
		agenda.clicarNumaDataValida();
		assertTrue(agenda.exibiuADataDosEventos());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeODiaDaSemanaEstaSendoExibidoJuntoComAData() throws InterruptedException{
		assertTrue(agenda.exibiuDiaDaSemana());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeUmaListaDeEventosEstaSendoExibida() {
		assertTrue(agenda.exibiuListaDeEventos());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeCadaEventoDaListaPossuiUmaFoto() {
		assertTrue(agenda.exibiuUmaFotoParaCadaEventoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAFotoDeCadaEventoDaListaPossuiOCropCorreto() {
		assertTrue(agenda.exibiuOCropCorretoParaCadaFotoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAFotoDeCadaEventoDaListaPossuiOWidthCorreto() {
		assertTrue(agenda.exibiuOWidthCorretoParaCadaFotoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeAFotoDeCadaEventoDaListaPossuiOHeightCorreto() {
		assertTrue(agenda.exibiuOHeightCorretoParaCadaFotoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeCadaEventoDaListaEstaExibindoUmTitulo() {
		assertTrue(agenda.exibiuUmTituloParaCadaEventoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeCadaEventoDaListaEstaExibindoUmaDescricao() {
		assertTrue(agenda.exibiuUmaDescricaoParaCadaEventoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeOCampoEnderecoDeCadaEventoEstaSendoExibindo() {
		assertTrue(agenda.exibiuCampoEndereçoParaCadaEventoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOCampoHoraDeCadaEventoEstaSendoExibindo() {
		assertTrue(agenda.exibiuCampoHoraParaCadaEventoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeOCampoValorDeCadaEventoEstaSendoExibindo() {
		assertTrue(agenda.exibiuCampoValorParaCadaEventoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOLinkExternoDeCadaEventoEstaSendoExibindo() {
		assertTrue(agenda.exibiuUmLinkExternoParaCadaEventoDaLista());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOLinkExternoDeCadaEventoEstaSendoExibindoComUmTitulo() {
		assertTrue(agenda.exibiuOTituloDoUmLinkExternoParaCadaEventoDaLista());
	}
}