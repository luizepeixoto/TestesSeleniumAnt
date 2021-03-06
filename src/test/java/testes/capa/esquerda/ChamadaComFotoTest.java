package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaComFoto;


public class ChamadaComFotoTest {
	
	private static ChamadaComFoto capa;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new ChamadaComFoto();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaChamadaComFotoEstaSendoExibido(){
		assertNotNull(capa.exibiuBoxDeChamadaComFoto());
	}
	
	@Test
	public void verificaSeAFotoEstaSendoExibinda(){
		assertTrue(capa.exibiuImagem());
	}
	
	@Test
	public void verificaAFotoEstaSendoExibidaComAClasseLinkAnimado(){
		assertTrue(capa.exibiuImagemComClasseLinkAnimado());
	}
	
	@Test
	public void verificaSeAImagemPossuiWidthDe460Px(){
		assertTrue(capa.getFotoImagemWidth());
	}
	
	@Test      
	public void verificaSeAImagemPossuiHeightDe200Px(){
		assertTrue(capa.getFotoImagemHeight());
	}
	
	@Test
	public void verificaSeAEditoriaDaChamadaSecundariaComFotoEstaSendoExibida(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoEditoria());
	}
	
	@Test
	public void verificaSeAEditoriaDaChamadaSecundariaComFotoPossuiUmLink(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoEditoriaLink());
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDaChamadaSecundariaComFotoEhValido(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoLinkValido());
	}
	
	@Test
	public void verificaSeAMateriaDaChamadaSecundariaComFotoPossuiUmTitulo(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoTitulo());
	}
	
	@Test
	public void verificaSeAMateriaDaChamadaSecundariaComFotoPossuiUmTituloComUmLink(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoTituloLink());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDaChamadaSecundariaComFotoPossuiUmLinkValido(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoTituloLinkValido());
	}
	
	@Test
	public void verificaSeAMateriaDaChamadaSecundariaComFotoEstaExibindoOAutor(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoAutor());
	}
	
	@Test
	public void verificaSeADescricaoDaMateriaDaChamadaSecundariaComFotoEstaSendoExibida(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoDescricao());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaChamadaSecundariaComFotoEstaSendoExibido(){
		assertTrue(capa.getBoxChamadaSecundariaComFotoComentarios());
	}
}