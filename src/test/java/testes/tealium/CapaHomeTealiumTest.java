package testes.tealium;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.CabecalhoBarrinha;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;

public class CapaHomeTealiumTest {
	
	private static CabecalhoBarrinha home;
	private String codigoFonte = home.getCodigoFonte();

	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		home = new CabecalhoBarrinha(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		home.fechar();
	}

	//Marcações do Tealium
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeAVariavelUtagDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("var utag_data"));
	}

	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeATagProdutoDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("produto"));
	}

	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeATagTipoPaginaDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("tipo_pagina"));
	}

	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeATagEditoriaDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("editoria"));
	}

	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeATagIdConteudoDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("id_conteudo"));
	}

	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeATagEntidadesDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("entidades"));
	}

	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeATagTopicosDataEstaSendoCarregadaNoCodigoDaPagina(){
		assertTrue(codigoFonte.contains("topicos"));
	}

	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeATagProdutoEhIgualOGlobo(){
		assertTrue(codigoFonte.contains("produto : \"O Globo\""));
	}

	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeATagTipoPaginaEhIgualACapa(){
		assertTrue(codigoFonte.contains("tipo_pagina : \"Capa\""));
	}

	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeATagEditoriaEstaPreenchida(){
		assertTrue(codigoFonte.contains("editoria : \"ece_frontpage\""));
	}

	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeATagIdConteudoEstaPreenchida(){
		assertTrue(codigoFonte.contains("id_conteudo : \"\""));
	}

	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeATagEntidadesEstaPreenchida(){
		assertTrue(codigoFonte.contains("entidades : [\"\"]"));
	}

	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeATagTopicosEstaPreenchida(){
		assertTrue(codigoFonte.contains("topicos : [\"\"]"));
	}

	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeOScriptAssincronoEstaSendoCarregadoNoCodigoDaPagina() throws InterruptedException{
		assertTrue(home.carregouJSNoModoAssincrono());
	}
}