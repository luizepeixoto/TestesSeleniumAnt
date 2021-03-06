package testes.newsletter.selecaoDosEditores;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.selecaoDosEditores.SelecaoDosEditoresCorpo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class SelecaoDosEditoresCorpoTest {
	
	private static SelecaoDosEditoresCorpo selecaoDosEditoresCorpo;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(selecaoDosEditoresCorpo.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		selecaoDosEditoresCorpo = new SelecaoDosEditoresCorpo(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		selecaoDosEditoresCorpo.fechar();
	}
	
	@Test
	public void verificaSeAMateriaPrincipalEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuAEditoriaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuOTituloDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPrincipalEstaComOTamanhoDaFonteCorreto() {
		assertTrue(selecaoDosEditoresCorpo.exibiuOTituloDaMateriaPrincipalComOTamanhoDaFonteCorreto());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuAFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalEstaComOEstiloCorreto() {
		assertTrue(selecaoDosEditoresCorpo.exibiuAFotoDaMateriaPrincipalComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDoTituloEDaFotoDaMateriaPrincipalSaoIguais() {
		assertTrue(selecaoDosEditoresCorpo.exibiuOMesmoLinkNaEditoriaNoTituloENaFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOCropDaFotoDaMateriaPrincipalEstaCorreto() {
		assertTrue(selecaoDosEditoresCorpo.exibiuOCropDaFotoDaMateriaPrincipalCorreto());
	}
	
	@Test
	public void verificaSeOAltDaFotoDaMateriaPrincipalEstaSendoExibido() {
		assertTrue(selecaoDosEditoresCorpo.exibiuOAltDaFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresCorpo.exibiuAFotoDaMateriaPrincipalSemBorda());
	}
	
	@Test
	public void verificaSeUmaBarraAposAMateriaPrincipalEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuABarraAposAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAPrimeiraListaDeMateriasSecundariasEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuAPrimeiraListaDeMateriasSecundarias());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarraEstaoSendoExibidos() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarra());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaAFotoEstaComOEstiloCorreto() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaOLinkDaFotoDaEditoriaDoTituloEDaOpcaoContinuarLendoSaoIguais() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaOAltDaFotoEstaSendoExibindo() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaOAltDaFoto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaAFotoNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoSemBorda());
	}
	
	@Test
	public void verificaSeAAreaGenteDoGloboEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuAAreaGenteDoGlobo());
	}
	
	@Test
	public void verificaSeUmaListaDeBlogsEstaSendoExibidaNaAreaGenteDoGlobo() {
		assertTrue(selecaoDosEditoresCorpo.exibiuUmaListaDeBlogsNaAreaGenteDoGlobo());
	}
	
	@Test
	public void verificaSeParaCadaBlogATabelaEstaComOEstiloCorreto() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaBlogATabelaComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaBlogExibidoAFotoDoBlogONomeDoBlogEOTituloDoUltimoPostEstaoSendoExibidos() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaBlogAFotoONomeEOTituloDoUltimoPost());
	}
	
	@Test
	public void verificaSeParaCadaBlogAFotoEstaComOEstiloCorreto() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaBlogAFotoComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaBlogExibidoOLinkDaFotoDoNomeEDoTituloDoUltimoPostSaoIguais() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaBlogOMesmoLinkNaFotoNoNomeENoTituloDoUltimoPost());
	}
	
	@Test
	public void verificaSeParaCadaBlogOAltDaFotoEstaSendoExibindo() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaBlogOAltDaFoto());
	}
	
	@Test
	public void verificaSeParaCadaBlogExibidoAFotoNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaBlogAFotoSemBorda());
	}
	
	@Test
	public void verificaSeUmaBarraAposAAreaGenteDoGloboEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuABarraAposAAreaGenteDoGlobo());
	}
	
	@Test
	public void verificaSeASegungaListaDeMateriasSecundariasEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCorpo.exibiuASegundaListaDeMateriasSecundarias());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarraEstaoSendoExibidos() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarra());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaAFotoEstaComOEstiloCorreto() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaOLinkDaFotoDaEditoriaDoTituloEDaOpcaoContinuarLendoSaoIguais() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaOAltDaFotoEstaSendoExibindo() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaOAltDaFoto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaAFotoNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoSemBorda());
	}
}