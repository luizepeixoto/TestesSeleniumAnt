package testes.newsletter.destaquesDoDia;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.destaquesDoDia.DestaquesDoDiaCorpo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class DestaquesDoDiaCorpoTest {
	
	private static DestaquesDoDiaCorpo destaquesDoDiaCorpo;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(destaquesDoDiaCorpo.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaquesDoDiaCorpo = new DestaquesDoDiaCorpo(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		destaquesDoDiaCorpo.fechar();
	}
	
	@Test
	public void verificaSeAMateriaPrincipalEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAEditoriaDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuAEditoriaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuOTituloDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPrincipalEstaComOTamanhoDaFonteCorreto() {
		assertTrue(destaquesDoDiaCorpo.exibiuOTituloDaMateriaPrincipalComOTamanhoDaFonteCorreto());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuAFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalEstaComOEstiloCorreto() {
		assertTrue(destaquesDoDiaCorpo.exibiuAFotoDaMateriaPrincipalComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDoTituloEDaFotoDaMateriaPrincipalSaoIguais() {
		assertTrue(destaquesDoDiaCorpo.exibiuOMesmoLinkNaEditoriaNoTituloENaFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOCropDaFotoDaMateriaPrincipalEstaCorreto() {
		assertTrue(destaquesDoDiaCorpo.exibiuOCropDaFotoDaMateriaPrincipalCorreto());
	}
	
	@Test
	public void verificaSeOAltDaFotoDaMateriaPrincipalEstaSendoExibido() {
		assertTrue(destaquesDoDiaCorpo.exibiuOAltDaFotoDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAFotoDaMateriaPrincipalNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaCorpo.exibiuAFotoDaMateriaPrincipalSemBorda());
	}
	
	@Test
	public void verificaSeUmaBarraAposAMateriaPrincipalEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuABarraAposAMateriaPrincipal());
	}
	
	@Test
	public void verificaSeAPrimeiraListaDeMateriasSecundariasEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuAPrimeiraListaDeMateriasSecundarias());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarraEstaoSendoExibidos() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarra());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaAFotoEstaComOEstiloCorreto() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaOLinkDaFotoDaEditoriaDoTituloEDaOpcaoContinuarLendoSaoIguais() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaOAltDaFotoEstaSendoExibindo() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaOAltDaFoto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaPrimeiraListaAFotoNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaPrimeiraListaAFotoSemBorda());
	}
	
	@Test
	public void verificaSeAAreaGenteDoGloboEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuAAreaGenteDoGlobo());
	}
	
	@Test
	public void verificaSeUmaListaDeBlogsEstaSendoExibidaNaAreaGenteDoGlobo() {
		assertTrue(destaquesDoDiaCorpo.exibiuUmaListaDeBlogsNaAreaGenteDoGlobo());
	}
	
	@Test
	public void verificaSeParaCadaBlogExibidoAFotoDoBlogONomeDoBlogEOTituloDoUltimoPostEstaoSendoExibidos() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaBlogAFotoONomeEOTituloDoUltimoPost());
	}
	
	@Test
	public void verificaSeParaCadaBlogATabelaEstaComOEstiloCorreto() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaBlogATabelaComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaBlogAFotoEstaComOEstiloCorreto() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaBlogAFotoComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaBlogExibidoOLinkDaFotoDoNomeEDoTituloDoUltimoPostSaoIguais() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaBlogOMesmoLinkNaFotoNoNomeENoTituloDoUltimoPost());
	}
	
	@Test
	public void verificaSeParaCadaBlogOAltDaFotoEstaSendoExibindo() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaBlogOAltDaFoto());
	}
	
	@Test
	public void verificaSeParaCadaBlogExibidoAFotoNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaBlogAFotoSemBorda());
	}
	
	@Test
	public void verificaSeUmaBarraAposAAreaGenteDoGloboEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuABarraAposAAreaGenteDoGlobo());
	}
	
	@Test
	public void verificaSeASegungaListaDeMateriasSecundariasEstaSendoExibida() {
		assertTrue(destaquesDoDiaCorpo.exibiuASegundaListaDeMateriasSecundarias());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarraEstaoSendoExibidos() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoOCropDaFotoAEditoriaOTituloAOpcaoContinuarLendoEUmaBarra());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaAFotoEstaComOEstiloCorreto() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaOLinkDaFotoDaEditoriaDoTituloEDaOpcaoContinuarLendoSaoIguais() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaOMesmoLinkNaFotoNaEditoriaNoTituloENaOpcaoContinuarLendo());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaOAltDaFotoEstaSendoExibindo() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaOAltDaFoto());
	}
	
	@Test
	public void verificaSeParaCadaMateriaSecundariaDaSegundaListaAFotoNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaCorpo.exibiuParaCadaMateriaSecundariaDaSegundaListaAFotoSemBorda());
	}
}