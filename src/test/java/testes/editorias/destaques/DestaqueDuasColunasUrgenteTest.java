package testes.editorias.destaques;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.editoria.destaques.DestaqueDuasColunasUrgente;

import crops.CropsDestaques;


public class DestaqueDuasColunasUrgenteTest {
	
	private static DestaqueDuasColunasUrgente editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new DestaqueDuasColunasUrgente();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void verificaSeAMancheteDuasColunasUrgenteEstaSendoExibido(){
		assertNotNull(editoria.exibiuDestaque2Colunas());
	}
	
	@Test
	public void exibiuTituloComAClasseUrgente(){
		assertNotNull(editoria.exibiuTituloUrgente());
	}
	
	@Test
	public void exibiuTextoUrgente(){
		assertTrue(editoria.exibiuTextoUrgente());
	}
	
	@Test
	public void exibiuTituloDoDestaque(){
		assertTrue(editoria.exibiuTituloDoDestaque());
	}
	
	@Test
	public void exibiuSubtituloDoDestaque(){
		assertTrue(editoria.exibiuSubtituloDoDestaque());
	}
	
	@Test
	public void exibiuBalaoDeComentarios(){
		assertTrue(editoria.exibiuBalaoDeComentarios());
	}
	
	@Test
	public void exibiuTotalDeComentarios(){
		assertTrue(editoria.exibiuTotalDeComentarios());
	}
	
	@Test
	public void exibiuImagemDoDestaque(){
		assertTrue(editoria.exibiuImagemDoDestaque());
	}
	
	@Test
	public void verificaSeAImagemDoDestaquePossuiOCropCorreto(){
		assertTrue(editoria.exibiuCropCorretoParaAImagemDoDestaque());
	}
	
	@Test
	public void exibiuClasseAnimadoScaleNaImagem(){
		assertTrue(editoria.exibiuClasseAnimadoScaleNaImagem());
	}
	
	@Test
	public void exibiuImagemComWidthDe940Px(){
		String widthEsperado = CropsDestaques.duasColunasFotoDestaquePrincial.getWidth();
		assertEquals(widthEsperado, editoria.exibiuImagemComWidthDe940Px());
	}
	
	@Test
	public void exibiuImagemComHeightDe410Px(){
		String heightEsperado = CropsDestaques.duasColunasFotoDestaquePrincial.getHeight();
		assertEquals(heightEsperado, editoria.exibiuImagemComHeightDe410Px());
	}
	
	@Test
	public void exibiuUmaListaDeWebChamadasAposDestaque(){
		assertTrue(editoria.exibiuWebChamadasAposDestaque());
	}
	
	@Test
	public void exibiuTextoParaCadaUmaDasWebChamadas(){
		assertTrue(editoria.exibiuTextoParaCadaUmaDasWebChamadas());
	}
	
	@Test
	public void exibiuUmLinkParaCadaUmaDasWebChamadas(){
		assertTrue(editoria.exibiuUmLinkParaCadaUmaDasWebChamadas());
	}
	
	@Test
	public void exibiuUmLinkValidoParaCadaUmaDasWebChamadas(){
		assertTrue(editoria.exibiuUmLinkValidoParaCadaUmaDasWebChamadas());
	}
	
	@Test
	public void exibiuUmaListaDeChamadasSecundarias(){
		assertTrue(editoria.exibiuUmaListaDeChamadasSecundarias());
	}
	
	@Test
	public void verificaSeAsImagensDasChamadasSecundariasPossuemOCropCorreto(){
		assertTrue(editoria.exibiuCropCorretoParaAsImagemDasChamadasSecundarias());
	}
	
	@Test
	public void exibiuUmaImagemParaCadaUmaDasChamadasSecundarias(){
		assertTrue(editoria.exibiuUmaImagemParaAsChamadasSecundarias());
	}
	
	@Test
	public void exibiuAClasseAnimadoOpacityParaAsImagensDaChamadasSecundarias(){
		assertTrue(editoria.exibiuAClasseAnimadoOpacityParaAsImagensDaChamadasSecundarias());
	}
	
	@Test
	public void exibiuWidthCorretoParaAsImagensDaChamadasSecundarias(){
		assertTrue(editoria.exibiuWidthCorretoParaAsImagensDaChamadasSecundarias());
	}
	
