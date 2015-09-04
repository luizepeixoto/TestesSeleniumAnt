package testes.listas;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.lista.ListaComFoto;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class ListaComFotoTest {
	
	private static ListaComFoto lista;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(lista.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		lista = new ListaComFoto(Navegador.CHROME);
		lista.esperaCarregar2Segundos();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		lista.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOTituloDaListaDeFatosEstaSendoExibido() {
		assertTrue(lista.exibiuOTituloDaListaDeFatos());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaAPaginacaoDaListaDeFatosEstaSendoExibidaCorretamenteParaAPrimeiraPosicao() {
		assertTrue(lista.exibiuPaginacaoDesabilitadaParaEsquerdaEHabilitadaParaADireita());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAListaDeFatosEstaSendoExibida() {
		assertTrue(lista.exibiuUmaListaDeFatos());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAListaDeFatosPossuiMaisDeUmFato() {
		assertTrue(lista.exibiuUmaListaValida());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAsImagensDaListaDeFatosPossuemOCropEOsTamanhosProporcionaisCorretos() throws InterruptedException {
		assertTrue(lista.exibiuCropWidthHeightCorretosParaAsImagens());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaAPaginacaoDaListaDeFatosEstaSendoExibidaCorretamenteParaAUltimaPosicao() {
		assertTrue(lista.exibiuPaginacaoDesabilitadaParaDireitaEHabilitadaParaAEsquerda());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOTituloDescricaoTotalDeFotosELegendaDeCadaItemEstaoSendoExibidosCorretamente() throws InterruptedException {
		assertTrue(lista.exibiuTituloDescricaoTotalDeFotosELegendaParaCadaItem());
	}
}