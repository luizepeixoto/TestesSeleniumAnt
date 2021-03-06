package testes.opine;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.opine.Opine;

import br.com.infoglobo.pages.Navegador;

public class OpineTest {
	
	private static Opine boxOpine;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		boxOpine = new Opine(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		boxOpine.fechar();
	}
	
	@Test
	public void exibiuOpinenaPagina(){
		assertNotNull(boxOpine.exibiuOBoxOpine());
	}
	
	@Test
	public void exibiuOTituloDoOpine(){
		assertTrue(boxOpine.exibiuOTituloOpine());
	}
	
	@Ignore
	@Test
	public void exibiuOTituloDeParaComentar(){
		assertTrue(boxOpine.exibiuOTituloParaComentar());
	}
	
	@Ignore
	@Test
	public void exibiuOTextoDeLogin(){
		String textoEsperado="POR FAVOR, FAÇA O SEU LOGIN NO GLOBO";
		assertEquals(textoEsperado, boxOpine.exibiuOTextoDeLogin());
	}
	
	@Ignore
	@Test
	public void exibiuOSegundoTextoDeLogin(){
		String textoEsperado="PARA OPINAR NESTE FÓRUM É NECESSÁRIO ENTRAR COM SEU LOGIN";
		assertEquals(textoEsperado, boxOpine.exibiuOSegundoTexto());
	}
	
	@Ignore
	@Test
	public void exibiuOTextoEntraComMeuLogin(){
		String textoEsperado="ENTRAR COM O MEU LOGIN";
		assertEquals(textoEsperado, boxOpine.exibiuOTextoEntrarComMeuLogin());
	}
	
	@Ignore
	@Test
	public void exibiuUmLinkEmEntraComMeuLogin(){
		assertTrue(boxOpine.exibiuUmLink());
	}
	
	@Ignore
	@Test
	public void exibiuOUmLinkVálidoNoTitulo(){
		assertTrue(boxOpine.exibiuUmLinkValido());
	}
}