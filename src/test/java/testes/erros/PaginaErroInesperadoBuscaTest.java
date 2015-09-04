package testes.erros;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.erros.PaginaErroInesperado;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class PaginaErroInesperadoBuscaTest {
	
	private static PaginaErroInesperado pagina;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		pagina = new PaginaErroInesperado(Navegador.FIREFOX);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		pagina.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeABuscaNaPaginaDeErroInesperadoEstaFuncionandoCorretamente() throws InterruptedException{
		pagina.executarScrollAteAPosicaoDeBusca();
		assertTrue(pagina.executarBuscaErroInesperado());
	}
}