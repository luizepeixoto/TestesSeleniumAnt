package testes.editorias;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.editoria.EditoriaComDoisIncludesDeMancheteDuasColunasUrgente;

public class EditoriaComDoisIncludesDeDestaqueDuasColunasUrgenteTest {
	
	private static EditoriaComDoisIncludesDeMancheteDuasColunasUrgente editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new EditoriaComDoisIncludesDeMancheteDuasColunasUrgente();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void verificaSeAEditoriaEstaExibindoDoisDestaquesDuasColunasUrgente(){
		assertNotNull(editoria.exibiuDoisDestaques());
	}
	
	@Test
	public void verificaSeOsIncludesApresentamInformacoesDiferentes(){
		assertTrue(editoria.exibiuDoisIncludesDiferentes());
	}
}