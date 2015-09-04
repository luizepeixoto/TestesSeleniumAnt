package testes.capa.direita;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

import org.junit.runner.RunWith;

import pages.capa.direita.BoxMaisBlogs;

@RunWith(OrdenadorTestes.class)
public class BoxMaisBlogsTest {

	private static BoxMaisBlogs colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxMaisBlogs(Navegador.FIREFOX);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxMaisBlogs() throws InterruptedException{
		assertTrue(colunaDaDireita.exibiuBoxMaisBlogs());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloMaisBlogs(){
		assertEquals("MAIS BLOGS", colunaDaDireita.exibiuTituloMaisBlogs());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuMinimoDeUmColunistas(){
		assertTrue(colunaDaDireita.exibiuMinimoDeUmColunistas() >= Integer.parseInt("1"));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuUmLinkNaChamadaDeCadaBlog(){
		assertTrue(colunaDaDireita.exibiuUmLinkEmCadaChamadaDosBlogs());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuImagemDoBlog(){
		assertTrue(colunaDaDireita.exibiuImagemDoBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuAutorEmCadaChamadaDosBlogs(){
		assertTrue(colunaDaDireita.exibiuAutorDeCadaBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuTituloNasChamadasDoBlog() {
		assertTrue(colunaDaDireita.exibiuTituloDosPostsNaChamadaDosBlogs());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuDataDosPostsNasChamadasDosBlogs() {
		assertTrue(colunaDaDireita.exibiuDataDoPostsNasChamadaDosBlogs());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuDataNoFormatoDDMMNoPrimeiroPost(){
		String dataHoraCompleta = colunaDaDireita.formatoDataEHora();
		dataHoraCompleta = dataHoraCompleta.replace(".", ",");
		
		String dia = dataHoraCompleta.split(",")[0];
		String mes = dataHoraCompleta.split(",")[1].substring(0, 2);
		
		assertTrue(StringUtils.isNumeric(dia) && StringUtils.isNumeric(mes));
		System.out.println(dataHoraCompleta);
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void exibiuHoraNoFormatoHHMMNoPrimeiroPost(){
		String dataHoraCompleta = colunaDaDireita.formatoDataEHora();
		String formatoHora = dataHoraCompleta.substring(8);
		
		String hora = formatoHora.split(":")[0];
		String minuto = formatoHora.split(":")[1];
		System.out.println(formatoHora);
		assertTrue(StringUtils.isNumeric(hora) && StringUtils.isNumeric(minuto));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void exibiuTituloVerTodosOsBlogs(){
		String tituloEsperado = "VER TODOS OS BLOGS";
		String tituloAtual = colunaDaDireita.exibiuTituloVerTodosOsBlogs();
		assertEquals(tituloEsperado.toLowerCase(), tituloAtual.toLowerCase());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 12)
	public void clicouNoTituloMaisBlogsERedirecionouParaAPaginaDeBlogs(){
		colunaDaDireita.clicouNoTituloMaisBlogs();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDeBlogs());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 13)
	public void clicouNoTituloDoPrimeiroBlogERedirecionouParaAPaginaDoBlog() throws InterruptedException{
		colunaDaDireita.voltarPaginaAnterior();
		Thread.sleep(1000);
		colunaDaDireita.clicouNoTituloDoPrimeiroBlog();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 14)
	public void clicouNoTituloVerTodosOsBlogsERedirecionouParaAPaginaDeBlogs() throws InterruptedException{
		colunaDaDireita.voltarPaginaAnterior();
		Thread.sleep(1000);
		colunaDaDireita.clicouNoTituloVerTodosOsBlogs();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDeBlogs());
	}
}
