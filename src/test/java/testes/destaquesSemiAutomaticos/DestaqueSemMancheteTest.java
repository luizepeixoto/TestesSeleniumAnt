package testes.destaquesSemiAutomaticos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.destaques.DestaqueSemManchete;

import br.com.infoglobo.pages.Navegador;

public class DestaqueSemMancheteTest {
	
	private static DestaqueSemManchete destaque;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaque = new DestaqueSemManchete(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		destaque.fechar();
	}
	
	@Test
	public void validarMenuEditoria(){
		assertTrue(destaque.validarMenuEditoria());
	}
	
	@Test
	public void validarMenuHome(){
		destaque.clicouNoLogoOGlobo();
		assertTrue(destaque.validarMenuHome());
	}
}