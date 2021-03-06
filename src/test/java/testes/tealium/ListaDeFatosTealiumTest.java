package testes.tealium;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.lista.ListaComFoto;

import br.com.infoglobo.pages.Navegador;

public class ListaDeFatosTealiumTest {
	
	private static ListaComFoto listaDeFatos;
	private String codigoFonteDaPagina = listaDeFatos.getCodigoFonte();
		
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		listaDeFatos = new ListaComFoto(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		listaDeFatos.fechar();
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
	public void verificaSeATagTipoPaginaEhIgualAListaDeFatos(){
		assertTrue(codigoFonteDaPagina.contains("tipo_pagina : \"Lista de Fatos\""));
	}

	@Test
	public void verificaSeATagEditoriaEstaPreenchida(){
		String nomeEditoria = listaDeFatos.obterNomeDaEditoria().toLowerCase();
		nomeEditoria = nomeEditoria.replace(" ", "-").replace("á", "a");
		assertTrue(codigoFonteDaPagina.contains("editoria : \""+nomeEditoria+"\""));
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
		assertTrue(listaDeFatos.carregouJSNoModoAssincrono());
	}
}