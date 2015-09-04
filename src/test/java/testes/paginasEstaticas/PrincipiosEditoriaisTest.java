package testes.paginasEstaticas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.paginasEstaticas.PrincipiosEditoriais;


public class PrincipiosEditoriaisTest {
	
	private static PrincipiosEditoriais principiosEditoriais;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		principiosEditoriais = new PrincipiosEditoriais();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		principiosEditoriais.fechar();
	}
	
	@Test
	public void exibiuTituloDosPrincipiosEditoriais(){
		assertNotNull(principiosEditoriais.exibiuOTitulo());
	}
	
	@Test
	public void exibiuIndice(){
		assertNotNull(principiosEditoriais.exibiuIndice());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void verificaSeOBannerDeAssinaturaNaoEstaSendoExibido(){
		assertTrue("O Banner está sendo exibido. Verifique se está configurado.", principiosEditoriais.exibiuBannerDeAssinatura());
	}
}