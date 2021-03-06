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

import pages.capa.direita.BoxGenteDoGloboComExclusoes;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxGenteDoGloboComExclusoesTest {

	private static BoxGenteDoGloboComExclusoes colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxGenteDoGloboComExclusoes(Navegador.FIREFOX);		
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuTituloGenteDoGlobo() throws InterruptedException{
		colunaDaDireita.executaScrollAteAPosicaoDesejada();
		assertEquals("GENTE DO GLOBO", colunaDaDireita.tituloGenteDoGlobo());
	}

	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuMinimoDeUmColunistas(){
		assertTrue(colunaDaDireita.quantidadeMinimaColunistas() >= Integer.parseInt("1"));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuTituloDoPrimeiroBlog(){
		assertTrue(colunaDaDireita.tituloDoPrimeiroBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuTituloDoPostDoPrimeiroBlog() {
		assertTrue(colunaDaDireita.tituloDoPostDoPrimeiroBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuTituloDoSegundoBlog(){
		assertTrue(colunaDaDireita.tituloDoSegundoBlog());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuTituloDoSegundoPost(){
		assertTrue(colunaDaDireita.tituloDoSegundoPost());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuDataNoFormatoDDMMNoSegundoPost(){
		String dataHoraCompleta = colunaDaDireita.formatoDataEHora();
		dataHoraCompleta = dataHoraCompleta.replace(".", ",");
		
		String dia = dataHoraCompleta.split(",")[0];
		String mes = dataHoraCompleta.split(",")[1].substring(0, 2);
		
		assertTrue(StringUtils.isNumeric(dia) && StringUtils.isNumeric(mes));
		
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuHoraNoFormatoHHMMNoSegundoPost(){
		String dataHoraCompleta = colunaDaDireita.formatoDataEHora();
		String formatoHora = dataHoraCompleta.substring(8);
		
		String hora = formatoHora.split(":")[0];
		String minuto = formatoHora.split(":")[1];
		System.out.println(formatoHora);
		assertTrue(StringUtils.isNumeric(hora) && StringUtils.isNumeric(minuto));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuTituloVerTodosOsBlogs(){
		assertEquals("VER TODOS OS BLOGS", colunaDaDireita.tituloVerTodosOsBlogs());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void clicarNoTituloDeUmBlogEVerificarSeRedirecionouParaPaginaDoBlog(){
		colunaDaDireita.clicouNoTituloDeUmBlog();
		assertTrue(colunaDaDireita.redirecionouParaPaginaDoBlog());
		
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void clicouNoTituloVerTodosOsBlogsERedirecionouParaAPaginaDeBlogs(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTituloVerTodosOs();
		assertTrue(colunaDaDireita.redirecionouParaPaginaDeBlogs());
	}
}