package testes.tealium;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.temporeal.LancesDoJogo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;

public class TempoRealTealiumTest {
	
	private static LancesDoJogo tempoRealTealium;
	private String codigoFonte = tempoRealTealium.getCodigoFonte();
		

	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		tempoRealTealium = new LancesDoJogo(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		tempoRealTealium.fechar();
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
	public void verificaSeATagTipoPaginaEhIgualATempoReal(){
		assertTrue(codigoFonte.contains("tipo_pagina : \"Tempo real futebol - jogo\""));
	}

	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeATagEditoriaEstaPreenchida(){
		String nomeEditoria = tempoRealTealium.obterNomeDaEditoria().toLowerCase();
		nomeEditoria = nomeEditoria.replace(" ", "-");
		assertTrue(codigoFonte.contains("editoria : \""+nomeEditoria+"\""));
	}

	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeATagIdConteudoEstaPreenchida(){
		assertTrue(!codigoFonte.contains("id_conteudo : \"\""));
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
		assertTrue(tempoRealTealium.carregouJSNoModoAssincrono());
	}


}
