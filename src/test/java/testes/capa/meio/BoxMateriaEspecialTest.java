package testes.capa.meio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.capa.meio.BoxEspecial;

import crops.CropsCapaColunaDoMeio;


public class BoxMateriaEspecialTest {
	
	private static BoxEspecial colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new BoxEspecial();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaChamadaEspecialEstaSendoExibida(){
		assertNotNull(colunaDoMeio.getBoxChamadaEspecial());
	}
	
	@Test
	public void verificaSeTituloEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuOTitulo());
	}
	
	@Test
	public void verificaSeAImagemDoDestaqueEstaSendoExibida(){
		assertTrue(colunaDoMeio.exibiuImagem());
	}
	
	@Test
	public void verificaSeAImagemDoDestaquePossuiOCropCorreto(){
		assertTrue(colunaDoMeio.exibiuCropCorretoParaImagemPrincipal());
	}
	
	@Test
	public void verificaSeAImagemDoDestaquePossuiOWidthCorreto(){
		String widthEsperado=CropsCapaColunaDoMeio.boxEspecialChamadaPrincipal.getWidth();
		assertEquals(widthEsperado, colunaDoMeio.getImagemWidth());
	}
	
	@Test
	public void verificaSeAImagemDoDestaquePossuiOHeightCorreto(){
		String heightEsperado=CropsCapaColunaDoMeio.boxEspecialChamadaPrincipal.getHeight();
		assertEquals(heightEsperado, colunaDoMeio.getImagemHeight());
	}
	
	@Test
	public void verificaSeOsDetalhesDaMateriaEstaoSendoExibidosComClasseFadeToBlack(){
		assertTrue(colunaDoMeio.exibiuClasseFade());
	}
	
	@Test
	public void verificaSeOTituloDoDestaqueEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuTitulo());
	}
	
	@Test
	public void verificaSeOTituloDoDestaquePossuiUmLink(){
		assertTrue(colunaDoMeio.exibiuTituloComLink());
	}
	
	@Test
	public void verificaSeOLinkDoTituloDoDestaqueEhValido(){
		assertTrue(colunaDoMeio.exibiuTituloComLinkValido());
	}
	
	@Test
	public void verificaSeOAutorDoDestaqueEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuAutor());
	}
	
	@Test
	public void verificaSeADescricaoDoDestaqueEstaSendoExibida(){
		assertTrue(colunaDoMeio.exibiuDescricao());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDoDestaqueEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuComentarios());
	}
	
	@Test
	public void verificaSeOsComentariosDoDestaquePossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuComentariosComLink());
	}
	
	//Chamadas de webchamadas como subchamadas das matéria principal
	@Test
	public void verificaSePeloMenosUmLinkDeWebChamadaEstaSendoExibidoComAMateriaPrincipal(){
		assertTrue(colunaDoMeio.exibiuLinkDeWebchamadaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOsTitulosDasWebChamadaDaMateriaPrincipalEstaoSendoExibidos(){
		assertTrue(colunaDoMeio.exibiuTituloDasWebchamadaDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOsTitulosDasWebChamadaDaMateriaPrincipalPossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuTituloDasWebchamadaDaMateriaPrincipalComUmLink());
	}
	
	@Test
	public void verificaSeOsTitulosDasWebChamadaDaMateriaPrincipalPossuemUmLinkValido(){
		assertTrue(colunaDoMeio.exibiuTituloDasWebchamadaDaMateriaPrincipalComLinksValidos());
	}
	
	@Test
	public void verificaSeOTotalDeComentarioDasWebChamadaDaMateriaPrincipalEstaoSendoExibidos(){
		assertTrue(colunaDoMeio.exibiuTotalDeComentariosDasWebchamadasDaMateriaPrincipal());
	}
	
	@Test
	public void verificaSeOTotalDeComentarioDasWebChamadaDaMateriaPrincipalPossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuTotalDeComentariosDasWebchamadasDaMateriaPrincipalComUmLink());
	}

	/*Chamadas Secundárias*/	
	@Test
	public void verificaSePeloMenosUmaChamadaSecundariaEstaSendoExibida(){
		assertTrue(colunaDoMeio.exibiuChamadasSecundarias());
	}
	
	@Test
	public void verificaAsFotosDasChamadasSecundariasEstaoSendoExibidas(){
		assertTrue(colunaDoMeio.exibiuFotosParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaAsFotosDasChamadasSecundariasEstaoExibindoOCropCorreto(){
		assertTrue(colunaDoMeio.exibiuCropParaAsFotosDeChamadasSecundarias());
	}
	
	@Test
	public void verificaAsFotosDasChamadasSecundariasEstaoExibindoOWidthCorreto(){
		assertTrue(colunaDoMeio.exibiuOWidthDasFotosDeChamadasSecundarias());
	}
	
	@Test
	public void verificaAsFotosDasChamadasSecundariasEstaoExibindoOHeightCorreto(){
		assertTrue(colunaDoMeio.exibiuOHeightDasFotosDeChamadasSecundarias());
	}
	
	@Test
	public void verificaSeAsFotosDasChamadasSecundariasPossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuLinkNasFotosDasChamadasSecundarias());
	}
	
	@Test
	public void verificaOsTitulosDasChamadasSecundariasEstaoSendoExibidos(){
		assertTrue(colunaDoMeio.exibiuTitulosParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaOsTitulosDasChamadasSecundariasPossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuTitulosParaAsChamadasSecundariasComLinks());
	}
	
	@Test
	public void verificaOsTitulosDasChamadasSecundariasPossuemUmLinkValido(){
		assertTrue(colunaDoMeio.exibiuTitulosParaAsChamadasSecundariasComUmLinkValido());
	}
	
	@Test
	public void verificaAsDescricoesDasChamadasSecundariasEstaoSendoExibidas(){
		assertTrue(colunaDoMeio.exibiuDescricaoParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaOTotalDeComentariosDasChamadasSecundariasEstaoSendoExibidos(){
		assertTrue(colunaDoMeio.exibiuComentariosParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDasChamadasSecundariasPossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuLinkNosComentariosDasChamadasSecundarias());
	}
	/*Fim de chamadas secundárias*/
	
	/*Chamadas de opinião ou entrevista*/
	@Test
	public void verificaSePeloMenosUmBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeOBoxDeOpiniaoEstaExibidoImagem(){
		assertTrue(colunaDoMeio.exibiuImagemNoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeOBoxDeOpiniaoEstaExibidoAsImagensComOCropProporcionalCorreto(){
		assertTrue(colunaDoMeio.exibiuImagemComCropProporcional());
	}
	
	@Test
	public void verificaSeAImagemDoBoxDeOpiniaoPossuiOWidthDe60Px(){
		assertTrue(colunaDoMeio.getBoxDeOpiniaoImagemWidth());
	}
	
	@Test
	public void verificaSeAImagemDoBoxDeOpiniaoPossuiOHeightDe60Px(){
		assertTrue(colunaDoMeio.getBoxDeOpiniaoImagemHeight());
	}
	
	@Test
	public void verificaSeOTituloDoBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuTituloDoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeOAutorDoBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuAutorDoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeADescricaoDoBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuDescricaoDoBoxDeOpiniao());
	}
	
	@Ignore
	@Test
	public void verificaSeAdescricaoBoxDeOpiniaoPossuiNoMaximo50Caracteres(){
		assertTrue(colunaDoMeio.exibiuMaximoDeCaracteresDaDescricaoDoBoxDeOpiniao());
	}
	/*Fim das Chamadas de opinião ou entrevista*/
	
	/*Início do box de links de webchamada*/
	@Test
	public void verificaSePeloMenosUmLinkDeWebChamadaEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuLinkDeWebchamada());
	}
	
	@Test
	public void verificaSeOsTitulosDosLinksDeWebChamadaEstaoSendoExibidos(){
		assertTrue(colunaDoMeio.exibiuTituloDosLinkDeWebchamada());
	}
	
	@Test
	public void verificaSeOsTitulosDosLinksDeWebChamadaPossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuTituloDosLinkDeWebchamadaComUmLink());
	}
	
	@Test
	public void verificaSeOsTitulosDosLinksDeWebChamadaPossuemUmLinkValido(){
		assertTrue(colunaDoMeio.exibiuTituloDosLinkDeWebchamadaComLinksvalidos());
	}
	
	@Ignore
	@Test
	public void verificaSeOTotalDeComentariosDosLinksDeWebChamadaEstaoSendoExibidos(){
		assertTrue(colunaDoMeio.exibiuTotalDeComentariosDosLinksDeWebchamadas());
	}
	
	@Ignore
	@Test
	public void verificaSeOTotalDeComentariosDosLinksDeWebChamadaComUmLink(){
		assertTrue(colunaDoMeio.exibiuTotalDeComentariosDosLinksDeWebchamadasComUmLink());
	}
}