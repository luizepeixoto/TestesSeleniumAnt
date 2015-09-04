package testes.tealium;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.PlantaoNavegacao;

import br.com.infoglobo.pages.Navegador;

public class PlantaoTealiumTest {
	
	private static PlantaoNavegacao plantao;
	private String codigoFonteDaPagina = plantao.getCodigoFonte();
		

	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new PlantaoNavegacao(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		plantao.fechar();
	}

	@Test
	public void verificaSeAVariavelUtagDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonteDaPagina.contains("var utag_data"));
	}

	@Test
	public void verificaSeATagProdutoDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonteDaPagina.contains("produto"));
	}

	@Test
	public void verificaSeATagTipoPaginaDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonteDaPagina.contains("tipo_pagina"));
	}

	@Test
	public void verificaSeATagEditoriaDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonteDaPagina.contains("editoria"));
	}

	@Test
	public void verificaSeATagIdConteudoDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonteDaPagina.contains("id_conteudo"));
	}

	@Test
	public void verificaSeATagEntidadesDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonteDaPagina.contains("entidades"));
	}

	@Test
	public void verificaSeATagTopicosDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonteDaPagina.contains("topicos"));
	}

	@Test
	public void verificaSeATagProdutoEhIgualOGlobo(){
		assertTrue(codigoFonteDaPagina.contains("produto : \"O Globo\""));
	}

	@Test
	public void verificaSeATagTipoPaginaEhIgualAPlantao(){
		assertTrue(codigoFonteDaPagina.contains("tipo_pagina : \"Plantao\""));
	}

	@Test
	public void verificaSeATagEditoriaEstaPreenchida(){
		assertTrue(!codigoFonteDaPagina.contains("editoria : \"\""));
	}

	@Test
	public void verificaSeATagIdConteudoEstaPreenchida(){
		assertTrue(!codigoFonteDaPagina.contains("id_conteudo : \"\""));
	}

	@Test
	public void verificaSeATagEntidadesEstaPreenchida(){
		assertTrue(codigoFonteDaPagina.contains("entidades : [\"\"]"));
	}

	@Test
	public void verificaSeATagTopicosEstaPreenchida(){
		assertTrue(codigoFonteDaPagina.contains("topicos : [\"\"]"));
	}

	@Test
	public void verificaSeOScriptAssincronoEstaSendoCarregadoNoCodigoDaPagina() throws InterruptedException{
		assertTrue(plantao.carregouJSNoModoAssincrono());
	}
}