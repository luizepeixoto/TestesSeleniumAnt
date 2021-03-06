package testes.listas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.lista.ListaComVideosMisto;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class ListaComVideosMistoTest {
	
	private static ListaComVideosMisto lista;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(lista.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		lista = new ListaComVideosMisto(Navegador.CHROME);
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
	public void verificaSeParaCadaUmDosFatosEstaSendoExibidoUmTituloDescricaoContadorEVideoDaGloboCom() throws InterruptedException {
		assertTrue(lista.exibiuTituloDescricaoContadorVideosComParaCadaFato());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaAPaginacaoDaListaDeFatosEstaSendoExibidaCorretamenteParaAUltimaPosicao() {
		assertTrue(lista.exibiuPaginacaoDesabilitadaParaDireitaEHabilitadaParaAEsquerda());
	}
}