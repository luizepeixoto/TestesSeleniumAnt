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
public class CapaMenuTopoTest {

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
	public void verificaSeOMenuEstaSendoExibidoNaCorPreta(){
		assertTrue(capa.exibiuMenuNaCorCorreta());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeNaPosicaoInicialOMenuDoElaNãoEstaSendoExibindo(){
		assertTrue(capa.escondeuOMenuDoElaNaPosicaoInicial());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAposScrollOMenuDoElaPassaASerExibido() throws InterruptedException{
		assertTrue(capa.exibiuOMenuDoElaAposOMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOMenuEditoriaAposMouseOverPassaASerExibido() throws InterruptedException{
		assertTrue(capa.exibiuOMenuEditoria());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAposScrollAteOTopoDaPaginaOMenuDoElaDeixaDeSerExibido() throws InterruptedException{
		assertTrue(capa.deixouDeExibirOMenuAposScrollAteOTopo());
	}
}