package testes.newsletter.destaquesDoDia;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.destaquesDoDia.DestaquesDoDiaTagueamento;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class DestaquesDoDiaTagueamentoTest {
	
	private static DestaquesDoDiaTagueamento destaquesDoDiaTagueamento;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(destaquesDoDiaTagueamento.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaquesDoDiaTagueamento = new DestaquesDoDiaTagueamento(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		destaquesDoDiaTagueamento.fechar();
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(destaquesDoDiaTagueamento.exibiuOTagueamentoNaEditoriaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaEditoriaDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(destaquesDoDiaTagueamento.exibiuOTagueamentoNoTituloDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(destaquesDoDiaTagueamento.exibiuOTagueamentoNaFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeCadaMateriaSecundariaDaPrimeiraListaEstaComOTagueamentoCorreto() {
		assertTrue(destaquesDoDiaTagueamento.exibiuParaCadaMateriaSecundariaDaPrimeiraListaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
	
	@Test
	public void verificaSeCadaBlogEstaComOTagueamentoCorreto() {
		assertTrue(destaquesDoDiaTagueamento.exibiuParaCadaBlogOTagueamentoNaFotoNoNomeENoTituloDoUltimoPost());
	}
	
	@Test
	public void verificaSeCadaMateriaSecundariaDaSegundaListaEstaComOTagueamentoCorreto() {
		assertTrue(destaquesDoDiaTagueamento.exibiuParaCadaMateriaSecundariaDaSegundaListaOTagueamentoNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
}