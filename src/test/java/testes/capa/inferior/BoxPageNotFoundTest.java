package testes.capa.inferior;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.capa.CapaMenuInferior;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxPageNotFoundTest {

	private static CapaMenuInferior capaMenuInferior;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(capaMenuInferior.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capaMenuInferior = new CapaMenuInferior(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capaMenuInferior.fechar();
	}

	@Test
	public void verificaSeOBoxPageNotFoundEstaSendoExibidoNaCapa() {
		assertNotNull(capaMenuInferior.exibiuOBoxDoPageNotFound());
	}

	@Test
	public void verificaSeOTituloPageNotFoundEstaSendoExibindo() {
		String resultadoEsperado = "Page Not Found";
		assertEquals(resultadoEsperado.toLowerCase(), capaMenuInferior.exibiuOTituloDoPageNotFound().toLowerCase());
	}
	
	@Test
	public void verificaSeOTituloDoPageNotFoundPossuiUmLink() {
		assertTrue(capaMenuInferior.oTituloPageNotFoundPossuiUmLink());
	}
	
	@Test
	public void verificaSeOLinkDoTituloPageNotFoundEhValido() {
		assertTrue(capaMenuInferior.oLinkDoTituloDoPageNotFoundEstaCorreto());
	}
	
	@Test
	public void verificaSeOBoxPageNotFoundEstaExibindoUmaListaDeMaterias() {
		assertTrue(capaMenuInferior.exibiuAsMateriasDoPageNotFound());
	}

	@Test
	public void verificaSeAsMateriasDoPageNotFoundEstaoExibindoATag() {
		assertTrue(capaMenuInferior.asMateriasDoPageNotFoundPossuemTag());
	}
	
	@Test
	public void verificaSeAsMateriasDoPageNotFoundEstaoExibindoUmLink() {
		assertTrue(capaMenuInferior.asMateriasDoPageNotFoundPossuemUmLink());
	}
	
	@Test
	public void verificaSeAsMateriasDoPageNotFoundEstaoExibindoUmLinkValido() {
		assertTrue(capaMenuInferior.osLinksDasMateriasDoPageNotFoundSaoValidos());
	}
	
	@Test
	public void verificaSeAsMateriasDoPageNotFoundEstaoExibindoUmaImagem() {
		assertTrue(capaMenuInferior.asMateriasDoPageNotFoundPossuemImagem());
	}
	
	@Test
	public void verificaSeOAltDaImagemDoPageNotFoundEstaExibindoOAutorDaFoto() {
		assertTrue(capaMenuInferior.oAltDasImagensDasMateriasDoPageNotFoundPossuemAutor());
	}
	
	@Test
	public void verificaSeAsImagensDasMateriasDoPageNotFoundPossuemUmWidthDe140Px() {
		assertTrue(capaMenuInferior.asImagensDasMateriasDoPageNotFoundPossuemWidthDe140Px());
	}
	
	@Test
	public void verificaSeAsImagensDasMateriasDoPageNotFoundPossuemUmHeightDe85Px() {
		assertTrue(capaMenuInferior.asImagensDasMateriasDoPageNotFoundPossuemHeightDe85Px());
	}
	
	@Test
	public void verificaSeAsMateriasDoPageNotFoundEstaoExibindoOTitulo() {
		assertTrue(capaMenuInferior.asMateriasDoPageNotFoundPossuemTitulo());
	}
}