	@Test
	public void exibiuHeightCorretoParaAsImagensDaChamadasSecundarias(){
		assertTrue(editoria.exibiuHeightCorretoParaAsImagensDaChamadasSecundarias());
	}
	
	@Test
	public void exibiuUmTitutoParaAsChamadasSecundarias(){
		assertTrue(editoria.exibiuUmTitutoParaAsChamadasSecundarias());
	}
	
	@Test
	public void exibiuOTitutoDasChamadasSecundariasComNoMaximo65Caracteres(){
		assertTrue(editoria.exibiuOTitutoDasChamadasSecundariasComNoMaximo75Caracteres());
	}
	
	@Test
	public void exibiuLinkNoTitutoDasChamadasSecundarias(){
		assertTrue(editoria.exibiuLinkNoTitutoDasChamadasSecundarias());
	}
	
	@Test
	public void exibiuLinkValidoNoTitutoDasChamadasSecundarias(){
		assertTrue(editoria.exibiuLinkValidoNoTitutoDasChamadasSecundarias());
	}
	
	@Test
	public void exibiuUmaDescricaoParaAsChamadasSecundarias(){
		assertTrue(editoria.exibiuUmaDescricaoParaAsChamadasSecundarias());
	}
	
	@Ignore
	public void exibiuDescricaoDasChamadasSecundariasComNoMaximo65Caracteres(){
		assertTrue(editoria.exibiuDescricaoDasChamadasSecundariasComNoMaximo75Caracteres());
	}
	
	@Test
	public void exibiuUmaListaDeOpinioes(){
		assertTrue(editoria.exibiuUmaListaDeOpinioes());
	}
	
	@Test
	public void exibiuUmaImagemParaCadaUmDosBoxDeOpiniao(){
		assertTrue(editoria.exibiuUmaImagemParaCadaUmDosBoxDeOpiniao());
	}
	
	@Test
	public void exibiuUmLinkNaImagemDeCadaUmDosBoxDeOpiniao(){
		assertTrue(editoria.exibiuUmLinkNaImagemDeCadaUmDosBoxDeOpiniao());
	}
	
	@Test
	public void exibiuUmLinkValidoNaImagemDeCadaUmDosBoxDeOpiniao(){
		assertTrue(editoria.exibiuUmLinkValidoNaImagemDeCadaUmDosBoxDeOpiniao());
	}
	
	@Test
	public void exibiuWidthCorretoParaAsImagensDoBoxDeOpiniao(){
		assertTrue(editoria.exibiuWidthCorretoParaAsImagensDoBoxDeOpiniao());
	}
	
	@Test
	public void exibiuHeightCorretoParaAsImagensDoBoxDeOpiniao(){
		assertTrue(editoria.exibiuHeightCorretoParaAsImagensDoBoxDeOpiniao());
	}
	
	@Test
	public void exibiuUmAntiTitutoParaCadaUmDosBoxDeOpiniao(){
		assertTrue(editoria.exibiuUmAntiTitutoParaCadaUmDosBoxDeOpiniao());
	}
	
	@Test
	public void exibiuOAutorEmCadaUmDosBoxDeOpiniao(){
		assertTrue(editoria.exibiuOAutorEmCadaUmDosBoxDeOpiniao());
	}
	
	@Test
	public void exibiuUmaDescricaoParaCadaUmDosBoxDeOpiniao(){
		assertTrue(editoria.exibiuUmaDescricaoParaCadaUmDosBoxDeOpiniao());
	}
	
	@Test
	public void exibiuAsDescricoesDosBoxDeOpiniaoComNoMaximo65Caracteres(){
		assertTrue(editoria.exibiuAsDescricoesDosBoxDeOpiniaoComNoMaximo65Caracteres());
	}
	
	@Test
	public void exibiuLinkNaDescricaoDoBoxDeOpiniao(){
		assertTrue(editoria.exibiuLinkNaDescricaoDoBoxDeOpiniao());
	}
	
	@Test
	public void exibiuLinkValidoNaDescricaoDoBoxDeOpiniao(){
		assertTrue(editoria.exibiuLinkValidoNaDescricaoDoBoxDeOpiniao());
	}
	
	@Test
	public void exibiuAutorNaChamadaPrincipal(){
		assertTrue(editoria.exibiuAutorNaChamadaPrincipal());
	}
	
	@Test
	public void exibiuAutorNaChamadaSecundaria(){
		assertTrue(editoria.exibiuAutorNaChamadaSecundaria());
	}
}
