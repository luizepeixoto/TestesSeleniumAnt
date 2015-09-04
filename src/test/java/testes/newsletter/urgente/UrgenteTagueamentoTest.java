package testes.newsletter.urgente;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.urgente.UrgenteTagueamento;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class UrgenteTagueamentoTest {
	
	private static UrgenteTagueamento urgenteTagueamento;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(urgenteTagueamento.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		urgenteTagueamento = new UrgenteTagueamento(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		urgenteTagueamento.fechar();
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(urgenteTagueamento.exibiuOTagueamentoNaEditoriaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(urgenteTagueamento.exibiuOTagueamentoNoTituloDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAOpcaoContinuarLendoDaMateriaPrincipalEstaComOTagueamentoCorreto() {
		assertTrue(urgenteTagueamento.exibiuOTagueamentoNaOpcaoContinuarLendoDaMateriaPrincipal());
	}
}