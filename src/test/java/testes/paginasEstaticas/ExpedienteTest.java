package testes.paginasEstaticas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.paginasEstaticas.Expediente;


public class ExpedienteTest {
	
	private static Expediente pagina;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		pagina = new Expediente();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		pagina.fechar();
	}
	
	@Ignore
	@Test
	public void exibiuPublicidade(){
		assertNotNull(pagina.exibiuPublicidade());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaNaoEstaSendoExibido(){
		assertTrue("O Banner está sendo exibido. Verifique se está configurado.", pagina.exibiuBannerDeAssinatura());
	}
	
	@Test
	public void exibiuBoxDeExpediente(){
		assertNotNull(pagina.exibiuBoxDeExpediente());
	}
}