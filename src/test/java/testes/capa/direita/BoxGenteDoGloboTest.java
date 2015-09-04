package testes.capa.direita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.capa.direita.BoxGenteDoGlobo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxGenteDoGloboTest {

	private static BoxGenteDoGlobo colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxGenteDoGlobo(Navegador.FIREFOX);	
		colunaDaDireita.esperaCarregar3Segundos();
		colunaDaDireita.executarScroll(colunaDaDireita.getDriver().findElement(By.xpath("//div[@class='gente-do-globo']")).getLocation());
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuTituloGenteDoGlobo() throws InterruptedException{
		assertEquals("GENTE DO GLOBO", colunaDaDireita.tituloGenteDoGlobo());
	}

	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuMinimoDeUmColunistas() throws NumberFormatException, InterruptedException{
		assertTrue(colunaDaDireita.quantidadeMinimaColunistas() >= Integer.parseInt("1"));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuTituloDoPrimeiroBlog() throws InterruptedException{
		assertTrue(colunaDaDireita.tituloDoPrimeiroBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuTituloDoPostDoPrimeiroBlog() throws InterruptedException {
		assertTrue(colunaDaDireita.tituloDoPostDoPrimeiroBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuTituloDoSegundoBlog() throws InterruptedException{
		assertTrue(colunaDaDireita.tituloDoSegundoBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuTituloDoSegundoPost() throws InterruptedException{
		assertTrue(colunaDaDireita.tituloDoSegundoPost());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuDataNoFormatoDDMMNoSegundoPost() throws InterruptedException{
		String dataHoraCompleta = colunaDaDireita.formatoDataEHora();
		dataHoraCompleta = dataHoraCompleta.replace(".", ",");
		
		String dia = dataHoraCompleta.split(",")[0];
		String mes = dataHoraCompleta.split(",")[1].substring(0, 2);
		
		assertTrue(StringUtils.isNumeric(dia) && StringUtils.isNumeric(mes));
		
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuHoraNoFormatoHHMMNoSegundoPost() throws InterruptedException{
		String dataHoraCompleta = colunaDaDireita.formatoDataEHora();
		String formatoHora = dataHoraCompleta.substring(8);
		
		String hora = formatoHora.split(":")[0];
		String minuto = formatoHora.split(":")[1];
		System.out.println(formatoHora);
		assertTrue(StringUtils.isNumeric(hora) && StringUtils.isNumeric(minuto));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuTituloVerTodosOsBlogs() throws InterruptedException{
		assertEquals("VER TODOS OS BLOGS", colunaDaDireita.tituloVerTodosOsBlogs());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void clicarNoTituloDeUmBlogEVerificarSeRedirecionouParaPaginaDoBlog() throws InterruptedException{
		colunaDaDireita.clicouNoTituloDeUmBlog();
		assertTrue(colunaDaDireita.redirecionouParaPaginaDoBlog());
		
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void clicouNoTituloVerTodosOsBlogsERedirecionouParaAPaginaDeBlogs() throws InterruptedException{
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTituloVerTodosOs();
		assertTrue(colunaDaDireita.redirecionouParaPaginaDeBlogs());
	}
}
