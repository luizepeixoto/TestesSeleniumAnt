package testes.newsletter.urgente;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.urgente.UrgenteCorpo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class UrgenteCorpoTest {
	
	private static UrgenteCorpo urgenteCorpo;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(urgenteCorpo.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		urgenteCorpo = new UrgenteCorpo(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		urgenteCorpo.fechar();
	}
	
	@Test
	public void verificaSeAMateriaPrincipalEstaSendoExibida() {
		assertTrue(urgenteCorpo.exibiuAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(urgenteCorpo.exibiuAEditoriaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(urgenteCorpo.exibiuOTituloDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPrincipalEstaComOTamanhoDaFonteCorreto() {
		assertTrue(urgenteCorpo.exibiuOTituloDaMateriaUrgenteComOTamanhoDaFonteCorreto());
	}
	
	public void verificaSeAOpcaoContinuarLendoDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(urgenteCorpo.exibiuAOpcaoContinuarLendoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDoTituloEDaOpcaoContinuarLendoDaMateriaPrincipalSaoIguais() {
		assertTrue(urgenteCorpo.exibiuOMesmoLinkNaEditoriaNoTituloENaOpcaoContinuarLendoDaMateriaPrincipal());
	}
}