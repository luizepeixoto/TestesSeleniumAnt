package testes.ela.capa;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ela.capa.CapaMenu;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class CapaMenuCentroTest {

	private static CapaMenu capa;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(capa.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new CapaMenu(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOMenuElaEstaSendoExibidoNoCentroDaPagina(){
		assertTrue(capa.exibiuMenuEla());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOMenuEstaExibindoAImagemDoElaCorretamente(){
		assertTrue(capa.exibiuImagemDoSiteEla());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAsEditoriasEstaoSendoExibidasNoMenu() throws InterruptedException{
		assertTrue(capa.exibiuEditoriasNoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOLayoutDasEditoriasQueEstaoSendoExibidasNoMenuEstaoCorretas() throws InterruptedException{
		assertTrue(capa.exibiuLayoutCorretoParaEditoriasNoMenu());
	}	
}