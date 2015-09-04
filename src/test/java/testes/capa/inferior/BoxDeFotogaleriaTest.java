package testes.capa.inferior;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.capa.CapaMenuInferior;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@Ignore
public class BoxDeFotogaleriaTest {
	
	private static CapaMenuInferior boxDeFotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(boxDeFotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		boxDeFotogaleria = new CapaMenuInferior(Navegador.CHROME);
		boxDeFotogaleria.esperaCarregar(2);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		boxDeFotogaleria.fechar();
	}
	
	@Test
	public void validaExistenciaDaFotogaleriaDaCapa(){
		assertNotNull(boxDeFotogaleria.getBoxDeFotogaleriaDaCapa());
	}
	
	@Test
	public void verificaSeOTituloDoBoxDeFotogaleriaEstaSendoExibido(){
		String resultadoEsperado = "Fotogalerias";
		assertEquals(resultadoEsperado.toLowerCase(), boxDeFotogaleria.oTituloDoBoxDeFotogaleriaEstaSendoExibido().toLowerCase());
	}
	
	@Test
	public void verificaSeOBoxDeFotogaleriaEstaExibindoUmaListaDeFotogalerias(){
		assertTrue(boxDeFotogaleria.estaSendoExibidaUmaListaDeFotogalerias());
	}
	
	@Test
	public void verificaSeCadaUmaDasFotogaleriasEstaExibindoUmLink(){
		assertTrue(boxDeFotogaleria.asFotogaleriasPossuemUmLink());
	}
	
	@Test
	public void verificaSeOsLinksDeCadaUmaDasFotogaleriasEhValido(){
		assertTrue(boxDeFotogaleria.osLinksDasFotogaleriasSaoValidos());
	}
	
	@Test
	public void verificaSeAPrimeiraImagemDeCadaFotogaleriaEstaSendoExibida(){
		assertTrue(boxDeFotogaleria.aPrimeiraImagemDasFotogaleriasEstaoSendoExibidas());
	}
	
	@Test
	public void verificaSeOsTitulosDasFotogaleriasEstaoSendoExibidos() throws InterruptedException{
		assertTrue(boxDeFotogaleria.getTituloDaFotoDoBoxDeFotogaleriaDaCapa());
	}
	
	@Test
	public void verificaSeOsTitulosDasFotogaleriasPossuemNoMaximo33Caracteres(){
		assertTrue(boxDeFotogaleria.exibiuTituloComNoMaximo33Caracteres());
	}
	
	@Test
	public void verificaSeOBotaoAnteriorEstaDesabilitadoParaAPrimeiraFoto(){
		assertNotNull(boxDeFotogaleria.oPrimeiroBotaoDeNavegacaoEstaSendoExibido());
	}
	
	@Test
	public void verificaSeOBotaoDeProximoEstaSendoExibido(){
		assertTrue(boxDeFotogaleria.getBotaoProximoDoBoxDeFotogaleria());
	}
	
	@Test
	public void validaExistenciaDoTextoDaNavegacaoDoBoxDeFotogalerias(){
		assertNotNull(boxDeFotogaleria.getTextoDaNavegacaoDoBoxDeFotogaleria());
	}
}