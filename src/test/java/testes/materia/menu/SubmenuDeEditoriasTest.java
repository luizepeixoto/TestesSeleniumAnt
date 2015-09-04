package testes.materia.menu;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.menu.SubmenuDeEditorias;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class SubmenuDeEditoriasTest {
	
	private static SubmenuDeEditorias subMenuEditorias;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(subMenuEditorias.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception{
		subMenuEditorias = new SubmenuDeEditorias(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste(){
		subMenuEditorias.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuSubMenuDeEconomia() throws InterruptedException{
		assertTrue(subMenuEditorias.exibiuSubMenuDeEconomia());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void NãoExibiuSubMenuDeEducacao(){
		assertTrue(subMenuEditorias.NãoExibiuSubMenuDeEducacao());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuQuantidadeMaximaDe8ItensNoSubMenu(){
		assertTrue(subMenuEditorias.exibiuQuantidadeMaximaDe8ItensNoSubMenu() <= Integer.parseInt("8"));
	}

}
