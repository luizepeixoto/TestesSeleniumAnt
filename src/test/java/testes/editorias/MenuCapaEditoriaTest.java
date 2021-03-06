package testes.editorias;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.editoria.Editorias;


public class MenuCapaEditoriaTest {
	
	private static Editorias menuEditorias;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		menuEditorias = new Editorias();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		menuEditorias.fechar();
	}
	
	@Test
	public void verificaSeOComentarEstaSendoExibidoNoCabecalhoDaCapaDeUmaEditoria(){
		assertTrue(menuEditorias.exibiuOComentariosNaCapaDeEditoria());
	}
}
