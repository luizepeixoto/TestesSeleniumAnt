package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.Materia;


public class MateriaLinksPatrocinadosTest {
	
	private static Materia materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new Materia();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeLinksPatrocinadosDoGoogleEstaSendoExibidoNoFimDapagina(){
		assertNotNull(materia.exibiuBoxDeLinksPatrocinados());
	}
	
	@Test
	public void verificaSeOConteudoDosLinksPatrocinadosEstaSendoExibido(){
		assertTrue(materia.exibiuConteudoDeLinksPatrocinados());
	}
	
}