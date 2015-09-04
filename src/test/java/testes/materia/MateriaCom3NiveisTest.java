package testes.materia;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.Materia3Niveis;


public class MateriaCom3NiveisTest {
	
	private static Materia3Niveis materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new Materia3Niveis();
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
	public void exibiuSubEditoriaTerceiroNivelNaPagina(){
		assertTrue(materia.exibiuSubEditoriaTerceiroNivel());
	}
	
	@Test
	public void aEditoriaASubEditoriaEASubeditoriaTerceiroNivelExibidasSaoDiferentes(){
		assertTrue(materia.exibiuCorretamenteAEditoriaEAsSubs());
	}
}