package testes.listas;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.lista.ListaBoxDeMaisGalerias;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeMaisGaleriasTest {
	
	private static ListaBoxDeMaisGalerias lista;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(lista.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		lista = new ListaBoxDeMaisGalerias(Navegador.CHROME);
		lista.esperaCarregar3Segundos();
		lista.executarScroll(lista.obterContadorInicial().getLocation());
		lista.esperaCarregar3Segundos();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		lista.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDeMaisListasEstaSendoExibidoFechado() {
		assertTrue(lista.exibiuOBoxDeMaisGaleriasFechado());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeAposClicarNoBotaoDeAbrirOBoxPassaASerExibidoAberto() {
		lista.clicarParaAbrirOBox();
		assertTrue(lista.exibiuOBoxAberto());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeASetaDePaginacaoParaEsquerdaEstaDesabilitadaEAPaginacaoDaDireitaEstaHabilitada() throws InterruptedException {
		lista.esperaCarregar2Segundos();
		assertTrue(lista.exibiuSetaDaEsquerdaDesabilitadaEDireitaHabilitada());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOBoxEstaExibindoUmaListaDeListasDeFatos() {
		assertTrue(lista.exibiuListaDeOutrasGalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAsImagensDoBoxPossuemLinkTituloCropWidthHeightSendoExibidosCorretamente() throws InterruptedException {
		assertTrue(lista.exibiuLinkTituloCropWidthHeightCorretosParaAsImagens());
	}
}