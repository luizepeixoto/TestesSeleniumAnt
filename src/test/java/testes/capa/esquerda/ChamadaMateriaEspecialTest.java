package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaEspecial;


public class ChamadaMateriaEspecialTest {
	
	private static ChamadaEspecial capa;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new ChamadaEspecial();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaChamadaEspecialEstaSendoExibida(){
		assertNotNull(capa.getBoxChamadaEspecial());
	}
	
	@Test
	public void verificaSeTituloEstaSendoExibido(){
		assertTrue(capa.exibiuOTitulo());
	}
	
	@Test
	public void verificaSeAImagemDoDestaqueEstaSendoExibida(){
		assertTrue(capa.exibiuImagem());
	}
	
	@Test
	public void verificaSeAImagemDoDestaquePossuiOWidthCorreto(){
		String widthEsperado="460";
		assertEquals(widthEsperado, capa.getImagemWidth());
	}
	
	@Test
	public void verificaSeAImagemDoDestaquePossuiOHeightCorreto(){
		String heightEsperado="276";
		assertEquals(heightEsperado, capa.getImagemHeight());
	}
	
	@Test
	public void verificaSeOTituloDoDestaqueEstaSendoExibido(){
		assertTrue(capa.exibiuTitulo());
	}
	
	@Test
	public void verificaSeOTituloDoDestaquePossuiUmLink(){
		assertTrue(capa.exibiuTituloComLink());
	}
	
	@Test
	public void verificaSeOLinkDoTituloDoDestaqueEhValido(){
		assertTrue(capa.exibiuTituloComLinkValido());
	}
	
	@Test
	public void verificaSeOAutorDoDestaqueEstaSendoExibido(){
		assertTrue(capa.exibiuAutor());
	}
	
	@Test
	public void verificaSeADescricaoDoDestaqueEstaSendoExibida(){
		assertTrue(capa.exibiuDescricao());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDoDestaqueEstaSendoExibido(){
		assertTrue(capa.exibiuComentarios());
	}
	
	@Test
	public void verificaSeOsComentariosDoDestaquePossuemUmLink(){
		assertTrue(capa.exibiuComentariosComLink());
	}
	
	@Test
	public void verificaSePeloMenosUmaChamadaSecundariaEstaSendoExibida(){
		assertTrue(capa.exibiuChamadasSecundarias());
	}
	
	@Test
	public void verificaAsFotosDasChamadasSecundariasEstaoSendoExibidas(){
		assertTrue(capa.exibiuFotosParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaSeAsFotosDasChamadasSecundariasPossuemUmLink(){
		assertTrue(capa.exibiuLinkNasFotosDasChamadasSecundarias());
	}
	
	@Test
	public void verificaOsTitulosDasChamadasSecundariasEstaoSendoExibidos(){
		assertTrue(capa.exibiuTitulosParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaOsTitulosDasChamadasSecundariasPossuemUmLink(){
		assertTrue(capa.exibiuTitulosParaAsChamadasSecundariasComLinks());
	}
	
	@Test
	public void verificaOsTitulosDasChamadasSecundariasPossuemUmLinkValido(){
		assertTrue(capa.exibiuTitulosParaAsChamadasSecundariasComUmLinkValido());
	}
	
	@Test
	public void verificaAsDescricoesDasChamadasSecundariasEstaoSendoExibidas(){
		assertTrue(capa.exibiuDescricaoParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaOTotalDeComentariosDasChamadasSecundariasEstaoSendoExibidos(){
		assertTrue(capa.exibiuComentariosParaAsChamadasSecundarias());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDasChamadasSecundariasPossuemUmLink(){
		assertTrue(capa.exibiuLinkNosComentariosDasChamadasSecundarias());
	}
	
	@Test
	public void verificaSePeloMenosUmBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(capa.exibiuBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeOBoxDeOpiniaoEstaExibidoImagem(){
		assertTrue(capa.exibiuImagemNoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeAImagemDoBoxDeOpiniaoPossuiOWidthDe60Px(){
		assertTrue(capa.getBoxDeOpiniaoImagemWidth());
	}
	
	@Test
	public void verificaSeAImagemDoBoxDeOpiniaoPossuiOHeightDe60Px(){
		assertTrue(capa.getBoxDeOpiniaoImagemHeight());
	}
	
	@Test
	public void verificaSeOTituloDoBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(capa.exibiuTituloDoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeOAutorDoBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(capa.exibiuAutorDoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeADescricaoDoBoxDeOpiniaoEstaSendoExibido(){
		assertTrue(capa.exibiuDescricaoDoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSeAdescricaoBoxDeOpiniaoPossuiNoMaximo44Caracteres(){
		assertTrue(capa.exibiuMaximoDeCaracteresDaDescricaoDoBoxDeOpiniao());
	}
	
	@Test
	public void verificaSePeloMenosUmLinkDeWebChamadaEstaSendoExibido(){
		assertTrue(capa.exibiuLinkDeWebchamada());
	}
	
	@Test
	public void verificaSeOsTitulosDosLinksDeWebChamadaEstaoSendoExibidos(){
		assertTrue(capa.exibiuTituloDosLinkDeWebchamada());
	}
	
	@Test
	public void verificaSeOsTitulosDosLinksDeWebChamadaPossuemUmLink(){
		assertTrue(capa.exibiuTituloDosLinkDeWebchamadaComUmLink());
	}
	
	@Test
	public void verificaSeOsTitulosDosLinksDeWebChamadaPossuemUmLinkValido(){
		assertTrue(capa.exibiuTituloDosLinkDeWebchamadaComLinksvalidos());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDosLinksDeWebChamadaEstaoSendoExibidos(){
		assertTrue(capa.exibiuTotalDeComentariosDosLinksDeWebchamadas());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDosLinksDeWebChamadaComUmLink(){
		assertTrue(capa.exibiuTotalDeComentariosDosLinksDeWebchamadasComUmLink());
	}
}