package testes.capa.direita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.capa.direita.BoxProjetosDeMarketing;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxProjetosDeMarketingTest {

	private static BoxProjetosDeMarketing colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxProjetosDeMarketing(Navegador.CHROME);
		colunaDaDireita.esperaCarregar3Segundos();
		colunaDaDireita.executarScroll(colunaDaDireita.getDriver().findElement(By.xpath("//div[@class='projetos-mkt slider-lateral']")).getLocation());
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxProjetosDeMarketing(){
		assertTrue(colunaDaDireita.exibiuBoxProjetosDeMarketing());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloProjetosDeMarketing(){
		assertEquals("Projetos de Marketing", colunaDaDireita.exibiuTituloProjetosDeMarketing());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuPrimeiroConteudoDoBox(){
		assertTrue(colunaDaDireita.exibiuPrimeiroConteudoDoBox());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void clicouNaSetaDaDireitaEExibiuSegundoConteudo(){
		colunaDaDireita.clicouNaSetaDaDireita();
		assertTrue(colunaDaDireita.exibiuSegundoConteudoDoBox());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void clicouNaSetaDaEsquerdaEExibiuPrimeiroConteudo(){
		colunaDaDireita.clicouNaSetaDaEsquerda();
		assertTrue(colunaDaDireita.exibiuPrimeiroConteudoDoBox());
	}
}
