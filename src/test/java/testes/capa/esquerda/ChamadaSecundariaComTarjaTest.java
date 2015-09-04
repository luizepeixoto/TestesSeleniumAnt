package testes.capa.esquerda;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaComChamadaSecundariaComTarja;


public class ChamadaSecundariaComTarjaTest {
	
	private static ChamadaComChamadaSecundariaComTarja capa;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new ChamadaComChamadaSecundariaComTarja();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaChamadaSecundariaEstaSendoExibida(){
		assertNotNull(capa.exibiuBoxChamadaSecundariaComTarja());
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibida(){
		assertTrue(capa.exibiuEditoriaDaMateria());
	}
	
	@Test
	public void verificaSeAEditoriaPossuiUmLink(){
		assertTrue(capa.exibiuUmLinkNaEditoria());
	}
	
	@Test
	public void verificaSeOLinkDaEditoriaDaEhValido(){
		assertTrue(capa.exibiuUmLinkValidoNaEditoria());
	}
	
	@Test
	public void verificaSeAMateriaPossuiUmTitulo(){
		assertTrue(capa.exibiuTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaPossuiUmLink(){
		assertTrue(capa.exibiuTituloComLink());
	}
	
	@Test
	public void verificaSeOLinkNoTituloDaMateriaEhValido(){
		assertTrue(capa.exibiuTituloComLinkValido());
	}
	
	@Test
	public void verificaSeAMateriaDaChamadaSecundariaEstaExibindoOAutor(){
		assertTrue(capa.exibiuAutorDaMateria());
	}
	
	@Test
	public void verificaSeADescricaoDaMateriaDaChamadaSecundariaEstaSendoExibida(){
		assertTrue(capa.exibiuDescricaoDaMateria());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaChamadaSecundariaEstaSendoExibido(){
		assertTrue(capa.exibiuTotalDeComentariosDaMateria());
	}
	
	@Test
	public void verificaSeOBoxComAsChamadasSecundariasEstaSendoExibido(){
		assertNotNull(capa.exibiuBoxDeChamadasSecundarias());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeMateriasSecundarias(){
		assertTrue(capa.exibiuListaDeMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmaTarja(){
		assertTrue(capa.exibiuTarjaNoTitulo());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoOTitulo(){
		assertTrue(capa.exibiuTituloNasMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAMateriaRelacionadaPossuiUmTituloComUmLink(){
		assertTrue(capa.exibiuLinkNosTitulosDasMateriasSecundarias());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaRelacionadaPossuiUmLinkValido(){
		assertTrue(capa.exibiuLinkValidoNoTituloDasMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsChamadasSecundariasEstaoExibindoOAutor(){
		assertTrue(capa.exibiuAutorNasMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsChamadasSecundariasEstaoExibindoADescricao(){
		assertTrue(capa.exibiuDescricaoDasMateriasSecundarias());
	}
}