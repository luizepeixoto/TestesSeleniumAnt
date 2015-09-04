package testes.indicadores;

import static org.junit.Assert.assertNotNull;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.indicadores.Indicadores;

public class PublicidadeTest {
	
	private static Indicadores publicidade;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		publicidade = new Indicadores();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		publicidade.fechar();
	}
	
	@Test
	public void exibiuBoxDePublicidade(){
		assertNotNull(publicidade.exibiuPublicidade());
	}
}