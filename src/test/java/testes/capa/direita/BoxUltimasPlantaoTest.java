package testes.capa.direita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxUltimasPlantao;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxUltimasPlantaoTest {

	private static BoxUltimasPlantao colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxUltimasPlantao(Navegador.FIREFOX);
		colunaDaDireita.scrollAteOBox();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxUltimasNoticias(){
		assertTrue(colunaDaDireita.exibiuBoxUltimasNoticias());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloPlantao(){
		assertEquals("Plantão", colunaDaDireita.exibiuTituloPlantao());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuQuantidadeMaiorQueUm(){
		assertTrue(colunaDaDireita.exibiuQuantidadeMaiorQueUm() >= Integer.parseInt("1"));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuHoraNoFormatoHHMM(){
		String horaCompleta = colunaDaDireita.exibiuHoraNoFormatoHHMM();
		String hora = horaCompleta.split(":")[0];
		String minuto = horaCompleta.split(":")[1];
		System.out.println(horaCompleta);
		
		assertTrue(StringUtils.isNumeric(hora) && StringUtils.isNumeric(minuto));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuDataNoFormatoDDMM(){
		String dataCompleta = colunaDaDireita.exibiuDataNoFormatoDDMM();
		String dia = dataCompleta.split("/")[0];
		String mes = dataCompleta.split("/")[1];
		System.out.println(dataCompleta);
		
		assertTrue(StringUtils.isNumeric(dia) && StringUtils.isNumeric(mes));		
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuNomeEditoriaOuSubeditoria(){
		assertTrue(colunaDaDireita.exibiuNomeEditoriaOuSubeditoria());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuTituloDoConteudo(){
		assertTrue(colunaDaDireita.exibiuTituloDoConteudo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuTituloVerTodasAsMateriasDoSite(){
		String tituloEsperado = "VER TODAS AS MATÉRIAS DO SITE";
		assertEquals(tituloEsperado, colunaDaDireita.exibiuTituloVerTodasAsMateriasDoSite());	
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void clicouNoTituloPlantaoERedirecionouParaAPaginaDePlantoesDaEditoria(){
		colunaDaDireita.clicouNoTituloPlantao();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDePlantoesDaEditoria());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void clicouNoTituloVerTodasAsMateriasDoSiteERedirecionouParaAPaginaDeUltimasNoticias(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTituloVerTodasAsMateriasDoSite();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDePlantoesDaEditoria());		
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void clicouNoConteudoERedirecionouParaAPaginaDoConteudo(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoConteudo();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoConteudo());
	}
}