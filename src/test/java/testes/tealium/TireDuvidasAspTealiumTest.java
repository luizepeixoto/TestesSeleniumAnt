package testes.tealium;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.asp.CapaTireDuvidas;

import br.com.infoglobo.pages.Navegador;

public class TireDuvidasAspTealiumTest {
	
	private static CapaTireDuvidas tireDuvidas;
	private String codigoFonte = tireDuvidas.getCodigoFonte();
		

	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		tireDuvidas = new CapaTireDuvidas(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		tireDuvidas.fechar();
	}

	@Test
	public void verificaSeAVariavelUtagDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("var utag_data"));
	}

	@Test
	public void verificaSeATagProdutoDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("produto"));
	}

	@Test
	public void verificaSeATagTipoPaginaDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("tipo_pagina"));
	}

	@Test
	public void verificaSeATagEditoriaDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("editoria"));
	}

	@Test
	public void verificaSeATagIdConteudoDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("id_conteudo"));
	}

	@Test
	public void verificaSeATagEntidadesDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("entidades"));
	}

	@Test
	public void verificaSeATagTopicosDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("topicos"));
	}

	@Test
	public void verificaSeATagProdutoEhIgualOGlobo(){
		assertTrue(codigoFonte.contains("produto : \"O Globo\""));
	}

	@Test
	public void verificaSeATagTipoPaginaEhIgualACapa(){
		assertTrue(codigoFonte.contains("tipo_pagina : \"Tire-Duvidas\""));
	}

	@Test
	public void verificaSeATagEditoriaEstaPreenchida(){
		assertTrue(codigoFonte.contains("editoria : \"servicos/tireduvidas\""));
	}

	@Test
	public void verificaSeATagIdConteudoEstaPreenchida(){
		assertTrue(codigoFonte.contains("id_conteudo : \"\""));
	}

	@Test
	public void verificaSeATagEntidadesEstaPreenchida(){
		assertTrue(codigoFonte.contains("entidades : [\"\"]"));
	}

	@Test
	public void verificaSeATagTopicosEstaPreenchida(){
		assertTrue(codigoFonte.contains("topicos : [\"\"]"));
	}

	@Test
	public void verificaSeOScriptAssincronoEstaSendoCarregadoNoCodigoDaPagina() throws InterruptedException{
		assertTrue(tireDuvidas.carregouJSNoModoAssincrono());
	}
}