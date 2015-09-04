package testes.ela.capa;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ela.capa.CapaEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeBlogsTest {

	private static CapaEla capa;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(capa.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capa = new CapaEla(Navegador.CHROME);
		capa.executaScrollParaAparecerOTituloDeUmaPosicao(capa.acessaClasseBlogsHomeList());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capa.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeBlogsEstaSendoExibido(){
		assertTrue(capa.exibiuBoxDeBlogs());
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDeBlogsEstaExibindoOTituloBlogs(){
		String tituloEsperado = "BLOGS";
		assertEquals(tituloEsperado, capa.exibiuTituloBlogs());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOTituloBlogsEstaSendoExibidoComOLayoutCorreto(){
		assertTrue(capa.exibiuTituloBlogsComOLayoutCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeCadaUmaDasChamadasDosBlogsEstaoExibindoAsInformacoesCorretas() throws InterruptedException{
		assertTrue(capa.exibiuChamadasDosBlogsComAsInformacoesCorretas());
	}
}