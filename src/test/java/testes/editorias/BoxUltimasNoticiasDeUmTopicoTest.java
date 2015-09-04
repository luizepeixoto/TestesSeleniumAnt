package testes.editorias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.editoria.BoxDeUltimasNoticiasDeUmTopico;


public class BoxUltimasNoticiasDeUmTopicoTest {

	private static BoxDeUltimasNoticiasDeUmTopico boxUltimasNoticias;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		boxUltimasNoticias = new BoxDeUltimasNoticiasDeUmTopico();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		boxUltimasNoticias.fechar();
	}
	
	@Test
	public void exibiuBoxUltimasNoticias(){
		assertNotNull(boxUltimasNoticias.exibiuBoxUltimasNoticias());
	}
	
	@Test
	public void exibiuTituloDoBox(){
		assertTrue(boxUltimasNoticias.exibiuTituloDoBox());
	}
	
	@Test
	public void exibiuUmLinkNoTituloDoBox(){
		assertTrue(boxUltimasNoticias.exibiuUmLinkNoTituloDoBox());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloDoBox(){
		assertTrue(boxUltimasNoticias.exibiuUmLinkValidoNoTituloDoBox());
	}
	
	@Test
	public void exibiuListaComMaterias(){
		assertTrue(boxUltimasNoticias.exibiuQuantidadeMaiorQueUm());
	}
	
	@Test
	public void exibiuHoraParaTodasAsMateriasDaLista(){
		assertTrue(boxUltimasNoticias.exibiuHoraParaAsMaterias());
	}
	
	@Test
	public void exibiuHoraNoFormatoHHMM(){
		String horaCompleta = boxUltimasNoticias.exibiuHoraNoFormatoHHMM();
		String hora = horaCompleta.split(":")[0];
		String minuto = horaCompleta.split(":")[1];
		System.out.println(horaCompleta);
		
		assertTrue(StringUtils.isNumeric(hora) && StringUtils.isNumeric(minuto));
	}
	
	@Test
	public void exibiuDataParaTodasAsMateriasDaLista(){
		assertTrue(boxUltimasNoticias.exibiuDataParaAsMaterias());
	}
	
	@Test
	public void exibiuDataNoFormatoDDMM(){
		String dataCompleta = boxUltimasNoticias.exibiuDataNoFormatoDDMM();
		String dia = dataCompleta.split("/")[0];
		String mes = dataCompleta.split("/")[1];
		System.out.println(dataCompleta);
		
		assertTrue(StringUtils.isNumeric(dia) && StringUtils.isNumeric(mes));		
	}
	
	@Test
	public void exibiuNomeDaEditoriaDaMateria(){
		assertTrue(boxUltimasNoticias.exibiuEditoriaParaAsMaterias());
	}
	
	@Test
	public void exibiuTituloDaMateria(){
		assertTrue(boxUltimasNoticias.exibiuTituloDaMateria());
	}
	
	@Test
	public void exibiuTituloVerTodasAsMateriasDoSite(){
		String resultadoEsperado = "Ver mais notícias";
		assertEquals(resultadoEsperado, boxUltimasNoticias.exibiuTituloVerTodasAsMateriasDoSite());	
	}
	
	@Test
	public void exibiuUmLinkNoTituloVerMaisNoticias(){
		assertTrue(boxUltimasNoticias.exibiuLinkNoTituloVerMaisNoticias());	
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloVerMaisNoticias(){
		assertTrue(boxUltimasNoticias.exibiuLinkValidoNoTituloVerMaisNoticias());	
	}
	
	@Ignore
	@Test
	public void verificaSeAEditoriaConfiguradaCorrespondeAMesmaApresentadaNoLinkDeVerMaisNoticias(){
		assertTrue(boxUltimasNoticias.exibiuEditoriaCorretaNoLinkDeVerMaisNoticias());	
	}
}

