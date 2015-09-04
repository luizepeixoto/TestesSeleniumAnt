package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaComWebChamada;


public class ChamadaComWebChamadasTest {
	
	private static ChamadaComWebChamada capa;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new ChamadaComWebChamada();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeChamadasComWebChamadasEstaSendoExibido(){
		assertNotNull(capa.exibiuBoxDeChamadasComWebChamadas());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibida(){
		assertTrue(capa.exibiuEditoria());
	}
	
	@Test
	public void verificaSeAEditoriaPossuiUmLink(){
		assertTrue(capa.exibiuLinkNaEditoria());
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaEhValido(){
		assertTrue(capa.exibiuLinkValidoNaEditoria());
	}
	
	@Test
	public void verificaSeOTituloDaAMateriaEstaSendoExibido(){
		assertTrue(capa.exibiuTitulo());
	}
	
	@Test
	public void verificaOTituloDaMateriaPossuiUmLink(){
		assertTrue(capa.exibiuTituloComLink());
	}
	
	@Test
	public void verificaOLinkNoTituloDaMateriaEhValido(){
		assertTrue(capa.exibiuTituloComLinkValido());
	}
	
	@Test
	public void verificaSeOAutorEstaExibindo(){
		assertTrue(capa.exibiuAutor());
	}
	
	@Test
	public void verificaSeADescricaoDaMateriaEstaSendoExibida(){
		assertTrue(capa.exibiuDescricao());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosEstaSendoExibido(){
		assertTrue(capa.exibiuTotalDeComentarios());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmListaDeWebChamadas(){
		assertTrue(capa.exibiuListaDeWebChamadas());
	}
	
	@Test
	public void verificaSeAsWebChamadasEstaoExibindoUmTitulo(){
		assertTrue(capa.exibiuTituloDasDeWebChamadas());
	}
	
	@Test
	public void verificaSeAsWebChamadasEstaoExibindoUmTituloComLink(){
		assertTrue(capa.exibiuTituloComLinkNasWebChamadas());
	}
	
	@Test
	public void verificaSeOsLinksNosTitulodsDasWebChamadasSaoValidos(){
		assertTrue(capa.exibiuLinkValidoNosTitulosDasWebChamadas());
	}
}