package testes.capa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.CapaCabecalho;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class CabecalhoBuscaTest {
	
	private static CapaCabecalho cabecalhoCentral;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(cabecalhoCentral.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		cabecalhoCentral = new CapaCabecalho(Navegador.FIREFOX);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		cabecalhoCentral.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void exibiuOBoxCentralDoCabecalho(){
		assertNotNull(cabecalhoCentral.exibiuABuscaNoCabecalho());
	}

	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void executarUmaBuscaValida() throws InterruptedException{
		assertTrue(cabecalhoCentral.executouABusca());
	}
}
