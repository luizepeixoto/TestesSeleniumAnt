package testes.materia.widget;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.widget.BoxVejaTambemDefeitoSemLinks;


public class BoxVejaTambemDefeitoSemLinksTest {
	
	private static BoxVejaTambemDefeitoSemLinks materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxVejaTambemDefeitoSemLinks();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDoVejaTambemEstaSendoExibidoNaMateria(){
		assertNotNull(materia.exibiuBoxVejaMais());
	}
	
	@Test
	public void verificaSeOTituloDoBoxVejaTambemEstaSendoExibido(){
		String resultadoEsperado = "Veja Também";
		assertEquals(resultadoEsperado, materia.getBoxTitulo());
	}
	
	@Test
	public void verificaSeOBoxEstaExibindoUmaListaDematerias(){
		assertTrue(materia.exibiuListaDeMaterias());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDoVejaTambemPossuemUmTitulo(){
		assertTrue(materia.exibiuTituloParaAsMaterias());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDoVejaTambemPossuemUmLink(){
		assertTrue(materia.exibiuUmLinkParaCadaUmaDasMaterias());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDoVejaTambemPossuemUmLinkValido(){
		assertTrue(materia.exibiuUmLinkValidoParaCadaUmaDasMaterias());
	}
}