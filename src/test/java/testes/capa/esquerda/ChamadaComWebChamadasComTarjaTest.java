package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaComWebChamadasComTarjas;


public class ChamadaComWebChamadasComTarjaTest {
	
	private static ChamadaComWebChamadasComTarjas capa;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new ChamadaComWebChamadasComTarjas();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaChamadaDeWebChamadasComTarjaEstaSendoExibida(){
		assertNotNull(capa.exibiuBoxDeWebChamdasComTarjas());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibida(){
		assertTrue(capa.exibiuEditoria());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibidaComUmLink(){
		assertTrue(capa.exibiuEditoriaComLink());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibidaComUmLinkValido(){
		assertTrue(capa.exibiuEditoriaComLinkValido());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEstaSendoExibido(){
		assertTrue(capa.exibiuTituloDaMateria());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaEstaSendoExibidoComUmLink(){
		assertTrue(capa.exibiuTituloDaMateriaComLink());
	}
	
	@Test
	public void verificaSeOLinkNoTituloDaMateriaEhValido(){
		assertTrue(capa.exibiuUmLinkValidoNoTituloDaMateria());
	}
	
	@Test
	public void verificaSeOAutorDaMateriaEstaSendoExibido(){
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
	public void verificaSeEstaSendoExibidoUmaListaDeWebChamadas(){
		assertTrue(capa.exibiuUmaListaDeWebChamadas());
	}
	
	@Test
	public void verificaSeOsLinksDaListaDeWebChamadasEstaoExibindoATarja(){
		assertTrue(capa.exibiuTarjaNosLinks());
	}
	
	@Test
	public void verificaSeOsLinksDaListaDeWebChamadasEstaoExibindoOTitulo(){
		assertTrue(capa.exibiuLinkComTitulo());
	}
	
	@Test
	public void verificaSeOsLinksDaListaDeWebChamadasEstaoExibindoUmLinkNoTitulo(){
		assertTrue(capa.exibiuTituloComLink());
	}
	
	@Test
	public void verificaSeOsLinksDaListaDeWebChamadasEstaoExibindoUmLinkValidoNoTitulo(){
		assertTrue(capa.exibiuLinkValidoNoTituloDosLinks());
	}
}