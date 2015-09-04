package testes.capa.direita;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.capa.direita.BoxClubeSouMaisRio;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxClubeSouMaisRioTest {
	
	private static BoxClubeSouMaisRio colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxClubeSouMaisRio();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	public void exibiuBoxClubeSouMaisRio(){
		assertTrue(colunaDaDireita.exibiuBoxClubeSouMaisRio());
	}
	
	@Test
	public void clicouNaImagemERedirecionouParaPaginaClubeSouMaisRio(){
		colunaDaDireita.clicouNaImagem();
		assertTrue(colunaDaDireita.redirecionouParaPaginaClubeSouMaisRio());
	}
}