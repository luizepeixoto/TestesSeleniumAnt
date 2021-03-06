package testes.tealium;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.asp.CapaDeUmBlog;

import br.com.infoglobo.pages.Navegador;

public class CapaDeUmBlogAspTealiumTest {
	
	private static CapaDeUmBlog capaDeUmBlogAsp;
	private String codigoFonte = capaDeUmBlogAsp.getCodigoFonte();
		

	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		capaDeUmBlogAsp = new CapaDeUmBlog(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		capaDeUmBlogAsp.fechar();
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
		assertTrue(codigoFonte.contains("tipo_pagina : \"Capa\""));
	}

	@Test
	public void verificaSeATagEditoriaEstaPreenchida(){
		assertTrue(codigoFonte.contains("editoria : \"blogs/radarolimpico\""));
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
		assertTrue(capaDeUmBlogAsp.carregouJSNoModoAssincrono());
	}
}