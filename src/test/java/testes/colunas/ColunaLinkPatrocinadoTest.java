package testes.colunas;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.coluna.Coluna;


public class ColunaLinkPatrocinadoTest {
	
	private static Coluna coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new Coluna();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		coluna.fechar();
	}
	
	@Ignore
	@Test
	public void verificaSeOBoxDaPropagandaArrobaEstaSendoExibido(){
		assertNotNull(coluna.exibiuBoxDaArroba());
	}
	
	@Test
	public void verificaSeOBoxDeLinkPatrocinadosEstaSendoExibidoNoFimDaPagina(){
		assertNotNull(coluna.exibiuBoxDeLinkPatrocinado());
	}
}