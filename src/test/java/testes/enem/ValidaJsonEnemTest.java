package testes.enem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.enem.EnemValidaJson;


public class ValidaJsonEnemTest {
	
	private static EnemValidaJson enem;
	private String conteudoDoJson = enem.exibiuCodigoFonteDaPagina(); 
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		enem = new EnemValidaJson();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		enem.fechar();
	}
	
	@Test
	public void verificaSeOJsonDoEnemEstaExibindoCorretamenteAsTagsDasProvas(){
		assertTrue("Não exibiu a Tag: Provas", conteudoDoJson.contains("provas"));
		assertTrue("Não exibiu a Tag: Nome da Prova", conteudoDoJson.contains("nome"));
		assertTrue("Não exibiu a Tag: Dias", conteudoDoJson.contains("dia"));
		assertTrue("Não exibiu a Tag: Cor da Prova", conteudoDoJson.contains("cor"));
		assertTrue("Não exibiu a Tag: Idioma", conteudoDoJson.contains("idioma"));
		assertTrue("Não exibiu a Tag: Data", conteudoDoJson.contains("data"));
		assertTrue("Não exibiu a Tag: Questões", conteudoDoJson.contains("questoes"));
		assertTrue("Não exibiu a Tag: Número", conteudoDoJson.contains("numero"));
		assertTrue("Não exibiu a Tag: Pergunta", conteudoDoJson.contains("pergunta"));
		assertTrue("Não exibiu a Tag: Opções", conteudoDoJson.contains("opcoes"));
		assertTrue("Não exibiu a Tag: Resposta", conteudoDoJson.contains("resposta"));
		assertTrue("Não exibiu a Tag: Comentários", conteudoDoJson.contains("comentario"));
	}
	
	@Test
	public void verificaSeOJsonDoEnemEstaExibindoCorretamenteAsLogomarcas(){
		assertTrue("Não exibiu a Tag: Logomarcas", conteudoDoJson.contains("logomarcas"));
		assertTrue("Não exibiu a Logomarcas Do Colégio 24 Horas", conteudoDoJson.contains("colegio24horas.png"));
		assertTrue("Não exibiu a Logomarcas Do Pensi", conteudoDoJson.contains("pensi.png"));
		assertTrue("Não exibiu a Logomarcas Do GPI", conteudoDoJson.contains("gpi.png"));
	}
	
	@Test
	public void verificaSeOJsonDoEnemEstaExibindoCorretamenteAsReferenciasDaProva(){
		assertTrue("Não exibiu a Tag: Referências", conteudoDoJson.contains("referencias"));
		assertTrue("Não exibiu a Tag: Dia", conteudoDoJson.contains("dia"));
		assertTrue("Não exibiu a Tag: Cor", conteudoDoJson.contains("cor"));
	}
}
