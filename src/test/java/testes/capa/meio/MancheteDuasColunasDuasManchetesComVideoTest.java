package testes.capa.meio;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioMancheteDuasColunasDuasManchetesComVideo;


public class MancheteDuasColunasDuasManchetesComVideoTest {
	
	private static CapaMeioMancheteDuasColunasDuasManchetesComVideo colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioMancheteDuasColunasDuasManchetesComVideo();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void exibiuVideoComoDestaqueEmMancheteDuasColunasDuasManchetes(){
		assertTrue(colunaDoMeio.exibiuVideoComoDestaqueEmMancheteDuasColunasDuasManchetes());
	}	
}