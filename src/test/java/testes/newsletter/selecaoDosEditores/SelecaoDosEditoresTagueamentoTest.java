package testes.newsletter.selecaoDosEditores;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.selecaoDosEditores.SelecaoDosEditoresTagueamento;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class SelecaoDosEditoresTagueamentoTest {
	
	private static SelecaoDosEditoresTagueamento selecaoDosEditoresTagueamento;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(selecaoDosEditoresTagueamento.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		selecaoDosEditoresTagueamento = new SelecaoDosEditoresTagueamento(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		selecaoDosEditoresTagueamento.fechar();
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(selecaoDosEditoresTagueamento.exibiuOTagueamentoNaEditoriaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaEditoriaDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(selecaoDosEditoresTagueamento.exibiuOTagueamentoNoTituloDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(selecaoDosEditoresTagueamento.exibiuOTagueamentoNaFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeCadaMateriaSecundariaDaPrimeiraListaEstaComOTagueamentoCorreto() {
		assertTrue(selecaoDosEditoresTagueamento.exibiuParaCadaMateriaSecundariaDaPrimeiraListaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
	
	@Test
	public void verificaSeCadaBlogEstaComOTagueamentoCorreto() {
		assertTrue(selecaoDosEditoresTagueamento.exibiuParaCadaBlogOTagueamentoNaFotoNoNomeENoTituloDoUltimoPost());
	}
	
	@Test
	public void verificaSeCadaMateriaSecundariaDaSegundaListaEstaComOTagueamentoCorreto() {
		assertTrue(selecaoDosEditoresTagueamento.exibiuParaCadaMateriaSecundariaDaSegundaListaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
}