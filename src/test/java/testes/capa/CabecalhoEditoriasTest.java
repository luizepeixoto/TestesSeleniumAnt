package testes.capa;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.capa.CapaCabecalho;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class CabecalhoEditoriasTest {
	
	private static CapaCabecalho cabecalhoCentral;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(cabecalhoCentral.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		cabecalhoCentral = new CapaCabecalho(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		cabecalhoCentral.fechar();
	}
	
	@Test
	public void verificaSeOCabecalhoDeEditoriasEstaSendoExibido(){
		assertNotNull(cabecalhoCentral.exibiuCabecalhoComEditorias());
	}
	
	@Test
	public void verificaSeOCabecalhoPossuiListaDeEditorias(){
		assertTrue(cabecalhoCentral.exibiuUmaListaDeEditorias());
	}
	
	@Test
	public void verificaSeOTituloDeCadaEditoriaEstaSendoExibido(){
		assertTrue(cabecalhoCentral.exibiuOTituloDeCadaEditoria());
	}
	
	@Ignore
	@Test
	public void verificaSeOTituloDeCadaEditoriaPossuiUmLink(){
		assertTrue(cabecalhoCentral.exibiuOTituloDeCadaEditoriaComUmLink());
	}
	
	@Ignore
	@Test
	public void verificaSeOLinkNoTituloDeCadaEditoriaEhValido(){
		assertTrue(cabecalhoCentral.oLinkEmCadaEditoriaEhValido());
	}
	
	@Test
	public void verificaSeAPrimeiraOpcaoDoMenuHomeEstaSendoExibidoComoAtivo(){
		String resultadoEsperado="HOME";
		assertEquals(resultadoEsperado, cabecalhoCentral.exibiuOTituloHomeComoAtivo());
	}
	
	@Test
	public void verificaSeAOpcaoMaisPossuiUmaListaDeItens() throws InterruptedException{
		assertTrue(cabecalhoCentral.exibiuListaDeLinksNoMenuMais());
	}
	
	@Test
	public void verificaSeOsItensDeMaisPossuemUmTitulo() throws InterruptedException{
		assertTrue(cabecalhoCentral.exibiuOsItensDeMaisComTitulo());
	}
	
	@Ignore
	@Test
	public void verificaSeOsItensDeMaisPossuemUmTituloComLink() throws InterruptedException{
		assertTrue(cabecalhoCentral.exibiuOsItensDeMaisComUmLinkNoTitulo());
	}
	
	@Ignore
	@Test
	public void verificaSeOsItensDeMaisPossuemUmTituloComLinkValido() throws InterruptedException{
		assertTrue(cabecalhoCentral.exibiuOsItensDeMaisComUmLinkValidoNoTitulo());
	}
	
}
