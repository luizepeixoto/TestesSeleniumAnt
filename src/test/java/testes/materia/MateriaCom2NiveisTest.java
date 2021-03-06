package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.Materia2Niveis;


public class MateriaCom2NiveisTest {
	
	private static Materia2Niveis materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new Materia2Niveis();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void exibiuEditoriaNoMenu(){
		assertTrue(materia.exibiuEditoria());
	}
	
	@Test
	public void exibiuSubEditoriaNaPagina(){
		assertTrue(materia.exibiuSubEditoria());
	}
	
	@Test
	public void aEditoriaExibidaEhDiferenteDaSubEditoriaExibida(){
		assertTrue(materia.exibiuCorretamenteEditoriaESubEditoria());
	}
}