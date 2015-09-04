package testes.capa.direita;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import pages.capa.direita.BoxVaiRio;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxVaiRioTest {
	
	private static BoxVaiRio colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxVaiRio();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxVaiRio(){
		assertTrue(colunaDaDireita.exibiuBoxVaiRio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloVaiRio(){
		assertEquals("Vairio", colunaDaDireita.exibiuTituloVaiRio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuImagemVaiRio(){
		assertTrue(colunaDaDireita.exibiuImagemVaiRio());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuTempoDaNoticia(){
		assertTrue(colunaDaDireita.exibiuTempoDaNoticia());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuChamadaDaNoticia(){
		assertTrue(colunaDaDireita.exibiuChamadaDaNoticia());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void clicouNoLogoVaiRioERedirecionouParaPaginaDoVaiRio(){
		colunaDaDireita.clicouNoLogoVaiRio();
		assertTrue(colunaDaDireita.redirecionouParaPaginaDoVaiRio());
	}
}
