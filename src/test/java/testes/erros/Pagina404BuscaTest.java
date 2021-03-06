package testes.erros;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.erros.Pagina404;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class Pagina404BuscaTest {
	
	private static Pagina404 pagina;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		pagina = new Pagina404(Navegador.FIREFOX);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		pagina.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeABuscaNaPaginaDeErro404EstaFuncionandoCorretamente() throws InterruptedException{
		pagina.executarScrollAteAPosicaoDeBusca();
		assertTrue(pagina.executarBusca404());
	}
}